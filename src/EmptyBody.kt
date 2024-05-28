class EmptyBody {
    val skipLine = println()
    fun errorRead(from:String? = null, to:String? = null){
        val subM = from?.let{"Попробуйте от $from до $to" }?: ""
        val errorRead = println("Введено некорректное значение! $subM")
    }
    val formulaV = "Формула вычисления объёма"
    fun subFormulaInfo():String{
        return "Где x - одно"
    }
    fun backToMain(list: MutableList<MainTypesInfo>){
        println("Нажмите Enter чтобы вернуться к меню")
        readln().let {
            Main().mainMenu(list)
        }
    }

    fun showTable(list: MutableList<MainTypesInfo>):MutableList<MutableList<Int>>{
        val checkLength:MutableList<MutableList<Int>> = mutableListOf(mutableListOf(0,0,0,0,0))

        list.forEach{item ->
            if (item.typeOfFigure.length>checkLength[0][0]) checkLength[0][0] = item.typeOfFigure.length
            if ((Math.round(item.valume * 1000.0)/1000.0).toString().length>checkLength[0][1]) checkLength[0][1] = (Math.round(item.valume * 1000.0)/1000.0).toString().length
            if ((Math.round(item.fluidLevel * 1000.0)/1000.0).toString().length>checkLength[0][2]) checkLength[0][2] = (Math.round(item.fluidLevel * 1000.0)/1000.0).toString().length
            if ((Math.round(item.pumpingSpeedIN * 1000.0)/1000.0).toString().length>checkLength[0][3]) checkLength[0][3] = (Math.round(item.pumpingSpeedIN * 1000.0)/1000.0).toString().length
            if ((Math.round(item.pumpingSpeedOUT * 1000.0)/1000.0).toString().length>checkLength[0][4]) checkLength[0][4] = (Math.round(item.pumpingSpeedOUT * 1000.0)/1000.0).toString().length
        }
        return checkLength

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

        val checkLength = EmptyBody().showTable(list)
        val tempList:MutableList<String> = mutableListOf()
        ID?.let {
            var id: String = ""
            if (modifier) id = "[${ID+1}]"

            tempList.add(
                "$id| ${list[ID].typeOfFigure}" + " ".repeat(checkLength[0][0]-list[ID].typeOfFigure.length) +
                        " | ${Math.round(list[ID].valume * 1000.0)/1000.0}" + " ".repeat(checkLength[0][1]-(Math.round(list[ID].valume * 1000.0)/1000.0).toString().length) +
                        " | ${Math.round(list[ID].fluidLevel * 1000.0)/1000.0}" + " ".repeat(checkLength[0][2]-(Math.round(list[ID].fluidLevel * 1000.0)/1000.0).toString().length) +
                        " | ${Math.round(list[ID].pumpingSpeedIN * 1000.0)/1000.0}" + " ".repeat(checkLength[0][3]-(Math.round(list[ID].pumpingSpeedIN * 1000.0)/1000.0).toString().length) +
                        " | ${Math.round(list[ID].pumpingSpeedOUT * 1000.0)/1000.0} |" + " ".repeat(checkLength[0][4]-(Math.round(list[ID].pumpingSpeedOUT * 1000.0)/1000.0).toString().length)
            )
        }?: run {
            list.forEachIndexed { index, it ->
                var id: String = ""
                if (modifier) id = "[${index+1}]"

                tempList.add(
                    "$id| ${it.typeOfFigure}" + " ".repeat(checkLength[0][0]-it.typeOfFigure.length) +
                            " | ${Math.round(it.valume * 1000.0)/1000.0}" + " ".repeat(checkLength[0][1]-(Math.round(it.valume * 1000.0)/1000.0).toString().length) +
                            " | ${Math.round(it.fluidLevel * 1000.0)/1000.0}" + " ".repeat(checkLength[0][2]-(Math.round(it.fluidLevel * 1000.0)/1000.0).toString().length) +
                            " | ${Math.round(it.pumpingSpeedIN * 1000.0)/1000.0}" + " ".repeat(checkLength[0][3]-(Math.round(it.pumpingSpeedIN * 1000.0)/1000.0).toString().length) +
                            " | ${Math.round(it.pumpingSpeedOUT * 1000.0)/1000.0} |" + " ".repeat(checkLength[0][4]-(Math.round(it.pumpingSpeedOUT * 1000.0)/1000.0).toString().length)
                )
            }
        }

        return tempList
    }

    fun defaultLoad():MutableList<MainTypesInfo>{
        val list: MutableList<MainTypesInfo> = mutableListOf()
        list.add(
            ParallelepipedInfo()
        )
        list.add(
            CylinderInfo(
                fluidLevel = 4.0
            )
        )
        return list
    }

    fun listOfTanksTitle():String{
        return """
            Список резервуаров
            
            [Объём - полный возможный объём резервуара]
            [Уров. - нынешний уровень жидкости]
            [IN - скорость закачки]
            [OUT - скорость откачки]
            
        """.trimIndent()
    }

}