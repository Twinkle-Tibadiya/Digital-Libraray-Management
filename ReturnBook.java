package Library;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.awt.Color;
import java.awt.Font;
public class ReturnBook extends JFrame implements ActionListener{

    JLabel l1,l2,l3;
    JPanel p1,p2;
    Font f,f1;
    JButton bt1,bt2;
    JTextField tf1,tf2;
    
    ReturnBook() 
    {
        super("Return Book");
        setLocation(0,0);
        setSize(650,400);
        
        f=new Font("Arial",Font.BOLD,25);
        f1=new Font("Arial",Font.BOLD,20);
        
        l1=new JLabel("Return Book");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setForeground(Color.WHITE);
        
        l2=new JLabel("Book No");
        tf1=new JTextField();
        
        l3=new JLabel("Student Id");
        tf2=new JTextField();
        
        l1.setFont(f);
        l2.setFont(f1);
        tf1.setFont(f1);
        
        l3.setFont(f1);
        tf2.setFont(f1);
        
        bt1=new JButton("Return Book");
        bt2=new JButton("Cancel");
        
        bt1.setFont(f1);
        bt2.setFont(f1);
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);
        
        p2=new JPanel();
        p2.setLayout(new GridLayout(3,2,10,10));
        p2.add(l2);
        p2.add(tf1);
        p2.add(l3);
        p2.add(tf2);
        p2.add(bt1);
        p2.add(bt2);
        
        setLayout(new BorderLayout(10,10));
        add(p1,"North");
        add(p2,"Center");
        }
    public void actionPerformed(ActionEvent e)
    {
        String bookno=tf1.getText();
        int stuid=Integer.parseInt(tf2.getText());
        
        if(e.getSource()==bt1)
        {
            try
            {
            ConnectionClass obj=new ConnectionClass();
            String q="delete from issuebook where bookbo='"+bookno+"' and studentid='"+stuid+"'";
            int rest=obj.stm.executeUpdate(q);
            if(rest==0)
            {
                JOptionPane.showMessageDialog(null,"Book did not issued");
                this.setVisible(false);
            }
            else
            {
               String q1="update addbook set issuebook=issuebook-1 where bookbo='"+bookno+"'";
               String q2="update addbook set quantity=quantity+1 where bookno='"+bookno+"'";
               int aa=obj.stm.executeUpdate(q1);
               int aaa=obj.stm.executeUpdate(q2);
               if(aa==1)
               {
                   if(aaa==1)
                   {
                       JOptionPane.showMessageDialog(null,"Your book successfully updated");
                       this.setVisible(false);
                   }
                   else
                   {
                       JOptionPane.showMessageDialog(null,"Please ! Fill all details carefully");
                   }
                   }
                   else
                   {
                           JOptionPane.showMessageDialog(null,"Please ! Fill all detail carefully");
                   }
            }  
            }
             catch(Exception ee)
            {
                ee.printStackTrace();
            }
        }
        if(e.getSource()==bt2)
        {
            JOptionPane.showMessageDialog(null,"Are you sure!");
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new ReturnBook().setVisible(true);
    }
}