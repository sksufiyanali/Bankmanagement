import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PinChange extends JFrame implements ActionListener{
  JPasswordField pin,repin;
  JButton change,back;  
  String pinnumber;
  
  PinChange(String pinnumber){
        setLayout(null);
        this.pinnumber=pinnumber;

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 800, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 900, 750);
        add(image);

        JLabel text=new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("system",Font.BOLD,16));
        text.setBounds(250,240,500,35);
        image.add(text);


          JLabel pintext=new JLabel("ENTER PIN");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("system",Font.BOLD,16));
        pintext.setBounds(165,320,180,25);
        image.add(pintext);

         pin=new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,16));
        pin.setBounds(330,320,180,25);
        image.add(pin);

             JLabel repintext=new JLabel("RE-ENTER NEW PIN");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("system",Font.BOLD,16));
        repintext.setBounds(165,360,180,25);
        image.add(repintext);

           repin=new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,16));
        repin.setBounds(330,360,180,25);
        image.add(repin);

         change=new JButton("CHANGE");
        change.setBounds(355,400,150,30);
        change.addActionListener(this);
        image.add(change);

           back=new JButton("BACK");
        back.setBounds(355,430,150,30);
        back.addActionListener(this);
        image.add(back);



        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
      if(ae.getSource()==change){
      try{
        String npin=pin.getText();
        String rpin=repin.getText();
        if(!npin.equals(rpin)){
          JOptionPane.showMessageDialog(null,"Entered pin does not match");
          return;
        }
      if(npin.equals(" ")){
          JOptionPane.showMessageDialog(null, "please enter the pin");
          return;
      }
      if(rpin.equals(" ")) {
         JOptionPane.showMessageDialog(null,"please enter the repin");
         return;
      }
      conn conn=new conn();

      String q1 = "update bank set pin = '"+rpin+"' where pin = '"+pin+"' ";
      String q2 = "update login set pin = '"+rpin+"' where pin = '"+pin+"' ";
      String q3 = "update signup3 set pin = '"+rpin+"' where pin = '"+pin+"' ";

               conn.s.executeUpdate(q1);
                conn.s.executeUpdate(q2);
                conn.s.executeUpdate(q3);
                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transaction(rpin).setVisible(true);

    
      }
catch(Exception e){
        System.out.println(e);
      }
    }
   else {
      setVisible(false);
      new Transaction(pinnumber).setVisible(true);
    }
    }

    public static void main(String args[]){
        new PinChange(" ").setVisible(true);
    }
  } 
  
