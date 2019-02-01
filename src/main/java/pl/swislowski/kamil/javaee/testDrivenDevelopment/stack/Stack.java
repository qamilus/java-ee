package pl.swislowski.kamil.javaee.testDrivenDevelopment.stack;

import java.nio.BufferOverflowException;
import java.util.EmptyStackException;

public class Stack {

    public static final int MAX_CAPACITY = 10;
    //    private boolean empty = true;
//    private int value;
    private int size = 0;
    private int[] contents = new int[MAX_CAPACITY];

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(int i) {
//        empty = false;
//        value = i;
//        size++;
        if (size == MAX_CAPACITY)
            throw new BufferOverflowException();

        contents[size++] = i;
    }

    public int pop() {
        if (isEmpty())
            throw new EmptyStackException();
//        empty = true;
//        size--;
        return contents[--size];
    }

    public int getSize() {


        return MAX_CAPACITY;
    }
// TODO : Praca domowa - nie zmieniać formy stosu z tablicy. Konfigurowalność rozmiaru stosu. Jeżeli się zwiększu, to luz, jeżeli się zmienjszy
    //TODO : trzeba rzucić wyjątkiem.
}
