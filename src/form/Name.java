package form;

public class Name {
    private String firstName;
    private String middleName;
    private String lastName;
    
    public Name(String firstName, String middleName, String lastName){
    if(middleName == null){
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        }
    else{
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        }
    }
    
    public void setFirstName(String firstName){
    this.firstName = firstName;
    }
    
    public void setMiddleName(String middleName){
        if(middleName == null){
            this.middleName = middleName;
        }
        else{
            this.middleName = middleName;
        }
    }
    
    public void setLastName(String lastName){
    this.lastName = lastName;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getMiddleName(){
        return middleName;
    }
    
    public String getLastName(){
        return lastName;
    }
}
