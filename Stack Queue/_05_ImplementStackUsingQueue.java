import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class StackQueue {
    private Queue<Integer> queue;
    private int size;
    public StackQueue() {
        queue = new LinkedList<>();
        size = 0;
    }
    public void push(int x) {
        queue.offer(x);
        for(int i=1; i<=size; i++) {
            queue.offer(queue.poll());
        }
        size += 1;
    }

    public int pop() {
        if(size == 0) {
            return Integer.MIN_VALUE;
        }
        size -= 1;
        return queue.poll();
    }

    public int top() {
        if(size == 0) {
            return Integer.MIN_VALUE;
        }
        return queue.peek();
    }

    public int size() {
        return this.size;
    }
}

public class _05_ImplementStackUsingQueue {
    public static void main(String[] args) {
        StackQueue stack = new StackQueue();
        System.out.println(stack.pop());
        stack.push(4);
        System.out.println(stack.top());
        stack.push(1);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.size());
        stack.push(12);
        System.out.println(stack.size());

    }
}
