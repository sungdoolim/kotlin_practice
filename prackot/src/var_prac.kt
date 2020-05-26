fun main(){
    // 기본 변수 선언 밑 ? 사용
    println("변수 연습 ")
    var a:Int
    a=3
    println(a)
    var b=2
    println(b)
    var c:String?="C"
    println(c)


    // let 부분
    var d:String?="staris"
    d?.let{println("this is not null ${d}")}
    d=null
    d?.let{println("this is not null ${d}")}




}