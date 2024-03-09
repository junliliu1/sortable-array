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

    }
}