import kotlin.math.PI

open class MainTypesInfo(
    var typeOfFigure: String,
    var sizes: List<Double>,
    var fluidLevel: Double = 0.0,
    var pumpingSpeedIN: Double = 1.0,
    var pumpingSpeedOUT: Double = 1.0
){
    open val valume: Double = 0.0
    open val percent:Double = 0.0
}

class ParallelepipedInfo(
    typeOfFigure: String = "Параллелепипед",
    sizes: List<Double> = listOf(2.0, 2.0, 6.0),
    fluidLevel: Double = 0.0,
    pumpingSpeedIN: Double = 1.0,
    pumpingSpeedOUT: Double = 1.0
) : MainTypesInfo(
    typeOfFigure,
    sizes,
    fluidLevel,
    pumpingSpeedIN,
    pumpingSpeedOUT
)
{
    override val valume:Double
        get() = (Math.round((this.sizes[0] * this.sizes[1] * this.sizes[2]) * 1000.0)/1000.0)

    override val percent: Double
        get() = ((this.fluidLevel * 100) / this.valume)
}

class CylinderInfo(
    typeOfFigure: String = "Цилиндр",
    sizes: List<Double> = listOf(1.5, 5.0),
    fluidLevel: Double = 0.0,
    pumpingSpeedIN: Double = 1.0,
    pumpingSpeedOUT: Double = 1.0
) : MainTypesInfo(
    typeOfFigure,
    sizes,
    fluidLevel,
    pumpingSpeedIN,
    pumpingSpeedOUT
)
{
    override val valume:Double
        get() = (Math.round((PI * (this.sizes[0]*this.sizes[0]) * this.sizes[1]) * 1000.0)/1000.0)

    override val percent: Double
        get() = ((this.fluidLevel * 100) / this.valume)
}