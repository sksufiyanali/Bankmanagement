
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;


public class signupone extends JFrame implements ActionListener {

    long random;
    JTextField nameTextField,fnameTextField,coutryTextField,emailTextField,AdressTextField,cityTextField,pinTextField,stateTextField;
    JButton next;
    JRadioButton male,female,other,unmarried;
    JRadioButton married;
    signupone(){
        setLayout(null);

        Random ran=new Random();
        random=Math.abs((ran.nextLong() % 9000L) + 1000L);
        
        JLabel formno=new JLabel("APPLICATION FORM NO."+ random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
             formno.setBounds(140,20,600,40);
             add(formno);

              JLabel personaldetails=new JLabel("Page 1:personal Details");
              personaldetails.setFont(new Font("Raleway",Font.BOLD,22));
              personaldetails.setBounds(290,80,400,30);
              add(personaldetails);

        JLabel name=new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

        nameTextField=new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);

         JLabel fname=new JLabel("Father's name:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);

        fnameTextField=new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(300,190,400,30);
        add(fnameTextField);
         

        JLabel gender=new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,240,200,30);
        add(gender);

       male=new JRadioButton("Male");
       male.setBounds(300,240,60,30);
       male.setBackground(Color.white);
       add(male);

       female=new JRadioButton("Female");
       female.setBounds(450,240,120,30);
       female.setBackground(Color.white);
       add(female);

       ButtonGroup gendergroup=new ButtonGroup();
       gendergroup.add(male);
       gendergroup.add(female);

        JLabel email=new JLabel("Email Adress:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,290,200,30);
        add(email);
        
        emailTextField=new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(300,290,400,30);
        add(emailTextField);

       /* 
       
       
       
       
       
       
       
       
       JLabel marital=new JLabel("Marital statues:");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,340,200,30);
        add(marital);
         
        
       married=new JRadioButton("Married");
       married.setBounds(300,340,100,30);
       married.setBackground(Color.white);
       add(married);

       unmarried=new JRadioButton("Unmarried");
       unmarried.setBounds(450,340,100,30);
       unmarried.setBackground(Color.white);
       add(unmarried);

       other=new JRadioButton("Other");
       other.setBounds(630,340,100,30);
       other.setBackground(Color.white);
       add(other);

       ButtonGroup maritalgroup=new ButtonGroup();
       maritalgroup.add(married);
       maritalgroup.add(unmarried);
       maritalgroup.add(other);*/
       

        JLabel Adress=new JLabel("Adress:");
        Adress.setFont(new Font("Raleway",Font.BOLD,20));
        Adress.setBounds(100,390,200,30);
        add(Adress);

        AdressTextField=new JTextField();
        AdressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        AdressTextField.setBounds(300,390,400,30);
        add(AdressTextField);

        JLabel city=new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,440,200,30);
        add(city);

        cityTextField=new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300,440,400,30);
        add(cityTextField);

        JLabel state=new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,490,200,30);
        add(state);

        stateTextField=new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300,490,400,30);
        add(stateTextField);

        
        JLabel pin=new JLabel("Pincode:");
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(100,540,200,30);
        add(pin);

        pinTextField=new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pinTextField.setBounds(300,540,400,30);
        add(pinTextField);

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
    @Override
    public void actionPerformed(ActionEvent ae) {
        String formno=""+ random;
        String name=nameTextField.getText();
       String fname= fnameTextField.getText();
       String gender=null;

      if(male.isSelected()) {
        gender="male";
       }else if(female.isSelected()){
        gender="female";
       }
     String email= emailTextField.getText();
     //JRadioButton marital=null;
      //if(married.isSelected()){
      /*   marital=married;
       }
       else if(unmarried.isSelected()){
        marital=unmarried;
       }
       else if(other.isSelected()){
        marital=other;
       }*/
       String Adress=AdressTextField.getText();
       String city=cityTextField.getText();
       String state=stateTextField.getText();
       String pin=pinTextField.getText();
       try{
        if(name.equals(" ")) {
            JOptionPane.showMessageDialog(null,"Name is required");
        }
        else{
            conn c = new conn();
            String q1 = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+gender+"','"+email+"','"+Adress+"','"+city+"','"+pin+"','"+state+"')";
            c.s.executeUpdate(q1);

           setVisible(false);
            new signuptwo(formno).setVisible(true);
            
            //setVisible(false);
            //new signupone().setVisible(true);
            
        }

       }catch(Exception e) {
        System.out.println(e);
       }
    
    }
         public static void main(String args[]){
        new signuptwo(" ");
}
}
