package pl.swislowski.kamil.javaee.testDrivenDevelopment.stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackNewTests {

    //Stack.getSize() – zwraca liczbę elementów na stosie
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
    public void testClear() {
        //given
        Stack stack = new Stack();


    }

}
