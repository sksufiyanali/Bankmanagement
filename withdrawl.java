
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;

public class withdrawl extends JFrame implements ActionListener {

    JTextField amount;
    JButton withdraw,back;
    String pinnumber;

    withdrawl(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,800,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,750);
        add(image);

        JLabel text=new JLabel("Enter the amout you want to Withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("system",Font.BOLD,16));
        text.setBounds(170,250,400,20);
        image.add(text);

         amount=new JTextField();
        text.setFont(new Font("Raleway",Font.BOLD,25));
        amount.setBounds(170,300,340,25);
        image.add(amount);

         withdraw=new JButton("Withdraw");
        withdraw.setBounds(355,400,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);

         back=new JButton("Back");
        back.setBounds(355,435,150,30);
        back.addActionListener(this);
        image.add(back);

        
        
  

        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==withdraw){
            String number=amount.getText();
            Date date=new Date();
            if(number.equals(" ")) {
                JOptionPane.showMessageDialog(null,"Please enter the amount you have to withdraw");
            }else{
                try{
                conn conn=new conn();
                String query="insert into bank values('"+pinnumber+"','"+date+"','withdrawl','"+number+"')";
                
               conn.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Rs "+number+"Withdraw Sucessfully");
                SetVisible(false);
                new Transaction(pinnumber).setVisible(true);
                
            } catch (SQLException e) {
                    System.out.println(e);
                }

            }

        }else if(ae.getSource()==back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);

        }
        
    }
       private void SetVisible(boolean b) {
    }
    public static void main(String args[]){
        new withdrawl(" ");

        

    }
}
