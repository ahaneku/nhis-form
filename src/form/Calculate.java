package form;

public class Calculate {

    public static double calculate10(String amount){
    
        double answer;
        
        if(amount.length() >= 7 ){
        String _amount = amount.substring(0, 7);
        int amountn = Integer.parseInt(_amount);
        answer = amountn * 0.1;
        }
        else{
        double amountn = Double.parseDouble(amount);
        answer = amountn * 0.1;
        }
        return answer;
    }
    
    public static double calculate90(String amount){
    double answer;
    
    if(amount.length() >=7 ){
        String _amount = amount.substring(0, 7);
        int amountn = Integer.parseInt(_amount);
        answer = amountn * 0.9;
        }
        else{
        double amountn = Double.parseDouble(amount);
        answer = amountn * 0.9;
        }
        return answer;
    }
}
