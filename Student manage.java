import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;






 class Helper {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//registering my sql driver
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection con()throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Srikanta@123");

    }

    public static void main(String...args) throws Exception {
        InsertTable it = new InsertTable();
        FetchTable ft = new FetchTable();
        UpdateTable ut = new UpdateTable();
        Scanner scan =new Scanner(System.in);
        System.out.println("""
			Press 1 for Insert : 
			Press 2 for Display :
			Press 3 for Update :
			Press 4 for Delete :
			Press 5 for Exit : 
			""");
        int variable = scan.nextInt();
        System.out.println("-------------------------------");
        switch(variable) {
            case 1 :
                it.saveMenuDriven();
                break;
            case 2 :
                ft.fetchMenuDriven();
                break;
            case 3 :
                ut.updateMenuDriven();
                break;
            case 4 :
                ut.deleteMenuDriven();
                break;
            case 5 :
                System.exit(0);
                break;
        }
    }}

 class InsertTable {
    Scanner sc = new Scanner(System.in);
    int e_id,e_age,e_salary;
    String e_name, e_city;
    //saving employee details in database
    public void saveMenuDriven()throws SQLException{
        System.out.println("Enter employee id :");
        e_id=sc.nextInt();
        System.out.println("enter employee name :");
        e_name=sc.next();
        System.out.println("Enter employee age :");
        e_age=sc.nextInt();
        System.out.println("enter employee city :");
        e_city=sc.next();
        System.out.println("Enter employee salary :");
        e_salary=sc.nextInt();
        Connection conn=Helper.con();
        PreparedStatement stmt=conn.prepareStatement("insert into Menudriven values(?,?,?,?,?)");
        stmt.setInt(1, e_id);
        stmt.setString(2, e_name);
        stmt.setInt(3, e_age);
        stmt.setString(4, e_city);
        stmt.setInt(5, e_salary);
        stmt.executeUpdate();
        ResultSet rs=stmt.executeQuery("select * from MenuDriven");
        while(rs.next()) {
            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4)+" "+rs.getInt(5));
        }

    }
}

 class FetchTable {
    //fetching employee details in the database (display)
    public void fetchMenuDriven() throws SQLException{
        Connection conn = Helper.con();
        Statement stmt = conn.createStatement();
        ResultSet rs=stmt.executeQuery("select * from MenuDriven");
        while(rs.next()) {
            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4)+" "+rs.getInt(5));
        }
    }
}
 class UpdateTable {
    Scanner sc = new Scanner(System.in);
    //updating employee details in database
    public void updateMenuDriven()throws SQLException{
        Connection conn=Helper.con();
        Statement stmt=conn.createStatement();
        System.out.println("enter employee city : ");
        String e_city=sc.nextLine();
        System.out.println("enter employee id : ");
        int e_id=sc.nextInt();
        stmt.executeUpdate("update menudriven set e_city='"+e_city+"' where e_id="+e_id);
        ResultSet rs=stmt.executeQuery("select * from MenuDriven");
        while(rs.next()) {
            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4)+" "+rs.getInt(5));
        }
    }
    //deleting employee details in database
    public void deleteMenuDriven() throws SQLException{
        Connection conn = Helper.con();
        Statement stmt = conn.createStatement();
        System.out.println("Enter employee id : ");
        int e_id = sc.nextInt();
        stmt.executeUpdate("delete from menudriven where e_id="+e_id);
        ResultSet rs=stmt.executeQuery("select * from MenuDriven");
        while(rs.next()) {
            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4)+" "+rs.getInt(5));
        }
    }
}