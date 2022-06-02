import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.reverseOrder;

public class Main {
    public static void main(String[] args) {


        EmployeeBook book1 = new EmployeeBook(10);

        Employee employee0 = new Employee("Суслова Капитолина Вадимовна", 250_000.0, 1);
        Employee employee1 = new Employee("Суслова Валерия Вадимовна", 200_000.0, 2);
        Employee employee2 = new Employee("Суслов Вадим Львович",80_000,3);
        Employee employee3 = new Employee("Суслова Екатерина Дмитриевна", 100_000,4);


        book1.AddEmployee(employee0);
        book1.AddEmployee(employee1);
        book1.AddEmployee(employee2);
        book1.AddEmployee(employee3);

        book1.PrintAllEmployees(); //проверка 1
        System.out.println("======================");
        book1.ChangeSalaryToTenPercent();
        book1.PrintAllEmployees();  // проверка 2
        System.out.println("======================");
        book1.ChangeSalaryDep(1.2,3);
        book1.PrintAllEmployees(); // проверка 3
        System.out.println("======================");
        System.out.println("Сумма всех зарплат в компании - " + book1.CalculateAllSalary() + " руб.");
        book1.EmployeeWithMinSalary();
        book1.EmployeeWithMaxSalary();
        System.out.println("Сердняя зарплата в компании - " + book1.CalculateAverageSalary() + " руб.");
        book1.FindMinSalaryDep(1);
        book1.FindMaxSalaryDep(1);
        System.out.println("Сумма всех зарплат в департаменте №1- " + book1.CalculateAllSalaryDep(1) + " руб.");
        System.out.println("Средняя З/П в отделе  №1 - " + book1.CalculateAverageSalaryDep(1) + " руб.");
        book1.PrintAllFullnamesExclDep(1);
        System.out.println(GetRandomNumber(100_000, 200_000));
        book1.UseFilterForSalaryAndPrintAll(GetRandomNumber(100_000,200_000));
        book1.DeleteEmployee(2);
        book1.DeleteEmployee("суслова екатерина Дмитриевна");
        book1.PrintAllEmployees(); //проверка
        book1.ChangeSalaryAndDepartment(); //ввод новой ЗП и департамента через консоль
        book1.PrintAllEmployees();//проверка

    }

    public static double GetRandomNumber (double min, double max){ //создал метод, который дает число для задания 3
    double x = (Math.random()*((max - min) + 1 )) + min;
    return x;
    }

    }

