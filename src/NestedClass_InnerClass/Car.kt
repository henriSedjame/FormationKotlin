package NestedClass_InnerClass

class Car(val nbroues : Int) {

    inner class Moteur(val carburant : String){

        fun puissance(){
            println("Le moteur prend du $carburant comme carbuant et la voiture a $nbroues roues")
        }
    }
}