import org.junit.Test;
import org.junit.Assert;
import java.util.Arrays;

public class SortableArray<T extends Comparable<T>> {
    private T[] array;

    public SortableArray(T[] array) {
        this.array = array;
    }

    public void sort() {
        Arrays.sort(array);
    }
  
    private void sortIntegers() {
        Integer[] intArray = (Integer[]) array;
        Arrays.sort(intArray);
        array = (T[]) intArray;
    }
  
    @Test
    public void testSortIntegers() {
        Integer[] intArray = {5, 2, 8, 1, 9};
        SortableArray<Integer> sortableIntArray = new SortableArray<>(intArray);

        sortableIntArray.sort();

        Integer[] expectedArray = {1, 2, 5, 8, 9};
        Assert.assertArrayEquals(expectedArray, sortableIntArray.getArray());
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

        sortableIntArray.sortIntegers();

        System.out.println("Sorted array:");
        sortableIntArray.print();
      
        sortableIntArray.testSortIntegers();
    }
}