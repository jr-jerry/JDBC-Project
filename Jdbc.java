import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class Jdbc {
    private Connection connectionObjRef;

    public Jdbc(Connection connectionObj){
        this.connectionObjRef=connectionObj;
    }
    public void deleteData(int id){
        try(Statement statement=connectionObjRef.createStatement()){

            String query="DELETE FROM student_tb where id="+id;

            int rowAffected=statement.executeUpdate(query);
            if(rowAffected>0){
                System.out.println("No of row affected "+rowAffected);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void updateData(int id,int age,String name){
        try{
            Statement statement=connectionObjRef.createStatement();
            String query="UPDATE  student_tb SET age="+age+",name='"+name+"' where id="+id;

            int rowAffected= statement.executeUpdate(query);

            if(rowAffected>0){
            System.out.println("No of row affected "+rowAffected);
           }
           statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            
        }
    }
    public ResultSet getAllData(){
        ResultSet rs=null;
        try{
            Statement statement=connectionObjRef.createStatement();
            String query="SELECT * from student_tb;";

             rs= statement.executeQuery(query);
           
          
        }catch(SQLException e){
            e.printStackTrace();
        }
        if(rs==null){
            throw new RuntimeException("No Table Found ");
        }
        return rs;
    }
    public void insertData(int id,int age,String name){
        try{
            Statement statement=connectionObjRef.createStatement();
            String query="INSERT INTO student_tb (id,age,name) values ("+id+","+age+",'"+name+"')";

            int rowAffected= statement.executeUpdate(query);

            if(rowAffected>0){
            System.out.println("No of row affected "+rowAffected);
           }
        }catch(SQLException e){
            e.printStackTrace();
        }
         
    }
    
}
