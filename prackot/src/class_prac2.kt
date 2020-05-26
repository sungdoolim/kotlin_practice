class animal(){
    constructor(name:String,age:Int):this(){
        this.name=name
        this.age=age
    }
    var name:String?=null
    var age:Int?=null
    fun pt():Unit{
        println("name:$name , age:$age")
    }
}

fun main():Unit{
    var ani=animal()
    var ani2=animal("staris",25)
    ani.pt()
    ani2.pt()
      
}