open class animal(){
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
data class Dog(var dna: Int):animal()  // dna name age 3개의 자료만 담고 있음

object fac {
    var arl= arrayListOf<Any>()
    var count=0;
    fun pregna():Dog{
        count+=1;
        var a=Dog(count)
        arl.add(a)
        return a

    }
}



fun main():Unit{
    var ani=animal()
    var ani2=animal("staris",25)
    ani.pt()
    ani2.pt()
    var dog=Dog(3)
    dog.pt(); println(dog.dna)

    var dog1=fac.pregna()
    dog1.pt();println(dog1.dna)
    var dog2=fac.pregna()
    dog2.pt();println(dog2.dna)


}