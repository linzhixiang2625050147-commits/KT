fun hypenSplitFun(){
    println("-----分割线-----")
}
fun guessNuberFun(N: Int, answer: Int): String {
    if (N>answer){
        return "你猜的数字大了"
    } else if (N<answer){
        return "你猜的数字小了"
    } else {
        return "恭喜你，猜对了！"
    }
}
fun main(){
    hypenSplitFun()
    println("我们来玩一个猜数字游戏吧。")
    println("我会随机生成一个1到100之间的数字，你来猜猜看吧。")
    val answer=(1..100).random()
    println("已生成随机数，接下来开始比较了")
    hypenSplitFun()
    while (true) {
        println("请输入你猜的数字：")
        val guessNumber= readln().toIntOrNull()
        //var answerBoolean = false
        hypenSplitFun()
        if (guessNumber == null || guessNumber !in 1..100) {
        println("请输入一个有效的数字（1到100之间）")
        continue
        }
        val result=guessNuberFun(guessNumber, answer)
        println(result)
        if(result=="恭喜你，猜对了！"){
            break
        }
        else if(result  =="你猜的数字大了"){
            println("请再试一次")
        }
        else if(result  =="你猜的数字小了"){
            println("请再试一次")
        }
        else{
            println("错误？")
            break
        }
    }
}