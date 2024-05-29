class ListOfTanks {
    fun printListOfTanks(list: MutableList<MainTypesInfo>) {
        val checkLength = EmptyBody().showLengthTable(list)
        val printedList = EmptyBody().printRow(list = list, modifier = false)
        val dop = 3



        val prt = ("|-"+"-".repeat(checkLength[0][0]+dop)+"-|-"
        +"-".repeat(checkLength[0][1]+dop)+"-|-"
        +"-".repeat(checkLength[0][2]+dop)+"-|-"
        +"-".repeat(checkLength[0][3]+dop)+"-|-"
        +"-".repeat(checkLength[0][4]+dop)+"-|")

        EmptyBody().listOfTanksTitle().apply(::print)
        //print(prt)
        println(
            EmptyBody().printRowTitle(list)
        )
        println(prt)
        printedList.forEachIndexed { index, it ->
            println("$it debug => ${list[index]::class.java.typeName} ${list[index].percent}%")
            println(prt)
        }

        EmptyBody().backToMain(list)
    }
}