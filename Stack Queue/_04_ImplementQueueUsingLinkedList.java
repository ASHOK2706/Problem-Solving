

class QueueLinkedList {
    private ListNode start;
    private ListNode end;
    private int size;
    public QueueLinkedList() {
        this.start = null;
        this.end = null;
        this.size = 0;
    }

    public void push(int x) {
        ListNode temp = new ListNode(x);
        if (start == null && end == null) {
            start = temp;
            end = temp;
        } else {
            end.next = temp;
            end = temp;
        }
        size += 1;
    }

    public int pop() {
        if (start == null) {
            return Integer.MIN_VALUE;
        }
        ListNode temp = start;
        start = start.next;
        temp.next = null;
        size -= 1;
        if(start == null) {
            end = null;
        }
        return temp.data;
    }

    public int top() {
        if(start == null) {
            return Integer.MIN_VALUE;
        }
        return start.data;
    }

    public int size() {
        return this.size;
    }
}

public class _04_ImplementQueueUsingLinkedList {
    public static void main(String[] args) {
        QueueLinkedList queue = new QueueLinkedList();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        System.out.println("queue top : "+ queue.top());  //   5
        System.out.println("queue pop : "+ queue.pop());
        System.out.println("queue top : "+ queue.top());
        System.out.println(queue.size());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.size());
        queue.push(11);
        System.out.println(queue.size());
    }
}
