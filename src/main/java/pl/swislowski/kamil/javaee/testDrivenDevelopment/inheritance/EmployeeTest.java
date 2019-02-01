package pl.swislowski.kamil.javaee.testDrivenDevelopment.inheritance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

public class EmployeeTest {

	private static final double SALARY_ADDITIONAL_PROCENT = 10.0;
	private static final int SALARY = 10000;
	private static final int DAY = 10;
	private static final int MONTH = 10;
	private static final int YEAR = 1988;
	private static final String NAME = "Pawe� Stefa�ski";

	@Test
	public void givenEmployee_whenGetName_thenNameNotNull() {
		// given
		Employee employee = new Employee("Pawe� Stefa�ski", 10000, 1988, 10, 10);

		// when
		String name = employee.getName();

		// then
		assertNotNull(name);
	}

	@Test
	public void givenEmployee_whenGetName_thenNameEqualsName() {
		// given
		Employee employee = new Employee(NAME, 10000, 1988, 10, 10);

		// when
		String name = employee.getName();

		// then
		assertEquals(NAME, name);
	}

	@Test
	public void givenEmployee_whenGetHireDay_thenHireDayNotNull() {
		// given
		Employee employee = new Employee(NAME, 10000, 1988, 10, 10);

		// when
		Date hireDay = employee.getHireDay();

		// then
		assertNotNull(hireDay);
	}

	@Test
	public void givenEmployee_whenGetHireDay_thenHireDayEqualsHireDay() {
		// given
		Employee employee = new Employee(NAME, 10000, YEAR, MONTH, DAY);
		GregorianCalendar gc = new GregorianCalendar(YEAR, MONTH - 1, DAY);

		// when
		Date hireDay = employee.getHireDay();
		Date gcDay = gc.getTime();

		// then
		assertEquals(hireDay, gcDay);
	}

	@Test
	public void givenEmployee_whenRaiseSalary_thenSalaryIsRaised() {
		// given
		Employee employee = new Employee(NAME, SALARY, YEAR, MONTH, DAY);
		double raise = SALARY * SALARY_ADDITIONAL_PROCENT / 100;
		double extraSalary = SALARY + raise;

		// when
		employee.raiseSalary(SALARY_ADDITIONAL_PROCENT);
		double salary = employee.getSalary();
		
		//then
		assertEquals(extraSalary, salary, 0.001);
	}

}
