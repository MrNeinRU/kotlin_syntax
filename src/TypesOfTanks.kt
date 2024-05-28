private data class volume(
    val name: String,
    val typeOfTanks: String,
    val formula_V: String,
)

class TypesOfTanks{
    private val nameP = "Параллелепипед"
    private val parallelepiped_V = "V = a * b * c"
    private val parallelepiped = """
            +------+.
            |`.    | `.         $nameP
            |  `+--+---+    
            |   |  |   |    ${EmptyBody().formulaV}        
            +---+--+.  |        $parallelepiped_V
             `. |    `.|
               `+------+
        """.trimIndent()

    private val nameC = "Цилиндр"
    private val cylinder_V = "V = π * r^2 * h"
    private val cylinder = """
             .-----.        $nameC
            (       )   
            |'-----'|   ${EmptyBody().formulaV}       
            |       |       $cylinder_V       
            |.-----.|
            (       )
             '-----'
        """.trimIndent()


    private val ellipsoid = """
            _________
            |       |
            |       | <- цилиндр
            |       |
            (       ) <- полусфера
             (_____)
        """.trimIndent()


    fun typeOfTanks(list: MutableList<MainTypesInfo>){
        println("__Виды резервуаров__")
        EmptyBody().skipLine
        val l = listOf(
            volume(name = nameP, typeOfTanks = parallelepiped, formula_V = parallelepiped_V),
            volume(name = nameC, typeOfTanks = cylinder, formula_V = cylinder_V),
        )
        l.forEach {
            print(it.typeOfTanks)
            EmptyBody().skipLine
        }
        EmptyBody().backToMain(list)

    }
}