import javax.security.auth.login.LoginException

private fun beginFilter(list: MutableList<MainTypesInfo>, byField:Int){
    val printedList = EmptyBody().printRow(list = list, modifier = false)

    println("Нынешняя таблица")
    EmptyBody().skipLine
    EmptyBody().printRowTitle(list).apply(::println)
    printedList.forEachIndexed { index, it ->
        println(it)
    }
    EmptyBody().skipLine

    while (true){
        print("Значение для фильтровки")
        EmptyBody().skipLine

        when(byField){
            1->{
                print(EmptyBody().helpMassageForChangeData())
                EmptyBody().skipLine
                try {
                    val str = readln()

                    val tempList = list.filter {
                        it.typeOfFigure.startsWith(str, ignoreCase = true)
                    }

                    if (tempList.isEmpty()) {
                        println("Данных нет")
                    }else{
                        val printedList2 = EmptyBody().printRow(list = tempList.toMutableList(), modifier = false)
                        EmptyBody().printRowTitle(tempList.toMutableList()).apply(::println)
                        printedList2.forEachIndexed { index, it ->
                            println(it)
                        }
                        EmptyBody().skipLine
                    }

                    subFilter(list, byField)
                }catch (e:Exception){
                    EmptyBody().errorRead()
                }
            }
            else->{
                print(EmptyBody().helpMassageForChangeData(
                    typeOfData = "Выражение",
                    example = ">10 | <10 | >10&&<14"
                ))
                EmptyBody().skipLine

                try {
                    val str = readln()
                    val tempList = list.filter {
                        val target:Double = when(byField){
                            3->{
                                it.percent.toDouble()
                            }

                            4->{
                                it.pumpingSpeedIN
                            }

                            5->{
                                it.pumpingSpeedOUT
                            }

                            else->{
                                it.valume
                            }
                        }
                            when(str.split("&&").size){
                            1->{
                                when(str[0]){
                                   '>'->{
                                        target > str.split(">")[1].toDouble()
                                    }
                                    '<'->{
                                        target < str.split("<")[1].toDouble()
                                    }
                                    else-> target.toString().startsWith(str, ignoreCase = true)
                                }
                            }
                            else->{
                                val a = str.split("&&")
                                when(a[0][0]){
                                    '>'->{
                                        if (a[1][0]=='<' &&
                                            a[0].split(">")[1].toDouble()<a[1].split("<")[1].toDouble()
                                            ){
                                            target > a[0].split(">")[1].toDouble() &&
                                                    target < a[1].split("<")[1].toDouble()
                                        }else throw LoginException("Неверное построение")
                                    }
                                    '<'->{
                                        if (a[1][0]=='>' &&
                                            a[0].split("<")[1].toDouble()>a[1].split(">")[1].toDouble()
                                        ){
                                            target < a[0].split("<")[1].toDouble() &&
                                                    target > a[1].split(">")[1].toDouble()
                                        }else throw LoginException("Неверное построение")
                                    }
                                    else-> throw Exception("NOT")
                                }
                            }
                        }
                    }
                    val printedList2 = EmptyBody().printRow(list = tempList.toMutableList(), modifier = false)
                    if (tempList.isNotEmpty()){
                        EmptyBody().printRowTitle(tempList.toMutableList()).apply(::println)
                        printedList2.forEachIndexed { index, it ->
                            println(it)
                        }
                    }

                    if (tempList.isEmpty()) println("Данных нет")
                    EmptyBody().skipLine
                    subFilter(list, byField)

                }catch (e: LoginException){
                    println(e.message)
                } catch (e:Exception){
                    EmptyBody().errorRead()
                }
            }
        }
    }
}

private fun subFilter(list: MutableList<MainTypesInfo>, byField:Int) {
    while (true){
        println("""
            1. Фильтровать (ввод значения)
            0. Назад
        """.trimIndent())
        try {
            when(readln().toInt()){
                1->{
                    beginFilter(list, byField)
                }
                0-> filter(list)
                else -> throw Exception("NOT")
            }
        }catch (e:Exception){
            EmptyBody().errorRead(from = "0", to = "1")
        }
    }
}

fun filter(list: MutableList<MainTypesInfo>){
    while (true){
        println("""
            __Фильтровать по:
            
            1. Названию
            2. Объёму
            3. Заполненности
            4. Скорости закачки
            5. Скорости откачки
            0. Отменить
        """.trimIndent())
        try {
            when(val a = readln().toInt()){
                in 1..5 -> subFilter(list, a)
                0->EmptyBody().backToMain(list)
                else-> throw Exception("NOT")
            }
        }catch (e:Exception){
            EmptyBody().errorRead(from = "0", to = "5")
        }
    }
}

private fun subSort(list: MutableList<MainTypesInfo>, noN: Int){
    println("Тип сортировки:")
    EmptyBody().skipLine
    println("""
        1. По возрастанию
        2. По убыванию
        0. Назад
    """.trimIndent())
    try {
        when(readln().toInt()){
            1->{
                when(noN){
                    1->{
                        val sortedL = list.sortedBy {
                            it.typeOfFigure
                        }.toMutableList()
                        println("Сортировка завершена")
                        EmptyBody().skipLine
                        EmptyBody().backToMain(sortedL)
                    }
                    2->{
                        val sortedL = list.sortedBy {
                            (Math.round(it.valume * 1000.0)/1000.0)
                        }.toMutableList()
                        println("Сортировка завершена")
                        EmptyBody().skipLine
                        EmptyBody().backToMain(sortedL)
                    }
                    3->{
                        val sortedL = list.sortedBy {
                            it.fluidLevel
                        }.toMutableList()
                        println("Сортировка завершена")
                        EmptyBody().skipLine
                        EmptyBody().backToMain(sortedL)
                    }
                }
            }
            2->{
                when(noN){
                    1->{
                        val sortedL = list.sortedByDescending {
                            it.typeOfFigure
                        }.toMutableList()
                        println("Сортировка завершена")
                        EmptyBody().skipLine
                        EmptyBody().backToMain(sortedL)
                    }
                    2->{
                        val sortedL = list.sortedByDescending {
                            (Math.round(it.valume * 1000.0)/1000.0)
                        }.toMutableList()
                        println("Сортировка завершена")
                        EmptyBody().skipLine
                        EmptyBody().backToMain(sortedL)
                    }
                    3->{
                        val sortedL = list.sortedByDescending {
                            it.fluidLevel
                        }.toMutableList()
                        println("Сортировка завершена")
                        EmptyBody().skipLine
                        EmptyBody().backToMain(sortedL)
                    }
                }
            }
            0->sort(list)
        }
    }catch (e:Exception){
        EmptyBody().errorRead(from = "0", to = "2")
    }


}

fun sort(list: MutableList<MainTypesInfo>){
    println("__Сортировка__")
    EmptyBody().skipLine

    while (true){
        println("""
            1. Названию
            2. Общему объёму
            3. Объёму жидкости
            0. Отмена
        """.trimIndent())
        try {
            when(val a = readln().toInt()){
                in 1..3->subSort(list, a)
                0-> EmptyBody().backToMain(list)
                else-> throw Exception()
            }
        }catch (e:Exception){
            EmptyBody().errorRead(from = "0", to = "3")
        }
    }
}