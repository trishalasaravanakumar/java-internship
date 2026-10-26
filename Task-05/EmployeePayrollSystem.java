import java.util.*;
class Employee {
    int id;
    String name;
    double salary;
    double tax;
    double deductions;
    double netSalary;
    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    void calculateSalary() {
        tax = salary * 0.10;
        deductions = salary * 0.05;
        netSalary = salary - tax - deductions;
    }
    void displaySalarySlip() {
        calculateSalary();
        System.out.println("\n===== Salary Slip =====");
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
        System.out.println("Basic Salary: " + salary);
        System.out.println("Tax: " + tax);
        System.out.println("Deductions: " + deductions);
        System.out.println("Net Salary: " + netSalary);
        System.out.println("=======================");
    }
}
public class EmployeePayrollSystem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();
        int choice = 0;
        while (choice != 4) {
            System.out.println("\n=== Employee Payroll System ===");
            System.out.println("1. Add Employee");
            System.out.println("2. Generate Salary Slip");
            System.out.println("3. Display Employees");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = in.nextInt();
            in.nextLine();
            if (choice == 1) {
                System.out.print("Enter Employee ID: ");
                int id = in.nextInt();
                in.nextLine();
                System.out.print("Enter Employee Name: ");
                String name = in.nextLine();
                System.out.print("Enter Basic Salary: ");
                double salary = in.nextDouble();
                employees.add(new Employee(id, name, salary));
                System.out.println("Employee added successfully.");
            } else if (choice == 2) {
                System.out.print("Enter Employee ID: ");
                int id = in.nextInt();
                boolean found = false;
                for (Employee employee : employees) {
                    if (employee.id == id) {
                        employee.displaySalarySlip();
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Employee not found.");
                }
            } else if (choice == 3) {
                if (employees.size() == 0) {
                    System.out.println("No employee records found.");
                } else {
                    System.out.println("\nEmployee Records:");
                    for (Employee employee : employees) {
                        System.out.println("ID: " + employee.id +
                                " | Name: " + employee.name +
                                " | Salary: " + employee.salary);
                    }
                }
            } else if (choice == 4) {
                System.out.println("Thank you!");
            } else {
                System.out.println("Invalid choice.");
            }
        }
        in.close();
    }
}
