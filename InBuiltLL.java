import java.util.LinkedList; //import LinkedList from java.util.List
public class InBuiltLL {
    public static void main(String[] args) {
        LinkedList<Integer> linkedlist = new LinkedList<>(); //Integer LinkedList
        linkedlist.addLast(1); //add last method 
        linkedlist.addLast(2);
        linkedlist.addFirst(0); //add first method
        System.out.println(linkedlist);
        linkedlist.removeLast(); //remove last method
        linkedlist.removeFirst(); //remove first method
        System.out.println(linkedlist);

    }
}
