
class Node {
    int data;
    Node next;

    public Node (int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node (int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedListInsert {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        Node head = convertArr2LL(arr);
        printLL(head);

        head = insertHead(head, 0);
        head = insertTail(head, 6);
        head = insertKthPosistion(head, 3, 100);
        head = insertBeforeElement(head, 3, 19);
        printLL(head);
    }


    private static Node insertHead(Node head, int data) {
        return new Node(data, head);
    }

    private static Node insertTail(Node head, int data) {
        if(head == null) {
            return new Node(data, head);
        }
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        Node newNode = new Node(data);
        temp.next = newNode;
        return head;
    }

    private static Node insertKthPosistion(Node head, int k, int data) {
        if(head == null) return head;
        if(k == 1) {
            return new Node(data, head);
        }
        Node temp = head;
        int count = 0;
        while(temp != null) {
            count++;
            if(count == k-1) {
                Node newNode  = new Node(data);
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    private static Node insertBeforeElement(Node head, int before, int data) {
        if(head == null) return null;
        if(head.data == before) {
            return new Node(data, head);
        }
        Node temp = head;
        while(temp.next != null) {
            if(temp.next.data == before) {
                Node newNode = new Node(data);
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
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
            System.out.print(temp.data+ " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
