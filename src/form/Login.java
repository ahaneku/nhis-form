package form;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

public class Login extends JFrame{
    
    public static final String laf = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
 
private ImageIcon loginIco;
private ImageIcon loginButton;
private ImageIcon loginRollOver;
private JLabel loginico;
private JTextField loginText;
private JPasswordField passwordText;
private JPanel pan1;
private JPanel pan2;
private JPanel pan3;
private JPanel pan4;
private JPanel pan5;
private JButton login;
private JLabel Username;
private JLabel Password;
private NewUser newUp;
private JDialog newU = null;
private JFrame form = null;
private final DataBase database = new DataBase();
private JButton jb;
private JButton jb1;
private Thread jbTask;


    public static void main(String[] args) {

        Login frame = new Login();
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setIconImage(new ImageIcon("App_ico.png").getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT));
    }
    
    public Login(){
        super("Login");
        setLayout(new BorderLayout());
        
        try{
            
        UIManager.setLookAndFeel(laf);
        
        }catch(Exception e){
            e.printStackTrace();
        }
      
        
        newUp = new NewUser();     ///////////////////////////////////
    //construsting panel one
        pan1 = new JPanel(new BorderLayout());
        loginIco = new ImageIcon("image\\login_ico.png");
        loginico = new JLabel(loginIco);
        pan1.add(loginico, BorderLayout.CENTER);
        
        
    pan2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    Username = new JLabel("USERNAME");
    Username.setHorizontalAlignment(SwingConstants.RIGHT);
    loginText = new JTextField("e.g chijioke or popsy95",20);
    loginText.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
    pan2.add(Username);
    pan2.add(loginText);
    
    
    //password panel and login button
    pan3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 1));
    loginButton = new ImageIcon("image\\login_button.png");
    loginRollOver = new ImageIcon("image\\login_roll_over.png");
    login = new JButton(loginButton);
    login.setBorder(new LineBorder(new Color(170, 170, 170)));
    login.setRolloverEnabled(true);
    login.setRolloverIcon(loginRollOver);
    Password = new JLabel("PASSWORD");
    Password.setHorizontalAlignment(SwingConstants.RIGHT);
    passwordText = new JPasswordField(20);
    passwordText.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
    pan3.add(Password);
    pan3.add(passwordText);
    pan3.add(login);
    JButton a = new JButton("New");
    a.setBackground(new Color(20, 70, 100));
    a.setForeground(Color.WHITE);
    a.setToolTipText("Add new account");
    
    
  //  a.setBackground(pan3.getBackground());
    
    pan3.add(a);
      //from NewUser "casted"     ///////////////////
    jb = (JButton)newUp.add;
    jb1 = (JButton)newUp.login;
    
    newUp.setUserName();
    newUp.setPassword();
    newUp.setInfo("");
    
    a.addActionListener((ActionEvent)->{
    
        this.remove(pan4);
        this.setSize(400, 300);
        this.add(newUp, BorderLayout.CENTER);
        
        
    });
    
  
   
    jb.addActionListener((ActionEvent)->{
        
        jbTask = new Thread(new Runnable(){
        
            @Override
            public void run(){
                
            boolean check = database.check(newUp.getUserName(), newUp.getPassword());
            newUp.setInfo("Please wait...");
            
        if(check == false){
      boolean r =  database.addUser(newUp.getUserName(), newUp.getPassword(), newUp.getGender());
                 if(r == true){
                 newUp.setInfo("User added.");
                 newUp.setUserName();
                 newUp.setPassword();
                 
             }else{
                     if(newUp.getUserName().isEmpty() || newUp.getPassword().isEmpty()){
                           newUp.setInfo("Username or Password can't be empty.");
                          
                     }else{
                            newUp.setInfo("Error Encountered.");
                     }
            }
                 jbTask = null;
        }
        else if(check == true){
            newUp.setInfo("User already exist.");
            
            jbTask = null;
        }
                
        
            }
        });
        
        jbTask.start();
       
    });
    
    jb1.addActionListener((actionEvent)->{
    
        this.remove(newUp);
        this.setSize(400, 200);
        this.add(pan4, BorderLayout.CENTER);
    });
    
    
    pan4 = new JPanel(new GridLayout(2, 1));
    pan4.add(pan2);
    pan4.add(pan3);
    
    add(pan1, BorderLayout.NORTH);
    add(pan4, BorderLayout.CENTER);
    
    
    //adding mouseevent listener
    loginText.addMouseListener(new MouseAdapter(){
    @Override
    public void mouseClicked(MouseEvent click){
        if(loginText.getText().equals("e.g chijioke or popsy95")){
              loginText.setText(null);
        }
    }
    
    @Override
    public void mouseExited(MouseEvent exit){
    if(loginText.getText().isEmpty()){
        loginText.setText("e.g chijioke or popsy95");
    }
    }
    
    @Override
    public void mouseEntered(MouseEvent entered){
    if(loginText.getText().equals("e.g chijioke or popsy95")){
        loginText.setText(null);
    }
    }
    });
    
    
    //registering action event
    ActionListener handle = new handles();
    
    login.addActionListener(handle);
    
    loginText.addActionListener((ActionEvent le)->{
       handle.actionPerformed(le);
        }
    );
    
    passwordText.addActionListener((ActionEvent ae)->{
   
    handle.actionPerformed(ae);
    
    });
    }
    
