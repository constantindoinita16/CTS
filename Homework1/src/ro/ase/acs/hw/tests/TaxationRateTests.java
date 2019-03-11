package ro.ase.acs.hw.tests;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import ro.ase.acs.hw.exceptions.InvalidStatusException;
import ro.ase.acs.hw.exceptions.InvalidTaxableIncomeException;
import ro.ase.acs.hw.model.Employee;
import ro.ase.acs.hw.model.EmployeeStatus;

public class TaxationRateTests {
	@Test
	public void testBonusForSINGLE_FILER1() {
		Employee employee = new Employee("John Doe", 1000, EmployeeStatus.SINGLE_FILER);
		try {
			assertEquals(0.1, employee.computeTaxationRate(), 0.0001);
		} catch (InvalidTaxableIncomeException e) {
			e.printStackTrace();
		} catch (InvalidStatusException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testBonusForSINGLEFILER2() {
		Employee employee = new Employee("John Doe", 10000, EmployeeStatus.SINGLE_FILER);
		try {
			assertEquals(0.12, employee.computeTaxationRate(), 0.0001);
		} catch (InvalidTaxableIncomeException e) {
			e.printStackTrace();
		} catch (InvalidStatusException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testBonusForSINGLEFILER3() {
		Employee employee = new Employee("John Doe", 50000, EmployeeStatus.SINGLE_FILER);
		try {
			assertEquals(0.22, employee.computeTaxationRate(), 0.0001);
		} catch (InvalidTaxableIncomeException e) {
			e.printStackTrace();
		} catch (InvalidStatusException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testBonusForSINGLEFILER4() {
		Employee employee = new Employee("John Doe", 150000, EmployeeStatus.SINGLE_FILER);
		try {
			assertEquals(0.24, employee.computeTaxationRate(), 0.0001);
		} catch (InvalidTaxableIncomeException e) {
			e.printStackTrace();
		} catch (InvalidStatusException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testBonusForSINGLEFILER5() {
		Employee employee = new Employee("John Doe", 180000, EmployeeStatus.SINGLE_FILER);
		try {
			assertEquals(0.32, employee.computeTaxationRate(), 0.0001);
		} catch (InvalidTaxableIncomeException e) {
			e.printStackTrace();
		} catch (InvalidStatusException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testBonusForSINGLEFILER6() {
		Employee employee = new Employee("John Doe", 250000, EmployeeStatus.SINGLE_FILER);
		try {
			assertEquals(0.35, employee.computeTaxationRate(), 0.0001);
		} catch (InvalidTaxableIncomeException e) {
			e.printStackTrace();
		} catch (InvalidStatusException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testBonusForSINGLEFILER7() {
		Employee employee = new Employee("John Doe", 520000, EmployeeStatus.SINGLE_FILER);
		try {
			assertEquals(0.37, employee.computeTaxationRate(), 0.0001);
		} catch (InvalidTaxableIncomeException e) {
			e.printStackTrace();
		} catch (InvalidStatusException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testBonusForNegative() {
		Employee employee = new Employee("John Doe", -520000, EmployeeStatus.MARRIED_FILING_JOINTLY);
		try {
			employee.computeTaxationRate();
			fail("The method should not work with a negative taxable income");
		} catch (InvalidTaxableIncomeException e) {
			e.printStackTrace();
		} catch (InvalidStatusException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testBonusForUnknownStatus() {
		Employee employee = new Employee("John Doe", -520000, EmployeeStatus.RANDOM_STATUS);
		try {
			employee.computeTaxationRate();
			fail("The method should not work with a legally unknown status");
		} catch (InvalidTaxableIncomeException e) {
			e.printStackTrace();
		} catch (InvalidStatusException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testBonusForWrongTreshold() {
		Employee employee = new Employee("John Doe", 520000, EmployeeStatus.MARRIED_FILING_SEPARATELY);
		try {
			if(employee.computeTaxationRate()!=0.37)
			fail("The rate for this configuration is 0.37");
		} catch (InvalidTaxableIncomeException e) {
			e.printStackTrace();
		} catch (InvalidStatusException e) {
			e.printStackTrace();
		}
	}
	
}
