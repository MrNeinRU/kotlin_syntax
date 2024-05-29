class EmptyBody {
    val skipLine = println()
    private val dop = 3
    fun errorRead(from:String? = null, to:String? = null){
        val subM = from?.let{"Попробуйте от $from до $to" }?: ""
        println("Введено некорректное значение! $subM")
    }
    val formulaV = "Формула вычисления объёма"
    fun backToMain(list: MutableList<MainTypesInfo>){
        println("Нажмите Enter чтобы вернуться к меню")
        readln().let {
            Main().mainMenu(list)
        }
    }

    fun showLengthTable(list: MutableList<MainTypesInfo>):MutableList<MutableList<Int>>{
        val checkLength:MutableList<MutableList<Int>> = mutableListOf(mutableListOf(0,0,0,0,0))

        list.forEach{item ->
            if (item.typeOfFigure.length>checkLength[0][0]) checkLength[0][0] = item.typeOfFigure.length
            if ((Math.round(item.valume * 1000.0)/1000.0).toString().length>checkLength[0][1]) checkLength[0][1] = (Math.round(item.valume * 1000.0)/1000.0).toString().length
            if ((Math.round(item.fluidLevel * 1000.0)/1000.0).toString().length>checkLength[0][2]) checkLength[0][2] = (Math.round(item.fluidLevel * 1000.0)/1000.0).toString().length
            if ((Math.round(item.pumpingSpeedIN * 1000.0)/1000.0).toString().length>checkLength[0][3]) checkLength[0][3] = (Math.round(item.pumpingSpeedIN * 1000.0)/1000.0).toString().length
            if ((Math.round(item.pumpingSpeedOUT * 1000.0)/1000.0).toString().length>checkLength[0][4]) checkLength[0][4] = (Math.round(item.pumpingSpeedOUT * 1000.0)/1000.0).toString().length
        }
        return checkLength//[[14, 6, 3, 3, 3]]

    }

    fun helpMassageForChangeData(typeOfData:String = "строка", example:String = "Слово",
                                 acceptable_value:String? = null):String{
        val acceptable_valueT = acceptable_value?.let {
            "Допустимое количество значений: $acceptable_value"
        }?:run { "" }
        return """
            Подсказка:
            Тип данных: $typeOfData
            Пример: $example
            $acceptable_valueT
        """.trimIndent()
    }

    fun printRow(list: MutableList<MainTypesInfo>, ID:Int? = null,
                 modifier:Boolean = true):List<String>{
        //ID = index

        val checkLength = EmptyBody().showLengthTable(list)
        val tempList:MutableList<String> = mutableListOf()
        ID?.let {
            var id = ""
            if (modifier) id = "[${ID+1}]"

            tempList.add(
                "$id| ${list[ID].typeOfFigure}" + " ".repeat(checkLength[0][0]-list[ID].typeOfFigure.length + dop) +
                        " | ${Math.round(list[ID].valume * 1000.0)/1000.0}" + " ".repeat(checkLength[0][1]-(Math.round(list[ID].valume * 1000.0)/1000.0).toString().length + dop) +
                        " | ${Math.round(list[ID].fluidLevel * 1000.0)/1000.0}" + " ".repeat(checkLength[0][2]-(Math.round(list[ID].fluidLevel * 1000.0)/1000.0).toString().length + dop) +
                        " | ${Math.round(list[ID].pumpingSpeedIN * 1000.0)/1000.0}" + " ".repeat(checkLength[0][3]-(Math.round(list[ID].pumpingSpeedIN * 1000.0)/1000.0).toString().length + dop) +
                        " | ${Math.round(list[ID].pumpingSpeedOUT * 1000.0)/1000.0}" + " ".repeat(checkLength[0][4]-(Math.round(list[ID].pumpingSpeedOUT * 1000.0)/1000.0).toString().length+dop) + " |"
            )
        }?: run {
            list.forEachIndexed { index, it ->
                var id = ""
                if (modifier) id = "[${index+1}]"

                tempList.add(
                    "$id| ${it.typeOfFigure}" + " ".repeat(checkLength[0][0]-it.typeOfFigure.length + dop) +
                            " | ${Math.round(it.valume * 1000.0)/1000.0}" + " ".repeat(checkLength[0][1]-(Math.round(it.valume * 1000.0)/1000.0).toString().length + dop) +
                            " | ${(Math.round(it.percent * 1000.0)/1000.0)}" + " ".repeat(checkLength[0][2]-(Math.round(it.percent * 1000.0)/1000.0).toString().length + dop) +
                            " | ${Math.round(it.pumpingSpeedIN * 1000.0)/1000.0}" + " ".repeat(checkLength[0][3]-(Math.round(it.pumpingSpeedIN * 1000.0)/1000.0).toString().length + dop) +
                            " | ${Math.round(it.pumpingSpeedOUT * 1000.0)/1000.0}" + " ".repeat(checkLength[0][4]-(Math.round(it.pumpingSpeedOUT * 1000.0)/1000.0).toString().length+dop) + " |"
                )
            }
        }

        return tempList
    }

    fun printRowTitle(list: MutableList<MainTypesInfo>):String{
        val checkLength = EmptyBody().showLengthTable(list)

        val x = "|"+"Название"+" ".repeat(checkLength[0][0]-"Название".length+2+dop)+"|"+
                "Объём"+" ".repeat(checkLength[0][1]-"объём".length+2+dop)+"|"+
                "Уров.%"+" ".repeat(checkLength[0][2]-"Уров.%".length+2+dop)+"|"+
                "IN"+" ".repeat(checkLength[0][3]-"IN".length+2+dop)+"|"+
                "OUT"+" ".repeat(checkLength[0][4]-"OUT".length+2+dop)+"|"
        return x
    }

    fun defaultLoad():MutableList<MainTypesInfo>{
        val list: MutableList<MainTypesInfo> = mutableListOf()
        list.add(
            ParallelepipedInfo(
                fluidLevel = 4.0
            )
        )
        list.add(
            CylinderInfo()
        )
        return list
    }

    fun listOfTanksTitle():String{
        return """
            __Список резервуаров__
            
            [Объём (м³) - полный возможный объём резервуара]
            [Уров. (%) - нынешний уровень жидкости]
            [IN - скорость закачки]
            [OUT - скорость откачки]
            
        """.trimIndent()
    }

}