/**
 * Created by kitak on 8/16/16.
 */
import java.io.*
import java.net.*
import java.util.*

fun main(args: Array<String>) {
    var servsock: ServerSocket? = null
    var sock: Socket? = null
    var out: OutputStream? = null
    var outstr: String
    var i: Integer
    var d: Date

    try {
        servsock = ServerSocket(6000, 300)
        while (true) {
            sock = servsock.accept();
            d = Date();
            outstr = "\n" +
                    "Hello, this is NetClock server." +
                    "\n ${d.toString()} \n" +
                    "Thank you. \n"
            out = sock.getOutputStream()
            for(c in outstr) {
                out.write(c.toInt())
            }
            out.write('\n'.toInt());
            sock.close();
        }
    } catch (e: IOException) {
        System.exit(1)
    }
}
