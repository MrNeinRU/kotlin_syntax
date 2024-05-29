import kotlin.system.exitProcess

class Main{
    fun mainMenu(listIk: MutableList<MainTypesInfo>?){
        println("Выберите пункт меню.")
        EmptyBody().skipLine
        println("1. Виды резервуаров.")
        println("2. Вывести список резервуаров.")
        println("3. Закачка/откачка.")
        println("4. Добавить резервуар.")
        println("5. Изменить данные резервуара.")
        println("6. Удалить резервуар.")
        println("7. Фильтровать резервуары.")
        println("8. Сортировать резервуары.")
        println("9. test.")
        println("0. Выход.")

        var optionS:Int?

        while (true){
            try {
                when(val ff = readln().toInt()){
                    in 0..9->{
                        optionS = ff
                        break
                    }
                    else->{
                        throw Exception("Not valid")
                    }
                }
            }catch (e:Exception){
                EmptyBody().errorRead(from = "0",to = "8+9")
            }
        }

        when(optionS){
            1->{
                TypesOfTanks().typeOfTanks(listIk!!)
            }
            2->{
                ListOfTanks().printListOfTanks(listIk!!)
            }
            3->{
                Pumping(listIk!!).startSelectPump()
            }
            4->{
                createNew(listIk!!)
            }
            5->{
                changeDataBy(listIk!!)
            }
            6->{
                deleteIt(listIk!!)
            }
            7->{
                filter(listIk!!)
            }
            8->{
                sort(listIk!!)
            }
            9->{
                test(listIk!!)
            }
            0->{
                exitProcess(0)
            }
            else->{
                println("Неожиданная ошибка")
            }
        }
    }
}



fun main() {
    val listIk_ = EmptyBody().defaultLoad()
    Main().mainMenu(listIk_)
}
