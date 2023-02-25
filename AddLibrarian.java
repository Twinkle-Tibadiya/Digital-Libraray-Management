package Library;
import java.awt.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.event.ActionListener;

public class AddLibrarian extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JButton bt1,bt2;
    JPanel p1,p2;
    JTextField tf1,tf2,tf3,tf4,tf5;
    JPasswordField pf1;
    Font f,f1;
            
    AddLibrarian() 
    {
        super("Add Libraraian");
        setLocation(450,400);
        setSize(450,400);
        
        f=new Font("Arial",Font.BOLD,25);
        f1=new Font("Arial",Font.BOLD,20);
        
        JLabel l1=new JLabel("Add Librarian");
        l1.setForeground(Color.WHITE);
        l1.setHorizontalAlignment(JLabel.CENTER);
        JLabel l2=new JLabel("Name");
        JLabel l3=new JLabel("Password");
        JLabel l4=new JLabel("Email");
        JLabel l5=new JLabel("Contact");
        JLabel l6=new JLabel("Address");
        JLabel l7=new JLabel("City");
        
        tf1=new JTextField();
        tf2=new JTextField();
        tf3=new JTextField();
        tf4=new JTextField();
        tf5=new JTextField();
        pf1=new JPasswordField();
        
        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        l6.setFont(f1);
        l7.setFont(f1);
        
        tf1.setFont(f1);
        tf2.setFont(f1);
        tf3.setFont(f1);
        tf4.setFont(f1);
        tf5.setFont(f1);
        pf1.setFont(f1);
        
        bt1=new JButton("Add Librarian");
        bt2=new JButton("Cancel");
        
        bt1.setFont(f1);
        bt2.setFont(f1);
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
       
        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);
        p1.setBackground(Color.BLUE);
        
        p2=new JPanel();
        p2.setLayout(new GridLayout(7,2,10,10));
        
        p2.add(l2);
        p2.add(tf1);
        p2.add(l3);
        p2.add(pf1);
        p2.add(l4);
        p2.add(tf2);
        p2.add(l5);
        p2.add(tf3);
        p2.add(l6);
        p2.add(tf4);
        p2.add(l7);
        p2.add(tf5);
        p2.add(bt1);
        p2.add(bt2);
        
        setLayout(new BorderLayout(10,10));//gap between p1 and p2
        add(p1,"North");
        add(p2,"Center");
    }
       
        
           
   public void actionPerformed(ActionEvent e)
   {
       String name=tf1.getText();
       String pass=pf1.getText();
       String email=tf2.getText();
       String contact=tf3.getText();
       String add=tf4.getText();
       String city=tf5.getText();

      if(e.getSource()==bt1)
      {
          try
          {
            ConnectionClass obj=new ConnectionClass();
            String q="insert into Librarian (name,password,email,contact,address,city) values('"+name+"','"+pass+"','"+email+"','"+contact+"','"+add+"','"+city+"')";
            int aa=obj.stm.executeUpdate(q);
            if(aa==1)
            {
                JOptionPane.showMessageDialog(null,"Your data successfully inserted");
                this.setVisible(false);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Please!,Fill all detail carefully");
                this.setVisible(true);
            }
          }
          catch(HeadlessException | SQLException ee)
          {
          }
      }
      if(e.getSource()==bt2)
      {
                   this.setVisible(false);
      }
   }
        public static void main(String args[])
        {
             new AddLibrarian().setVisible(true);
        }

    static class setVisible {

        public setVisible(boolean b) {
        }
    }
}

      

