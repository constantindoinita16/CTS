package BusinessLogic;

import Exceptions.InvalidStatusException;
import Exceptions.InvalidTaxableIncomeException;

public class Employee {
	private String fullName;
	private double taxableIncome;
	private EmployeeStatus employeeStatus;
	
	public Employee() {}
	public Employee(String fullName, double taxableIncome, EmployeeStatus employeeStatus) {
		this.fullName = fullName;
		this.taxableIncome = taxableIncome;
		this.employeeStatus = employeeStatus;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public double getTaxableIncome() {
		return taxableIncome;
	}
	public void setTaxableIncome(double taxableIncome) throws InvalidTaxableIncomeException{
		if(taxableIncome > 0) {
		this.taxableIncome = taxableIncome;
		}else {
			throw new InvalidTaxableIncomeException("the income has to be greater than 0");
		}
	}
	public EmployeeStatus getEmployeeStatus() {
		return employeeStatus;
	}
	public void setEmployeeStatus(EmployeeStatus employeeStatus) {
		this.employeeStatus = employeeStatus;
	}
	
	public double computeTaxationRate() throws InvalidTaxableIncomeException, InvalidStatusException {
		double rate = 0;
		switch(this.employeeStatus) {
		case SINGLE_FILER:
			if(this.taxableIncome > 0) {
				if(this.taxableIncome < 9525) {
					rate = 0.1;
				}
				if(this.taxableIncome < 38700 && this.taxableIncome >=9525) {
					rate = 0.12;
				}
				if(this.taxableIncome < 82500 && this.taxableIncome >= 38700) {
					rate = 0.22;
				}
				if(this.taxableIncome < 157500 && this.taxableIncome >= 82500) {
					rate = 0.24;
				}
				if(this.taxableIncome < 200000 && this.taxableIncome >= 157500) {
					rate = 0.32;
				}
				if(this.taxableIncome < 500000 && this.taxableIncome >= 200000) {
					rate = 0.35;
				}
				if(this.taxableIncome > 500000) {
					rate = 0.37;
				}
			}else {
				throw new InvalidTaxableIncomeException("Taxable Income should be a positive number!");
			}
			break;
		case MARRIED_FILING_JOINTLY:
			if(this.taxableIncome > 0) {
				if(this.taxableIncome < 19050) {
					rate = 0.1;
				}
				if(this.taxableIncome < 77400 && this.taxableIncome >=19050) {
					rate = 0.12;
				}
				if(this.taxableIncome < 165000 && this.taxableIncome >= 77400) {
					rate = 0.22;
				}
				if(this.taxableIncome < 315000 && this.taxableIncome >= 165000) {
					rate = 0.24;
				}
				if(this.taxableIncome < 400000 && this.taxableIncome >= 315000) {
					rate = 0.32;
				}
				if(this.taxableIncome < 600000 && this.taxableIncome >= 400000) {
					rate = 0.35;
				}
				if(this.taxableIncome > 600000) {
					rate = 0.37;
				}
			}else {
				throw new InvalidTaxableIncomeException("Taxable Income should be a positive number!");
			}
			break;
		case MARRIED_FILING_SEPARATELY:
			if(this.taxableIncome > 0) {
				if(this.taxableIncome < 9525) {
					rate = 0.1;
				}
				if(this.taxableIncome < 38700 && this.taxableIncome >=9525) {
					rate = 0.12;
				}
				if(this.taxableIncome < 82500 && this.taxableIncome >= 38700) {
					rate = 0.22;
				}
				if(this.taxableIncome < 157500 && this.taxableIncome >= 82500) {
					rate = 0.24;
				}
				if(this.taxableIncome < 200.000 && this.taxableIncome >= 157500) {
					rate = 0.32;
				}
				if(this.taxableIncome < 300.000 && this.taxableIncome >= 200.000) {
					rate = 0.35;
				}
				if(this.taxableIncome > 300.000) {
					rate = 0.37;
				}
			}else {
				throw new InvalidTaxableIncomeException("Taxable Income should be a positive number!");
			}
			break;
		case HEAD_OF_HOUSEHOLD:
			if(this.taxableIncome > 0) {
				if(this.taxableIncome < 13600) {
					rate = 0.1;
				}
				if(this.taxableIncome < 51800 && this.taxableIncome >=13600) {
					rate = 0.12;
				}
				if(this.taxableIncome < 82500 && this.taxableIncome >= 51800) {
					rate = 0.22;
				}
				if(this.taxableIncome < 157500 && this.taxableIncome >= 82500) {
					rate = 0.24;
				}
				if(this.taxableIncome < 200000 && this.taxableIncome >= 157500) {
					rate = 0.32;
				}
				if(this.taxableIncome < 500000 && this.taxableIncome >= 200000) {
					rate = 0.35;
				}
				if(this.taxableIncome > 500000) {
					rate = 0.37;
				}
			}else {
				throw new InvalidTaxableIncomeException("Taxable Income should be a positive number!");
			}
			break;
		default:
			throw new InvalidStatusException("This status is not accepted by the legislation.");
		}
		return rate;
	}
}
