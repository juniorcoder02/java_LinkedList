public class Search {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node head;
    public static Node tail;

    public void addFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // function for iterative search
    public static int iterativeSearch(int key) {
        Node temp = head;
        int i = 0;

        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;

        }
        return -1;
    }

    public int recursiveSearch(int key) {
        return helper(head, key);
    }

    public int helper(Node head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public static void main(String[] args) {
        Search s = new Search();
        s.addFirst(2);
        s.addFirst(4);
        s.addFirst(10);
        s.addLast(7);
        s.addLast(12);
        s.print();
        System.out.println("Iterative search for key 7 : " + s.iterativeSearch(7));
        System.out.println("Iterative search for key 7 " + s.iterativeSearch(13));
        System.out.println("recursive search for key 7 : " + s.recursiveSearch(7));
        System.out.println("recursive search for key 7 " + s.iterativeSearch(13));
    }
}