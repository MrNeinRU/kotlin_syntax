import kotlinx.coroutines.*
import java.io.Console

fun test(list: MutableList<MainTypesInfo>) = runBlocking {
    var c = 0
    val li = listOf("[ \\ ]", "[ | ]", "[ / ]", "[ - ]")
    val fds = launch(Dispatchers.IO) {
        while (true){
            print("\r")
            if (c > 3) c=0
            print(li[c])
            delay(500)
            c++
        }
    }
    launch {
        delay(4000)
        fds.cancel()
        EmptyBody().backToMain(list)
    }
}