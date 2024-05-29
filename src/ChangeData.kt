import javax.security.auth.login.LoginException

private fun subCreate(ch:Int, list: MutableList<MainTypesInfo>){
    while (true){
        when(ch){
            1->{
                println("""
                        Создать стандартный объект?
                        
                        название: Параллелепипед
                        размеры: a=2.0, b=2.0, c=6.0
                        заполненность: пустой(0.0)
                        скорость закачки: 1.0
                        скорость откачки: 1.0
                    """.trimIndent())
                EmptyBody().skipLine
            }
            2->{
                println("""
                        Создать стандартный объект?
                        
                        название: Цилиндр
                        размеры: r=1.5, h=5.0
                        заполненность: пустой(0.0)
                        скорость закачки: 1.0
                        скорость откачки: 1.0
                    """.trimIndent())
                EmptyBody().skipLine
            }
        }
        println("""
            1. Да
            2. Нет
            0. Отмена
        """.trimIndent())
        try {
            when(readln().toInt()){
                1->{
                    when(ch){
                        1->{list.add(ParallelepipedInfo())}
                        2->{list.add(CylinderInfo())}
                    }
                    EmptyBody().backToMain(list)
                }
                2->{
                    when(ch){
                        1->{list.add(ParallelepipedInfo())}
                        2->{list.add(CylinderInfo())}
                    }
                    subChangeBy(list, list.size-1, fromCreat = true)
                }
                0->{
                    EmptyBody().backToMain(list)
                }
            }
        }catch (e:Exception){
            EmptyBody().errorRead(from = "0",to = "2")
        }

    }
}


fun createNew(list: MutableList<MainTypesInfo>){
    println("__Создание__\n")

    while (true){
        println("""
            Тип добавляемого объекта
            
            1. Параллелепипед
            2. Цилиндр
            0. Отмена
        """.trimIndent())
        try {
            when(val i = readln().toInt()){
                in 1..2->{
                   subCreate(i, list)
                }
                0->{
                    EmptyBody().backToMain(list)
                }
                else->{
                    throw Exception("NOT")
                }
            }
        }catch (e:Exception){
            EmptyBody().errorRead(from = "0",to = "2")
        }
    }
}

