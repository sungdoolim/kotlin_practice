open class Employee(name:String="default"){
    constructor(name:String,age:Int):this(name){
        this.name=name
        this.age=age
    }


   private var name:String? =null
   private var age:Int? =null
    fun getAge(): Int? {
        return this.age
    }
    fun setAge(age:Int?):Unit{
        this.age=age
    }
    fun getName(): String?{
        return this.name
    }
    fun setName(name:String?):Unit{
        this.name=name
    }

}
class Supervisor(): Employee() {
    constructor(name:String):this(){
        setName(name)
    }



}

fun main():Unit{
    var emp=Employee("first")
    println(emp.getAge())
    var sup=Supervisor("supfirst")
    println(sup.getName())




}