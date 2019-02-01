package pl.swislowski.kamil.javaee.testDrivenDevelopment.stack;

import org.junit.Test;

import java.nio.BufferOverflowException;
import java.util.EmptyStackException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class StackTests {


    private static final int VALUE_123 = 123;
    private static final int VALUE_1 = 1;

    @Test
    public void newlyCreatedStackIsEmpty() {
        //given
        Stack s = new Stack();

        //when
        boolean empty = s.isEmpty();

        //then
        assertTrue(empty);
    }

    @Test
    public void afterPushStackIsNoLongerEmpty() {
        //given
        Stack s = new Stack();

        //when
        s.push(1);
        boolean empty = s.isEmpty();

        //then
        assertFalse(empty);
    }

    @Test
    public void afterPushAndPopStackEmpty() {
        //given
        Stack s = new Stack();

        //when
        s.push(1);
        s.pop();
        boolean empty = s.isEmpty();

        //then
        assertTrue(empty);
    }

    @Test(expected = EmptyStackException.class)
    public void emptyStackThrowsOnPop() {
        //given
        Stack s = new Stack();

        //when
        s.pop();

        //then
        // throws EmptyStackException
    }

    @Test
    public void popReturnsWhatWasPushed(){
        //given
        Stack s = new Stack();

        //when
        s.push(VALUE_123);
        int popValue = s.pop();

        //then
        assertEquals(VALUE_123, popValue);
    }

    @Test
    public void stackNotEmptyWhenLessPopThanPush(){
        //given
        Stack s = new Stack();

        //when
        s.push(VALUE_123);
        s.push(VALUE_123);
        s.pop();
        boolean empty = s.isEmpty();

        //then
        assertFalse(empty);
    }

    @Test
    public void lastPopReturnsFirstPushedValue(){
        //given
        Stack s = new Stack();

        //when
        s.push(VALUE_1);
        s.push(VALUE_123);
        s.pop();
        int popValue = s.pop();

        //then
        assertEquals(VALUE_1, popValue);
//        assertTrue(s.isEmpty());
    }

    @Test(expected = BufferOverflowException.class)
    public void stackThrowsWhenCapacityExceeded(){
        //given
        Stack s = new Stack();

        //when
        for (int i = 0; i < Stack.MAX_CAPACITY + 1; i++) {
                s.push(i);
        }

        //then
        //throws BufferOverflowException
    }
}
