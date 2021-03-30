
    //Binary Search Tree
    open class Node (var key :Int, var left: Node?, var right : Node? )
     var root:Node? = null;

    fun insert( a : Int, value: Node?) : Node? {
        var q = value;
        if(q == null) {
             q = Node(a, null, null);
            System.out.println(q);
            System.out.println(value);
            if(root == null) {
                root = q;
            }
        }else {
           if(a > value?.key!!) {
               value.right =  insert(a, value?.right);
           }else {
               value.left =  insert(a, value?.left);
           }
        }
        return q;
    }

    fun printTree( value : Node?) {
        if(value == null )return;
        printTree(value.left);
        System.out.println(value.key);
        printTree(value.right)
    }

    fun main() {
        var a = intArrayOf(6, 1,2,3,4,3)
        for(i in a) {
            System.out.println(i);
            insert(i, root);
        }
        printTree(root!!);
    }

