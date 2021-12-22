package ds.stack;

import java.util.Stack;

/**
 * https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1360/
 * Design a ds.stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 *
 * MinStack() initializes the ds.stack object.
 * void push(int val) pushes the element val onto the ds.stack.
 * void pop() removes the element on the top of the ds.stack.
 * int top() gets the top element of the ds.stack.
 * int getMin() retrieves the minimum element in the ds.stack.
 *
 *
 * Example 1:
 *
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * Output
 * [null,null,null,null,-3,null,0,-2]
 *
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 *
 *
 * Constraints:
 *
 * -231 <= val <= 231 - 1
 * Methods pop, top and getMin operations will always be called on non-empty stacks.
 * At most 3 * 104 calls will be made to push, pop, top, and getMin.
 * PUSH :
 * VALUE < MIN ->  MIN = VALUE , VALUE = 2*VALUE - MIN
 * POP :
 * VALUE < MIN  -> POP , MIN = 2*MIN -VALUE
 * TOP :
 * VALUE < MIN -> return MIN , VALUE
 */
public class Min_Stack {
    Long min ;
    Stack<Long> stack = new Stack();
    public Min_Stack() {
        min = Long.MAX_VALUE;
    }

    public void push(int val) {
        Long value = Long.valueOf(val);
        if(stack.isEmpty()){
            stack.push(value);
            min = value;
        }else{
            if(value < min){
                stack.push(2*value - min);
                min = value;
            }else{
                stack.push(value);
            }
        }
    }

    public void pop() {
        if(stack.isEmpty()){
            return;
        }else{
            Long value = stack.pop();
            if(value < min ){
                min = 2*min - value ;
            }
        }
    }

    public int top() {
        Long value = stack.peek();
        if(value < min){
            return min.intValue();
        }else{
            return value.intValue();
        }
    }

    public int getMin() {
        return min.intValue();
    }
}
