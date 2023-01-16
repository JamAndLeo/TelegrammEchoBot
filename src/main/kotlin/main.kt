import DI.DaggerServerComponent

fun main() {
    val server = DaggerServerComponent.create().getServer()
    while (true){
        server.postingEchoMessagesForAll()
    }

}