private class handles implements ActionListener{
@Override
public void actionPerformed(ActionEvent log){
    loginText.getAction();
    passwordText.getAction();
    
    if(loginText.getText().isEmpty() || passwordText.getText().isEmpty()){
    JOptionPane.showMessageDialog(null, "Username or Password Field \n Can Not Be Empty");
   
    }
    else{
    
loginText.getAction();
passwordText.getAction();

//declaring variables
String retriv;
String usernam = loginText.getText().trim();
String pass = passwordText.getText().trim();

//loading database
 //database = new DataBase();

//retriving password fro database
retriv = database.userLogin(usernam, pass).trim();

//checking if passwords are compatible
if(pass.equals(retriv) ) {
    
//disposing login frame
        dispose();
 //creating application interface
     
        form = new Form();
        
        
        form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        form.setSize(form.getToolkit().getScreenSize());
        form.setIconImage(new ImageIcon("App_ico.png").getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT)); 
        
          
        //new User
        
                newU = new JDialog(form);
                newU.setSize(250, 250);
               
                newU.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                newU.setTitle("Add User");
                newU.setResizable(false);
                newU.setLocationRelativeTo(null);
        
        //declaring and Defining MenuBar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem addUser = new JMenuItem("Add New User");
        addUser.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
      //  JMenuItem searchMenuItem = new JMenuItem("Search NHIS ID NO");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        
        newU.addWindowListener(new WindowAdapter(){
        @Override
        public void windowClosing(WindowEvent wee){
            form.setEnabled(true);
        }
            
        });
        
         //buttons from NewUser panel "casted"      ////////////////////////
        jb = (JButton)newUp.add;
        jb1 = (JButton)newUp.login;
        
         addUser.addActionListener((ActionEvent)->{
             newUp.setUserName();
             newUp.setPassword();
             newUp.setInfo("");
            
                newU.setLayout(new BorderLayout());
                newU.add(newUp , BorderLayout.CENTER);
                newU.setVisible(true);
                form.setEnabled(false);
                
            });
     
        jb1.addActionListener((Actionevent)->{
            //login but in add dialog
         if(newU != null && form != null){
         
             newU.dispose();
             form.dispose();
             main(new String[]{});
         }else if(newU == null && form == null){
             main(new String[]{});
         }
            
        });  
             
       
        
        //adding action event to exit menus
        exitMenuItem.addActionListener((ActionEvent) -> {
       
        form.dispose();
        });
        
        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutMenuItem = new JMenuItem("About");
        
        //adding action event to About menus //// editing     /////////////////////////
        aboutMenuItem.addActionListener((ActionEvent ae) -> {
            form.setEnabled(false);
            JDialog About = new JDialog(form);
            JTextArea textAbout = new JTextArea(5, 20);
            textAbout.setEditable(false);
            textAbout.setLineWrap(true);
            textAbout.setWrapStyleWord(true);
            textAbout.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));
            textAbout.setText("This Application was built by Chijioke from LIONsoft \n\n"
                    + "and Popsy from College Bit for NHIS."
                    + " As of the time this application was made the builders both school in University of Nigeria, Nsukka also known"
                    + " as UNN.");
            
           // textAbout.setVisible(true);
            textAbout.setBackground(Color.white);
            
            About.setLayout(new GridLayout(2, 1));
            JPanel pan2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JPanel pan3 = new JPanel(new BorderLayout());
            JButton okbt = new JButton("cancle");
            
            pan2.add(okbt);
            pan3.add(textAbout, BorderLayout.CENTER);
            pan3.add(pan2, BorderLayout.SOUTH);
            
            Image Lionsoft_logo = new ImageIcon("image\\LIONSOFT_LOGO.png").getImage();
            About.add(new aboutBox(Lionsoft_logo));
            About.add(pan3);
            
            //setting translucency
            About.setUndecorated(true);
            About.setOpacity(0.8f);
            
            About.setSize(400, 400);
            About.setResizable(false);
            About.setLocationRelativeTo(null);
            About.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            About.setVisible(true);
            
            About.addWindowListener(new WindowAdapter(){

                @Override
                public void windowClosing(WindowEvent e) {
                    form.setEnabled(true);
                }
            
            });
                        
            okbt.addActionListener((ActionEvent) -> {
                
            form.setEnabled(true);
            About.dispose();
            });
            
        });
        
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        
        fileMenu.add(addUser);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);
        helpMenu.add(aboutMenuItem);
        
        
        
        //adding menubar to frame
        
        form.setJMenuBar(menuBar);
        form.setVisible(true);
        form.setResizable(true);
        
        Form.setQuery("Welcome "+usernam.toUpperCase());
        
}
else if( !pass.equals(retriv) || loginText.getText() == null){
   JLabel LAB = new JLabel("USER DOES NOT EXIST");
   LAB.setBackground(Color.white);
   LAB.setFont(new Font(Font.DIALOG, Font.PLAIN + Font.BOLD,13));
JOptionPane.showMessageDialog(null, LAB, "ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);

}
    }

}
    }
 
private class aboutBox extends JPanel  {

    private Image image;
    
    public aboutBox(){}
    
    public aboutBox(Image image){
    this.image = image;
    //setBackground(Color.WHITE);
    }
    
    @Override
    protected void paintComponent(Graphics g){
    super.paintComponent(g);
    
    
    g.drawImage(image, 20, 20, getWidth() / 2 , getHeight(), this);
    
    }
}

}

  