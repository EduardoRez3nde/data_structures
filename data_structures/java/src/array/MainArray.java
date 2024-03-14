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

        array.remove(10);

        for (int i = 0; i < array.size(); i++) {
            System.out.printf("%d ", array.get(i));
        }
        System.out.printf("%n%d ", array.getCapacity());
        //System.out.printf("%n%d ", temp);
    }
}
