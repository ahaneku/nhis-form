package form;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.border.BevelBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;

public class NewUser extends JPanel{
    
    private static final String [] gS = {"Male", "Female"};
    
    private final JPanel pan1;
    private final JPanel pan2;
    private final JPanel pan3;
    private final JPanel pan4;
    private final JPanel pan5;
    private final JPanel pan6;
    private final JTextField name;
    private final JPasswordField password;
    private final JLabel info;
    public final JButton login;
    public final JButton add;
    private final JComboBox<String> gender;
    private final String in = "Info : ";
    private char gen;
    
    public NewUser(){
    
        setLayout(new BorderLayout());
        
        pan1 = new JPanel(new BorderLayout(3, 2));
        JPanel np = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel nameL = new JLabel("Name : ");
        name = new JTextField(18);
        name.setBorder(new BevelBorder(BevelBorder.LOWERED));
        np.add(name);
        pan1.add(nameL, BorderLayout.WEST);
        pan1.add(np, BorderLayout.CENTER);
        
        pan2 = new JPanel(new BorderLayout(3, 2));
        JPanel pp = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel passL = new JLabel("Password : ");
        password = new JPasswordField(16);
        password.setBorder(new BevelBorder(BevelBorder.LOWERED));
        pp.add(password);
        pan2.add(passL, BorderLayout.WEST);
        pan2.add(pp, BorderLayout.CENTER);
        
        pan3 = new JPanel(new BorderLayout(3, 2));
        JLabel genderL = new JLabel("Gender : ");
        gender = new JComboBox();
        pan3.add(genderL, BorderLayout.WEST);
        pan3.add(gender, BorderLayout.CENTER);
        
        for(String gg : gS){
            gender.addItem(gg);
        }
        
        //buttons
        pan4 = new JPanel(new BorderLayout());
        JPanel ap = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel lp = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel cp = new JPanel(new GridLayout(1, 1));
        add = new JButton("Add");
        login = new JButton("Login");
        lp.add(login);
        ap.add(add);
        pan4.add(lp, BorderLayout.WEST);
        pan4.add(ap, BorderLayout.EAST);
        cp.add(pan4);
        
        info = new JLabel();
        info.setForeground(Color.BLUE);
        info.setText(in);
        
        pan5 = new JPanel(new GridLayout(3, 1));
        pan5.setBounds(0, 10, 30, getWidth());                  //////////////////
        pan5.add(pan1);
        pan5.add(pan2);
        pan5.add(pan3);
        
        pan6 = new JPanel(new BorderLayout());
        pan6.add(pan5, BorderLayout.NORTH);
        pan6.add(pan4, BorderLayout.SOUTH);
        
        add(pan6, BorderLayout.CENTER);
        add(info, BorderLayout.SOUTH);
        
 /*       login.addActionListener(new ActionListener(){
            
            @Override
          public void actionPerformed(ActionEvent ae){
                        uh.signIn();
                    }
            
        });
        
        add.addActionListener((ActionEvent)->{
            
            uh.data(getUserName(), getPassword(), getGender());
        });   */
        
    }
    
public String getUserName(){
return name.getText().trim();
}    

public void setUserName(){
    name.setText("");
}

public String getPassword(){
    return password.getText().trim();
}

public void setPassword(){
    password.setText("");
}

public char getGender(){
    if(gender.getSelectedIndex() == 0){
        gen = 'M';
    }else if(gender.getSelectedIndex() == 1){
        gen = 'F';
    }
    
    return gen;
}

public void setInfo(String inf){
    if(!inf.equals("Error Encountered.") | !inf.equals("Username or Password can't be empty.")){
        info.setForeground(Color.BLUE);
        info.setText(in+inf);
    }else if(  inf.equals( "Error Encountered.") | inf.equals("Username or Password can't be empty.")){
        info.setForeground(Color.red);
        info.setText(in+inf);
    }
    
}


}
