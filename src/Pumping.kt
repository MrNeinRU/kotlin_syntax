
private enum class En(val value: String) {
    IN("закачка"), OUT("откачка")
}
private data class PumpingOptions(
    val ID: Int,
    val pInOut:En? = null,
    val startingPoint: Double,
    val endingPoint: Double? = null,
    val randomized:Boolean = false,
    val randRange: IntRange = 0..0
)
class Pumping (private val list: MutableList<MainTypesInfo>){
    private val printingList = EmptyBody().printRow(list)

    private fun typeOfAction(modifierList: MutableMap<Int, PumpingOptions>, objectT: Int):MutableMap<Int, PumpingOptions>{
        println("Меню: Тип действия *")
        EmptyBody().skipLine
        while (true){
            println("""
                Тип:
                1. Закачка
                2. Откачка
            """.trimIndent())
            try {
                when(readln().toInt()){
                    1->{
                        while (true){
                            println("""
                                        До какого уровня
                                        Допустимы значения от ${list[objectT-1].fluidLevel} до ${list[objectT-1].valume}
                                        """.trimIndent())
                            try {
                                when(val x = readln().toDouble()){
                                    in list[objectT-1].fluidLevel..list[objectT-1].valume->{
                                        modifierList[objectT] = modifierList[objectT]!!.copy(
                                            pInOut = En.IN, endingPoint = x)
                                        break
                                    }
                                    else->throw Exception("Ошибка ввода")
                                }
                            }catch (e:Exception){
                                EmptyBody().errorRead(from = "${list[objectT-1].fluidLevel}", to = "${list[objectT-1].valume}")
                            }
                        }
                        break
                    }
                    2->{
                        while (true){
                            println("""
                                        До какого уровня
                                        Допустимы значения от ${list[objectT-1].fluidLevel} до 0.0
                                        """.trimIndent())
                            try {
                                when(val x = readln().toDouble()){
                                    in 0.0..list[objectT-1].fluidLevel->{
                                        modifierList[objectT] = modifierList[objectT]!!.copy(
                                            pInOut = En.OUT, endingPoint = x)
                                        break
                                    }
                                    else->throw Exception("Ошибка ввода")
                                }
                            }catch (e:Exception){
                                EmptyBody().errorRead(from = "${list[objectT-1].fluidLevel}", to = "0.0")
                            }
                        }
                        break
                    }
                    else->throw Exception("Ошибка ввода")
                }
            }catch (e:Exception){
                EmptyBody().errorRead(from = "0", to = "2")
            }
        }
        return modifierList
    }

    private fun randAction(modifierList: MutableMap<Int, PumpingOptions>, objectT: Int):MutableMap<Int, PumpingOptions>{
        println("Меню: Рандомизазия")
        EmptyBody().skipLine
        while (true){
            println("""
                Установить случайную скорость изменения уровня жидкости:
                1. да
                2. нет
            """.trimIndent())
            try {
                when(readln().toInt()){
                    1->{
                        println("Впишите допустимые пределы")
                        EmptyBody().skipLine
                        println(
                            EmptyBody().helpMassageForChangeData(
                                typeOfData = "список значений",
                                example = "1 2",
                                acceptable_value = "Допустм ввод только 2 значений, где первое значение больше второго"
                            )
                        )
                        while (true){
                            try {
                                val z = readln()
                                if(z.split(" ").size == 2){
                                    if (z.split(" ")[0].toInt() < z.split(" ")[1].toInt()){
                                        if (z.split(" ")[1].toInt() < 100){
                                            modifierList[objectT] = modifierList[objectT]!!.copy(
                                                randomized = true, randRange = z.split(" ")[0].toInt()..z.split(" ")[1].toInt()
                                            )
                                            break
                                        }else throw Exception("Ошибка ввода")
                                    }else throw Exception("Ошибка ввода")
                                }else throw Exception("Ошибка ввода")

                            }catch (e:Exception){
                                EmptyBody().errorRead(from = "1", to = "100")
                            }
                        }
                        break
                    }
                    2-> {
                        modifierList[objectT] = modifierList[objectT]!!.copy(
                            randomized = false, randRange = 0..0
                        )
                        return modifierList
                    }
                }
            }catch (e:Exception){
                EmptyBody().errorRead(from = "1", to = "2")
            }

            break
        }
        return modifierList
    }

