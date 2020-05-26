object Factory{
 var carfac= ArrayList<Car>()
    //var car:Car?=null
    fun makecar() {
      var car = Car("s1", 1)
      carfac.add(car)
    }

}

data class Car(var name:String, var horse:Int)


class CarF(name :String, horse:Int){
    constructor(name:String,horse:Int,desc:String):this(name,horse){
        this.desc=desc
    }
    var name:String? = name
    var horse: Int?=horse
    var desc: String?=null

    fun p():Unit{
        println("$name : $horse : $desc")
    }

}
fun main(){

  /*  println("hello")
    calc(10,2,"/")
    var c=Car("staris",100)
    //c.p();
    var cf=CarF("hama",50,"staris loves hama")
    var cf1=CarF("hama",50)
    cf.p();
    cf1.p();

    var arr:Array<Int>?=null
    arr= arrayOf(3,5,2)

    println(arr?.isEmpty())
    println(arr[2])
    println(arr.get(2))
    //arr[3]=2 error
    println("size:${arr.size}")

    println("size:${arr.size}")
    println("for문 연습")
    for( a in arr) {
        print("$a , ")
    }
    println()
    for(a in 1..10 step 2){
        print("$a , ")
    }
    println()
    for(a in 10 downTo 1){

        if(a%2==0){
            continue
        }
        print("$a , ")
    }



    println()

    val ar:ArrayList<Any>;
    ar= arrayListOf();
    ar.add(2);

   // println(ar.get(2))

    Factory.makecar()// 강의에서도 Factory 자체를 받아오네
    var newcar=Factory.carfac.get(0)
    println(newcar)


   // println(ar?.get(1))
*/

    var a: String?="s"
    var b=a?.toUpperCase()
    a?.let{a="not null"}//a가 null 이 아니라면
    println(a)

    var sqr:(Int)->(Int)={it-> it*it}// 매게로 1개만 받으면 it로 받을 수 있음
    fun sqr2(a:Int):Int{
        return a*a
    }

    fun L(lamda:(Int)->Int):Int{
        return lamda(4)
    }

    println("제곱수 ${sqr(3)}")
    println("제곱수 ${sqr2(3)}")
    println("제곱수 ${L(sqr)}")// 심오한데..?

    val addfun:String.(Int)->(Int)={this.length}
    println(a?.addfun(3))

}


fun calc(a:Int,b:Int,c:String){
    when(c){
        "+"->println(a+b)
        "-"->println(a-b)
        "*"->println(a*b)
        "/"->println(a/b)
    }
}