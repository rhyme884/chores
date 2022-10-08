import java.io.StreamTokenizer
private var order = 1

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    nextToken(); val n = nval.toInt()
    nextToken(); val m = nval.toInt()
    nextToken(); val here = nval.toInt() - 1

    val visited = Array(n) { false }
    val orders = Array(n) { 0 }
    val edges = mutableMapOf<Int, MutableList<Int>>()
    repeat(m) {
        nextToken(); val v1 = nval.toInt() - 1
        nextToken(); val v2 = nval.toInt() - 1
        //  undirected graph
        val v1Neighbors = edges.getOrDefault(v1, mutableListOf())
        val v2Neighbors = edges.getOrDefault(v2, mutableListOf())

        v1Neighbors.add(v2)
        v2Neighbors.add(v1)
        edges[v1] = v1Neighbors
        edges[v2] = v2Neighbors
    }

    dfs(visited, edges, here, orders)
    orders.forEach {
        println(it)
    }
}

fun dfs(visited: Array<Boolean>, edges: Map<Int, MutableList<Int>>, here: Int, orders: Array<Int>) {
    visited[here] = true
    orders[here] = order++

    edges[here] ?. let { neighbors ->
        neighbors.sorted().forEach { neighbor ->
            if (!visited[neighbor]) dfs(visited, edges, neighbor, orders)
        }
    }
}