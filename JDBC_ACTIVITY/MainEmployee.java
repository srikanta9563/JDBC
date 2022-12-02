package JDBC.com.main.Emp;

import JDBC.com.main.EmployeeUploader;

class MainEmployee {

    public static void main(String[] args) {
        try {
            EmployeeUploader obj = new EmployeeUploader();
            //TEST CASES:

            System.out.println("Statement 1- department table");
            //appendix 1- department table
            obj.storeDepartmentDetails(1, "Accounts", "Srik", "Accounts Dept");
            obj.storeDepartmentDetails(2, "Admin", "Arko", "Admin Dept");
            obj.storeDepartmentDetails(3, "Sales", "Sourav", "Sales Dept");
            obj.storeDepartmentDetails(4, "HR", "Mahesh", "HR Dept");


            //appendix 1- employee table
            System.out.println("Statement 1- employee table");
            obj.storeEmployeeDetails(87, "Deep", 12000, 9878761212L, "Address 1", 2);
            obj.storeEmployeeDetails(110, "Ajay", 18000, 9654376143L, "Address 2", 1);
            obj.storeEmployeeDetails(98, "Dabu", 11000, 9965322212L, "Address 3", 4);
            obj.storeEmployeeDetails(67, "Ram", 19000, 8078343732L, "Address 4", 3);
            obj.storeEmployeeDetails(45, "Vimal", 27000, 9932113221L, "Address 5", 4);
            obj.storeEmployeeDetails(987, "Kiran", 21000, 7076337238L, "Address 6", 2);

            //appendix 2-
            System.out.println("Statement 2");
            obj.storeEmployeeDetails(87, "Jack", 12000, 994234651L, "Address 1", 2);

            //appendix 3-
            System.out.println("Statement 3");
            obj.storeEmployeeDetails(123, "Ron", 12000, 972234651L, "Address 1", 99);

            //appendix 4-
            System.out.println("Statement 4");
            obj.storeEmployeeDetails(124, "Jim", 500, 923234651L, "Address 1", 2);
        }catch(Exception e) {
            System.out.println(e);
        }

    }

}