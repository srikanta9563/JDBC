import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

 class Jdbc_inserting {
    public static void main(String[] args) {	//main method

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");	//loading driver
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDb" ,"root" ,"Srikanta@123");	//getting connection
            Statement stmt = conn.createStatement();	//creating statement

            stmt.executeUpdate("insert into Studentmanage values(2, 'srikanta',9563931065,'kolkata')");	//executeing query
            System.out.println("inserted succesfully");
            conn.close();	// closing connection
        } catch (Exception e) {		//exception handeling
            System.out.println(e);
        }

    }
}


