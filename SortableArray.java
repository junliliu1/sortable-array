import java.util.Arrays;

public class SortableArray<T extends Comparable<T>> {
    private T[] array;

    public SortableArray(T[] array) {
        this.array = array;
    }

    public void sort() {
        Arrays.sort(array);
    }

    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    public void print() {
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        Integer[] intArray = {5, 2, 8, 1, 9};
        SortableArray<Integer> sortableIntArray = new SortableArray<>(intArray);

        System.out.println("Original array:");
        sortableIntArray.print();

        sortableIntArray.sort();

        System.out.println("Sorted array:");
        sortableIntArray.print();
    }
}