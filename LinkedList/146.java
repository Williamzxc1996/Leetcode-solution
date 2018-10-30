/**
146.LRU Cache
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 /* capacity */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
*/

/**
The thing is to use a map to mantain the key->value pairs, and use a queue(linkedlist) to mantain the delete order.
However, if just use linkedlist, when I adjust the delete order,the remove method of linkedlist will cost O(n), 
which won't satisfied the follow-up.
To achieve O(1), I have to adjust the structrue, but the main idea is the same. I create my own double linked list to maitain
the delete oreder, and use map to mantain key->doublelinkedlistNode pairs. Therefore, everytime that I need to adjust the delete order,
I will derive the node from map using key directly with O(1) complexity.
*/

class DoubleLinkedListNode{
    public int key;
    public int value;
    public DoubleLinkedListNode pre;    //point to its predecessor
    public DoubleLinkedListNode post;   //point to its next
    
    public DoubleLinkedListNode(){
        key = -1;
        value = -1;
        pre = null;
        post = null;
    }
    
    public DoubleLinkedListNode(int key, int value, DoubleLinkedListNode pre, DoubleLinkedListNode post){
        this.key = key;
        this.value = value;
        this.pre = pre;
        this.post = post;
    }
}

class LRUCache {
    private DoubleLinkedListNode head,tail;        //Using the double linkedlist
    private Map<Integer,DoubleLinkedListNode> map = new HashMap();       //matain key->node
    private int cap;
    private int length;

    public LRUCache(int capacity) {
        cap = capacity;
        length = 0;
        head = new DoubleLinkedListNode();
        tail = new DoubleLinkedListNode();
        head.post = tail;
        tail.pre = head;
    }
    
    public void updateOrder(DoubleLinkedListNode node){
        //move the node from somewhere middle in the doublelinkedlist to the head
        node.pre.post = node.post;
        node.post.pre = node.pre;
        node.post = head.post;
        node.pre = head;
        head.post = node;
        node.post.pre = node;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            DoubleLinkedListNode temp = map.get(key);
            updateOrder(temp);
            return temp.value;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            //update the value, and update key's order
            DoubleLinkedListNode temp = map.get(key);
            temp.value = value;
            updateOrder(temp);
        }else{
            //check the length first
            if(length == cap){
                //first delete then add
                DoubleLinkedListNode delete = tail.pre;
                tail.pre = delete.pre;
                tail.pre.post = tail;
                map.remove(delete.key);         //delete in map
            }else{
                length++;
            }
            DoubleLinkedListNode add = new DoubleLinkedListNode(key,value,head,head.post);
            head.post.pre = add;
            head.post = add;
            map.put(add.key,add);
        }
    }
}
