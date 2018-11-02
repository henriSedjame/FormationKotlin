package cast

class Homme : Person() {

    override fun presentation(){
        println("je suis un homme")
        super.presentation()
    }

    fun parler(){
        println("Je suis un homme et je parle")
    }
}