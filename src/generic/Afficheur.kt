package generic

import java.lang.StringBuilder

class Afficheur() {


    fun <T> affiche(list : Array<T>): String{
        val builder = StringBuilder()
        var separator = ""

        return buildString {
            list.reversed().forEach {
                this.append(separator)
                this.append(it)
                separator = " ,"
            }
        }
    }
}