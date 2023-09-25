import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener{
   JButton deposit,withdrawl,ministatement,pinchange,fastcash,balance,exit;
   String pinnumber;
    Transaction(String pinnumber){
      this.pinnumber=pinnumber;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,800,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,750);
        add(image);

        JLabel text=new JLabel("Please Selet Your Transaction");
        text.setBounds(210,280,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

         deposit=new JButton("Deposit");
        deposit.setBounds(150,340,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

          withdrawl=new JButton("Withdrawl");
        withdrawl.setBounds(355,340,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

          fastcash=new JButton("Fastcash");
        fastcash.setBounds(150,370,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);

            ministatement=new JButton("Ministatement");
        ministatement.setBounds(355,370,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);

            pinchange=new JButton("Pinchange");
        pinchange.setBounds(150,400,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);

         balance=new JButton("Balance enquery");
        balance.setBounds(355,400,150,30);
        balance.addActionListener(this);
        image.add(balance);

        exit=new JButton("Exit");
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
      }else if(ae.getSource()==deposit){
        setVisible(false);
        new Deposit(pinnumber).setVisible(true);
      }
      else if(ae.getSource()==withdrawl){
        setVisible(false);
        new withdrawl(pinnumber).setVisible(true);
      }
      else if(ae.getSource()==fastcash){
        setVisible(false);
        new FastCash(pinnumber).setVisible(true);
      }
      else if(ae.getSource()==pinchange){
        setVisible(false);
        new PinChange(pinnumber).setVisible(true);
      }
      else if(ae.getSource()==balance){
        setVisible(false);
        new BalanceEnquiry(pinnumber).setVisible(true);
      }
      else if(ae.getSource()==ministatement){
       // setVisible(false);
        new Ministatement(pinnumber).setVisible(true);
      }
      
   }
       public static void main(String args[]){
        new Transaction(" ");

    }
}