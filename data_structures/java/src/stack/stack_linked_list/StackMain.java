package stack.stack_linked_list;

public class StackMain {

    public static void main(String[] args) {

        StackLinkedList<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.pop();


        stack.forEach(elem -> System.out.printf("%d ", elem));

    }
}
