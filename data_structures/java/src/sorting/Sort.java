package sorting;

public class Sort implements Sorting {

    public static void bubbleSort(Comparable[] collection) {

        boolean flag = false;
        for (int i = 0; i < collection.length - 1; i++) {
            for (int j = 0; j < collection.length - 1 - i; j++) {
                if (Sorting.less(collection[j + 1], collection[j])) {
                    Sorting.swap(collection, j + 1, j);
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }

    public static void selection(Comparable[] collection) {
        int i, j, k;
        for (i = 0; i < collection.length - 1; i++) {
            for (j = k = i; j < collection.length; j++) {
                if (Sorting.less(collection[j], collection[k]))
                    k = j;
            }
            Sorting.swap(collection, i, k);
        }
    }

    public static void insertion(Comparable[] collection) {
        int i, j;
        for (i = 1; i < collection.length; i++) {
            for (j = i; j > 0 && Sorting.less(collection[j], collection[j - 1]); j--) {
                Sorting.swap(collection, j, j - 1);
            }
        }
    }

    public static void shellSort(Comparable[] collection) {

        int h = 1;
        while (h < collection.length/3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < collection.length; i++) {
                for (int j = i; j >= h && Sorting.less(collection[j], collection[j-h]); j -= h)
                    Sorting.swap(collection, j, j-h);
            }
            h = h/3;
        }
    }

    public static void mergeSortR(Comparable[] collection) {
        mergeSortR(collection, 0, collection.length - 1);
    }

    private static void mergeSortR(Comparable[] collection, int l, int h) {

        if (l < h) {
            int mid = l + (h - l) / 2;
            mergeSortR(collection, l, mid);
            mergeSortR(collection, mid + 1, h);
            Sort.merging(collection, l, mid, h);
        }
    }

    private static void merging(Comparable[] collection, int l, int m, int h) {

        int i = l;
        int k = l;
        int j = m + 1;
        Comparable[] temp = new Comparable[collection.length];

        while (i <= m && j <= h) {

            if (Sorting.less(collection[i], collection[j]))
                temp[k++] = collection[i++];
            else
                temp[k++] = collection[j++];
        }
        while (i <= m)
            temp[k++] = collection[i++];

        while (j <= h)
            temp[k++] = collection[j++];

        for (i = l; i <= h; i++)
            collection[i] = temp[i];
    }
}
