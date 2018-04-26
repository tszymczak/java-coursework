package Chapter11;

import java.util.ArrayList;

/**
 *
 * @author Don Smith
 */
public class MyStringStack extends ArrayList<String> {
    public boolean isEmpty() {
        return super.isEmpty();
    }
    
    public int getSize() {
        return size();
    }
    
    public String peek() {
        return get(getSize() - 1);
    }
    
    public String pop() {
        String o = get(getSize() - 1);
        remove(getSize() - 1);
        return o;
    }
    
    public void push(String o) {
        add(o);
    }
    
    @Override
    public String toString() {
        return "stack: " + super.toString();
    }
}
