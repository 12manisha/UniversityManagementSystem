package universitymanagementsystem;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;

public class TeacherLeaveDetail extends JFrame implements ActionListener {

    Choice crollno;
    JTable table;
    JButton search , print,cancel;

    public TeacherLeaveDetail() {
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
            ResultSet rs = c.stmt.executeQuery("SELECT * FROM teacherleave");
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
                
        cancel = new JButton("Cancel");
        cancel.setBounds(220,70,80,20);
        add(cancel);
        cancel.addActionListener(this);

        setSize(900, 700);
        setLocationRelativeTo(null);
        setTitle("Student Leave Details");
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent evt)
    {
        Object obj = evt.getSource();
        
        if(obj == search)
        {
            String query = "Select * from teacherleave where empid= '"+ crollno.getSelectedItem() +"' ";
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
        else if(obj == cancel)
        {
            setVisible(false);
        }
        
    }

    public static void main(String[] args) {
        new TeacherLeaveDetail();
    }
}
