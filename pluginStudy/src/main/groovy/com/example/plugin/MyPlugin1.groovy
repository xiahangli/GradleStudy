package com.example.plugin

import com.android.build.gradle.AppExtension
import com.android.build.gradle.TestExtension
import com.android.build.gradle.api.ApplicationVariant
import com.android.builder.testing.api.TestException
import org.gradle.api.Plugin
import org.gradle.api.Project;

public class MyPlugin1 implements Plugin<Project> {
    @Override
    void apply(Project target) {
        print("apply")

        if (target.plugins.hasPlugin("com.android.application")) {
            print("has com.android.application")
            target.afterEvaluate {
                /**
                 * android这个dsl是在TestPlugin中通过
                 * project.getExtensions()
                 *                 .create(
                 *                         "android",
                 *                         TestExtension.class,
                 *                         project,
                 *                         projectOptions,
                 *                         globalScope,
                 *                         buildTypeContainer,
                 *                         productFlavorContainer,
                 *                         signingConfigContainer,
                 *                         buildOutputs,
                 *                         sourceSetManager,
                 *                         extraModelInfo);
                 *     }
                 *     创建的，创建的是TestExtension对象，在这里是通过target.extensions.getByName("android")获取这里创建的
                 *     名字为android的TestPlugin包装对象，保存成android字段供后面使用
                 *
                 *
                 *     其中TestExtension有getApplicationVariants方法，方法注释如下
                 *      Returns the list of Application variants. Since the collections is built after evaluation, it
                 *      * should be used with Gradle's <code>all</code> iterator to process future items.
                 *
                 */

                //Cannot cast object 'extension 'android'' with class 'com.android.build.gradle.internal.dsl.BaseAppModuleExtension_Decorated'
                // to class 'com.android.builder.testing.api.TestException'
                //注意这里的BaseAppModuleExtension->AppExtension->TestedExtension,其中AppExtension是有getApplicationVariants方法的
                //可以使用android.applicationVariants的方式访问该方法
                //不能使用TestExtension作为android的类型,需要使用动态类型def
                def android = target.extensions.getByName("android")
                //通过groovy的property语法访问getApplicationVariants方法,注释说后面用all方法调用should be used with Gradle's all iterator
                android.applicationVariants.all{
                    //也可以是 def variant->
                    ApplicationVariant variant->


                        //tasks对应getTasks方法，返回TaskContainer实例，这里获取processXXXResource,其中xxx是大写的变体名字，如processDebugResource
//            "process${variant.name.capitalize()}Resources" 的一个例子是processDebugResource
                        //TODO 注意AndroidConfig.java中有这个属性getAaptOptions,会返回AaptOptions,而AaptOptions中有additionalParameters字段
//                        def processResourcesTask = target.tasks.findByName("process${variant.name.capitalize()}Resources")


                        //针对:app:processDebugResources这个task做逻辑处理
//                        if (processResourcesTask) {
//                            def properties = processResourcesTask.properties
//                            println("解析：" + "process${variant.name.capitalize()}Resources")
//                            for (int i = 0; i < properties.size(); i++) {
//                                println("解析" + properties[i])
//                            }
//                            println("xxxx"+processResourcesTask)
                            def processResourcesTask = Compatibilities.getProcessResourcesTask(target, variant)
                            ensureStableIdsArgsWasInjected(processResourcesTask,target)

                            //TODO https://github.com/rickgit/Test/blob/2437ded7fee0719d29de86b92f0f2e61e4a479ea/GradlePlugin/src/main/groovy/edu/ptu/java/gradleplugin/PublicPlugin.groovy
//                            println aaptOptions
//                                File publicTxtFile = project.rootProject.file('public.txt')
//                                //public文件存在，则应用，不存在则生成
//                                if (publicTxtFile.exists()) {
//                                    project.logger.error "${publicTxtFile} exists, apply it."
//                                    //aapt2添加--stable-ids参数应用
//                                    aaptOptions.additionalParameters("--stable-ids", "${publicTxtFile}")
//                                } else {
//                                    project.logger.error "${publicTxtFile} not exists, generate it."
//                                    //aapt2添加--emit-ids参数生成
//                                    aaptOptions.additionalParameters("--emit-ids", "${publicTxtFile}")
//                                }
                        }



                }

            }

        }



