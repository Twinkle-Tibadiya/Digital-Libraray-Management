package Library;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
public class ViewBook extends JFrame{

    String x[]={"id","bookno","bookname","author","publisher","quantity","issuebook","date"};
    String y[][]=new String[20][7];
    JButton bt1;
    JTable t;
    Font f,f1;
    int i=0,j=0;
    
    ViewBook() 
    {
        super("View Book");
        setLocation(1,1);
        setSize(1000,400);
        
        f=new Font("Arial",Font.BOLD,25);
        f1=new Font("Arial",Font.BOLD,20);
        
        try
        {
            ConnectionClass obj=new ConnectionClass();
            String q="select * from addbook";
            ResultSet rest=(ResultSet) obj.stm.executeQuery(q);
            while(rest.next())
            {
                y[i][j++]=rest.getString("id");
                y[i][j++]=rest.getString("bookno");
                y[i][j++]=rest.getString("bookname");
                y[i][j++]=rest.getString("author");
                y[i][j++]=rest.getString("publisher");
                y[i][j++]=rest.getString("quantity");
                y[i][j++]=rest.getString("issuebook");
                y[i][j++]=rest.getString("date");
                
                i++;
                j=0;
            }
            t=new JTable(y,x);
            t.setFont(f);
        }
        catch(Exception e)
        {
        e.printStackTrace();
        }
        }
    public static void main(String[] args) {
        new ViewBook().setVisible(true);
    }
   
}

    
   
    
