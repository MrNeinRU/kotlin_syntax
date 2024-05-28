class ListOfTanks {
    fun printListOfTanks(list: MutableList<MainTypesInfo>) {
        val checkLength = EmptyBody().showTable(list)
        val printedList = EmptyBody().printRow(list = list, modifier = false)
        val dop = 3

        println(EmptyBody().listOfTanksTitle())

        val prt = ("|-"+"-".repeat(checkLength[0][0]+dop)+"-|-"
        +"-".repeat(checkLength[0][1]+dop)+"-|-"
        +"-".repeat(checkLength[0][2]+dop)+"-|-"
        +"-".repeat(checkLength[0][3]+dop)+"-|-"
        +"-".repeat(checkLength[0][4]+dop)+"-|")

        println(prt)
        println(
            "|"+"Название"+" ".repeat(checkLength[0][0]-"Название".length+2+dop)+"|"
                    +"Объём"+" ".repeat(checkLength[0][1]-"объём".length+2+dop)+"|"
                    +"Уров."+" ".repeat(checkLength[0][2]-"Уров.".length+2+dop)+"|"
                    +"IN"+" ".repeat(checkLength[0][3]-"IN".length+2+dop)+"|"
                    +"OUT"+" ".repeat(checkLength[0][4]-"OUT".length+2+dop)+"|"
        )
        println(prt)
        printedList.forEachIndexed { index, it ->
            println("$it debug => ${list[index]::class.java.typeName} ${list[index].percent}%")
            println(prt)
        }

        EmptyBody().backToMain(list)
    }
}