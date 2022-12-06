import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


class Menudriven {
    Scanner s = new Scanner(System.in);
    int e_id, e_age, e_salary;
    String e_name, e_city;

    //saving employee details in DB
    public void saveMenudriven() throws SQLException{
        System.out.println("Enter Employee ID: ");
        e_id = s.nextInt();
        System.out.println("Enter Employee Name: ");
        e_name = s.next();
        System.out.println("Enter Employee Age: ");
        e_age = s.nextInt();
        System.out.println("Enter Employee City: ");
        e_city = s.next();
        System.out.println("Enter Employee Salary: ");
        e_salary = s.nextInt();
        Connection conn =Helper.con();
        PreparedStatement sl = conn.prepareStatement("insert into Menudriven values(?,?,?,?,?)");
        sl.setInt(1,e_id);
        sl.setString(2, e_name);
        sl.setInt(3,e_age);
        sl.setString(4, e_city);
        sl.setInt(5,e_salary);
        sl.executeUpdate();
    }

    //fetching datas
    public void fetchMenudriven() throws SQLException{
        Connection conn = Helper.con();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from Menudriven");
        while(rs.next()) {
            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4)+" "+rs.getInt(5));
        }
    }

    //updating datas
    public void updateMenudriven() throws SQLException{
        Connection conn = Helper.con();
        Statement st = conn.createStatement();
        System.out.println("Enter Employe Id you want to update: ");
        e_id = s.nextInt();
        System.out.println("Enter Employe City: ");
        e_city = s.nextLine();
        st.executeUpdate("update Menudriven set city='"+e_city+"' where Id="+e_id);
    }

    //deleting datas
    public void deleteMenudriven() throws SQLException{

        Connection conn = Helper.con();
        Statement st = conn.createStatement();
        System.out.println("Enter employee Id: ");
        e_id = s.nextInt();
        st.executeUpdate("delete from Menudriven where Id="+e_id);
    }

     public static void main(String...args) throws SQLException {
        Menudriven mde=new Menudriven();
         mde.saveMenudriven();
         mde.fetchMenudriven();
         mde.updateMenudriven();
         mde.deleteMenudriven();
}}
