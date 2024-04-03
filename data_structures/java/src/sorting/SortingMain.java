package sorting;

public class SortingMain {

    public static void main(String[] args) {

        Integer[] arr = {50, 30, 10, 100, 40, 20, 5, 8, 2};
        Sort.insertion(arr);


        for (Integer integer : arr) {
            System.out.printf("%d ", integer);
        }
        System.out.println();

    }
}
