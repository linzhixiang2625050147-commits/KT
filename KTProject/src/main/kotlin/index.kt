fun hyphenSplitFun(){
    println("-------------")
}
data class Task(
    //任务编号
    val id: Int,
    //任务名称
    val name: String,
    //任务描述
    val description: String,
    //任务完成状态
    var done: Boolean=false
)

fun main()
{
    val tasks = mutableListOf<Task>()
    var taskId = 0

    hyphenSplitFun()
    println("Hello Welcome to use it")
    hyphenSplitFun()
    while(true){
        println("请选择你需要操作的选项")
        println("1.添加任务")
        println("2.查看所有任务")
        println("3.删除任务")
        println("4.更改任务状态")
        println("5.退出程序")
        hyphenSplitFun()
        val projectOptions=readLine()?: ""
        if(projectOptions=="1"){
            // 添加任务
            hyphenSplitFun()
            println("请输入任务名")
            val taskName=readln()
            hyphenSplitFun()
            println("请输入任务描述")
            val taskDescription=readln()
            taskId++
            val newTask = Task(taskId, taskName, taskDescription)
            tasks.add(newTask)
            println("任务添加成功")
            hyphenSplitFun()
        }
        else if(projectOptions=="2"){
            //查看所有任务
            hyphenSplitFun()
            println("正在查看所有任务")
            hyphenSplitFun()
            if(tasks.isEmpty()){
                println("暂无任务")
            }else{
                for(task in tasks){
                    println("任务编号: ${task.id}, 任务名称: ${task.name}, 任务描述: ${task.description}, 完成状态: ${task.done}")
                }
            }
            hyphenSplitFun()
        }
        else if(projectOptions=="3"){
            //删除任务
            hyphenSplitFun()
            println("请输入要删除的任务编号")
            val taskToRemove = readln()?.toIntOrNull()
            if (taskToRemove != null) {
                val task = tasks.find { it.id == taskToRemove }
                if (task != null) {
                    tasks.remove(task)
                    println("任务删除成功")
                } else {
                    println("未找到该任务")
                }
            } else {
                println("输入无效")
            }
            hyphenSplitFun()
        }
        else if(projectOptions=="4"){
            //更改任务状态
            hyphenSplitFun()
            println("请输入要更改的项目编号")
            val changeTaskID=readln()?.toIntOrNull()
            if(changeTaskID==null){
                println("错误，请重新输入")
                hyphenSplitFun()
            }
            else{
                val target=tasks.find { it.id == changeTaskID }
                if(target!=null){
                    target.done=!target.done
                    println("任务状态已更改")
                }
                else{
                    println("未找到该任务")
                }
                hyphenSplitFun()
            }

        }
        else if(projectOptions=="5"){
            //退出程序11

            hyphenSplitFun()
            println("感谢使用，再见！")
            hyphenSplitFun()
            break
        }
        else{
            println("无效选项，请重新选择")
        }
    }
}