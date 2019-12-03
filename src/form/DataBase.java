package form;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//import org.sqlite.SQLiteJDBCLoader;

public class DataBase {
    
    private Connection connection;
    private ResultSet resultSet;
    private Statement statement;
    private String sqlStatement;
    
    @SuppressWarnings("CallToPrintStackTrace")
    public DataBase(){
        try{
   
    Class.forName("org.sqlite.JDBC");
    System.out.println("Driver loaded");
    }
        catch(ClassNotFoundException excep){
        excep.printStackTrace();
        }
    }
    
    public String userLogin(String username1, String password1){
        String usern = username1;
        String pass = password1;
        String databasePassword = "";
        
        try{
    
  //  String user = "chijioke";
   // String passwordLog = "chijioke";
    
   //  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userLogin",user,passwordLog);
    connection = DriverManager.getConnection("jdbc:sqlite:nhis.sqlite");
    System.out.println("Connected to server");
    
     statement = connection.createStatement(); 
        sqlStatement = "select password from userlogin where password = '"+pass+"' and username = '"+usern+"';";
       
        resultSet = statement.executeQuery(sqlStatement);
        
        while(resultSet.next()){
            databasePassword = resultSet.getString("password");
            
        }
        System.out.println("<----"+databasePassword);
        
         
        }
        catch(SQLException sqlexcep){
            
            try{
            if(resultSet != null){
            
                resultSet.close();
                statement.close();
                connection.close();
            }
            }catch(Exception e){
            }
        }
       
        return databasePassword;
    }
    
    public boolean addUser(String user, String pass, char gender){
        sqlStatement = "insert into userlogin (username, password, gender) values ('"+user+"', '"+pass+"', '"+gender+"');";
        
        
        
        if(user.equals("") || pass.equals("")){
            return false;
        }
        
        try{
        connection = DriverManager.getConnection("jdbc:sqlite:nhis.sqlite");
        
        
        statement = connection.createStatement();
                statement.executeUpdate(sqlStatement);
        
        
        }catch(SQLException sqle){
            sqle.printStackTrace();
            return false;
        }finally{
        
            try{
                if(connection != null){
                    connection.close();
                }
            }catch(SQLException sqle){
            sqle.printStackTrace();
            }
        }
        
        return true;
    }
    
    public boolean check(String newName, String newP){
        String invalid;
        
        if(newName.equals("") || newP.equals("")){
          return false;
        }
        
        sqlStatement = "select username from userlogin where username ='"+newName+"';";
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:nhis.sqlite");
            statement = connection.createStatement();
       
            resultSet = statement.executeQuery(sqlStatement);
            
            while(resultSet.next()){
                invalid = resultSet.getString("username");
                
                if(invalid.equalsIgnoreCase(newName)){
                    return true;
                }
            }
        
        }catch(SQLException sqle){
        sqle.printStackTrace();
        }finally{
        
            try{
                if(connection != null){
                    connection.close();
                }
            }catch(SQLException sqle){
            sqle.printStackTrace();
            }
        }
        
        return false;
    }
    
    @SuppressWarnings("CallToPrintStackTrace")
    public void putPerson(Person person){
     
        //declaring variables to get data
        String firstname = person.getName().getFirstName().toLowerCase();
        String middlename = person.getName().getMiddleName().toLowerCase();
        String lastname = person.getName().getLastName().toLowerCase();
        String nhisidno = person.get_NHIS_ID_NO().getNhis_id_no();
        char gender = person.getGender().getGender();
        int cost = person.getBill().getCost();
        float _10per = person.getBill().get_10PercentofCost();
        float _90per = person.getBill().get_90PercentofCost();
        java.util.Date date = person.getDate();
                
         try{
        
           // connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nhis","chijioke","chijioke");
             connection = DriverManager.getConnection("jdbc:sqlite:nhis.sqlite");
            System.out.println("connection made");
          
            statement = connection.createStatement();
            System.out.println(" Statement created");
            
           sqlStatement = "insert into person (firstname, middlename, lastname, nhisid, gender, cost, _10per, _90per, date)"
                    + " values ('"+firstname+"','"+middlename+"','"+lastname+"','"+nhisidno+"','"+gender+"',"+cost+","+_10per+","+_90per+",'"+date+"');";
           statement.executeUpdate(sqlStatement);
           
           statement.close();
           
            
            if(statement != null){
            
            statement.close();
            connection.close();
            }
        }
       catch(SQLException sql){
       sql.printStackTrace();
       }
    }
    
}
