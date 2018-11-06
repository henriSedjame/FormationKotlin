import CompanionObject.Appareil
import cast.Femme
import cast.Homme
import cast.Person
import dataClass.Photo
import NestedClass_InnerClass.Bag
import NestedClass_InnerClass.Car
import java.lang.Exception
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        var homme : Homme = Homme()
        var femme : Femme = Femme()

        //SmartCast
        if (femme is Person) femme.presentation()

        //Safe cast
        (femme as? Homme)?.parler() // => rien ne se passe

        //Unsafe cast
        try {
            (femme as Homme).parler() // => levée d'une exception
        }catch (e : Exception) {
            println(e.message)
        }


        //Data Class
        val photo : Photo = Photo(femme, homme)

        /* Les méthodes auto générées */
        val copy1: Photo = photo.copy()
        val copy2 = photo.copy(femme, femme)
        var equals: Boolean = photo.equals(copy1)
        val hashCode: Int = photo.hashCode()
        val toString: String = photo.toString()
        val component1: Femme = photo.component1()
        val component2: Person = photo.component2()


        //Nested Class
        val bag : Bag = Bag(10);
        val item : Bag.Item = Bag.Item(50); // => instanciation de la nested class indépendamment de l'instance de sa classe parente
        item.showWeight();

        //Inner Class
        val voiture : Car = Car(4)
        val moteur = voiture.Moteur("diesel") // => instanciation de l' Inner class à partir de l'instance de sa classe parente
        moteur.puissance();

        //Companion Object
        val shot: Photo = Appareil.shot(femme, homme) // => La méthode shot() du companion Object s'utilise comme une méthode static en java

        //Delegates

        val p : String by lazy { "hello world" }

        var del : String by Delegate()

        var obs : String by Delegates.observable(""){
            property, oldValue, newValue ->  println("$oldValue -> $newValue")
        }

        del = "nouvelle valeur déléuée"
        println(del)

        obs="nouvelle valeur observée"

        println(obs)

        // Unit

        val unit : () -> Unit = {println("unit is called")}

        unit()

    }

}

class Delegate {

    operator fun getValue(ref:Any?, property : KProperty<*>):String {
        return "$ref ... thank you for delegating ${property.name} to me"
    }

    operator fun setValue(ref:Any?, property : KProperty<*>, value:String){
        println("$value has been assigned to ${property.name} in the class $ref")
    }
}





