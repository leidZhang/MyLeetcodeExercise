package stack_and_queue;

import java.util.Stack;

public class StackImplQueue {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty()); // return false
    }

    static class MyQueue {
        Stack<Integer> outStack;
        Stack<Integer> inStack;
        public MyQueue() {
            outStack = new Stack<>();
            inStack = new Stack<>();
        }

        public void push(int x) {
            inStack.push(x);
        }

        public int pop() {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
            int res = outStack.pop();
            while (!outStack.isEmpty()) {
                inStack.push(outStack.pop());
            }
            return res;
        }

        public int peek() {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
            int res = outStack.peek();
            while (!outStack.isEmpty()) {
                inStack.push(outStack.pop());
            }
            return res;
        }

        public boolean empty() {
            return inStack.isEmpty();
        }
    }
}
