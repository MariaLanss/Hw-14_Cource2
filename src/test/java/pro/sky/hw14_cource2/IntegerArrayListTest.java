package pro.sky.hw14_cource2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerArrayListTest {
    private IntegerArrayList out;

    @BeforeEach
    public void setUp(){
        out = new IntegerArrayList();
        out.add(155);
    }

    @Test
    void shouldReturnItemWhenAddIsCalled() {
        assertEquals(22, out.add(22));
        assertEquals(2,out.size());
    }

    @Test
    void shouldAddItemWhenArrayIsFull(){
        IntegerArrayList out = new IntegerArrayList(1);
        out.add(189);
        out.add(55);
        assertEquals(2, out.size());
    }

    @Test
    void shouldReturnItemWhenAddWithIndexIsCalled() {
        assertEquals(189, out.add(0, 189));
        assertEquals(2, out.size());
        assertEquals(189, out.get(0));
    }

    @Test
    void shouldThrowExceptionWhenAddWithIncorrectIndexIsCalled(){
        assertThrows(IntegerArrayListIndexOutOfBoundsException.class, ()-> out.add(15, 45));
    }

    @Test
    void shouldSetNewValueWhenSetIsCalled() {
        out.add(45);
        out.set(1, 88);
        assertEquals(88, out.get(1));
    }

    @Test
    void shouldThrowExceptionWhenSetIsCalledWithIncorrectIndex(){
        assertThrows(IntegerArrayListIndexOutOfBoundsException.class, () -> out.set(22, 57));
    }

    @Test
    void shouldRemoveItemByIndexAndShiftArray() {
        out.add(22);
        out.add(221);
        assertEquals(22, out.remove(1));

        IntegerArrayList expected = new IntegerArrayList();
        expected.add(155);
        expected.add(221);
        assertEquals(expected, out);
    }

    @Test
    void shouldThrowExceptionWhenRemoveWithIncorrecteIndexIsCalled(){
        assertThrows(IntegerArrayListIndexOutOfBoundsException.class, ()->out.remove(12));
    }

    @Test
    void shouldRemoveItemByValueAndShiftArray() {
        out.add(55);
        out.add(87);
        assertEquals(55, out.remove(Integer.valueOf(55)));

        IntegerArrayList expected = new IntegerArrayList();
        expected.add(155);
        expected.add(87);
        assertEquals(expected, out);
    }

    @Test
    void shouldReturnTrueWhenContainsWithExistingItemIsCalled() {
        assertTrue(out.contains(155));
    }

    @Test
    void shouldReturnFalseWhenContainsWithExistingItemIsCalled() {
        assertFalse(out.contains(156));
    }

    @Test
    void shouldReturnIndexOfExistingItem() {
        out.add(22);
        out.add(67);
        out.add(22);
        out.add(1);
        assertEquals(1, out.indexOf(22));
    }
    @Test
    void shouldReturnMinusOneWhenIndexOfIsCalledForNonExistentItem() {
        assertEquals(-1, out.indexOf(22));
    }

    @Test
    void shouldReturnLastIndexOfExistingItem() {
        out.add(22);
        out.add(67);
        out.add(22);
        out.add(1);
        assertEquals(3, out.lastIndexOf(22));
    }

    @Test
    void shouldReturnItemByIndex() {
        out.add(22);
        out.add(105);
        assertEquals(22, out.get(1));
    }

    @Test
    void shouldThrowExceptionWhenGetIsCalledWithWrongIndex(){
        assertThrows(IntegerArrayListIndexOutOfBoundsException.class, ()-> out.get(3));
    }

    @Test
    void shouldReturnTrueForEqualStringArrayLists() {
        IntegerArrayList expected = new IntegerArrayList();
        expected.add(155);
        assertTrue(out.equals(expected));
    }
    @Test
    void shouldReturnFalseForInEqualStringArrayLists() {
        IntegerArrayList expected = new IntegerArrayList(9);
        expected.add(155);
        assertFalse(out.equals(expected));
    }

    @Test
    void shouldReturnSizeOfStringArrayList() {
        assertEquals(1, out.size());

        out.add(22);
        assertEquals(2, out.size());

        out.add(3);
        assertEquals(3, out.size());
    }

    @Test
    void shouldReturnTrueWhenEmpty() {
        out.remove(0);
        assertTrue(out.isEmpty());
    }
    @Test
    void shouldReturnFalseWhenNotEmpty() {
        assertFalse(out.isEmpty());
    }

    @Test
    void shouldBeClearedWhenClearIsCalled() {
        out.clear();
        assertEquals(0, out.size());
    }

    @Test
    void toArray() {
        out.add(77);
        assertArrayEquals(new Integer[]{155, 77}, out.toArray());
    }
}
