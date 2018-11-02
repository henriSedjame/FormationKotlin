package CompanionObject

import cast.Femme
import cast.Person
import dataClass.Photo

abstract class Appareil {

    companion object {

        fun shot(model: Person, photographe : Person) = Photo(model as Femme,  photographe)

    }
}