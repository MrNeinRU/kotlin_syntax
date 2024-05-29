import kotlinx.coroutines.*

fun test(list: MutableList<MainTypesInfo>) = runBlocking {
    val mainL = 4
    var c = 0
    val li = listOf("[ \\ ]", "[ | ]", "[ / ]", "[ - ]")
    val fds = launch(Dispatchers.IO) {
        while (true){
            print("\r")
            if (c > mainL) break
            print("[" + "=".repeat(c) + " ".repeat(mainL-c) + "] ${((c.toDouble() / mainL.toDouble())*100).toInt()}%")
            delay(800)
            c++
        }
    }
    val fds2 = launch {
        delay(5000)
        fds.cancel()
        EmptyBody().backToMain(list)
    }
    launch {
        while (true){
            delay(100)
            if(fds.isCompleted) {
                fds2.cancel()
                EmptyBody().backToMain(list)
            }
        }
    }

}