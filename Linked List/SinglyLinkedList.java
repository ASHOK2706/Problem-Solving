
class Node {
    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedList {
    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 2, 324, 23, 23}; 
        Node head = convertArr2LL(arr);
        // System.out.println(head.data);
        printLL(head);
        
    }

    private static Node convertArr2LL(int[] arr) {
        Node head = new Node(arr[0]);
        Node tail = head;

        for(int i=1; i<arr.length; i++) {
            Node temp = new Node(arr[i]);
            tail.next = temp;
            tail = temp;
        }
        return head;
    }

    private static void printLL(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data +" ");
            temp = temp.next;
        }
    }
}