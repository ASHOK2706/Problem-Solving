
class QueueArray {
    private int[] queue;
    private int start;
    private int end;
    private int currentSize;

    public QueueArray(int size) {
        this.queue = new int[size];
        this.start = -1;
        this.end = -1;
        this.currentSize = 0;
    }

    public void push(int x) {
        if (currentSize == 0) {
            start = 0;
            end = 0;
        } else if (currentSize == queue.length) {
            System.out.println("Queue is full");
            return;
        }
        queue[end] = x;
        end = (end+1) % queue.length;
        currentSize += 1;
    }

    public int pop() {
        if(currentSize == 0) {
            System.out.print("Queue is Empty ");
            return Integer.MIN_VALUE;
        }
        int element = queue[start];
        if(currentSize == 1) {
            start = -1;
            end = -1;
        } else {
            start = (start + 1) % queue.length;
        }
        currentSize -= 1;
        return element;
    }

    public int top() {
        if(currentSize == 0) {
            System.out.print("Queue is Empty ");
            return Integer.MIN_VALUE;
        }
        return queue[start];
    }

    public int size() {
        return currentSize;
    }
}
public class _02_ImplementingQueueUsingArray {
    public static void main(String[] args) {
        QueueArray queue = new QueueArray(4);
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
