package package2 ;

import javax.persistence.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- ObjectDB CRUD Operations Menu ---");
            System.out.println("1. Add Company");
            System.out.println("2. Add Employee");
            System.out.println("3. Add Recruitment");
            System.out.println("4. Get Company by ID");
            System.out.println("5. Get Employee by ID");
            System.out.println("6. Get Recruitment by ID");
            System.out.println("7. Update Company");
            System.out.println("8. Update Employee");
            System.out.println("9. Delete Company");
            System.out.println("10. Delete Employee");
            System.out.println("11. Delete Recruitment");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter company name: ");
                    String companyName = sc.nextLine();
                    Company company = new Company(companyName);
                    DBOperations.addCompany(company);
                    System.out.println("Company added successfully.");
                    break;

                case 2:
                    System.out.print("Enter employee name: ");
                    String empName = sc.nextLine();
                    System.out.print("Enter employee email: ");
                    String empEmail = sc.nextLine();
                    System.out.print("Enter company ID: ");
                    int companyId = sc.nextInt();
                    Company c = DBOperations.getCompanyById(companyId);
                    if (c != null) {
                        Employee employee = new Employee(empName, empEmail, c);
                        DBOperations.addEmployee(employee);
                        System.out.println("Employee added successfully.");
                    } else {
                        System.out.println("Company not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter employee ID: ");
                    int empId = sc.nextInt();
                    System.out.print("Enter company ID: ");
                    int compId = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.print("Enter position: ");
                    String position = sc.nextLine();

                    Employee e = DBOperations.getEmployeeById(empId);
                    Company comp = DBOperations.getCompanyById(compId);

                    if (e != null && comp != null) {
                        Recruitment recruitment = new Recruitment(e, comp, position);
                        DBOperations.addRecruitment(recruitment);
                        System.out.println("Recruitment added successfully.");
                    } else {
                        System.out.println("Employee or Company not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter company ID: ");
                    int compIdToFetch = sc.nextInt();
                    Company fetchedCompany = DBOperations.getCompanyById(compIdToFetch);
                    if (fetchedCompany != null) {
                        System.out.println("Company ID: " + fetchedCompany.getId());
                        System.out.println("Company Name: " + fetchedCompany.getName());
                    } else {
                        System.out.println("Company not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter employee ID: ");
                    int empIdToFetch = sc.nextInt();
                    Employee fetchedEmployee = DBOperations.getEmployeeById(empIdToFetch);
                    if (fetchedEmployee != null) {
                        System.out.println("Employee ID: " + fetchedEmployee.getId());
                        System.out.println("Name: " + fetchedEmployee.getName());
                        System.out.println("Email: " + fetchedEmployee.getEmail());
                        System.out.println("Company: " + fetchedEmployee.getCompany().getName());
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 6:
                    System.out.print("Enter recruitment ID: ");
                    int recIdToFetch = sc.nextInt();
                    Recruitment fetchedRecruitment = DBOperations.getRecruitmentById(recIdToFetch);
                    if (fetchedRecruitment != null) {
                        System.out.println("Recruitment ID: " + fetchedRecruitment.getId());
                        System.out.println("Position: " + fetchedRecruitment.getPosition());
                        System.out.println("Employee: " + fetchedRecruitment.getEmployee().getName());
                        System.out.println("Company: " + fetchedRecruitment.getCompany().getName());
                    } else {
                        System.out.println("Recruitment not found.");
                    }
                    break;

                case 7:
                    System.out.print("Enter company ID to update: ");
                    int companyIdToUpdate = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.print("Enter new company name: ");
                    String newCompName = sc.nextLine();
                    DBOperations.updateCompany(companyIdToUpdate, newCompName);
                    System.out.println("Company updated successfully.");
                    break;

                case 8:
                    System.out.print("Enter employee ID to update: ");
                    int empIdToUpdate = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.print("Enter new employee name: ");
                    String newEmpName = sc.nextLine();
                    System.out.print("Enter new employee email: ");
                    String newEmpEmail = sc.nextLine();
                    DBOperations.updateEmployee(empIdToUpdate, newEmpName, newEmpEmail);
                    System.out.println("Employee updated successfully.");
                    break;

                case 9:
                    System.out.print("Enter company ID to delete: ");
                    int compIdToDelete = sc.nextInt();
                    DBOperations.deleteCompany(compIdToDelete);
                    System.out.println("Company deleted successfully.");
                    break;

                case 10:
                    System.out.print("Enter employee ID to delete: ");
                    int empIdToDelete = sc.nextInt();
                    DBOperations.deleteEmployee(empIdToDelete);
                    System.out.println("Employee deleted successfully.");
                    break;

                case 11:
                    System.out.print("Enter recruitment ID to delete: ");
                    int recIdToDelete = sc.nextInt();
                    DBOperations.deleteRecruitment(recIdToDelete);
                    System.out.println("Recruitment deleted successfully.");
                    break;

                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}