package stack.stack_array;

public class StackMain {

    public static void main(String[] args) {

        DynamicArrayStack<Integer> stack = new DynamicArrayStack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.forEach(elem -> System.out.printf("%d ", elem));
        System.out.printf("\n%d", stack.top());
    }
}
