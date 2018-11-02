package NestedClass_InnerClass

class Bag(itemCount: Int) {

    val items = arrayOfNulls<Item>(itemCount)

    class Item(val weight : Int){

        fun showWeight(){
            println("Poids de l'item : $weight")
        }
    }
}