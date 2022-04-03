package chapter08_stack;

/**
 * @author Jason
 * @date 2020/4/14
 */
public class StackBasedOnArray {

    /**
     * String数组
     */
    private String[] data;

    /**
     * 栈的容量
     */
    private int size;

    /**
     * 栈中元素个数
     */
    private int count;

    public StackBasedOnArray(int size) {
        this.data = new String[size];
        this.size = size;
        this.count = 0;
    }

    public boolean push(String data) {
        if (count >= size) {
            System.out.println("no room for data.");
            return false;
        }
        this.data[count] = data;
        count++;
        return true;
    }

    public String pop() {
        if (count == 0) {
            return null;
        }
        String tmp = this.data[count - 1];
        count--;
        return tmp;
    }

    public void printAll() {
        System.out.println("====start====");
        if (this.count == 0) {
            System.out.println("nothing here.");
            return;
        }
        for (int i = this.count - 1; i >= 0; i--) {
            System.out.println(this.data[i]);
        }
        System.out.println("=====end=====");
    }

    public static void main(String[] args) {
        StackBasedOnArray stack = new StackBasedOnArray(5);
        stack.push("1");
        stack.printAll();
        stack.push("2");
        stack.printAll();
        stack.push("3");
        stack.printAll();
        stack.push("4");
        stack.printAll();
        stack.push("5");
        stack.printAll();
        stack.push("6");
        stack.printAll();
        System.out.println(stack.pop());
        stack.printAll();
        System.out.println(stack.pop());
        stack.printAll();
        System.out.println(stack.pop());
        stack.printAll();
        System.out.println(stack.pop());
        stack.printAll();
        System.out.println(stack.pop());
        stack.printAll();
        System.out.println(stack.pop());
        stack.printAll();
    }
}
