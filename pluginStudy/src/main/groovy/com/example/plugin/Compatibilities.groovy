package com.example.plugin

/**
 * https://github.com/Tencent/tinker/blob/18f21f8981e7d984ab3d02ecb70ec724cb9fa8c2/tinker-build/tinker-patch-gradle-plugin/src/main/groovy/com/tencent/tinker/build/gradle/Compatibilities.groovy
 */
class Compatibilities{

    /**
     * 根据project和variant获取processResourceTask
     * @param project
     * @param variant
     * @return
     */
    static def getProcessResourcesTask(project, variant) {
        return project.tasks.findByName("process${variant.name.capitalize()}Resources")
    }
}