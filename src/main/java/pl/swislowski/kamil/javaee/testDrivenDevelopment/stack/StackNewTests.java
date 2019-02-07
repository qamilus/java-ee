package pl.swislowski.kamil.javaee.testDrivenDevelopment.stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class StackNewTests {

	private static final int INITIAL_CAPACITY_12 = 12;
	private static final int SIZE_15 = 15;
	private static final int VALUE_2 = 2;

	// Stack.getSize() – zwraca liczbę elementów na stosie
	// Stack.clear() – czyści stos (usuwa wszystkie elementy)
	// configurable Stack capacity – stos o zmiennej pojemności, różne metody

	@Test
	public void givenStack_whenGetSize_thenSizeIsCorrect() {
		// given
		Stack stack = new Stack();

		// when
		int size = stack.getSize();

		// then
		assertEquals(Stack.MAX_CAPACITY, size);
	}

	@Test
	public void givenStackWithCustomSize_whenGetSize_thenSizeIsCorrect() {
		// given
		Stack stack = new Stack(SIZE_15);

		// when
		int size = stack.getSize();

		// then
		assertEquals(SIZE_15, size);
	}

	@Test
	public void givenStack_whenClear_thenStackIsEmpty() {
		// given
		Stack stack = new Stack();

		// when
		stack.push(VALUE_2);
		stack.clear();
		boolean empty = stack.isEmpty();

		// then
		assertTrue(empty);
	}

	@Test
	public void givenStackWithCustomSize_whenClear_thenStackIsEmpty() {
		// given
		Stack stack = new Stack(INITIAL_CAPACITY_12);

		// when
		stack.push(VALUE_2);
		stack.clear();
		boolean empty = stack.isEmpty();

		// then
		assertTrue(empty);
	}

	@Test
	public void givenStackWithCustomSize_whenPushAndClear_thenStackOriginalAndCustomSizeIsEqual() {
		// given
		Stack stack = new Stack(INITIAL_CAPACITY_12);

		// when
		for (int i = 0; i < INITIAL_CAPACITY_12; i++) {
			stack.push(VALUE_2);
		}

		stack.clear();

		// then
		assertEquals(Stack.MAX_CAPACITY, INITIAL_CAPACITY_12);
	}

}
