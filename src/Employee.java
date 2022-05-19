public class Employee {

    private String fullname;
    private double salary;
    private int department;

    private int id;

    private static int Count;


    public Employee(String fullname, double salary, int department) {
    this.fullname = fullname;
    this.salary = salary;
    this.department = department;
    this.id = Count;
    Count++;
}
    public String getFullname() {
        return fullname;
    }

    public double getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    public int getId() {
        return id;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return id + " " + fullname + " " +  salary + " " + department;
    }

}
