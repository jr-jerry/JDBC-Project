import java.sql.*;
import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        String URL="jdbc:mysql://localhost:3306/user_db";
        String USERNAME="admin";
        String PASSWORD="admin112233admin";
        Scanner sc=new Scanner(System.in);
        Jdbc jdbc;
        try(Connection connectionObjRef=DriverManager.getConnection(URL, USERNAME, PASSWORD)){
           

            jdbc=new Jdbc(connectionObjRef);
            System.out.println("1. Insertion \n 2. Read All ");
            int choice;
            System.out.println("enter choice ");
            choice=sc.nextInt();

           switch (choice) {
            case 1:
                System.out.println("Enter id : ");
                int id=sc.nextInt();

                

                System.out.println("Enter your age ");
                int age=sc.nextInt();

                sc.nextLine();

                System.out.println("Enter your name ");
                String name=sc.nextLine();

                jdbc.insertData(id,age,name);
                break;
            case 2:
                ResultSet rs=jdbc.getAllData();

                while(rs.next()){
                    System.out.println(rs.getInt("age")+" "+rs.getString("name"));
                }
                break;
            case 3:
                System.out.println("Update Data ");

                System.out.println("enter Id you want to update ! ");
                int id2=sc.nextInt();
                sc.nextLine();

                System.out.println("enter the updated name you want : ");
                String updatedName=sc.nextLine();

                System.out.println("Enter the updated age you want : ");
                int updatedAge=sc.nextInt();

                jdbc.updateData(id2, updatedAge, updatedName);


            default:
                break;
           } 
           
            
        }catch(SQLException e){
            System.out.println("Exception occur to connect to database ");
            e.printStackTrace();
        }
    }
}