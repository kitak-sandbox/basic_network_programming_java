import java.io.InputStream
import java.net.Socket

/**
 * Created by kitak on 8/16/16.
 */
fun main(args: Array<String>) {
    val buff = ByteArray(1024)
    var readsocket: Socket? = null
    var instr: InputStream? = null
    var cont = true

    try {
        readsocket = Socket(args[0], Integer.parseInt(args[1]))
        instr = readsocket.inputStream
    } catch (e: Exception) {
        System.err.println("Network error")
        System.exit(1)
    }

    while (cont) {
        try {
            val n = instr!!.read(buff)
            System.out.write(buff, 0, n)
        } catch (e: Exception) {
            cont = false
        }

    }

    try {
        instr!!.close()
    } catch (e: Exception) {
        System.err.println("Network error")
        System.exit(1)
    }

}
