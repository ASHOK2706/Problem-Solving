
class StackLinkedList {
    private ListNode top;
    private int size;
    StackLinkedList() {
        this.top = null;
        this.size = 0;
    }

    public void push(int x) {
        ListNode temp = new ListNode(x);
        temp.next = top;
        top = temp;
        size += 1;
    }

    public int pop() {
        if(top == null) {
            return Integer.MIN_VALUE;
        }
        ListNode temp = top;
        top = top.next;
        temp.next = null;
        size -= 1;
        return temp.data;
    }

    public int top() {
        if(top == null) {
            return Integer.MIN_VALUE;
        }
        return top.data;
    }

    public int size() {
        return size;
    }
}
public class _03_ImplementStackUsingLinkedList {
    public static void main(String[] args) {
        StackLinkedList stack = new StackLinkedList();
        stack.push(4);
        stack.push(2);
        stack.push(3);
        stack.push(1);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        stack.push(7);
        System.out.println(stack.size());
    }
}
