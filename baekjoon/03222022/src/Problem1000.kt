import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val token = StringTokenizer(this.readLine())
    print(token.nextToken().toInt() + token.nextToken().toInt())
}