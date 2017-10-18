package com.binio.stream;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class EmployeeTest {

    List<Employee> employees;

    @Before
    public void setup() {

        employees = new ArrayList<>();
        employees.add(new Employee(123, "Jack", "Johnson", LocalDate.of(1988, Month.APRIL, 12)));
        employees.add(new Employee(345, "Cindy", "Bower", LocalDate.of(2011, Month.DECEMBER, 15)));
        employees.add(new Employee(567, "Perry", "Node", LocalDate.of(2005, Month.JUNE, 07)));
        employees.add(new Employee(467, "Pam", "Krauss", LocalDate.of(2005, Month.JUNE, 07)));
        employees.add(new Employee(435, "Fred", "Shak", LocalDate.of(1988, Month.APRIL, 17)));
        employees.add(new Employee(678, "Dann", "Lee", LocalDate.of(2007, Month.APRIL, 12)));
        employees.add(new Employee(678, "Bob", "Lee", LocalDate.of(2007, Month.APRIL, 12)));
    }

    @Test
    public void java_8() {

        Comparator<Employee> byEmployeeNumber = Comparator.comparing(Employee::getEmployeeNumber);
        Comparator<Employee> byEmployeeName = Comparator.comparing(Employee::getEmployeeFirstName);
        employees.stream().sorted(byEmployeeNumber.thenComparing(byEmployeeName)).collect(Collectors.toList())
                .forEach(e -> System.out.println(e));
    }
}