    private fun typeAndOptionsOfPumping(selectedOb: List<Int>){
        var modifierList: MutableMap<Int, PumpingOptions> = mutableMapOf()

        println("Запущен процесс обработки")
        EmptyBody().skipLine
        selectedOb.forEach{ objectT ->

            modifierList[objectT] = PumpingOptions(ID = objectT, startingPoint = list[objectT-1].fluidLevel)
            while (true){
                val mes = if(modifierList[objectT]!!.pInOut != null)
                    "тип: ${if (modifierList[objectT]!!.pInOut == En.IN) En.IN.value else En.OUT.value} |конечная точка: ${modifierList[objectT]!!.endingPoint}"
                else ""

                println("Выберете пункт для изменения")
                print("* помечены обязательные пункты")
                EmptyBody().printRowTitle(list).apply(::print)
                EmptyBody().printRow(list, ID = objectT-1, modifier = false).forEach(::println)
                EmptyBody().skipLine
                println("""
                1. Тип действия * $mes
                2. Рандомизировать? ${if(modifierList[objectT]!!.randomized) "пределы ${modifierList[objectT]!!.randRange}" else ""}
                3. Подтвердить у ${list[objectT-1].typeOfFigure}
                0. Отмена
            """.trimIndent())
                try {
                    when(readln().toInt()){
                        1->modifierList = typeOfAction(modifierList, objectT)
                        2->randAction(modifierList, objectT)
                        3->{
                            if (modifierList[objectT]!!.pInOut!=null && modifierList[objectT]!!.endingPoint!=null)
                                break
                            else throw Exception("1")
                        }
                        0-> EmptyBody().backToMain(list)
                        else-> throw Exception("Ошибка ввода")
                    }
                }catch (e:Exception){
                    if (e.message != "1")
                        EmptyBody().errorRead(from = "0", to = "2")
                    else println("Не заполнены ключевые данные\n")
                }
            }

        }
        println("Обработка завершина\n")

        //todo вход в короутину
    }

    fun startSelectPump(){
        println("__Закачка/Откачка__")
        //EmptyBody().skipLine
        println(
            EmptyBody().helpMassageForChangeData(
                typeOfData = "значение или список значений",
                example = "1 / 1 2 3",
                acceptable_value = "допускаются только уникальные значения"
            )
        )
        EmptyBody().skipLine
        while (true){
            println("___${EmptyBody().printRowTitle(list)}")
            printingList.forEach(::println)
            println("0. Отмена")
            try {
                val a = readln()
                try {
                    if (a.toInt() == 0) EmptyBody().backToMain(list)
                }catch (e:Exception){
                    //println(e)
                }
                a.split(" ").forEach {
                    it.toInt()
                    when(it.toInt()){
                        in 1..list.size->{
                            var c = 0
                            a.split(" ").forEach { s->
                                if (it.toInt() == s.toInt()) {
                                    c++
                                    if (c>1)throw Exception("Ошибка ввода (неуникальность)")
                                }
                            }
                        }
                        else -> throw Exception("Ошибка ввода (смотри подсказку)")
                    }
                }
                when{
                    a.split(" ").size == 1->{

                        a.toIntOrNull()?.let {
                            typeAndOptionsOfPumping(listOf(it))
                        }?: run { throw Exception("Ошибка ввода (смотри подсказку)") }
                    }
                    a.split(" ").size != 1->{
                        val mutableList:MutableList<Int> = mutableListOf()
                        a.split(" ").forEach {
                            mutableList.add(it.toInt())
                        }
                        typeAndOptionsOfPumping(mutableList.toList())
                    }
                    else->throw Exception("Ошибка ввода")
                }
            }catch (e:Exception){
                println(">> ${e.message}")
                EmptyBody().errorRead(from = "0 (только выход)", to = "списка")
            }
        }
    }
}