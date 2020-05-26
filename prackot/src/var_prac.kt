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

    //array
    var e=arrayOf(1,3,5)
    var elen=e.size
    for(i in e){
        print("$i ")
    }
    println("\nlen = ${elen}")
    for(i in 0..elen-1 step 1){
        print("${e[i]} ")
    }
    println()
    for(i in elen-1 downTo 0 step 1){
        print("${e[i]} ")
    }
    // when
    for(i in 0..elen-1 step 1){
        when(e[i]){
            in 1..3->println("1~3 : ${e[i]}")
            in 3..5-> println("3~5 : ${e[i]}")
            else ->println("hi : ${e[i]}")
        }
    }
    //arraylist
    var f= arrayListOf<Any>()
    f.add(3)
    f.add("S")
    var flen= f.size
    for(i in 0..flen-1){
        print("${f.get(i)} ")
    }
    println()
    

}