public class Node <T extends Comparable> {
    T obj;
    Node next;
    Node prev;
    int vorkommen;

    public Node(T obj){
        this.obj=obj;
        vorkommen=1;
    }

}
