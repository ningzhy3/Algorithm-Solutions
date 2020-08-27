# 包含min函数的栈

```java
class minStack {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        public void push(int node) {
            stack.push(node);
            if (minStack.isEmpty()) {
                minStack.push(node);
            } else {
                if (minStack.peek() > node) {
                    minStack.push(node);
                } else {
                    minStack.push(minStack.peek());
                }
            }
        }

        public void pop() {
            stack.pop();
            minStack.pop();

        }

        public int top() {
           return stack.peek();

        }

        public int min() {
            return minStack.peek();
        }
    }
```

维持一个minStack保存当前的最小值

