package circularly_linked_list;

public class CircularlyMan {

    public static void main(String[] args) {

        CircularlyLinkedL<Integer> list = new CircularlyLinkedList<>();

        list.addFirst(10);

        System.out.printf("%d", list.first());
    }
}
