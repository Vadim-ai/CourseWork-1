import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.reverseOrder;

public class Main {
    public static void main(String[] args) {

        Employee[] employees = new Employee[10];

        Employee employee0 = new Employee("Суслова Капитолина Вадимовна", 250_000.0, 1);
        Employee employee1 = new Employee("Суслова Валерия Вадимовна", 200_000.0, 1);
        Employee employee2 = new Employee("Суслов Вадим Львович",80_000,3);
        Employee employee3 = new Employee("Суслова Екатерина Дмитриевна", 100_000,4);


        AddEmployee(employee0, employees);
        AddEmployee(employee1, employees);
        AddEmployee(employee2,employees);
        AddEmployee(employee3,employees);
        PrintAllEmployees(employees); //проверка 1
        System.out.println("======================");
        ChangeSalaryToTenPercent(employees);
        PrintAllEmployees(employees);  // проверка 2
        System.out.println("======================");
        ChangeSalaryDep(employees,1.2,3);
        PrintAllEmployees(employees); // проверка 3
        System.out.println("======================");
        System.out.println("Сумма всех зарплат в компании - " + CalculateAllSalary(employees) + " руб.");
        EmployeeWithMinSalary(employees);
        EmployeeWithMaxSalary(employees);
        System.out.println("Сердняя зарплата в компании - " + CalculateAverageSalary(employees) + " руб.");
        FindMinSalaryDep(employees,1);
        FindMaxSalaryDep(employees,1);
        System.out.println("Сумма всех зарплат в департаменте №1- " + CalculateAllSalaryDep(employees,1) + " руб.");
        System.out.println("Средняя З/П в отделе  №1 - " + CalculateAverageSalaryDep(employees,1) + " руб.");
        PrintAllFullnamesExclDep(employees, 1);
        System.out.println(GetRandomNumber(100_000, 200_000)); //баловался рандомом:)
        UseFilterForSalaryAndPrint(employees,130_000);
    }

    public static void AddEmployee(Employee employee, Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                break;
            }
        }
    }

    public static void PrintAllEmployees(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].toString());
            }
        }
    }

    public static double CalculateAllSalary(Employee[] employees) {
        double sumAllSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                sumAllSalary = sumAllSalary + employees[i].getSalary();
            }
        }
        return sumAllSalary;
    }

    public static void EmployeeWithMinSalary(Employee[] employees){
        int index = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                break;
            } else if (employees[i].getSalary() < employees[index].getSalary()) {
                index = i;
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой - " + employees[index].getFullname());
    }

    public static void EmployeeWithMaxSalary(Employee[] employees){
        int max = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                break;
            } else if (employees[i].getSalary() > employees[max].getSalary()) {
                max = i;
            }
        }
        System.out.println("Сотрудник с максимальной зарплатой - " + employees[max].getFullname());
    }

    public static double CalculateAverageSalary(Employee[]employees){
        double sumAllSalary1 = CalculateAllSalary(employees);;
        double averageSalary = 0;
        int count = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                count ++;
            }
        }
        averageSalary = sumAllSalary1/count;
        return averageSalary;
    }

    public static void PrintAllFullnames(Employee[]employees){
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].getFullname().toString() + " " + employees[i].getSalary());
            }
        }
    }
    public static void ChangeSalaryToTenPercent (Employee[]employees){
        double percent = 1.1;
        double newSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                employees[i].setSalary(employees[i].getSalary()*percent);
            }
        }
    }

    public static void FindMinSalaryDep (Employee[]employees, int department){
        int index = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                break;
            } else if (employees[i].getSalary() < employees[index].getSalary() && employees[i].getDepartment() == department) {
                index = i;
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой - " + employees[index].getFullname() + ". Работает в отделе - " + department);
    }

    public static void  FindMaxSalaryDep (Employee[]employees, int department){
        int max = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                break;
            } else if (employees[i].getSalary() > employees[max].getSalary() && employees[i].getDepartment() == department) {
                max = i;
            }
        }
        System.out.println("Сотрудник с максимальной зарплатой - " + employees[max].getFullname() + ". Работает в отделе - " + department);
    }

    public static double CalculateAllSalaryDep (Employee[]employees, int department){
        Employee[] employeeDeps = FilterByDep(employees,department);
        double salaryDep;
        salaryDep = CalculateAllSalary(employeeDeps);
        return salaryDep;
    }

    public static Employee[] FilterByDep (Employee[]employees, int department){
        Employee[] employeeDeps = new Employee[employees.length];
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                continue;
            } else if (employees[i].getDepartment() == department){
                employeeDeps[i] = employees[i];
            }
        }
        return employeeDeps;
    }
    public static double CalculateAverageSalaryDep(Employee[]employees,int department){
        Employee[] employeeDeps = FilterByDep(employees, department);
        double averageSalaryDep = CalculateAverageSalary(employeeDeps);
        return averageSalaryDep;
    }

    public static void ChangeSalaryDep (Employee[]employees,double percent, int department){
        Employee[] employeeDeps = FilterByDep(employees, department);
        for (int i = 0; i < employeeDeps.length; i++) {
            if (employeeDeps[i] != null) {
                employeeDeps[i].setSalary(employeeDeps[i].getSalary()*percent);
            }
        }
    }

    public static void PrintAllFullnamesExclDep(Employee[]employees, int department){
        Employee[] employeeDeps = FilterByDep(employees, department);
        for (int i = 0; i < employeeDeps.length; i++) {
            if (employeeDeps[i] != null) {
                System.out.println(employeeDeps[i].getFullname().toString() + " " + employeeDeps[i].getSalary());
            }
        }
    }
    public static double GetRandomNumber (double min, double max){ //создал метод, который дает число для задания 3
    double x = (Math.random()*((max - min) + 1 )) + min;
    return x;
    }

    public static void UseFilterForSalaryAndPrint(Employee[]employees,double randomNumber){
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] ==null) {
                break;
            } else if (employees[i].getSalary() < randomNumber) {
                System.out.println("Сотрудники с зарплатой меньше - " + randomNumber + " руб. :" + employees[i].getId()  + " "  + employees[i].getFullname() + " " + employees[i].getSalary());
            }else if (employees[i].getSalary() >= randomNumber) {
                System.out.println("Сотрудники с зарплатой выше - " + randomNumber + " руб. :" + employees[i].getId()  + " "  + employees[i].getFullname() + " " + employees[i].getSalary());
            }
            }
        }
    }

