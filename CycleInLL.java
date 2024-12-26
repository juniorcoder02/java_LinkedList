public class CycleInLL {

    /**
     * Node class to represent each node in the linked list.
     */
    public static class Node {
        int data;   // Data stored in the node
        Node next;  // Pointer to the next node in the linked list

        // Constructor to initialize a node with given data
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Function to detect if a cycle exists in a linked list.
     * Uses Floyd's Cycle Detection Algorithm (Tortoise and Hare Method).
     *
     * @param head - The head of the linked list.
     * @return true if a cycle exists, false otherwise.
     */
    public static boolean isCycle(Node head) {
        Node slow = head; // Slow pointer (moves one step at a time)
        Node fast = head; // Fast pointer (moves two steps at a time)

        // Traverse the linked list to detect a cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;        // Move slow pointer by 1 step
            fast = fast.next.next;   // Move fast pointer by 2 steps

            // If slow and fast pointers meet, a cycle exists
            if (slow == fast) {
                return true;
            }
        }

        // If fast reaches null, there is no cycle
        return false;
    }

    /**
     * Function to remove a cycle from the linked list if it exists.
     * Steps:
     * 1. Detect the cycle using the same two-pointer approach.
     * 2. Find the meeting point of the two pointers in the cycle.
     * 3. Identify the starting point of the cycle.
     * 4. Remove the cycle by breaking the link of the last node in the cycle.
     *
     * @param head - The head of the linked list.
     */
    public static void removeCycle(Node head) {
        Node slow = head; // Slow pointer for detecting cycle
        Node fast = head; // Fast pointer for detecting cycle
        boolean cycleExists = false; // Flag to indicate if a cycle is found

        // Step 1: Detect the cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                cycleExists = true; // Cycle detected
                break;
            }
        }

        // If no cycle is detected, return
        if (!cycleExists) {
            return;
        }

        // Step 2: Find the start of the cycle
        slow = head;  // Reset slow pointer to the head
        Node prev = null; // To keep track of the last node in the cycle
        while (slow != fast) {
            prev = fast;  // Keep track of the node before `fast`
            slow = slow.next;  // Move slow pointer one step
            fast = fast.next;  // Move fast pointer one step
        }

        // Step 3: Remove the cycle by breaking the link
        prev.next = null; // Break the link of the last node in the cycle
    }

    public static void main(String[] args) {
        // Create a linked list with a cycle: 1 -> 2 -> 3 -> (points back to 1)
        Node head = new Node(1);           // Create first node
        head.next = new Node(2);           // Create second node
        head.next.next = new Node(3);      // Create third node
        head.next.next.next = head;        // Form a cycle by pointing the last node to the head

        // Step 1: Check if a cycle exists
        boolean hasCycle = isCycle(head);
        System.out.println("Cycle detected: " + hasCycle); // Expected output: true

        // Step 2: Remove the cycle
        if (hasCycle) {
            removeCycle(head);
            System.out.println("Cycle removed.");
        }

        // Step 3: Check again to confirm the cycle is removed
        hasCycle = isCycle(head);
        System.out.println("Cycle detected after removal: " + hasCycle); // Expected output: false
    }
}
