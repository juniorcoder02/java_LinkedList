public class ZigZagLL {

    // Define a Node class for the linked list
    public static class Node {
        int data;
        Node next;

        // Constructor to initialize a new node with data
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Method to rearrange the linked list in a Zig-Zag fashion
    public void ZigZag(Node head) {
        // Step 1: Find the middle of the linked list
        // We use the slow and fast pointer approach
        Node slow = head;
        Node fast = head.next;

        // Move slow by 1 step and fast by 2 steps to find the middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow; // Slow now points to the middle node

        // Step 2: Reverse the second half of the list
        Node curr = mid.next; // Start from the node after the middle
        mid.next = null;      // Break the list into two halves
        Node prev = null;     // To reverse, initialize previous as null
        Node next;

        // Reverse the second half
        while (curr != null) {
            next = curr.next; // Save the next node
            curr.next = prev; // Reverse the current node's pointer
            prev = curr;      // Move prev forward
            curr = next;      // Move curr forward
        }

        // 'prev' now points to the head of the reversed second half
        Node left = head;  // Pointer for the first half
        Node right = prev; // Pointer for the reversed second half
        Node nextL, nextR; // Temporary variables for traversal

        // Step 3: Merge the two halves in a Zig-Zag manner
        while (left != null && right != null) {
            nextL = left.next; // Save the next node of the left half
            left.next = right; // Link left node to right node
            nextR = right.next; // Save the next node of the right half
            right.next = nextL; // Link right node to the next left node

            // Move pointers forward
            left = nextL; 
            right = nextR;
        }
    }

    public static void main(String[] args) {
        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
        Node head = new Node(1); // Create first node
        head.next = new Node(2); // Create second node
        head.next.next = new Node(3); // Create third node
        head.next.next.next = new Node(4); // Create fourth node
        head.next.next.next.next = new Node(5); // Create fifth node
        head.next.next.next.next.next = new Node(6); // Create sixth node
        head.next.next.next.next.next.next = new Node(7); // Create seventh node

        // Instantiate the ZigZagLL class
        ZigZagLL zigzag = new ZigZagLL();
        
        // Perform Zig-Zag rearrangement
        zigzag.ZigZag(head);

        // Print the linked list after rearrangement
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
