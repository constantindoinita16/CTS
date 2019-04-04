package Tests;

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.Before;
import org.junit.Test;

import BusinessLogic.Employee;
import BusinessLogic.EmployeeStatus;
import Exceptions.InvalidStatusException;
import Exceptions.InvalidTaxableIncomeException;

public class TestComputeTaxationRate {
	private Employee employee;
	
	@Before
	public void setUp() {
		employee = new Employee("Mirel", 160000,EmployeeStatus.MARRIED_FILING_JOINTLY);
	}

	
	@Test
	public void testRight() throws InvalidTaxableIncomeException, InvalidStatusException {
		float expectedValue= 0.22f;
		assertEquals(expectedValue,employee.computeTaxationRate(), 0.00001);
	}
	
	@Test(expected = InvalidTaxableIncomeException.class)
	public void testBoundary() throws InvalidTaxableIncomeException {
		employee.setTaxableIncome(0);
		fail("The income should be a positive number");
	}
	
	@Test(expected = InvalidTaxableIncomeException.class)
	public void testException() throws InvalidTaxableIncomeException, InvalidStatusException{
		employee.setTaxableIncome(-1);
		employee.computeTaxationRate();
		fail("The income should be a positive number");
		
	}
	
	
	@Test(timeout = 10)
	public void testPerformance() throws InvalidTaxableIncomeException, InvalidStatusException {
		employee.computeTaxationRate();
	}
	
	@Test
	public void testInverse() throws InvalidTaxableIncomeException {
	employee.setTaxableIncome(500);
	assertNotEquals("verific ca val initiala nu mai e", 160000, employee.getTaxableIncome());
	}
}
