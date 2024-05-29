import kotlinx.coroutines.*
import java.io.Console

fun test(list: MutableList<MainTypesInfo>) = runBlocking {
    val mainL = 30
    var c = 0
    val li = listOf("[ \\ ]", "[ | ]", "[ / ]", "[ - ]")
    val fds = launch(Dispatchers.IO) {
        while (true){
            print("\r")
            if (c > mainL) break
            print("[" + "=".repeat(c) + " ".repeat(mainL-c) + "]")
            delay(100)
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
            if(fds.isCompleted) {
                fds2.cancel()
                EmptyBody().backToMain(list)
            }
        }
    }

}