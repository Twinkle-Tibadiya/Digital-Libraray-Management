package Library;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Font;

public class DeleteLibrarian extends JFrame implements ActionListener{

    String x[]= {"id","name","password","email","contact","address","city"};
    JButton bt1;
    JLabel l1;
    String y[][]=new String[20][7];
    int i=0,j=0;
    JTable t;
    JTextField tf1;
    JPanel p1;
    Font f;
    
   DeleteLibrarian()
   {
       super("Delete Librarian");
       setLocation(1,1);
       setSize(1000,400);
       
       f=new Font("Arial",Font.BOLD,25);
       try
       {
           ConnectionClass obj=new ConnectionClass();
           String q="select * from librarian";
           ResultSet rst=(ResultSet) obj.stm.executeQuery(q);
           while(rst.next())
           {
               y[i][j++]=rst.getString("lid");
               y[i][j++]=rst.getString("name");
               y[i][j++]=rst.getString("password");
               y[i][j++]=rst.getString("email");
               y[i][j++]=rst.getString("address");
               y[i][j++]=rst.getString("city");
               i++;
               j=0;
           }
           t=new JTable(y,x);
           t.setFont(f);                   
       }
       catch(Exception ee)
       {
           ee.printStackTrace();
       }
       JScrollPane sp=new JScrollPane();
             
       l1=new JLabel("Delete Librarian");
       tf1=new JTextField();
       bt1=new JButton("Delete");
       bt1.addActionListener(this);
       
       l1.setFont(f);
       tf1.setFont(f);
       bt1.setFont(f);
       
       p1=new JPanel();
       p1.setLayout(new GridLayout(1,3,10,10));
       p1.add(l1);
       p1.add(tf1);
       p1.add(bt1);
       
       setLayout(new BorderLayout(10,10));
       add(sp,"Center");
       add(p1,"South");
    }
    public static void main(String[] args) {
        new DeleteLibrarian().setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt1)
        {
            int id=Integer.parseInt(tf1.getText());
            try
            {
                ConnectionClass obj=new ConnectionClass();
                String q="delete from librarian where lid='"+id+"'";
                int res=obj.stm.executeUpdate(q);
                if(res==1)
                {
                    JOptionPane.showMessageDialog(null,"Your data successfully deleted");
                    this.setVisible(false);
                    new DeleteLibrarian().setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Your data did not successfully deleted");
                    this.setVisible(false);
                    new DeleteLibrarian().setVisible(true);
                }
                
            }
            catch(Exception ee)
            {
                ee.printStackTrace();
            }
        }
    }

    static class setVisible {

         public setVisible(boolean b) {
        }
    }
}
