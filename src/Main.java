import java.util.Arrays;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {

        Employee[] employees = new Employee[10];

        Employee employee0 = new Employee("Суслова Капитолина Вадимовна", 250_000.0, 1);
        Employee employee1 = new Employee("Суслова Валерия Вадимовна", 200_000.0, 2);
        Employee employee2 = new Employee("Суслов Вадим Львович",80_000,3);
        Employee employee3 = new Employee("Суслова Екатерина Дмитриевна", 100_000,4);

        AddEmployee(employee0, employees);
        AddEmployee(employee1, employees);
        AddEmployee(employee2,employees);
        AddEmployee(employee3,employees);
        PrintAllEmployees(employees);
        System.out.println("Сумма всех зарплат в компании - " + CalculateAllSalary(employees) + " руб.");
        EmployeeWithMinSalary(employees);
        EmployeeWithMaxSalary(employees);
        System.out.println("Сердняя зарплата в компании - " + CalculateAverageSalary(employees) + " руб.");
        PrintAllFullnames(employees);

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
        double sumAllSalary1 = 0;
        double averageSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                sumAllSalary1 = sumAllSalary1 + employees[i].getSalary();
                averageSalary = sumAllSalary1/(i + 1);
            }
        }
        return averageSalary;
    }

    public static void PrintAllFullnames(Employee[]employees){
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].getFullname().toString());
            }
        }
    }


}