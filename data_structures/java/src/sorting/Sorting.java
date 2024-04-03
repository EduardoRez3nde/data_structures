package sorting;

@SuppressWarnings("unchecked")
public interface Sorting {

    static boolean less(Comparable collection1, Comparable collection2) {
        return collection1.compareTo(collection2) < 0;
    }

    static void swap(Comparable[] collection1, int i, int j) {
        Comparable t = collection1[i];
        collection1[i] = collection1[j];
        collection1[j] = t;
    }

    static boolean isSorted(Comparable[] collection) {
        for (int i = 1; i < collection.length; i++) {
            if (less(collection[i], collection[i - 1])) return false;
        }
        return true;
    }
}
