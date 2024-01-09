/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package universitymanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
/**
 *
 * @author INDIA
 */
public class TeacherLeave extends JFrame implements ActionListener {
    
    Choice crollno , ctime;
    JDateChooser dcdate;
    JButton submit, cancel;
    
    TeacherLeave()
    {
        setSize(500,550);
        setLocation(550,100);
        setLayout(null);
        
        JLabel heading = new JLabel("Apply Leave");
        heading.setBounds(40,50,300,30);
        heading.setFont(new Font("Tahoma", Font.BOLD,20));
        add(heading);
        
        JLabel lblrollno = new JLabel("Search By Employee Id");
        lblrollno.setBounds(60, 100, 200, 20);
        lblrollno.setFont(new Font("Tahoma", Font.PLAIN,18));
        add(heading);

        crollno = new Choice();
        crollno.setBounds(60, 130, 200, 200);
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
        
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60,180,200,20);
        lbldate.setFont(new Font("Taboma",Font.PLAIN,18));
        add(lbldate);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(60,210,200,30);
        add(dcdate);
        
        JLabel lbltime = new JLabel("Time Duration");
        lbltime.setBounds(60,260,150,20);
        lbltime.setFont(new Font("Taboma", Font.PLAIN,18));
        add(lbltime);
        
        ctime = new Choice();
        ctime.setBounds(60,290,200,20);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);
        
        submit = new JButton("Submit");
        submit.setBounds(60,350,100,25);
        add(submit);
        submit.addActionListener(this);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(200,350,100,25);
        add(cancel);
        cancel.addActionListener(this);
         
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent evt)
    {
        Object obj = evt.getSource();
        
        if(obj == submit)
        {
            String empid = crollno.getSelectedItem();
            String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            String duration = ctime.getSelectedItem();
            
            String query = "insert into teacherleave values('"+empid+"','"+date+"','"+duration+"' ) ";
            try{
                Conn c = new Conn();
                c.stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Leave Confirmed");
                setVisible(false);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        else if(obj == cancel)
        {
            setVisible(false);
        }
    }
    
    public static void main(String args[])
    {
         new TeacherLeave();
    }
}
