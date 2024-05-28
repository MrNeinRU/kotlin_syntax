import javax.security.auth.login.LoginException

private fun beginFilter(list: MutableList<MainTypesInfo>, byField:Int){
    val printedList = EmptyBody().printRow(list = list, modifier = false)

    println("Нынешняя таблица")
    EmptyBody().skipLine
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
                    val printedList2 = EmptyBody().printRow(list = tempList.toMutableList(), modifier = false)
                    printedList2.forEachIndexed { index, it ->
                        println(it)
                    }
                    if (tempList.isEmpty()) println("Данных нет")
                    EmptyBody().skipLine
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
                    println(str.split("&&").size)
                    val tempList = list.filter {
                        var target:Double = when(byField){
                            3->{
                                it.fluidLevel
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
                    printedList2.forEachIndexed { index, it ->
                        println(it)
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
            when(val a = readln().toInt()){
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
            Фильтровать по:
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

fun sort(list: MutableList<MainTypesInfo>){

    val sortedList = list.sortedBy{ it.fluidLevel.toInt() }//todo не работает сортировка
    sortedList.forEach {
        println(it)
    }

    EmptyBody().backToMain(list)
}