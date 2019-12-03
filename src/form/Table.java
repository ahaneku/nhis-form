package form;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class Table extends DefaultTableModel implements Runnable{
    
    private static int roCount = 0;
    private Statement statement;
    private Connection connection;
    private ResultSet resultSet;
    private Table table;
    private  String [] Details;
    
    public Table(){
    super(new String[][]{},
           new String[]{"S/N","FIRST NAME","MIDDLE NAME","LAST NAME","NHIS ID NO","GENDER","COST","10% COST","90% COST","DATE REGISTERED"} );
    //this.table = table;
    
   setRowCount(roCount++);
   
   
        
     /*    try{
           
       //2.creating a connection to database
       connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhis","chijioke","chijioke");
       System.out.println("Connection has been created");
       
       //3.sql statement to be executed 
        statement = connection.createStatement();
       System.out.println(statement.toString());
       
       String st = "select * from person order by firstname;";
       
       //set result from server or through server
        resultSet = statement.executeQuery(st);
        
        
        while(resultSet.next()){
            String firstname = resultSet.getString(2).toUpperCase();
            String middlename = resultSet.getString(3).toUpperCase();
            String lastname = resultSet.getString(4).toUpperCase();
            String nhisid = resultSet.getString(5).toUpperCase();
            String gender = resultSet.getString(6).toUpperCase();
            String cost = resultSet.getString(7);
            String _10per = resultSet.getString(8);
            String _90per = resultSet.getString(9);
            String date = resultSet.getString(10);
           
             Details = new String[]{""+(getRowCount()+1),firstname, middlename, lastname,nhisid,
                            gender,cost,_10per,_90per,date};
           //retriving datas from database
             addRow(Details);
             Form.numberOfPersonsText.setText(""+getRowCount());
          
        }
        }
       catch(SQLException sqex){
        sqex.printStackTrace();
        }   */
    }
    
    @Override
    public void run(){
    
         try{
           
       //2.creating a connection to database
     //  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhis","chijioke","chijioke");
       connection = DriverManager.getConnection("jdbc:sqlite:nhis.sqlite");
       System.out.println("Connection has been created");
       
       //3.sql statement to be executed 
        statement = connection.createStatement();
       System.out.println(statement.toString());
       
       String st = "select * from person order by firstname;";
       
       //set result from server or through server
        resultSet = statement.executeQuery(st);
        
        
        while(resultSet.next()){
            String firstname = resultSet.getString(2).toUpperCase();
            String middlename = resultSet.getString(3).toUpperCase();
            String lastname = resultSet.getString(4).toUpperCase();
            String nhisid = resultSet.getString(5).toUpperCase();
            String gender = resultSet.getString(6).toUpperCase();
            String cost = resultSet.getString(7);
            String _10per = resultSet.getString(8);
            String _90per = resultSet.getString(9);
            String date = resultSet.getString(10);
           
             Details = new String[]{""+(getRowCount()+1),firstname, middlename, lastname,nhisid,
                            gender,cost,_10per,_90per,date};
           //retriving datas from database
             addRow(Details);
             Form.numberOfPersonsText.setText(""+getRowCount());
          
        }
        }
       catch(SQLException sqex){
        }finally{
             if(resultSet != null){
                 try{
         resultSet.close();
         statement.close();
         connection.close();
         
                 }catch(Exception e){}
             }
         }
        
    }
    
 
}
