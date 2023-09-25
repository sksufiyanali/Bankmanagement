
import java.awt.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;

import java.util.*;
import java.awt.event.*;
import java.sql.*;



public class signuptwo extends JFrame implements ActionListener {

    long random;
    JTextField aadhar,Pan;
    JButton next;
    JRadioButton syes,sno;
    JComboBox religion,catagory,occupation,education,income;
    String formno;
    signuptwo(String formno){
      this.formno=formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM-PAGE 2");

              JLabel Additionaldetails=new JLabel("Page 2:Additional Details");
              Additionaldetails.setFont(new Font("Raleway",Font.BOLD,22));
              Additionaldetails.setBounds(290,80,400,30);
              add(Additionaldetails);

        JLabel name=new JLabel("Religion:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

        String valreligion[] ={"Hindu","muslim","sikh","christian","other"};
        JComboBox religion=new JComboBox(valreligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);


    
      JLabel fname=new JLabel("Catagory:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,100,30);
        add(fname);   

         
      String valcatagory[]={"General","Obc","St","Other"};
      JComboBox catagory=new JComboBox(valcatagory);
        catagory.setBounds(300,190,400,30);
        catagory.setBackground(Color.WHITE);
        add(catagory);
         

        JLabel gender=new JLabel("Income:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,240,200,30);
        add(gender);

    
String incomecatagory[]={"Null","<1,50,000","<2,50,000","<5,00,000","upto 10,00,000"};
      JComboBox income=new JComboBox(incomecatagory);
       income.setBounds(300,240,400,30);
       income.setBackground(Color.white);
       add(income);

        JLabel email=new JLabel("Educational:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,290,200,30);
        add(email);
       JLabel marital=new JLabel("Qualifiation:");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,315,200,30);
        add(marital);

        String educationvalue[]={"Non-Graduate","Graduate","Post-Graduate","Doctrate","Other"};
      JComboBox education=new JComboBox(educationvalue);
       education.setBounds(300,290,400,30);
       education.setBackground(Color.white);
       add(education);
         
       

        JLabel Adress=new JLabel("Occupation:");
        Adress.setFont(new Font("Raleway",Font.BOLD,20));
        Adress.setBounds(100,370,200,30);
        add(Adress);

            String Occupationvalue[]={"salaried","self-employed","Business","Doctor","Student","Other"};
      JComboBox Occupation=new JComboBox(Occupationvalue);
       Occupation.setBounds(300,370,400,30);
       Occupation.setBackground(Color.white);
       add(Occupation);
        

        JLabel city=new JLabel("Pan number:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,440,200,30);
        add(city);

        Pan=new JTextField();
        Pan.setFont(new Font("Raleway",Font.BOLD,14));
        Pan.setBounds(300,440,400,30);
        add(Pan);

        JLabel state=new JLabel("Aadhar Number:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,490,200,30);
        add(state);

        aadhar=new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,14));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);

        
        JLabel pin=new JLabel("Senior citizen:");
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(100,540,200,30);
        add(pin);

        syes=new JRadioButton("Yes");
        syes.setFont(new Font("Raleway",Font.BOLD,14));
        syes.setBounds(300,540,100,30);
        add(syes);

          sno=new JRadioButton("No");
        sno.setFont(new Font("Raleway",Font.BOLD,14));
        sno.setBounds(450,540,100,30);
        add(sno);

        ButtonGroup emaritalgroup=new ButtonGroup();
        emaritalgroup.add(syes);
        emaritalgroup.add(sno);


         next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(640,600,80,30);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(Color.white);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    public signuptwo() {
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        String formno=""+ random;
        String sreligion=(String) religion.getSelectedItem();
         String scatagory=(String) catagory.getSelectedItem();
        String sincome=(String) income.getSelectedItem();
        String seducation=(String) education.getSelectedItem();
        String soccupation=(String) occupation.getSelectedItem();
        

       
       //String gender=null;

       String sPan=Pan.getText();
       String saadhar=aadhar.getText();
      // String state=stateTextField.getText();
      // String pin=pinTextField.getText();
       
  
       String seniorcitzen=null;
      if(syes.isSelected()){
        seniorcitzen="Yes";
       }
       else if(sno.isSelected()){
        seniorcitzen="No";
       }

       try{
       
        if(religion.equals(" ")) {
          JOptionPane.showMessageDialog(null,"All the fields are required");
      }
      else{
            conn c = new conn();
            String q1 = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scatagory+"','"+sincome+"','"+seducation+"','"+soccupation+"', '"+sPan+"','"+saadhar +"','"+seniorcitzen+"')";

            c.s.executeUpdate(q1);
      }
            
            
            //setVisible(false);
           // new signuptwo(formno).setVisible(true);
        
     //signup3object
     setVisible(false);
     new signupthree(formno).setVisible(true);
       }catch(Exception e) {
        System.out.println(e);
       }
    
    }
         public static void main(String args[]){
        new signuptwo("");
}
}
