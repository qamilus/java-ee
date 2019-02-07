package pl.swislowski.kamil.javaee.testDrivenDevelopment.account;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AccountTests {

	// private static final double WITHDRAW_4_4 = 4.4;
	private static final double INITIAL_BALANCE_10_0 = 10.0;
	private static final double DEPOSIT_3_3 = 3.3;
	private static final Double WITHDRAW_2_2 = 2.2;

	@Test
	public void givenAccount_whenAccountInitialized_thenAccountNotNull() {
		// given
		Account account = null;

		// when
		account = new Account();

		// then
		assertNotNull("Konto nie mo¿e byæ null", account);
	}

	@Test
	public void balanceTest() {
		// given
		Account account = new Account();

		// when
		Double balance = account.getBalance();

		// then
		assertNotNull("Saldo nie mo¿e byæ null", balance);
	}

	@Test
	public void withdrawTest() {
		// given
		Account account = new Account();

		// when
		Double balanceBefore = account.getBalance();
		account.withdraw(WITHDRAW_2_2);
		Double balanceAfter = account.getBalance();

		// then
		Double balanceMinusWithdraw = balanceBefore - WITHDRAW_2_2;
		assertEquals("B³êdne saldo po wyp³acie œrodków", balanceMinusWithdraw, balanceAfter);
	}

	@Test
	public void withdrawTest2() {
		// given
		Account account = new Account();

		// when
		Double withdraw = account.withdraw(WITHDRAW_2_2);

		// then
		assertNotNull("Wyp³acone œrodkie nie mog¹ byæ null", withdraw);
	}

	@Test
	public void depositTest() {
		// given
		Account account = new Account();

		// when
		Double deposit = account.deposit(DEPOSIT_3_3);

		// then
		assertNotNull("Wp³acone œrodki nie mog¹ byæ null", deposit);
	}

	@Test
	public void depositTest2() {
		// given
		Account account = new Account();

		// when
		Double balanceBefore = account.getBalance();
		Double deposit = account.deposit(DEPOSIT_3_3);

		// then
		Double balancePlusDeposit = balanceBefore + DEPOSIT_3_3;
		assertEquals("B³êdne saldo po wp³acie œrodków", balancePlusDeposit, deposit);
	}

	@Test
	public void givenAccountWithInitialBalance_whenGetInitialBalance_thenBalanceIsCorrect() {
		// given
		Account account = new Account(INITIAL_BALANCE_10_0);

		// when
		// account.setInitialBalance(3.2);
		Double balance = account.getBalance();

		// then
		assertEquals("Saldo pocz¹tkowe siê nie zgadza", INITIAL_BALANCE_10_0, balance, 0.001);
	}

	@Test
	public void givenAccount_whenDepositAndWithdrawSameAmount_thenBalanceIsLikeBefore() {
		// given
		Account account = new Account();

		// when
		Double balanceBefore = account.getBalance();
		account.deposit(DEPOSIT_3_3);
		account.withdraw(WITHDRAW_2_2);
		Double balanceAfter = account.getBalance();

		// then
		Double DepositAndWithdraw = balanceBefore + DEPOSIT_3_3 - WITHDRAW_2_2;
		assertEquals("Saldo siê nie zgadza", DepositAndWithdraw, balanceAfter);
	}

	@Test
	public void givenAccount_whenDepositAndWithdraw_thenBalanceGreaterThanZero() {
		// given
		Account account = new Account();

		// when
		account.getBalance();
		account.deposit(DEPOSIT_3_3);
		account.withdraw(WITHDRAW_2_2);
		Double balanceAfter = account.getBalance();

		// then
		assertTrue("Saldo jest mniejsze od zera", balanceAfter >= 0);
	}

	@Test
	public void givenAccount_whenWithdraw_thenBalanceLessThanZero() {
		// given
		Account account = new Account();

		// when
		Double initialBalance = account.getBalance();
		Double balanceAfter = account.withdraw(WITHDRAW_2_2);

		// then
		Double balanceAfterWithdraw = initialBalance - WITHDRAW_2_2;
		assertEquals("Saldo jest wiêksze od zera", balanceAfterWithdraw, balanceAfter);
	}
}
