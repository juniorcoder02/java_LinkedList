public class MergeSortLL {
    // Node class to represent each element in the linked list
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to find the middle node of the linked list
    private Node findMid(Node head) {
        Node slow = head;      // Slow pointer moves one step
        Node fast = head.next; // Fast pointer moves two steps

        // Move pointers until fast reaches the end
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; // Slow pointer now points to the middle
    }

    // Function to merge two sorted linked lists
    private Node merge(Node head1, Node head2) {
        Node dummy = new Node(-1); // Dummy node to simplify merging logic
        Node prev = dummy;

        // Pointers for the two lists to be merged
        Node c1 = head1;
        Node c2 = head2;

        // Compare elements from both lists and merge in sorted order
        while (c1 != null && c2 != null) {
            if (c1.data < c2.data) {
                prev.next = c1;
                c1 = c1.next;
            } else {
                prev.next = c2;
                c2 = c2.next;
            }
            prev = prev.next;
        }

        // Attach any remaining elements from either list
        prev.next = (c1 != null) ? c1 : c2;

        return dummy.next; // Return the merged list (excluding dummy)
    }

    // Recursive function to sort the linked list using Merge Sort
    public Node mergeSort(Node head) {
        // Base case: If the list is empty or has only one element, it is already sorted
        if (head == null || head.next == null) {
            return head;
        }

        // Find the middle of the list
        Node mid = findMid(head);
        Node rightHead = mid.next; // Head of the right sublist
        mid.next = null;           // Break the list into two halves

        // Recursively sort the left and right halves
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // Merge the sorted halves
        return merge(newLeft, newRight);
    }

    // Helper function to print the linked list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Create a linked list
        Node head = new Node(4);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(3);

        System.out.println("Original Linked List:");
        printList(head);

        // Perform merge sort
        MergeSortLL list = new MergeSortLL();
        head = list.mergeSort(head);

        System.out.println("Sorted Linked List:");
        printList(head);
    }
}
