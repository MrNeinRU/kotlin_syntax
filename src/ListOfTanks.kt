class ListOfTanks {
    fun printListOfTanks(list: MutableList<MainTypesInfo>) {
        val checkLength = EmptyBody().showTable(list)
        val printedList = EmptyBody().printRow(list = list, modifier = false)
        println(EmptyBody().listOfTanksTitle())

        val prt = ("|-"+"-".repeat(checkLength[0][0])+"-|-"
        +"-".repeat(checkLength[0][1])+"-|-"
        +"-".repeat(checkLength[0][2])+"-|-"
        +"-".repeat(checkLength[0][3])+"-|-"
        +"-".repeat(checkLength[0][4])+"-|")

        println(prt)
        println(
            "|"+"Название"+" ".repeat(checkLength[0][0]-"Название".length+2)+"|"
                    +"Объём"+" ".repeat(checkLength[0][1]-"объём".length+2)+"|"
                    +"Уров."+" ".repeat(checkLength[0][2]-"Уров.".length+2)+"|"
                    +"IN"+" ".repeat(checkLength[0][3]-"IN".length+2)+"|"
                    +"OUT"+" ".repeat(checkLength[0][4]-"OUT".length+2)+"|"
        )
        println(prt)
        printedList.forEachIndexed { index, it ->
            println("$it ${list[index]::class.java.typeName}")
            println(prt)
        }

        EmptyBody().backToMain(list)
    }
}