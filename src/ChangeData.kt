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
            when(val f = readln().toInt()){
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
    println("Создание")

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
    val printedList = EmptyBody().printRow(list, ID)
    var changed = 0

    println("Изменяемый элемент")
    printedList.forEach {
        println(it)
    }

    val ty:MainTypesInfo = list[ID!!]

//    val chParallelepipedInfo = ParallelepipedInfo(
//        typeOfFigure = list[ID].typeOfFigure,
//        sizes = list[ID].sizes,
//        fluidLevel = list[ID].fluidLevel,
//        pumpingSpeedIN = list[ID].pumpingSpeedIN,
//        pumpingSpeedOUT = list[ID].pumpingSpeedOUT
//    )
//    val chCylinderInfo = CylinderInfo(
//        typeOfFigure = list[ID].typeOfFigure,
//        sizes = list[ID].sizes,
//        fluidLevel = list[ID].fluidLevel,
//        pumpingSpeedIN = list[ID].pumpingSpeedIN,
//        pumpingSpeedOUT = list[ID].pumpingSpeedOUT
//    )

    println(">> ${ty::class.java.typeName} <<")
    EmptyBody().skipLine

    while (true){
        println("Выберите параметр для изменения.")
        EmptyBody().skipLine
        println("""
            1. название    (${ty.typeOfFigure})
            2. размеры    (${ty.sizes}) объём: ${(Math.round(ty.valume * 1000.0)/1000.0)}
            3. заполненность    (${ty.fluidLevel}) ${if (fromCreat) "быстрое изменение доступно только сейчас" else ""}
            4. скорость закачки    (${ty.pumpingSpeedIN})
            5. скорость откачки    (${ty.pumpingSpeedOUT}) 
            6. СОХРАНИТЬ    ${if (fromCreat) "и выйти" else ""}
        """.trimIndent())
        println("0. Отмена")

        try {
            when(val k = readln().toInt()){
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
                                        if (a.toDouble()<=ty.valume && a.toDouble()>=0.0){
                                            changed = 1
                                            ty.fluidLevel = a.toDouble()
                                            break
                                        }else{
                                            throw Exception("NOT")
                                        }

                                    }
                                }
                            }catch (e:Exception){
                                EmptyBody().errorRead(from = "0", to = "${ty.valume}")
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
                        if (fromCreat) EmptyBody().backToMain(list)
                    }else throw LoginException("EX")
                }
                0->{
                    if (changed == 0 && fromCreat) {
                        list.removeAt(ID)
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
    println("Изменение")

    while (true){
        println("Выберите объект для изменения.")
        val printedList = EmptyBody().printRow(list)
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
    println("Удаление")
    val checkLength = EmptyBody().showTable(list)

    while (true){
        println("Выберите объект для удаления.")
        EmptyBody().skipLine

        list.forEachIndexed { index, it ->
            println(
                "[${index+1}]| ${it.typeOfFigure}" + " ".repeat(checkLength[0][0]-it.typeOfFigure.length) +
                        " | ${Math.round(it.valume * 1000.0)/1000.0}" + " ".repeat(checkLength[0][1]-(Math.round(it.valume * 1000.0)/1000.0).toString().length) +
                        " | ${Math.round(it.fluidLevel * 1000.0)/1000.0}" + " ".repeat(checkLength[0][2]-(Math.round(it.fluidLevel * 1000.0)/1000.0).toString().length) +
                        " | ${Math.round(it.pumpingSpeedIN * 1000.0)/1000.0}" + " ".repeat(checkLength[0][3]-(Math.round(it.pumpingSpeedIN * 1000.0)/1000.0).toString().length) +
                        " | ${Math.round(it.pumpingSpeedOUT * 1000.0)/1000.0} |" + " ".repeat(checkLength[0][4]-(Math.round(it.pumpingSpeedOUT * 1000.0)/1000.0).toString().length))
        }
        println("0. Отмена")

        try {
            when(val k = readln().toInt()){
                in 1..list.size->{
                    list.removeAt(k-1)
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