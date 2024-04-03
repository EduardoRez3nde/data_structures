package array;

public class MainArray {

    public static void main(String[] args) {

        DynamicArray<Integer> array = new DynamicArray<>();

        array.push(10);
        array.push(30);
        array.push(50);
        array.push(70);
        array.push(40);
        array.push(10);

        for (int element : array) {
            System.out.printf("%d ", element);
        }

        System.out.printf("%n%d ", array.getCapacity());
        //System.out.printf("%n%d ", temp);
    }
}
