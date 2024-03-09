import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SortableArray<T extends Comparable<T>> {
    private T[] array;

    public SortableArray(T[] array) {
        this.array = array;
    }

    public void sort() {
        Arrays.sort(array);
    }
    public void sortStrings() {
        Arrays.sort(array, (a, b) -> ((String) a).compareTo((String) b));
    }
    @Test
    public void testSortStrings() {
        String[] stringArray = {"banana", "apple", "cherry", "date"};
        SortableArray<String> sortableStringArray = new SortableArray<>(stringArray);

        sortableStringArray.sortStrings();

        String[] expectedArray = {"apple", "banana", "cherry", "date"};
        Assert.assertArrayEquals(expectedArray, stringArray);
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
        // Test sorting strings
        String[] stringArray = {"banana", "apple", "cherry", "date"};
        SortableArray<String> sortableStringArray = new SortableArray<>(stringArray);

        System.out.println("Original string array:");
        sortableStringArray.print();

        sortableStringArray.sortStrings();

        System.out.println("Sorted string array:");
        sortableStringArray.print();

        // Run the unit tests
        sortableStringArray
                .testSortStrings();
    }
}