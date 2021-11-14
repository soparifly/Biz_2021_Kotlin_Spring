class Main_02 {


    val scal:Scanner  = Scanner(System.`in`)
    while(true){
        print("첫번째 정수를 입력하세요 : " )
        val strNum1 = scan.nextLine()
        val intNum1 = try{
            Integer.valueOf(strNum1)
        } catch (e:Exception){
            println("")
            continue
        }
        print("두번째 정수를 입력하세요 : ")
    }
}