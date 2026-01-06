import java.util.Stack;

public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;


    public MinStack() {
        minStack=new Stack<>();
        stack=new Stack<>();;

    }

    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty()|| minStack.peek()>val)
        {
            minStack.push(val);
        }

    }

    public void pop() {
        if(!stack.isEmpty() && !minStack.isEmpty() &&stack.peek().equals(minStack.peek()))
        {
            minStack.pop();
        }
        stack.pop();

    }

    public int top() {
        return stack.peek();

    }

    public int getMin() {
        return minStack.peek();

    }
}
