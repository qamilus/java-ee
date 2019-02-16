package pl.swislowski.kamil.javaee.testDrivenDevelopment.stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StackNewTests {
    private static final int VALUE_1 = 1;

    //Stack.getHeight() – zwraca liczbę elementów na stosie
    //Stack.clear() – czyści stos (usuwa wszystkie elementy)
    // configurable Stack capacity – stos o zmiennej pojemności, różne metody

    @Test
    public void givenStack_whenGetSize_thenSizeIsCorrect() {
        //given
        Stack stack = new Stack();

        //when
        int size = stack.getSize();

        //then
        assertEquals(Stack.MAX_CAPACITY, size);
    }

    @Test
    public void givenStack_whenStackClear_thenStackEmpty() {
        //given
        Stack stack = new Stack();

        //when
        stack.push(VALUE_1);
        stack.pop();
        boolean clear = stack.clear();

        //then
        assertTrue(clear);
    }

}
