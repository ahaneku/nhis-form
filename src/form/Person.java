package form;

public class Person {
private Name name;
private NHIS_ID_NO nhis_id_no;
private Gender gender;
private Bill bill;
private java.util.Date date;
private static long numberOfPersons;
private String [][] Details;

public Person(Name name, NHIS_ID_NO nhis_id_no, Gender gender, Bill bill){

    this.name = name;
    this.nhis_id_no = nhis_id_no;
    this.gender = gender;
    this.bill = bill;
    this.date = new java.util.Date();
  
}



public Name getName(){
return name;
}

public NHIS_ID_NO get_NHIS_ID_NO(){
return nhis_id_no;
}

public Gender getGender(){
return gender;
}

public Bill getBill(){
return bill;
}

@Override
public String toString(){
return "Details of Person :"+"\n";
        
}

public java.util.Date getDate(){
return date;
}

public void getDetails(){

}

 {
numberOfPersons++;
}
 
 public static long getNumberOfPersons(){
 return numberOfPersons;
 }
}
