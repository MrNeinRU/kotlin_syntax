private fun pumpIN(list: MutableList<MainTypesInfo>, ID:Int){
    val printedList = EmptyBody().printRow(list, ID)
    printedList.forEach {
        println(it)
    }//TODO закончить функционал
    EmptyBody().backToMain(list)
}
private fun pumpOUT(list: MutableList<MainTypesInfo>, ID:Int){
    val printedList = EmptyBody().printRow(list, ID)
    printedList.forEach {
        println(it)
    }//TODO закончить функционал
    EmptyBody().backToMain(list)
}

private fun selectToPump(list: MutableList<MainTypesInfo>, i:Int){
    var optionF:Int
    val printedList = EmptyBody().printRow(list)
    while (true){
        println("Выберите необходимый объект")
        EmptyBody().skipLine
        printedList.forEach {
            println(it)
        }
        println("0. Отменить")

        try {
            when(val ff = readln().toInt()){
                in 0..list.size->{
                    optionF = ff
                    break
                }
                else->{
                    throw Exception("Not valid")
                }
            }
        }catch (e:Exception){
            EmptyBody().errorRead(from = "1",to = "${list.size}")
        }
    }
    when(optionF){
        0->{
            EmptyBody().backToMain(list)
        }
        in 1..list.size->{
            when(i){
                1->{
                    pumpIN(list, optionF-1)
                }
                2->{
                    pumpOUT(list, optionF-1)
                }
                else->{
                    println("Неожиданная ошибка")
                }
            }
        }
        else->{
            println("Неожиданная ошибка")
        }
    }
}

fun pumping(list: MutableList<MainTypesInfo>){
    var optionS:Int
    while (true){
        println("Выберите необходимый параметр")
        println("""
            1. Закачать
            2. Откачать
            0. Отмена
        """.trimIndent())
        try {
            when(val ff = readln().toInt()){
                in 0..2->{
                    optionS = ff
                    break
                }
                else->{
                    throw Exception("Not valid")
                }
            }
        }catch (e:Exception){
            EmptyBody().errorRead(from = "0",to = "2")
        }
    }
    when(optionS){
        1,2->{
            selectToPump(list, optionS)
        }
        0->{
            EmptyBody().backToMain(list)
        }
        else->{
            println("Неожиданная ошибка")
        }
    }

}