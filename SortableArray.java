import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.Comparator;

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

    public void sortFloats() {
        Arrays.sort(array, new Comparator<T>() {
            @Override
            public int compare(T float1, T float2) {
                return float1.compareTo(float2);
            }
        });
    }
  
    @Test
    public void testSortFloats() {
        Float[] floatArray = {3.14f, 1.618f, 2.718f, 0.577f};
        SortableArray<Float> sortableFloatArray = new SortableArray<>(floatArray);

        sortableFloatArray.sortFloats();

        Float[] expectedArray = {0.577f, 1.618f, 2.718f, 3.14f};
        Assert.assertArrayEquals(expectedArray, floatArray);
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
         // Test sorting integers
        Integer[] intArray = {5, 2, 8, 1, 9};
        SortableArray<Integer> sortableIntArray = new SortableArray<>(intArray);

        System.out.println("Original array:");
        sortableIntArray.print();

        sortableIntArray.sortIntegers();

        System.out.println("Sorted array:");
        sortableIntArray.print();
      
        // Run the unit tests
        sortableIntArray.testSortIntegers();
      
        // Test sorting floats
        Float[] floatArray = {3.14f, 1.618f, 2.718f, 0.577f};
        SortableArray<Float> sortableFloatArray = new SortableArray<>(floatArray);

        System.out.println("Original float array:");
        sortableFloatArray.print();

        sortableFloatArray.sortFloats();

        System.out.println("Sorted float array:");
        sortableFloatArray.print();

        // Run the unit test for sortFloats
        sortableFloatArray.testSortFloats();
  
          // Test sorting strings
        String[] stringArray = {"banana", "apple", "cherry", "date"};
        SortableArray<String> sortableStringArray = new SortableArray<>(stringArray);

        System.out.println("Original string array:");
        sortableStringArray.print();

        sortableStringArray.sortStrings();

        System.out.println("Sorted string array:");
        sortableStringArray.print();

        // Run the unit tests
        sortableStringArray.testSortStrings();
        //test_1 (new change)
    }
}