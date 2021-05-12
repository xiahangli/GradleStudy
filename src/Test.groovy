def personInfo = [name: 'Daniel.Sun', location: 'Shanghai']
assert 'Daniel.Sun' == personInfo?['name']


def list = ['a','b','c']
assert 'a' in list

Integer x = 123
String s = (String) x

println s
class B{

}
class Identifiable {
    String name
}
class User {
    Long id
    String name
    def asType(Class target) {
        if (target == Identifiable) {
            return new Identifiable(name: name)
        }
        throw new ClassCastException("User cannot be coerced into $target")
    }
}

def u = new User(name: 'Xavier')
println u
def p =u as Identifiable

println p