
class Node {
    int data;
    Node next;
    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedListDelete {
    public static void main(String[] args) {
        int[] arr = {235,23,12,1,23,123};
        Node head = convertArr2LL(arr);
        //head = deleteHead(head);
        //head = deleteTail(head);
        //head = deleteKthNode(head, 10);
        head = deleteElement(head, 123);
        printLL(head);
    }

    @SuppressWarnings("unused")
    private static Node deleteHead(Node head) {
        if(head == null) return head;
        head = head.next;
        return head;
    }

    
    @SuppressWarnings("unused")
    private static Node deleteTail(Node head) {
        if(head == null || head.next == null) return null;
        Node temp = head;
        while(temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }

    @SuppressWarnings("unused")
    private static Node deleteKthNode(Node head, int k) {
        if(head == null) return null;
        if(k==1) {
            head = head.next;
            return head;
        }

        Node temp = head;
        Node prev = null;
        int count =0;
        while(temp != null) {
            count++;
            if(count == k) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    private static Node deleteElement(Node head, int data) {
        if(head == null) return null;
        if(head.data == data) {
            head = head.next;
            return head;
        }

        Node temp = head;
        Node prev = null;
        while(temp != null) {
            if(temp.data == data) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }



    private static Node convertArr2LL(int [] arr) {
        Node head = new Node(arr[0]);
        Node tail = head;
        for(int i=1; i<arr.length; i++) {
            Node  temp = new Node(arr[i]);
            tail.next =  temp;
            tail = temp;
        }
        return head;
    }

    private static void printLL(Node head) {
        Node temp = head;
        while(temp!=null) {
            System.out.print(temp.data+" ");
            temp= temp.next;
        }
    }
}
