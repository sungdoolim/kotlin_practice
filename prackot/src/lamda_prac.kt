import kotlin.time.seconds

fun main(){

    val addfunc:String.()->Unit={
        println("addfunc")
    }
    var a="staris"
    a.addfunc()
// 한개일 때 it 쓰지? 두개 이상일때 ... 쫌 이상한데..?
    // 이거 그거네 앞에 있는 타입은 생략가능하지?...안되네.... 대신 안에다가 해야지??
    // 람다 식 기본
    val a1:(Int,Int)->String={ aa: Int, bb: Int ->
        when(aa){
            in 1..5->"fail"
            else->"success"
        }
    }
    println(a1(3,5))

    // 람다식 함수 활용 부분
    var a2:(Int)->String={
        a:Int->
        a.toString()
    }
    fun invokelamda(l:(Int)->String,param:Int):Int{

        var b:String?=l(param)
    return Integer.parseInt(b);
    }
    println(invokelamda(a2,5))


}