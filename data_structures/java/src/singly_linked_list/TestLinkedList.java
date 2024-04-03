package singly_linked_list;

public class TestLinkedList {

    public static void main(String[] args) {

        LinkedList<Integer> list = new SinglyLinkedList<>();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d ", list.get(i));
        }
    }
    
}
