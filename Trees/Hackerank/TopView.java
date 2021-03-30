import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
    
    static class NodeHeight {
        Node value;
        int height;
        NodeHeight( int height,Node value) {
            this.value = value;
            this.height = height;
        }
    }
	public static void topView(Node root) {
        Queue<NodeHeight> val = new LinkedList<NodeHeight>();
        TreeMap<Integer,Integer> q = new TreeMap<Integer,Integer>();
        NodeHeight c = new NodeHeight(0, root);
        val.add(c);
        while(val.size() != 0) {
             NodeHeight v = val.poll();
           //  System.out.println(v.height +" "+v.value +" "+v.value.data);
            if(!q.containsKey(v.height)) {
                q.put(v.height, v.value.data);
            }
            if(v.value.left != null) {
               //   System.out.println(v.value.left +" "+v.value.left.data);
                  NodeHeight s  = new NodeHeight(v.height-1,v.value.left );
                  val.add(s);
            }
            if(v.value.right != null) {
                  NodeHeight s  = new NodeHeight(v.height+1,v.value.right );
                  val.add(s);
           }
        }
        
           for (Map.Entry<Integer, Integer> entry : q.entrySet()) {
                    System.out.print(entry.getValue() + " ");
              }
    
      
    }

	public static Node insert(Node root, int data) {