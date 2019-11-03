package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {

    private Object[] simpleArray;
    private ImmutableArrayList basicArray1;
    private ImmutableArrayList basicArray2;

    @Before
    public void setUp() {
        simpleArray = new Object[]{1, 2, 3};
        basicArray1 = new ImmutableArrayList(simpleArray);
        basicArray2 = new ImmutableArrayList(2);

    }

    @Test
    public void testAddSame() {
        ImmutableArrayList newArray = basicArray1.add(4);
        Object[] actualResult = newArray.toArray();

        Object[] expectedResult = new Object[]{1, 2, 3, 4};
        assertEquals(expectedResult[3], actualResult[3]);
        assertEquals(expectedResult.length, newArray.getSize());

    }

    @Test
    public void testAddExtend() {
        ImmutableArrayList newArray = basicArray1.add(4);
        ImmutableArrayList extendedArray = newArray.add(5);
        Object[] actualResult = extendedArray.toArray();

        Object[] expectedResult = new Object[]{1, 2, 3, 4, 5};
        assertEquals(expectedResult[0], actualResult[0]);
        assertEquals(expectedResult.length, extendedArray.getSize());

    }


    @Test
    public void getSize() {
        assertEquals(basicArray2.getSize(), 0);
        assertEquals(basicArray1.getSize(), 3);
    }

    @Test
    public void testAddByIndex() {
        ImmutableArrayList newArray = basicArray1.add(1, 4);
        Object[] actualResult = newArray.toArray();
        Object[] expectedResult = new Object[]{1, 4, 2, 3};
        assertEquals(expectedResult[1], actualResult[1]);
        assertEquals(expectedResult[3], actualResult[3]);
        assertEquals(expectedResult[0], actualResult[0]);
        assertEquals(expectedResult.length, newArray.getSize());

    }


    @Test
    public void testAddAll() {
        Object[] extra = new Object[]{3, 2, 1, 0};
        Object[] expectedResult = new Object[]{1, 2, 3, 3, 2, 1, 0};
        ImmutableArrayList newArray = basicArray1.addAll(extra);
        Object[] actualResult = newArray.toArray();
        assertEquals(expectedResult[3], actualResult[3]);
        assertEquals(expectedResult[6], actualResult[6]);
        assertEquals(expectedResult[0], actualResult[0]);
        assertEquals(expectedResult.length, newArray.getSize());

    }


    @Test
    public void testGet() {
        assertEquals(1, basicArray1.get(0));
        assertEquals(3, basicArray1.get(2));
    }

    @Test
    public void set() {
        assertEquals(1, basicArray1.get(0));
        ImmutableArrayList newArray = basicArray1.set(0, 2);
        assertEquals(2, newArray.get(0));
        ImmutableArrayList anotherArray = basicArray1.set(2, 5);
        assertEquals(5, anotherArray.get(2));
    }

    @Test
    public void indexOf() {
        int ind = basicArray1.indexOf(1);
        assertEquals(0, ind);
        int ind2 = basicArray1.indexOf(3);
        assertEquals(2, ind2);
    }

    @Test
    public void clear() {
        ImmutableArrayList newArray = basicArray1.clear();
        assertEquals(0, newArray.getSize());
    }

    @Test
    public void isEmpty() {
        assertFalse(basicArray1.isEmpty());
        assertTrue(basicArray2.isEmpty());
    }

    @Test
    public void toArray() {
        Object[] actualResult = basicArray1.toArray();
        assertEquals(1, actualResult[0]);
        assertEquals(3, actualResult[2]);
    }

    @Test
    public void testToString() {
        System.out.println(basicArray1.toString());
        assertEquals("[1, 2, 3, null]", (basicArray1.toString()));
    }
}
