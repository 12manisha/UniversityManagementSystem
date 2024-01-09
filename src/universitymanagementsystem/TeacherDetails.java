package universitymanagementsystem;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;

public class TeacherDetails extends JFrame implements ActionListener {

    Choice crollno;
    JTable table;
    JButton search , print, update, add, cancel;

    public TeacherDetails() {
        setLayout(null);

        JLabel heading = new JLabel("Search By Employee Id");
        heading.setBounds(60, 20, 250, 20);
        heading.setFont(new Font("Tahoma", Font.BOLD,15));
        add(heading);

        crollno = new Choice();
        crollno.setBounds(250, 20, 150, 20);
        add(crollno);

        try {
            Conn c = new Conn();
            ResultSet rs = c.stmt.executeQuery("SELECT * FROM teacher");
            while (rs.next()) {
                crollno.add(rs.getString("empid"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        table = new JTable();
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);

        try {
            Conn c = new Conn();
            ResultSet rs = c.stmt.executeQuery("SELECT * FROM teacher");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        add(search);
        search.addActionListener(this);
        
        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        add(print);
        print.addActionListener(this);
        
        update = new JButton("Update");
        update.setBounds(220,70,80,20);
        add(update);
        update.addActionListener(this);
                
        add = new JButton("Add");
        add.setBounds(320,70,80,20);
        add(add);
        add.addActionListener(this);
                
        cancel = new JButton("Cancel");
        cancel.setBounds(420,70,80,20);
        add(cancel);
        cancel.addActionListener(this);

        setSize(900, 700);
        setLocationRelativeTo(null);
        setTitle("Teacher Details");
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent evt)
    {
        Object obj = evt.getSource();
        
        if(obj == search)
        {
            String query = "Select * from teacher where empid = '"+ crollno.getSelectedItem() +"' ";
            try{
                Conn c = new Conn();
                ResultSet rs = c.stmt.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        else if(obj == print)
        {
            try{
                table.print();
            }catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        else if(obj == add)
        {
            setVisible(false);
            new AddTeacher();
        }
        else if(obj == update)
        {
            setVisible(false);
            new UpdateStudent();
        }
        else if(obj == cancel)
        {
            setVisible(false);
        }
        
    }

    public static void main(String[] args) {
        new TeacherDetails();
    }
}
