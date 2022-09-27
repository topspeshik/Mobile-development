
import kotlin.math.*
fun main() {
    var n = 10
    var m = 5
    var arr =  Array(n, { Array(m, {0}) })


    var a = n*m
        for (i in 0..max(n,m)+max(n,m)){
             for (j in 0.. i){
                 if (i-j < n && j< m &&  arr[i-j][j] == 0 ) {
                     arr[i - j][j] = a
                     a--
                 }
             }
        }

    for ( i in arr){
        for (j in i){
            print(j.toString() + " ")
        }
        println()
    }


}