private fun subChangeBy(list: MutableList<MainTypesInfo>, ID:Int?,
                        fromCreat:Boolean = false){
    val printedList = EmptyBody().printRow(list, ID, modifier = false)
    var changed = 0

    println("\\/ Изменяемый элемент \\/")
    EmptyBody().printRowTitle(list).apply(::println)
    printedList.forEach {
        println(it)
    }

    val ty:MainTypesInfo = list[ID!!]
    val cloned = when(list[ID]::class.java.typeName){
        "ParallelepipedInfo"->{
            ParallelepipedInfo(
                list[ID].typeOfFigure,
                list[ID].sizes,
                list[ID].fluidLevel,
                list[ID].pumpingSpeedIN,
                list[ID].pumpingSpeedOUT
            )
        }
        else->{
            CylinderInfo(
                list[ID].typeOfFigure,
                list[ID].sizes,
                list[ID].fluidLevel,
                list[ID].pumpingSpeedIN,
                list[ID].pumpingSpeedOUT
            )
        }
    }

    //println(">> ${ty::class.java.typeName} <<")
    EmptyBody().skipLine

    while (true){
        println("Выберите параметр для изменения.")
        EmptyBody().skipLine
        println("""
            1. название    (${ty.typeOfFigure})
            2. размеры    (${ty.sizes}) объём: ${(Math.round(ty.valume * 1000.0)/1000.0)} м³
            3. заполненность    (${ty.fluidLevel}) м³ ${if (fromCreat) "быстрое изменение доступно только сейчас" else ""}
            4. скорость закачки    (${ty.pumpingSpeedIN})
            5. скорость откачки    (${ty.pumpingSpeedOUT}) 
            6. СОХРАНИТЬ    ${if (fromCreat) "и выйти" else ""}
        """.trimIndent())
        println("0. Отмена")

        try {
            when(readln().toInt()){
                1->{
                    println("нынешнее значение -> ${ty.typeOfFigure}")
                    EmptyBody().skipLine
                    println(EmptyBody().helpMassageForChangeData())
                    EmptyBody().skipLine
                    print("Введите новое значение: ")
                    while (true){
                        try {
                            val a = readln()
                            when{
                                a.isEmpty() ->{
                                    throw Exception("NOT")
                                }
                                else->{
                                    changed = 1
                                    ty.typeOfFigure = a
                                    break
                                }
                            }
                        }catch (e:Exception){
                            EmptyBody().errorRead()
                        }
                    }
                }
                2->{
                    println("нынешнее значение -> ${ty.sizes}")
                    EmptyBody().skipLine
                    println(EmptyBody().helpMassageForChangeData(
                        typeOfData = "перечень значений",
                        example = "1 2 3",
                        acceptable_value = ty.sizes.size.toString()
                    ))
                    EmptyBody().skipLine
                    print("Введите новое значение: ")
                    while (true){
                        try {
                            val a = readln()
                            when{
                                a.isEmpty() ->{
                                    throw Exception("NOT")
                                }
                                else->{
                                    if (a.split(" ").size == ty.sizes.size){
                                        val mTempList = mutableListOf<Double>()
                                        a.split(" ").forEach {
                                            println(it.toDouble())
                                            mTempList.add(it.toDouble())
                                        }
                                        changed = 1
                                        ty.sizes = mTempList
                                        break
                                    }else{
                                        throw Exception("NOT")
                                    }

                                }
                            }
                        }catch (e:Exception){
                            EmptyBody().errorRead()
                        }
                    }
                }
                3->{
                    if (fromCreat){
                        println("нынешнее значение -> ${ty.fluidLevel}")
                        EmptyBody().skipLine
                        println(EmptyBody().helpMassageForChangeData(
                            typeOfData = "значение",
                            example = "1",
                            acceptable_value = "1 | допустимы значения от 0.0 до ${ty.valume}"
                        ))
                        EmptyBody().skipLine
                        print("Введите новое значение: ")
                        while (true){
                            try {
                                val a = readln()
                                when{
                                    a.isEmpty() ->{
                                        throw Exception("NOT")
                                    }
                                    else->{
                                        if (a.toDouble()<=(Math.round(ty.valume * 1000.0)/1000.0) && a.toDouble()>=0.0){
                                            changed = 1
                                            ty.fluidLevel = a.toDouble()
                                            break
                                        }else{
                                            throw Exception("NOT")
                                        }

                                    }
                                }
                            }catch (e:Exception){
                                EmptyBody().errorRead(from = "0", to = "${(Math.round(ty.valume * 1000.0)/1000.0)}")
                            }
                        }
                    }else{
                        println("Изменения уровня жидкости производятся из спец. меню")
                    }
                }
                4->{
                    println("нынешнее значение -> ${ty.pumpingSpeedIN}")
                    EmptyBody().skipLine
                    println(EmptyBody().helpMassageForChangeData(
                        typeOfData = "значение",
                        example = "1",
                        acceptable_value = "1"
                    ))
                    EmptyBody().skipLine
                    print("Введите новое значение: ")
                    while (true){
                        try {
                            val a = readln()
                            when{
                                a.isEmpty() ->{
                                    throw Exception("NOT")
                                }
                                else->{
                                    if (a.toDouble()<=100.0 && a.toDouble()>0.0){
                                        changed = 1
                                        ty.pumpingSpeedIN = a.toDouble()
                                        break
                                    }else{
                                        throw Exception("NOT")
                                    }

                                }
                            }
                        }catch (e:Exception){
                            EmptyBody().errorRead(from = "больше 0", to = "100")
                        }
                    }
                }
                5->{
                    println("нынешнее значение -> ${ty.pumpingSpeedOUT}")
                    EmptyBody().skipLine
                    println(EmptyBody().helpMassageForChangeData(
                        typeOfData = "значение",
                        example = "1",
                        acceptable_value = "1"
                    ))
                    EmptyBody().skipLine
                    print("Введите новое значение: ")
                    while (true){
                        try {
                            val a = readln()
                            when{
                                a.isEmpty() ->{
                                    throw Exception("NOT")
                                }
                                else->{
                                    if (a.toDouble()<=100.0 && a.toDouble()>0.0){
                                        changed = 1
                                        ty.pumpingSpeedOUT = a.toDouble()
                                        break
                                    }else{
                                        throw Exception("NOT")
                                    }

                                }
                            }
                        }catch (e:Exception){
                            EmptyBody().errorRead(from = "больше 0", to = "100")
                        }
                    }
                }
                6->{
                    if (changed == 1) {
                        list[ID] = ty
                        println("Значения сохранены")
                        EmptyBody().skipLine
                        if (fromCreat) EmptyBody().backToMain(list) else subChangeBy(list, ID, fromCreat)
                    }else throw LoginException("EX")
                }
                0->{
                    if (fromCreat) {
                        list.removeAt(ID)
                    }else{
                        list[ID] = cloned
                    }
                    EmptyBody().backToMain(list)
                }
                else->{
                    throw Exception("NOT")
                }
            }
        }catch (e: LoginException){
            println("""
                В сохранение отказано
                >> Данные не были изменены
                """.trimIndent())
            EmptyBody().skipLine
        }catch (e:Exception){
            EmptyBody().errorRead(from = "0",to = "6")
        }
    }
}

fun changeDataBy(list: MutableList<MainTypesInfo>){
    println("__Изменение__")

    while (true){
        println("Выберите объект для изменения.")
        val printedList = EmptyBody().printRow(list)
        println("___${EmptyBody().printRowTitle(list)}")
        printedList.forEach {
            println(it)
        }
        println("0. Отмена")

        try {
            when(val k = readln().toInt()){
                in 1..list.size->{
                    subChangeBy(list, k-1)
                }
                0->{
                    EmptyBody().backToMain(list)
                }
                else->{
                    throw Exception("NOT")
                }
            }
        }catch (e:Exception){
            EmptyBody().errorRead(from = "0",to = "${list.size}")
        }
    }
}

fun deleteIt(list: MutableList<MainTypesInfo>){

    val printedList = EmptyBody().printRow(list)
    println("__Удаление__")
    EmptyBody().skipLine
    while (true){
        println("Выберите объект для удаления.")
        EmptyBody().skipLine
        println("___${EmptyBody().printRowTitle(list)}")
        printedList.forEach {
            println(it)
        }
        println("0. Отмена")

        try {
            when(val k = readln().toInt()){
                in 1..list.size->{
                    list.removeAt(k-1)
                    println("Объект удалён")
                    EmptyBody().backToMain(list)
                }
                0->{
                    EmptyBody().backToMain(list)
                }
                else->{
                    throw Exception("NOT")
                }
            }
        }catch (e:Exception){
            EmptyBody().errorRead(from = "0",to = "${list.size}")
        }
    }
}