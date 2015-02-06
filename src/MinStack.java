import java.util.ArrayList;
import java.util.List;

class MinStack {
    List<Integer> stack = new ArrayList<Integer>();
    List<Integer> min = new ArrayList<Integer>();
    
    public void push(int x) {
        stack.add(x);
        if(min.size() == 0 || (min.size() > 0 && x <= min.get(min.size() - 1))) {
            min.add(x);
        }
    }

    public void pop() {
        if(stack.size() == 0) return;
        
        int t = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        
        if(t <= min.get(min.size() -1)) {
            min.remove(min.size() - 1);
        }
    }

    public int top() {
        if(stack.size() == 0) return -1;
        
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        if(min.size() == 0) return -1;
        return min.get(min.size() - 1);
    }
}
