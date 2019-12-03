package form;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.JTableHeader;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

public class Form extends JFrame{

    //declaring variables(fields) for interface
    private final JPanel panel1;
    private final JPanel panel2;
    private final JPanel panel3;
    private final JPanel panel4;
    private final JPanel panel5;
    private final JPanel panel6;
    private final JPanel panel7;
    private final JPanel panel8;
    private final JPanel panel9;
    private final JPanel panel10;
    private final JPanel panel11;
    private final JPanel panel12;
    private final JPanel panel13;
    private final JPanel panel14;
    private final JPanel panel15;
    private final JPanel panel16;
    private final JPanel panel17;
    private final JPanel panel18;
    private final JPanel panel19;
    private final JLabel firstName;
    private final JLabel middleName;
    private final JLabel lastName;
    private final JLabel nhisIdNo;
    private final JLabel totalCost;
    private final JLabel _10Percent;
    private final JLabel _90Percent;
    private final JLabel numberOfPersons;
    private final JTextField firstNameText;
    private final JTextField middleNameText;
    private final JTextField lastNameText;
    private final JTextField totalCostText;
    private final JTextField _10PercentText;
    private final JTextField _90PercentText;
    private final JTextField searchText;
    private final JTextField nhisIdNoText;
    private final static JTextField quaryField =  new JTextField("", 80);
    private final JButton registrationButton;
    private final JRadioButton Male;
    private final JRadioButton Female;
    private final ButtonGroup Gender;
    private final JTable table;
    private final JScrollPane Scroll;
   // private final JScrollPane Scroll1;
    private Table tab;
    private final DataBase dataBase = new DataBase(); 
    private float _10per;
    private float _90per;
    private Person person;
    private Name name;
    private NHIS_ID_NO nhis_id_no;
    private Bill bill;
    private Gender gender;
    static final JTextField numberOfPersonsText = new JTextField(8);
    
