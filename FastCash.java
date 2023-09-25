import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.util.Date;

import java.sql.*;

import com.mysql.cj.protocol.Resultset;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FastCash extends JFrame implements ActionListener{
   JButton deposit,withdrawl,ministatement,pinchange,fastcash,balance,exit;
   String pinnumber;
    FastCash(String pinnumber){
      this.pinnumber=pinnumber;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,800,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,750);
        add(image);

        JLabel text=new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(210,280,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

         deposit=new JButton("Rs 100");
        deposit.setBounds(150,340,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

          withdrawl=new JButton("Rs 500");
        withdrawl.setBounds(355,340,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

          fastcash=new JButton("Rs 1000");
        fastcash.setBounds(150,370,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);

            ministatement=new JButton("Rs 2000");
        ministatement.setBounds(355,370,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);

            pinchange=new JButton("Rs 5000");
        pinchange.setBounds(150,400,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);

         balance=new JButton("Rs 10000");
        balance.setBounds(355,400,150,30);
        balance.addActionListener(this);
        image.add(balance);

        exit=new JButton("Back");
        exit.setBounds(355,430,150,30);
        exit.addActionListener(this);
        image.add(exit);



    

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }
    private void add(Jlabel text) {
    }
   @Override
   public void actionPerformed(ActionEvent ae) {
      if(ae.getSource()==exit) {
         System.exit(0);
         setVisible(false);
         new Transaction(pinnumber).setVisible(true);
      }else {
        String amount=((JButton)ae.getSource()).getText().substring(3);
        conn c=new conn();
        try{
        
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            } 
            
            if (ae.getSource() != exit && balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insufficent Balance");
                return;
            }
        Date date=new Date();
        String query="insert into bank values('"+pinnumber+"','"+date+"', 'withdrawl''"+amount+"')";
        c.s.executeUpdate(query);
        JOptionPane.showMessageDialog(null,"Rs"+amount+"Debited sucessfully");
    
         setVisible(false);
        new Transaction(pinnumber).setVisible(true);

    }catch(Exception e) {
         System.out.println(e);
        }
      }
      
   }
       public static void main(String args[]){
        new FastCash(" ");

    }
}
