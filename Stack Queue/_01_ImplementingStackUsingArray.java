

class StackArray {
    private int top;
    private int[] stack;

    public StackArray(int size) {
        this.stack = new int[size];
        this.top = -1;
    }


    public void push(int x) {
        if(stack.length == top) {
            System.out.println("Stack Limit Execeed");
        } else {
            top += 1;
            stack[top] = x;
        }
    }

    public int pop() {
        if(top == -1) {
            System.out.print("Stack is Empty ");
            return -1;
        }
        top -= 1;
        return stack[top+1];


    }

    public int top() {
        if (top == -1) {
            System.out.print("Stack is Empty ");
            return -1;
        }
        return stack[top];
    }

    public int size() {
        return top+1;
    }

}


public class _01_ImplementingStackUsingArray {
    public static void main(String[] args) {
        StackArray stack = new StackArray(5);
        stack.push(9);
        stack.push(5);
        stack.push(3);
        System.out.println(stack.top());
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.top());
        stack.push(100);
        System.out.println(stack.top());
    }
}
