import java.util.Stack;

class QueueStack {
    Stack<Integer> s1;
    Stack<Integer> s2;
    public QueueStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(x);
        while(!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    public int pop() {
        if(s1.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return s1.pop();
    }

    public int top() {
        return s1.peek();
    }

    public int size() {
        return s1.size();
    }
}

public class _06_ImplementQueueUsingStack {
    public static void main(String[] args) {
        QueueStack queue = new QueueStack();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        System.out.println("queue top : "+ queue.top());
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
