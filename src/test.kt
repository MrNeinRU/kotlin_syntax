import kotlinx.coroutines.*
import java.io.Console

fun test(list: MutableList<MainTypesInfo>) = runBlocking {
    val mainL = 20
    var c = 0
    val li = listOf("[ \\ ]", "[ | ]", "[ / ]", "[ - ]")
    val lls = """
        grq
        aSDa
        aDFsa
    """.trimIndent()
    val fds = launch(Dispatchers.IO) {
        while (true){
            print("\r")
            if (c > mainL) break
            print("[" + "=".repeat(c) + " ".repeat(mainL-c) + "]")
            //print("\r")

            //print(lls/*li[c]*/)
            delay(100)
            c++
        }
    }
    launch {
        delay(4000)
        fds.cancel()
        EmptyBody().backToMain(list)
    }
}