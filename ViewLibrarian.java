package Library;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.Font;
import javax.swing.*;

        
public class ViewLibrarian extends JFrame{

    String x[]={"lid","name","passowrd","email","contact","address","city"};
    JButton bt;
    String y[][]=new String[20][7];
    int i=0,j=0;
    JTable t;
    Font f,f1;
    
    ViewLibrarian()
    {
        super("View Librarian");
        setLocation(1,1);
        setSize(1000,400);
        
        f=new Font("Arial",Font.BOLD,25);
        f1=new Font("Arial",Font.BOLD,20);
        
        try
        {
         ConnectionClass obj=new ConnectionClass();
         String q="select * librarian";
         ResultSet rest=(ResultSet) obj.stm.executeQuery(q);
        while(rest.next())
        {
            y[i][j++]=rest.getString("lid");
            y[i][j++]=rest.getString("name");
            y[i][j++]=rest.getString("password");
            y[i][j++]=rest.getString("email");
            y[i][j++]=rest.getString("contact");
            y[i][j++]=rest.getString("address");
            y[i][j++]=rest.getString("city");
            i++; //row increment
            j=0; //new column    
        }
        t=new JTable(y,x);
        t.setFont(f);
      }
        catch(Exception ee)
        {
            ee.printStackTrace();
        }
    
    JScrollPane sp=new JScrollPane(t);
    add(sp);
    }
    public static void main(String[] args) 
    {
     new ViewLibrarian().setVisible(true);
     
    }

    static class setVisible {

        public setVisible(boolean b) {
        }
    }
}
