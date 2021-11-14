import java.util.*

fun main(args: Array<String>) {
    /**
     * in에 백팃을 사용하는이유 코틀린에 키워드가 이미존재하기때문에 헷갈리지않기위해
     *
     */
    val scan: Scanner = Scanner(System.`in`)
    print("정수 1을 입력")
    var strNum1 = scan.nextLine()
    print("정수 2를 입력")
    var strNum2 = scan.nextLine()


    var intNum1 = Integer.valueOf(strNum1)
    var intNum2 = Integer.valueOf(strNum2)

}

/**
 * 함수에서는 반드시 매개변수의 타입을 지정해줘야한다
 */
fun view(num1:Int, num2:Int){

    var sum = num1 + num2
    var minus = num1 - num2
    var times = num2 * num2
    var div = num1 / num2

    println("$num1 + $num2 = $sum ")
}