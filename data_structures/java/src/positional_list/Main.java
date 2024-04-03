package positional_list;

public class Main {

    public static void main(String[] args) {

        PositionalList<Integer> list = new LinkedPositionalList<>();

        list.addFirst(10);
        list.addFirst(60);
        list.addFirst(20);
        list.addFirst(70);
        list.addFirst(40);
        list.addFirst(80);

        LinkedPositionalList.insertionSort(list);

        list.forEach(x -> System.out.printf("%d ", x));
    }
}
