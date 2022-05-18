public class Main {
    public static void main(String[] args) {

        Employee[] employees = new Employee[10];

        Employee employee0 = new Employee("Суслова Капитолина Вадимовна", 250_000.0, 1);
        Employee employee1 = new Employee("Суслова Валерия Вадимовна", 200_000.0, 2);

        AddEmployee(employee0, employees);
        AddEmployee(employee1, employees);
        PrintAllEmployees(employees);

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

    }
}