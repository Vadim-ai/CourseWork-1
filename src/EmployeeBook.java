import java.util.Scanner;

class EmployeeBook {

    private Employee[] employees;

    public EmployeeBook(int qtyEmployees) {
        employees = new Employee[qtyEmployees];
    }

    public void AddEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                break;
            }
        }
    }

    public void PrintAllEmployees() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].toString());
            }
        }
    }

    public double CalculateAllSalary() {
        double sumAllSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                sumAllSalary = sumAllSalary + employees[i].getSalary();
            }
        }
        return sumAllSalary;
    }

    public void EmployeeWithMinSalary() {
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

    public void EmployeeWithMaxSalary() {
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

    public double CalculateAverageSalary() {
        double sumAllSalary1 = CalculateAllSalary();
        int count = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                count++;
            }
        }
        double averageSalary = sumAllSalary1 / count;
        return averageSalary;
    }

    public void PrintAllFullnames() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].getFullname().toString() + " " + employees[i].getSalary());
            }
        }
    }

    public void ChangeSalaryToTenPercent() {
        double percent = 1.1;
        double newSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                employees[i].setSalary(employees[i].getSalary() * percent);
            }
        }
    }

    public void FindMinSalaryDep(int department) {
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

    public void FindMaxSalaryDep(int department) {
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

    public double CalculateAllSalaryDep(int department) {
        Employee[] employeeDeps = FilterByDep(department);
        double salaryDep = 0;
        for (int i = 0; i < employeeDeps.length; i++) {
            if (employeeDeps[i] != null) {
                salaryDep = salaryDep + employeeDeps[i].getSalary();
            }
        }
        return salaryDep;

    }

    public Employee[] FilterByDep(int department) {
        Employee[] employeeDeps = new Employee[employees.length];
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                continue;
            } else if (employees[i].getDepartment() == department) {
                employeeDeps[i] = employees[i];
            }
        }
        return employeeDeps;
    }

    public double CalculateAverageSalaryDep(int department) {
        Employee[] employeeDeps = FilterByDep(department);
        double averageSalaryDep = 0;
        double sumAllSalaryDep = CalculateAllSalaryDep(department);
        int count = 0;
        for (int i = 0; i < employeeDeps.length; i++) {
            if (employeeDeps[i] != null) {
                count++;
            }
        }
        averageSalaryDep = sumAllSalaryDep / count;
        return averageSalaryDep;
    }

    public void ChangeSalaryDep(double percent, int department) {
        Employee[] employeeDeps = FilterByDep(department);
        for (int i = 0; i < employeeDeps.length; i++) {
            if (employeeDeps[i] != null) {
                employeeDeps[i].setSalary(employeeDeps[i].getSalary() * percent);
            }
        }
    }

    public void PrintAllFullnamesExclDep(int department) {
        Employee[] employeeDeps = FilterByDep(department);
        for (int i = 0; i < employeeDeps.length; i++) {
            if (employeeDeps[i] != null) {
                System.out.println(employeeDeps[i].getFullname().toString() + " " + employeeDeps[i].getSalary());
            }
        }
    }

    public void UseFilterForSalaryAndPrintAll(double randomNumber) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                continue;
            } else if (employees[i].getSalary() < randomNumber) {
                System.out.println("Сотрудники с зарплатой меньше - " + randomNumber + " руб. :" + employees[i].getId() + " " + employees[i].getFullname() + " " + employees[i].getSalary());
            } else if (employees[i].getSalary() >= randomNumber) {
                System.out.println("Сотрудники с зарплатой выше - " + randomNumber + " руб. :" + employees[i].getId() + " " + employees[i].getFullname() + " " + employees[i].getSalary());
            }
        }
    }

    public void DeleteEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                continue;
            } else if (employees[i].getId() == id) {
                employees[i] = null;
                System.out.println("Сотрудник под номером: " + id + " - удален.");
            }
        }
    }

    public void DeleteEmployee(String fullName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                continue;
            } else if (employees[i].getFullname().equalsIgnoreCase(fullName)) {
                employees[i] = null;
                System.out.println("Сотрудник " + fullName + " - удален.");
            }
        }
    }

    public void ChangeSalaryAndDepartment() {
        double newSalary;
        int newDep;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Что Вы хотите сделать?");
            System.out.println("1 - Поменять ЗП сотруднику");
            System.out.println("2 - Поменять отдел у сотрудника");
            System.out.println("3 - Выйти");

            int command = scanner.nextInt();
            scanner.nextLine();
            
        if (command == 1) {

            System.out.println("Кому будем менять ЗП? (ФИО) ");
            String fullName = scanner.nextLine();

            System.out.println();

            System.out.println("Введите новую ЗП: ");
            newSalary = scanner.nextDouble();
            scanner.nextLine();

            for (int i = 0; i < employees.length; i++) {
                if (employees[i].getFullname().equalsIgnoreCase(fullName)) {
                    employees[i].setSalary(newSalary);
                    System.out.println("Теперь у сотрудника - " + employees[i].getFullname() + " теперь новая зарплата, она составляет -" + employees[i].getSalary());
                    break;
                }
            }
        } else if (command == 2) {
            System.out.println("Какому сотруднику будем менять отдел? (ФИО) ");
            String fullName = scanner.nextLine();
            
            System.out.println();
            
            System.out.println("Введите новый отдел: ");
            newDep = scanner.nextInt();
            
            for (int i = 0; i < employees.length; i++) {
                if (employees[i].getFullname().equalsIgnoreCase(fullName)) {
                    employees[i].setDepartment(newDep);
                    System.out.println("Теперь сотрудник - " + employees[i].getFullname() + " работает в отделе № -" + employees[i].getDepartment());
                    break;
                }
            }
        } else if (command == 3) {
            System.out.println("Пока! :)");
            break;

        } else {
            System.out.println("Сорри, такой команды пока нет");
        }
        }
        }

}