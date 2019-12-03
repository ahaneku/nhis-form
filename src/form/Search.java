package form;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Search extends DefaultTableModel implements Runnable {
    
   
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private String search1;
    private String [] Details;
    private final String name;
    
    
    public Search(String name){
       super(new String[][]{},
           new String[]{"S/N","FIRST NAME","MIDDLE NAME","LAST NAME","NHIS ID NO","GENDER","COST","10% COST","90% COST","DATE REGISTERED"});
    this.name = name.toLowerCase();
    }
    
    @Override
    public void run(){
    
         
        search1 = "select * from person where firstname = '"+name+"' or lastname = '"+name+"' or nhisid = '"+name+"'";
    
        try{
        
          //  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhis","chijioke","chijioke");
            connection = DriverManager.getConnection("jdbc:sqlite:nhis.sqlite");
            statement = connection.createStatement();
            
            resultSet = statement.executeQuery(search1);
            
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
            addRow(Details);
            }
            System.out.println("");
        }
       
        catch(SQLException sql){
        sql.printStackTrace();
        }
    }
    
    public void searchIndex(String name){
    
   
   /*     
        search1 = "select * from person where firstname = '"+name+"' or lastname = '"+name+"' or nhisid = '"+name+"'";
    
        try{
        
          //  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhis","chijioke","chijioke");
            connection = DriverManager.getConnection("jdbc:sqlite:nhis.sqlite");
            statement = connection.createStatement();
            
            resultSet = statement.executeQuery(search1);
            
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
            addRow(Details);
            }
            System.out.println("");
        }
       
        catch(SQLException sql){
        sql.printStackTrace();
        }
        */
    }
    
}
