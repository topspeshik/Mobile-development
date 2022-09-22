import java.io.FileInputStream
import java.util.*

fun main() {
    val sc = Scanner(FileInputStream("roles.txt"))

    val roles = arrayListOf<String>()
    val textLines = arrayListOf<String>()
    var line  = ""
    var c  = 0

    while (sc.hasNextLine()) {
        line = sc.nextLine()
        if (line == "textLines:" || c > 0) {
            c++
            textLines.add((c-1).toString() + ") " + line)
        }
        else
            roles.add(line +":")
    }
    roles.removeAt(0)
    textLines.removeAt(0)

    var arr =  Array(roles.size, { Array(textLines.size+1, {"0"}) })

    arr.forEachIndexed{i, el ->
        arr[i][0] = roles[i]

    }
   for (i in 0..roles.size-1 ){
       for (j in 0..textLines.size-1 ){
            if (textLines[j].substring(3,textLines[j].indexOf(":")+1).startsWith(arr[i][0]) || (arr[i][0].indexOf(" ")) > 0 &&
                textLines[j].substring(3,textLines[j].indexOf(":")+1).startsWith(arr[i][0].substring(0,arr[i][0].indexOf(" ")))) {
                arr[i][j + 1] = textLines[j]
            }

        }

    }

    for (array in arr) {
        for (value in array) {
            if (value != "0")
            println(value)
        }
        println()
    }

}