import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener{
    JButton back;
    String pinnumber;
    BalanceEnquiry(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 800, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 900, 750);
        add(image);

        back=new JButton("Back");
        back.setBounds(355,430,150,30);
        back.addActionListener(this);
        image.add(back);
        
        int balance=0;
        conn c=new conn();
        try{
        
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while (rs.next()) {
                if (rs.getString("mode").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            } 
        }catch(Exception e){
            System.out.println(e);
        }
        JLabel text=new JLabel("Your Account Balance is Rs"+balance);
        text.setForeground(Color.WHITE);
        text.setBounds(170,250,400,30);
        image.add(text);
    
        

    
    setSize(900,900);
    setLocation(300, 0);
    setUndecorated(true);
    setVisible(true);
        
}
public static void main(String args[]){
    new BalanceEnquiry(" ");

}
@Override
public void actionPerformed(ActionEvent ae) {
    setVisible(false);
    new Transaction(pinnumber).setVisible(true);

}
}