    void ensureStableIdsArgsWasInjected(agpProcessResourcesTask,project) {
        println("ddddddddd $agpProcessResourcesTask")
        if (!isAapt2EnabledCompat(project)) {
            println "xxxxx"
            return
        }
        def aaptOptions
        println("aptapt")
        try {
            //https://juejin.cn/post/6844904142717075469 processDebugResources对应的实现类是ProcessAnroidResource
            aaptOptions = agpProcessResourcesTask.aaptOptions
            println("aaptOptions")
        } catch (Throwable ignored) {
            println("aaptOptions error $aaptOptions")
            aaptOptions = null
        }

        if (aaptOptions == null) {
            def currClazz = agpProcessResourcesTask.getClass().getSuperclass()
            while (true) {
                try {
                    def field = currClazz.getDeclaredField('aaptOptions')
                    field.setAccessible(true)
                    aaptOptions = field.get(agpProcessResourcesTask)
                    break
                } catch (NoSuchFieldException ignored) {
                    if (!currClazz.equals(Object.class)) {
                        currClazz = currClazz.getSuperclass()
                    } else {
                        break
                    }
                }
            }
        }

        //FIXME 注意下面的话
        // It's wired that only AGP 3.5.x needs this ensurance logic. In newer version of AGP, aaptOptions field
        // is gone, which let us skip the rest logic.
        if (aaptOptions != null) {
            def additionalParameters = aaptOptions.additionalParameters
            if (additionalParameters == null) {
                additionalParameters = new ArrayList<String>()
                replaceFinalField(aaptOptions.getClass(), 'additionalParameters', aaptOptions, additionalParameters)
            }
            if (!additionalParameters.contains('--stable-ids')) {
                additionalParameters.add('--stable-ids')
                def stableIdsFile = project.file(TinkerBuildPath.getResourcePublicTxt(project))
                additionalParameters.add(stableIdsFile.getAbsolutePath())
                project.logger.error("AApt2 is enabled, and tinker ensures that ${stableIdsFile.getAbsolutePath()} is injected into aapt options.")
            }
        }else{
            println("卧槽，aaptOptions没有")
        }

    }

    /**
     * 判断是否使能了aapt2资源打包工具
     * get whether aapt2 is enabled
     */
    static boolean isAapt2EnabledCompat(Project project) {
        if (getAndroidGradlePluginVersionCompat() >= '3.3.0') {
            //when agp' version >= 3.3.0, use aapt2 default and no way to switch to aapt.
            return true
        }
        boolean aapt2Enabled = false
        try {
            def projectOptions = getProjectOptions(project)
            Object enumValue = resolveEnumValue("ENABLE_AAPT2", Class.forName("com.android.build.gradle.options.BooleanOption"))
            aapt2Enabled = projectOptions.get(enumValue)
        } catch (Exception e) {
            try {
                //retry for agp <= 2.3.3
                //when agp <= 2.3.3, the field is store in com.android.build.gradle.AndroidGradleOptions
                Class classAndroidGradleOptions = Class.forName("com.android.build.gradle.AndroidGradleOptions")
                def isAapt2Enabled = classAndroidGradleOptions.getDeclaredMethod("isAapt2Enabled", Project.class)
                isAapt2Enabled.setAccessible(true)
                aapt2Enabled = isAapt2Enabled.invoke(null, project)
            } catch (Exception e1) {
                //if we can't get it, it means aapt2 is not support current.
                aapt2Enabled = false
            }
        }
        return aapt2Enabled
    }

    /**
     * get android gradle plugin version by reflect
     */
    static String getAndroidGradlePluginVersionCompat() {
        String version = null
        try {
            Class versionModel = Class.forName("com.android.builder.model.Version")
            def versionFiled = versionModel.getDeclaredField("ANDROID_GRADLE_PLUGIN_VERSION")
            versionFiled.setAccessible(true)
            version = versionFiled.get(null)
        } catch (Exception e) {

        }
        return version
    }

    /**
     * 通过反射获取ProjectOptions对象
     * get com.android.build.gradle.options.ProjectOptions obj by reflect
     */
    static def getProjectOptions(Project project) {
        try {
            def basePlugin = project.getPlugins().hasPlugin('com.android.application') ? project.getPlugins().findPlugin('com.android.application') : project.getPlugins().findPlugin('com.android.library')
            return Class.forName("com.android.build.gradle.BasePlugin").getMetaClass().getProperty(basePlugin, 'projectOptions')
        } catch (Exception e) {
        }
        return null
    }

    /**
     * 同样通过反射获取枚举对象
     * get enum obj by reflect
     */
    static <T> T resolveEnumValue(String value, Class<T> type) {
        for (T constant : type.getEnumConstants()) {
            if (constant.toString().equalsIgnoreCase(value)) {
                return constant
            }
        }
        return null
    }
}