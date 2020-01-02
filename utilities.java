package com.deloitte.employee;

public class utilities {
	public static boolean nameValidation(String name) {
		String pattern="^[A-Za-z]+$";
		if(name.matches(pattern))
		return true;
		else
			System.out.println("name should be in alphabets");
		return false;
	}
	public static boolean salaryValidation(String Salary) {
		String pattern="^[0-9]+[.]{1}[0-9]+$";
		if(Salary.matches(pattern))
			return true;
		else
			System.out.println("salary should be in digits");
		return false;
	}

}
