package com.ps.stream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public record Emp(String name, String job, Integer salary, String department) {}

    public static void main(String[] args) {
        List<Emp> employees = List.of(
            new Emp("Alice", "Software Engineer", 90000, "IT"),
            new Emp("Bob", "Project Manager", 110000, "Management"),
            new Emp("Charlie", "HR Executive", 70000, "HR"),
            new Emp("David", "Software Engineer", 95000, "IT"),
            new Emp("Eve", "Data Scientist", 105000, "Data Science"),
            new Emp("Frank", "Marketing Specialist", 80000, "Marketing"),
            new Emp("Grace", "DevOps Engineer", 98000, "Operations"),
            new Emp("Hank", "Sales Manager", 87000, "Sales"),
            new Emp("Ivy", "Business Analyst", 92000, "Finance"),
            new Emp("Jack", "Cybersecurity Analyst", 97000, "Security")
        );
        List<Emp> employees1 =new ArrayList<Main.Emp>();
        employees1.addAll(employees);
        

        // Print employees
      //  employees.forEach(System.out::println);
        System.out.println(getSecondHighestSalaryEmp(employees1));
        System.out.println(getSecondHighestSalaryEmpUsingStream(employees1));
        System.out.println(getEmpByDepartment(employees1,"IT"));
        getHighestPaidEmpByDepartment(employees1,"IT");
    }
    
  static  Emp getSecondHighestSalaryEmp(List<Emp> ls) {
	  Collections.sort(ls, (a,b)-> b.salary().compareTo(a.salary()));
    	return ls.get(1);
    }  
  
  
  static  Emp getSecondHighestSalaryEmpUsingStream(List<Emp> ls) {
	  return
			  ls.stream()
			  .sorted(Comparator.comparingInt(Emp::salary).reversed())
			  .skip(1)
			  .findFirst()
			  .get();
    } 
  
  static  List<Emp> getEmpByDepartment(List<Emp> ls,String str) {
	  return ls.stream().filter(e->e.department().equalsIgnoreCase("IT")).toList();
	  
    }  
  
  // get Highest paid  emp in each department
  static  void getHighestPaidEmpByDepartment(List<Emp> ls,String str) {
	  System.out.println("$$$$$  getHighestPaidEmpByDepartment $$$$$");
	   ls.stream()
			  .collect(Collectors.groupingBy(Emp::department,Collectors.toList()))
			  .entrySet()
			  .stream()
			  .forEach(System.out::println);
					 
			  	  
			  
			  
			  
	  
    } 
    
}