    //constructor for interface
    public Form(){
    super("Prescription Total Cost IDE");
    setLayout(new BorderLayout());
    

    
    //constructing panel1
    panel1 = new JPanel(new GridLayout(1, 3));
    panel15 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    panel16 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    panel17 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    firstName = new JLabel("FIRST NAME");
    firstName.setForeground(Color.WHITE);
    firstNameText = new JTextField(null,15);
    firstNameText.setBorder(new BevelBorder(BevelBorder.LOWERED));
    panel15.add(firstName);
    panel15.add(firstNameText);
    panel15.setBackground(new Color(80, 90, 170));
    middleName = new JLabel("MIDDLE NAME");
    middleName.setForeground(Color.WHITE);
    middleNameText = new JTextField(15);
    middleNameText.setBorder(new BevelBorder(BevelBorder.LOWERED));
    panel16.add(middleName);
    panel16.add(middleNameText);
    panel16.setBackground(new Color(80, 90, 170));
    lastName = new JLabel("LAST NAME");
    lastName.setForeground(Color.white);
    lastNameText = new JTextField(null,15);
    lastNameText.setBorder(new BevelBorder(BevelBorder.LOWERED));
    panel17.add(lastName);
    panel17.add(lastNameText);
    panel17.setBackground(new Color(80, 90, 170));
    panel1.add(panel15);
    panel1.add(panel16);
    panel1.add(panel17);
    panel1.setBackground(new Color(80, 90, 170));
    panel1.setBorder(new BevelBorder(BevelBorder.RAISED));
    
    
    //constructing panel2
    panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 4, 0));
    nhisIdNo = new JLabel("NHIS ID NO");
    nhisIdNoText = new JTextField(16);
    nhisIdNoText.setBorder(new BevelBorder(BevelBorder.LOWERED));
    panel2.add(nhisIdNo);
    panel2.add(nhisIdNoText);
    panel2.setBorder(new BevelBorder(BevelBorder.RAISED));
    
    //constructing panel3
    panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 4, 0));
    Gender = new ButtonGroup();
    Male = new JRadioButton("MALE", false);
    Female = new JRadioButton("FEMALE", false);
    Gender.add(Male);
    Gender.add(Female);
    panel3.add(Male);
    panel3.add(Female);
    
    
    panel3.setBorder(new BevelBorder(BevelBorder.RAISED));
    panel3.setBorder(new TitledBorder("GENDER"));
    
    
    //construction panel12(Number of persons tray)
    panel12 = new JPanel(new FlowLayout(FlowLayout.LEADING));
    panel13 = new JPanel(new BorderLayout());
    numberOfPersons = new JLabel("Total");
    numberOfPersonsText.setBorder(new BevelBorder(BevelBorder.LOWERED));
    numberOfPersonsText.setEditable(false);
    numberOfPersonsText.setBackground(Color.WHITE);
    numberOfPersonsText.setHorizontalAlignment(SwingConstants.RIGHT);
    numberOfPersonsText.setToolTipText("Total Number Of Persons");
    panel13.add(numberOfPersons, BorderLayout.WEST);
    panel13.setBackground(new Color(80, 90, 180));
    panel13.add(numberOfPersonsText, BorderLayout.EAST);
    
    
    quaryField.setEditable(false);
    quaryField.setBackground(Color.white);
    quaryField.setForeground(Color.red);
    panel19 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    panel19.add(quaryField);
    panel19.setBackground(new Color(80, 90, 180));
   
    ////////////////////////////////////////
    panel12.add(panel13);
    panel12.add(panel19);
    panel12.setBorder(new BevelBorder(BevelBorder.RAISED));
    panel12.setBackground(new Color(80, 90, 180));
    
    
    //constructing panel9
    panel9 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    panel14 = new JPanel(new BorderLayout());
    registrationButton = new JButton("REGISTER");
    panel9.add(registrationButton);
    panel9.setBorder(new BevelBorder(BevelBorder.LOWERED));
    searchText = new JTextField("Search Here",15);
    searchText.setBorder(new BevelBorder(BevelBorder.LOWERED));
    searchText.setDisabledTextColor(Color.gray);
    panel14.add(searchText, BorderLayout.CENTER);
    panel14.add(panel9, BorderLayout.EAST);
    
    //adding event handler to search field
    searchText.addMouseListener(new MouseAdapter(){
    @Override
    public void mouseClicked(MouseEvent click){
    searchText.getAction();
    searchText.setText(null);
    searchText.setToolTipText("Press Enter To Begin Search After Input");
    }
    
    
    @Override
    public void mouseExited(MouseEvent exit){
        if(searchText.getText().isEmpty()){
                searchText.setText("Search Here");
        }
    
    }
    
    @Override
   public void mouseEntered(MouseEvent enter){
       searchText.setToolTipText("Press Enter To Begin Search After Input");
    }
    });
    
    
    //Main Table
    searchText.addActionListener((ActionEvent searchEvent) -> {
    
        setEnabled(false);
        Search sarchs = new Search(searchText.getText());
        new Thread(sarchs).start();
       // sarchs.searchIndex(searchText.getText());
        JTable table1 = new JTable(sarchs);
        table1.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
        table1.setColumnSelectionAllowed(false);
        table1.setEnabled(false);
        table1.sizeColumnsToFit(true);
        table1.setSelectionBackground(Color.white);
        
        TableColumnModel columnModel1 = table1.getColumnModel();
        JTableHeader header1 = new JTableHeader(columnModel1);
        header1.setReorderingAllowed(false);
        header1.setResizingAllowed(false);
        columnModel1.setColumnSelectionAllowed(false);
        columnModel1.getColumn(0).setMaxWidth(40);
        columnModel1.getColumn(4).setWidth(900);
        columnModel1.getColumn(5).setMaxWidth(100);
        columnModel1.getColumn(6).setMaxWidth(500);
        columnModel1.getColumn(7).setMaxWidth(250);
        columnModel1.getColumn(8).setMaxWidth(250);
    
        //search Dialog
        JDialog search = new JDialog(this);
        search.setLayout(new BorderLayout());
        search.setTitle("Search:\\"+searchText.getText());
        search.setSize(1000, 300);
        search.setResizable(false);
        search.setLocationRelativeTo(null);
        search.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel pan = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        ImageIcon okbtico = new ImageIcon("image\\Ok_Button.png");
        ImageIcon rollOverOkButton = new ImageIcon("image\\RollOver_Ok_Button.png");
        JButton okBt = new JButton(okbtico);
        okBt.setRolloverEnabled(true);
        okBt.setRolloverIcon(rollOverOkButton);
        okBt.setBorder(new LineBorder(new Color(80, 90, 170), 1));
        pan.add(okBt);
        
        search.setUndecorated(true);
        search.setOpacity(0.9f);
        
        search.add(new JScrollPane(table1), BorderLayout.CENTER);
        search.add(pan, BorderLayout.SOUTH);
        search.setVisible(true);
       
        search.addWindowListener(new WindowAdapter(){
        @Override
        public void windowClosing(WindowEvent wieve){
            
        setEnabled(true);
        
        }
        });
        //adding listener to OK button
        okBt.addActionListener((ActionEvent ok) -> {
       
        setEnabled(true);
        search.dispose();
        
        });
       
    });
    
    //constructing panel4
    panel4 = new JPanel(new GridLayout(4,1));
   
    panel4.add(panel1);
    panel4.add(panel2);
    panel4.add(panel3);
    panel4.add(panel14);
    panel4.setBorder(new TitledBorder("PATIENT DETAILS"));
    panel4.setBackground(Color.gray);
    

    //constructing panel5 table panel
    panel5 = new JPanel(new BorderLayout());
   
    Thread _1stThread = new Thread(tab = new Table()
    
    );   //thread starts
 
    _1stThread.start();
    
    table = new JTable(tab);
    table.setRowSelectionAllowed(false);
    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    table.setSelectionBackground(Color.WHITE);
    table.setRowHeight(19);
    table.setRowMargin(2);
    table.setColumnSelectionAllowed(false);
    table.setEnabled(false);
    table.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
           
    TableColumnModel columnModel = table.getColumnModel();
    JTableHeader header = new JTableHeader(columnModel);
    header.setReorderingAllowed(false);
    header.setResizingAllowed(false);
    columnModel.setColumnSelectionAllowed(false);
    columnModel.getColumn(0).setMaxWidth(40);
    columnModel.getColumn(4).setWidth(900);
    columnModel.getColumn(5).setMaxWidth(100);
    columnModel.getColumn(6).setMaxWidth(500);
    columnModel.getColumn(7).setMaxWidth(250);
    columnModel.getColumn(8).setMaxWidth(250);
    
    
    //scroll for table and patients details
    Scroll = new JScrollPane(table);
    Scroll.setBorder(new BevelBorder(BevelBorder.LOWERED));
    Scroll.setWheelScrollingEnabled(true);
    panel5.add(panel4, BorderLayout.NORTH);
    panel5.add(Scroll, BorderLayout.CENTER);
    panel5.add(panel12, BorderLayout.SOUTH);
    
    
    //constructing panel6
    panel6 = new JPanel(new GridLayout(2, 1, 0, 2));
    totalCost = new JLabel("COST OF DRUGS");
    totalCost.setForeground(Color.WHITE);
    totalCostText = new JTextField(20);
    totalCostText.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
    totalCostText.setToolTipText("Press ENTER to calculate \n 10% and 90% of cost");
    panel6.add(totalCost);
    panel6.add(totalCostText);
    panel6.setBorder(new BevelBorder(BevelBorder.RAISED));
    panel6.setBackground(new Color(80, 90, 170));
    
    //construction panel7
    panel7 = new JPanel(new BorderLayout());
    _10Percent = new JLabel("10% OF COST");
    _10Percent.setFont(new Font(Font.SANS_SERIF, Font.LAYOUT_LEFT_TO_RIGHT + Font.BOLD, 13));
    _10PercentText = new JTextField(10);
    _10PercentText.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
    panel7.add(_10Percent, BorderLayout.WEST);
    panel7.add(_10PercentText, BorderLayout.EAST);
    panel7.setBorder(new BevelBorder(BevelBorder.LOWERED));
    panel7.setBackground(new Color(100, 120, 150));
    
    //constructing panel8
    panel8 = new JPanel(new BorderLayout());
    _90Percent = new JLabel("90% OF COST");
    _90Percent.setFont(new Font(Font.SANS_SERIF, Font.LAYOUT_LEFT_TO_RIGHT + Font.BOLD, 13));
    _90PercentText = new JTextField(10);
    _90PercentText.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
    panel8.add(_90Percent, BorderLayout.WEST);
    panel8.add(_90PercentText, BorderLayout.EAST);
    panel8.setBorder(new BevelBorder(BevelBorder.LOWERED));
    panel8.setBackground(new Color(150, 100, 120));
    
    
    //constructing panel10
    panel10 = new JPanel(new GridLayout(3, 1));
    panel10.add(panel7);
    panel10.add(panel8);
    panel10.setOpaque(true);
    panel10.setBackground(new Color(80, 90, 170));
    
    
    //constructing panel11////////////////////////////////////////
    panel11 = new JPanel(new BorderLayout());
    panel11.add(panel6, BorderLayout.NORTH);
    panel11.add(panel10, BorderLayout.SOUTH);
    panel11.setBackground(Color.WHITE);
    panel11.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
    
    
    //finalyzing window
    panel18 = new JPanel(new BorderLayout());
    panel18.add(panel5, BorderLayout.CENTER);
    panel18.add(panel11, BorderLayout.EAST);
    
    //Scroll1 = new JScrollPane(panel18);
   // Scroll1.setWheelScrollingEnabled(true);
   // Scroll1.setBorder(new BevelBorder(BevelBorder.LOWERED));
    
    //adding panels to frame
    
    add(panel18);
    
    //Declaring and Registering ActionListeners
    ActionListener listener = new Listeners();
   
    registrationButton.addActionListener(new personHandler());
    
    totalCostText.addActionListener(listener);
    totalCostText.addCaretListener((CaretListener)listener);     
    
    //Setting Input Methods and making fields non-editable
    _10PercentText.setEditable(false);
    _10PercentText.setHorizontalAlignment(SwingConstants.RIGHT);
    _10PercentText.setBackground(Color.white);
    _90PercentText.setEditable(false);
    _90PercentText.setHorizontalAlignment(SwingConstants.RIGHT);
    _90PercentText.setBackground(Color.WHITE);
    
    
    
    }
    
    public static void setQuery(String query){
    
        quaryField.setText("");
        quaryField.setForeground(Color.black);
        quaryField.setText(query);
        quaryField.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
        
    }
    
    private class Listeners implements ActionListener, CaretListener {
        
          
        @Override
        public void caretUpdate(CaretEvent ce){
        
              try{
                
                 _10per = (float)Calculate.calculate10(totalCostText.getText());
                    _90per = (float)Calculate.calculate90(totalCostText.getText());
                    _10PercentText.setText(""+_10per);
                    _90PercentText.setText(""+_90per);}
                catch(NumberFormatException errr){
                    _10PercentText.setText("");
                    _90PercentText.setText("");
                quaryField.setText("");
                quaryField.setForeground(Color.red);
                if(totalCostText.getText().equals("")){
                    quaryField.setText("");
                }
                else if(!totalCostText.getText().equals("")){
                    quaryField.setText("invalid amount at total cost "+errr.getMessage());
                }
                
                }
                
            
            
        }
        
    
        @Override
        public void actionPerformed(ActionEvent event2){
                
                try{
                
                 _10per = (float)Calculate.calculate10(event2.getActionCommand());
                    _90per = (float)Calculate.calculate90(event2.getActionCommand());
                    _10PercentText.setText(""+_10per);
                    _90PercentText.setText(""+_90per);}
                catch(NumberFormatException errr){
               
                quaryField.setText("");
                quaryField.setForeground(Color.red);
                quaryField.setText("invalid amount at total cost "+errr.getMessage());
               
                }
                
            
           
        
    }
    }
    
    public class personHandler implements ActionListener{
      
        @Override
    public void actionPerformed(ActionEvent event3){
        //sending actions to fields
                firstNameText.getAction();
                middleNameText.getAction();
                lastNameText.getAction();
                nhisIdNoText.getAction();
                totalCostText.getAction();
                Male.getAction();
                Female.getAction();
                _10PercentText.getAction();
                _90PercentText.getAction();
                float _10per = 0;
                float _90per = 0;
                
                //calculating 10% and 90%
                //calculating fields
                try{
                if(totalCostText.getText().equals("") || totalCostText.getText().matches("[0-9]+[a-zA-Z]+[a-zA-Z0-9]*") || totalCostText.getText().matches("[a-zA-Z]+[0-9a-zA-Z]+")){
                    quaryField.setForeground(Color.RED);
                    quaryField.setText("");
                    quaryField.setText("invalid Amount : "+totalCostText.getText());
                    return;
               
                }
                
                else if( !totalCostText.getText().equals(new String())  || !totalCostText.getText().equals("")){
                quaryField.setText("");
                _10per = (float)Calculate.calculate10(totalCostText.getText());
                _90per = (float)Calculate.calculate90(totalCostText.getText());
                _10PercentText.setText(""+_10per);
                _90PercentText.setText(""+_90per);
                }
                }
                catch(NumberFormatException errr){
                quaryField.setText("");
                quaryField.setForeground(Color.red);
                quaryField.setText("invalid amount at COST: "+errr.getMessage());
                }
                
                //getting actions
                firstNameText.getAction();
                middleNameText.getAction();
                lastNameText.getAction();
                nhisIdNoText.getAction();
                totalCostText.getAction();
                Male.getAction();
                Female.getAction();
                _10PercentText.getAction();
                _90PercentText.getAction();
                
                
                //checking if fields are empty
               if(!firstNameText.getText().isEmpty() && !lastNameText.getText().isEmpty() &&
                        !nhisIdNoText.getText().isEmpty() && ((Male.isSelected() == true)|| (Female.isSelected() == true)) 
                         ){
                    
                   //setting query field
                    quaryField.setText("");
                    quaryField.setForeground(Color.GREEN);
                  
                    //getting datas
                  String []Details;  
                 char genderString = '-';
                 String firstname = firstNameText.getText();
                 String middlename = middleNameText.getText();
                 String lastname = lastNameText.getText();
                 String nhisidno = nhisIdNoText.getText();
                 String cost = totalCostText.getText().trim();
                 String _10percent = ""+_10per;
                 String _90percent = ""+_90per;
                 
                 //passing datas to objects
                name = new Name(firstname, middlename, lastname);
                nhis_id_no = new NHIS_ID_NO(nhisidno);
                bill = new Bill(Integer.parseInt(cost), Float.parseFloat(_10percent), Float.parseFloat(_90percent));
                
                if(Male.isSelected()){
                genderString = 'M';
                gender = new Gender(genderString);
                }
                else if(Female.isSelected()){
                genderString = 'F';
                gender = new Gender(genderString);
                }
                
                
                //adding person
                person = new Person(name, nhis_id_no, gender, bill);
                dataBase.putPerson(person);
                
                
                //concatenating details
                  Details = new String[]{""+(tab.getRowCount()+1),firstname.toUpperCase(), middlename.toUpperCase(), lastname.toUpperCase(),
                      nhisidno.toUpperCase(),
                            ""+genderString, cost, _10percent, _90percent, person.getDate().toString()};
                
                tab.addRow(Details);
                numberOfPersonsText.setText(""+tab.getRowCount());
                
                    //setting quaryfield
                   quaryField.setText("---------------------> DATA SAVED <------------------------");
                   
                //clearint fields
                firstNameText.setText(null);
                middleNameText.setText(null);
                lastNameText.setText(null);
                nhisIdNoText.setText(null);
                totalCostText.setText(null);
                Male.setFocusPainted(false);
                Female.setFocusPainted(false);
                _10PercentText.setText(null);
                _90PercentText.setText(null);
                
                }
               else if(firstNameText.getText().isEmpty() || lastNameText.getText().isEmpty() ||
                        nhisIdNoText.getText().isEmpty() || (Male.isSelected() == false || Female.isSelected() == false) 
                       ){
                    
                    quaryField.setForeground(Color.red);
                    quaryField.setFont(new Font(Font.DIALOG, Font.PLAIN, 12));
                    quaryField.setText("Required Fields are Empty, Complete Patient Details");
                    
                   }
              }      
        }

    }