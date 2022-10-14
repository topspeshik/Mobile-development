// сочетание определения класса и конструктора одновременно объявляет переменные и задаёт их значения
class Rect(var x: Int, var y: Int, var width: Int, var height: Int) : Movable, Figure(0), Transforming {
    // TODO: реализовать интерфейс Transforming
    var color: Int = -1 // при объявлении каждое поле нужно инициализировать

    lateinit var name: String // значение на момент определения неизвестно (только для объектных типов)
    // дополнительный конструктор вызывает основной
    constructor(rect: Rect) : this(rect.x, rect.y, rect.width, rect.height)

    override fun resize(zoom: Int) {
        width *= zoom
        height *= zoom
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int) {
        var tWidth = width
        width = height
        height = tWidth

        if (centerX == x && centerY == y) return

        if(direction == RotateDirection.Clockwise)
        {
            var tX = x
            x = y - centerY + centerX
            y = -1 * (tX - centerX) + centerY
        }
        else
        {
            var tX = x
            x = -1 * (y - centerY) + centerX
            y = tX - centerX + centerY
        }
    }

    // нужно явно указывать, что вы переопределяете метод
    override fun move(dx: Int, dy: Int) {
        x += dx; y += dy
    }

    // для каждого класса area() определяется по-своему
    override fun area(): Float {
        return (width*height).toFloat() // требуется явное приведение к вещественному числу
    }

    override fun toString(): String {
        return "x - $x, y - $y, width - $width, height - $height"
    }
}