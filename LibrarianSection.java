package Library;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Font;
public class LibrarianSection extends JFrame implements ActionListener{

    JLabel l1;
    JPanel p1,p2;
    Font f,f1;
    JButton bt1;
    
    LibrarianSection() 
    {
        super("Librarian Section");
        setLocation(0,0);
        setSize(1500,800);
        
        f=new Font("Arial",Font.BOLD,25);
        f1=new Font("Arial",Font.BOLD,20);
        
        ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("Library/icon/lilaptop.jpg"));
        Image img=ic.getImage().getScaledInstance(1500,800,Image.SCALE_DEFAULT);
        ImageIcon ic1=new ImageIcon(img);
        l1=new JLabel(ic1);
        
        JMenuBar m1=new JMenuBar();
        JMenu men1=new JMenu("Add Info");
        JMenuItem ment1=new JMenuItem("Add Book");
        
        JMenu men2=new JMenu("View Info");
        JMenuItem ment2=new JMenuItem("View Book");
        JMenuItem ment22=new JMenuItem("View Issue Book");
        
        JMenu men3=new JMenu("Issue Info");
        JMenuItem ment3=new JMenuItem("Issue Book");
        
        JMenu men4=new JMenu("Return");
        JMenuItem ment4=new JMenuItem("Return Book");
        
        JMenu men5=new JMenu("Exit");
        JMenuItem ment5=new JMenuItem("Logout");
        
        men1.add(ment1);
        men2.add(ment2);
        men2.add(ment22);
        men3.add(ment3);
        men4.add(ment4);
        men5.add(ment5);
        
        m1.add(men1);
        m1.add(men2);
        m1.add(men3);
        m1.add(men4);
        m1.add(men5);
         
        ment1.setFont(f1);
        ment2.setFont(f1);
        ment22.setFont(f1);
        ment3.setFont(f1);
        ment4.setFont(f1);
        ment5.setFont(f1);
        
        men1.setFont(f1);
        men2.setFont(f1);
        ment3.setFont(f1);
        ment4.setFont(f1);
        men5.setFont(f1);
        
        ment1.addActionListener(this);
        ment2.addActionListener(this);
        ment3.addActionListener(this);
        ment4.addActionListener(this);
        ment5.addActionListener(this);
        
        setMenuBar(m1);
        add(l1);
              
      }
    

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    public void actionPerformed(ActionEvent e) 
    {
        String comd=e.getActionCommand();
        if(comd.equals("Add Book"))
        {
            new AddBook().setVisible(true);
        }
        else if(comd.equals("View Book"))
        {
            new ViewBook().setVisible(true);
        }
        else if(comd.equals("Issue Book"))
        {            
            new IssueBook().setVisible(true);
        }
        else if(comd.equals("Return Book"))
        {
            new ReturnBook().setVisible(true);
        }
        else if(comd.equals("Exit"))
        {
            System.exit(0);
        }
    }

    private void setMenuBar(JMenuBar m1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
