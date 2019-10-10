package com.company;

import java.util.HashMap;
import java.util.Map;

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};

public class Main {

    public static void main(String[] args) {
        // write your code here
//        {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
        Node c = new Node(3, null, null);
        c.random = c;

        Node b = new Node(2, null, c);


        Node a = new Node(1, b, c);

        Main ins = new Main();
        ins.copyRandomList(a);
    }

    // Definition for a Node.


//    class Solution {
        public Node copyRandomList(Node head) {

            Map map = new HashMap<Node, Node>();
            Node node = head;

            while (node != null) {
                map.put(node, new Node(head.val, null, null));
                node = node.next;
            }
            node = head;

            while (node != null) {
                ((Node)map.get(node)).next = (Node) map.get(node.next);
                ((Node)map.get(node)).random = (Node) map.get(node.random);
                node = node.next;
            }
            Node a = (Node) map.get(head);

            return (Node) map.get(head);
        }
//    }
}
