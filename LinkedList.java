public class LinkedList {
    // Define the Node class representing each element of the LinkedList
    public static class Node { 
        int data; // Stores the data for the node
        Node next; // Reference to the next node in the LinkedList

        // Constructor to initialize the node with data
        public Node(int data) {
            this.data = data;
        }
    }

    // Define the LinkedList attributes
    public static Node head; // Points to the first node in the LinkedList
    public static Node tail; // Points to the last node in the LinkedList
    public static int size;  // Tracks the number of elements in the LinkedList

    // Add an element to the beginning of the LinkedList
    public void addFirst(int data) { 
        // Create a new node with the given data
        Node newNode = new Node(data);
        size++; // Increment size as we are adding a new element

        // If the LinkedList is empty, the new node becomes both head and tail
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // Link the new node to the current head
        newNode.next = head;

        // Update head to point to the new node
        head = newNode;
    }

    // Add an element to the end of the LinkedList
    public void addLast(int data) { 
        // Create a new node with the given data
        Node newNode = new Node(data);
        size++; // Increment size as we are adding a new element

        // If the LinkedList is empty, the new node becomes both head and tail
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // Link the current tail to the new node
        tail.next = newNode;

        // Update tail to point to the new node
        tail = newNode;
    }

    // Print all elements of the LinkedList
    public void print() { 
        Node temp = head; // Start from the head node
        while (temp != null) { // Traverse until the end of the LinkedList
            System.out.print(temp.data + " --> "); // Print current node's data
            temp = temp.next; // Move to the next node
        }
        System.out.println("null"); // Indicate the end of the LinkedList
    }

    // Add an element at a specific index in the LinkedList
    public void add(int idx, int data) {
        // If adding at the beginning, reuse the addFirst method
        if (idx == 0) {
            addFirst(data);
            return;
        }

        // Create a new node with the given data
        Node newNode = new Node(data);
        size++; // Increment size as we are adding a new element

        Node temp = head; // Start from the head
        int i = 0; // Counter to track current index
        while (i < idx - 1) { // Traverse until the node before the desired position
            temp = temp.next;
            i++;
        }

        // Insert the new node by adjusting pointers
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Remove the first element from the LinkedList
    public int removeFirst() {
        // Handle the case when the LinkedList is empty
        if (size == 0) {
            System.out.println("LinkedList is empty");
            return Integer.MIN_VALUE; // Return a placeholder value
        } 

        // Handle the case when the LinkedList has only one element
        if (size == 1) {
            int val = head.data; // Store the data of the only node
            head = tail = null; // Reset head and tail to null
            size = 0; // Reset size
            return val; // Return the removed element
        }

        // Store the data of the node to be removed
        int val = head.data;

        // Update head to the next node
        head = head.next;

        size--; // Decrement size
        return val; // Return the removed element
    }

    // Remove the last element from the LinkedList
    public int removeLast() {
        // Handle the case when the LinkedList is empty
        if (size == 0) {
            System.out.println("LinkedList is empty");
            return Integer.MIN_VALUE; // Return a placeholder value
        } 

        // Handle the case when the LinkedList has only one element
        if (size == 1) {
            int val = head.data; // Store the data of the only node
            head = tail = null; // Reset head and tail to null
            size = 0; // Reset size
            return val; // Return the removed element
        }

        // Traverse to the second-last node
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }

        // Store the data of the last node
        int val = prev.next.data;

        // Update the second-last node to be the new tail
        prev.next = null;
        tail = prev;

        size--; // Decrement size
        return val; // Return the removed element
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList(); // Create a new LinkedList object

        // Demonstration of LinkedList operations
        System.out.print("Initially list is empty: ");
        ll.print();

        ll.addFirst(2);
        System.out.print("After adding 1st element at the beginning: ");
        ll.print();

        ll.addFirst(1);
        System.out.print("After adding another element at the beginning: ");
        ll.print();

        ll.addLast(3);
        System.out.print("After adding an element at the end: ");
        ll.print();

        ll.addLast(4);
        System.out.print("After adding another element at the end: ");
        ll.print();

        ll.add(2, 9);
        System.out.print("After adding an element in the middle at index 2: ");
        ll.print();

        System.out.println("Size of LinkedList after addition operations: " + ll.size);

        ll.removeFirst();
        System.out.print("After removing the first element: ");
        ll.print();

        ll.removeLast();
        System.out.print("After removing the last element: ");
        ll.print();

        System.out.println("Size of LinkedList after removal operations: " + ll.size);
    }
}
