
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

class ScannerJDBC {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        Scanner s3 = new Scanner(System.in);
        Scanner s4=new Scanner(System.in);
        System.out.println("enter estudent id: ");
        String s_id = s1.next();
        System.out.println("enter student name: ");
        String s_name = s2.next();
        System.out.println("enter stdent phone no: ");
        String s_phone = s3.next();
        System.out.println("enter address: ");
        String s_Address=s4.next();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");	//loading driver
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDb" ,"root" ,"Srikanta@123");	//getting connection
            PreparedStatement stmt = conn.prepareStatement("insert into Studentmanage values(?, ?, ?,?)");	//creating statement

            stmt.setString(1, s_id);
            stmt.setString(2, s_name);
            stmt.setString(3, s_phone);
            stmt.setString(4,s_Address);
            stmt.execute();	//executeing query
            System.out.println("inserted succesfully");

        } catch (Exception e) {		//exception handeling
            System.out.println(e);
        }
      s1.close();
        s2.close();
        s3.close();
        s4.close();
    }
}