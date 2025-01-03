public class DoublyLL {

    // Define the Node class for the doubly linked list
    public class Node {
        int data;       // Data of the node
        Node next;      // Pointer to the next node
        Node prev;      // Pointer to the previous node

        // Constructor to initialize a new node
        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // Head and tail of the DLL
    public Node head;
    public Node tail;
    public int size; // Size of the DLL

    // Constructor to initialize the DLL
    public DoublyLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Add a node at the beginning of the list
    public void addFirst(int data) {
        Node newNode = new Node(data); // Create a new node
        size++; // Increase size of the list

        // If the list is empty, set both head and tail to the new node
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // Update pointers for adding at the beginning
        newNode.next = head; // New node points to the current head
        head.prev = newNode; // Current head points back to the new node
        head = newNode;      // Update head to the new node
    }

    // Add a node at the end of the list
    public void addLast(int data) {
        Node newNode = new Node(data); // Create a new node
        size++; // Increase size of the list

        // If the list is empty, set both head and tail to the new node
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // Update pointers for adding at the end
        tail.next = newNode; // Tail points to the new node
        newNode.prev = tail; // New node points back to the current tail
        tail = newNode;      // Update tail to the new node
    }

    // Remove the first node from the list
    public void removeFirst() {
        // If the list is empty, nothing to remove
        if (head == null) {
            System.out.println("The list is empty, nothing to remove.");
            return;
        }

        size--; // Decrease size of the list

        // If there's only one node, set head and tail to null
        if (head == tail) {
            head = tail = null;
            return;
        }

        // Update head and remove the first node
        head = head.next; // Move head to the next node
        head.prev = null; // Set the previous pointer of the new head to null
    }

    // Remove the last node from the list
    public void removeLast() {
        // If the list is empty, nothing to remove
        if (head == null) {
            System.out.println("The list is empty, nothing to remove.");
            return;
        }

        size--; // Decrease size of the list

        // If there's only one node, set head and tail to null
        if (head == tail) {
            head = tail = null;
            return;
        }

        // Update tail and remove the last node
        tail = tail.prev; // Move tail to the previous node
        tail.next = null; // Set the next pointer of the new tail to null
    }

    // Print the list in a readable format
    public void print() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        Node temp = head; // Start from the head
        while (temp != null) {
            System.out.print(temp.data + " <--> "); // Print data
            temp = temp.next; // Move to the next node
        }
        System.out.println("null"); // Indicate the end of the list
    }

    // reverse a doubly linked list
    public void reverse() {
        // If the list is empty or has only one node, nothing to reverse
        if (head == null || head == tail) {
            return;
        }

        Node curr = head; 
        Node prev = null;
        Node next;

        // Traverse the list and swap the next and previous pointers
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;

            prev = curr;
            curr = next;
        }
        head = prev;
    
    }

    // Main method to test the doubly linked list
    public static void main(String[] args) {
        DoublyLL dll = new DoublyLL(); // Create a new doubly linked list

        // Add elements to the list
        dll.addFirst(10);
        dll.addFirst(20);
        dll.addLast(5);
        dll.addLast(1);

        // Print the list
        System.out.print("List after additions: ");
        dll.print();

        dll.reverse();
        System.out.print("List after reversing: ");
        dll.print();

        // Remove elements from the list
        dll.removeFirst();
        System.out.print("List after removing the first element: ");
        dll.print();

        dll.removeLast();
        System.out.print("List after removing the last element: ");
        dll.print();

        // Print the final size of the list
        System.out.println("Final size of the list: " + dll.size);
    }
}
