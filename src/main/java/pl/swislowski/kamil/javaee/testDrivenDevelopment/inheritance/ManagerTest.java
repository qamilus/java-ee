package pl.swislowski.kamil.javaee.testDrivenDevelopment.inheritance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * This program demonstrates inheritance.
 * 
 * @version 1.21 2004-02-21
 * @author Cay Horstmann http://www.horstmann.com/corejava.html
 */
public class ManagerTest {
//   public static void main(String[] args)
//   {
//      // construct a Manager object
//      Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
//      boss.setBonus(5000);
//
//      Employee[] staff = new Employee[3];
//
//      // fill the staff array with Manager and Employee objects
//
//      staff[0] = boss;
//      staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
//      staff[2] = new Employee("Tommy Tester", 40000, 1990, 3, 15);
//
//      // print out information about all Employee objects
//      for (Employee e : staff)
//         System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());
//   }

	@Test
	public void givenManager_whenCreated_thenNotNull() {
		// given
		Manager boss;

		// when
		boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);

		// then
		assertNotNull(boss);
	}

	@Test
	public void givenMenager_whenGetSalaryWithNoBonus_thenEqualsInitialSalary() {
		// given
		Manager manager = new Manager("Karol Stefa�ski", 90000, 1988, 11, 15);

		// when
		double salary = manager.getSalary();

		// then
		assertEquals(90000, salary, 0.001);
	}

	   @Test
	   public void givenMenager_whenGetSalaryWithBonus_thenEqualsInitialSalaryWithBonus() {
		   //given
		   Manager manager = new Manager("Karol Stefa�ski", 90000, 1988, 11, 15);
		   
		   //when
		   manager.setBonus(1000);
		   double salary = manager.getSalary();
		   
		   //then
		   assertEquals(91000, salary, 0.001);
	   }
}