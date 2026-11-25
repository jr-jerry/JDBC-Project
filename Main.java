import java.sql.*;
import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        String URL="jdbc:mysql://localhost:3306/user_db";
        String USERNAME="admin";
        String PASSWORD="admin112233admin";
        Scanner sc=new Scanner(System.in);
        Jdbc jdbc;
       
        try(Connection connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);
            Statement statement=connection.createStatement();
            ){

            System.out.println("Enter name you want data");
            String name=sc.nextLine();
            String readQuery="SELECT * from student_tb where name ='"+name+"'";

            ResultSet rs=statement.executeQuery(readQuery);
            while(rs.next()){
                System.out.println(rs.getString("name")+" "+rs.getInt("id"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}