import java.util.*
import kotlin.collections.HashMap
import java.util.LinkedList

import java.util.Queue
//https://codeforces.com/problemset/problem/1490/D

open class Node(
    var key:Long,
    var left: Node? = null,
    var right: Node? = null)

    var root: Node? = null;

    fun getMax( start: Int, end: Int,   a: List<Long>) : Int {
        var max = -1.toLong();
        var position =0;
        for(i in start..end) {
            if(a[i] > max) {
                max = a[i]
                position = i;
            }
        }
        return position;
    }

    fun createTree(start: Int, end: Int, a: List<Long>, next: Node?) : Node? {
        if(start > end) return null;

        var c = next;
        var position =0;
        if(c == null) {
            position  = getMax(start, end, a);
            c = Node(a[position], null,null);
            if(root == null) {
                root = c;
            }
        }

        if(c != null && position-1 >= start) {
            c.left =  createTree(start, position - 1, a, c.left);
        }

        if(c != null && position+1 <= end) {
            c.right =  createTree(position+1, end, a, c.right);
        }
        return c;
    }

fun printLevelOrder(root: Node?): HashMap<Long,Int> {
    // Base Case
    if (root == null) return HashMap<Long,Int>()

    // Create an empty queue for level order tarversal
    val q: Queue<Node?> = LinkedList()
    var map  = HashMap<Long,Int>();
    // Enqueue Root and initialize height
    q.add(root)
    var count =0;
    while (true) {

        // nodeCount (queue size) indicates number of nodes
        // at current level.
        var nodeCount = q.size
        if (nodeCount == 0) break

        // Dequeue all nodes of current level and Enqueue all
        // nodes of next level
        while (nodeCount > 0) {
            val node = q.peek()
            if (node != null) {
                map.put(node.key,count)
            }
            q.remove()
            if (node!!.left != null) q.add(node.left)
            if (node.right != null) q.add(node.right)
            nodeCount--
        }
        count++;
    }
    return map;
}

    fun main() {
        val T=readLine()!!.toInt();
        repeat(T) {
            val s=readLine()!!.toInt();
            var a = readLine()!!.split(" ").map { it.toLong() };

            root = null;
            root = createTree(0,s-1,a, root);
            if(root != null) {
                var map = root?.let { it1 -> printLevelOrder(it1) };
                for (i in a) {
                    System.out.print(map!!.get(i));
                    System.out.print(" ");
                }
            }
           println()
          // System.out.println(root!!.key);
            //System.out.println(root!!.left!!.key);
            //System.out.println(root!!.right!!.key);
        }
    }

