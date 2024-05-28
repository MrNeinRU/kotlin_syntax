data class volume(
    val typeOfTanks: String,
    val formula_V: String,
)

class TypesOfTanks{
    private val parallelepiped_V = "V = a * b * c"
    private val parallelepiped = """
            +------+.
            |`.    | `. 
            |  `+--+---+    ${EmptyBody().formulaV}
            |   |  |   |        $parallelepiped_V
            +---+--+.  |
             `. |    `.|
               `+------+
        """.trimIndent()

    private val cylinder_V = "V = π * r^2 * h"
    private val cylinder = """
             .-----.
            (       )   ${EmptyBody().formulaV}
            |'-----'|       $cylinder_V
            |       |       
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
        val l = listOf(
            volume(typeOfTanks = parallelepiped, formula_V = parallelepiped_V),
            volume(typeOfTanks = cylinder, formula_V = cylinder_V),
        )
        l.forEach {
            print(it.typeOfTanks)
            EmptyBody().skipLine
//            print("     ")
//            println(it.formula_V)
        }
        EmptyBody().backToMain(list)

    }
}