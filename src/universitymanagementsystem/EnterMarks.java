/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package universitymanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
/**
 *
 * @author INDIA
 */
public class EnterMarks extends JFrame implements ActionListener {
    
    Choice crollno;
    JButton submit, cancel;
    JComboBox cbsemester;
    JTextField tfsub1,tfsub2, tfsub3,tfsub4, tfsub5, tfmark1, tfmark2, tfmark3, tfmark4, tfmark5;
            
    EnterMarks()
    {
        setSize(1000,500);
        setLocation(300,150);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,40,400,300);
        add(image);
        
        JLabel heading = new JLabel("Enter Marks of Student");
        heading.setBounds(50, 0, 500, 50);
        heading.setFont(new Font("Tahoma", Font.ITALIC, 20));
        add(heading);
        
        JLabel lblrollnumber = new JLabel("Select Roll Number");
        lblrollnumber.setBounds(50, 70, 150, 20);
        add(lblrollnumber);
        
        crollno = new Choice();
        crollno.setBounds(200, 70, 150, 20);
        add(crollno);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.stmt.executeQuery("select * from student");
            while(rs.next()) {
                crollno.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        JLabel lblsemester = new JLabel("Select Semester");
        lblsemester.setBounds(50,110,150,20);
        add(lblsemester);
        
        String semester[] = {"1st Semester" , "2nd Semester", "3rd Semester","4th Semester","5th Semester","6th Semester","7th Semester","8th Semester" };
        cbsemester = new JComboBox(semester);
        cbsemester.setBounds(200,110,150,20);
        add(cbsemester);
        
        JLabel lblentersubject = new JLabel("Select Subject");
        lblentersubject.setBounds(100,150,200,40);
        add(lblentersubject);
        
        JLabel lblentermarks = new JLabel("Enter Marks");
        lblentermarks.setBounds(320,150,200,40);
        add(lblentermarks);
        
        tfsub1 = new JTextField();
        tfsub1.setBounds(50,200,200,20);
        add(tfsub1);
        tfsub2 = new JTextField();
        tfsub2.setBounds(50,230,200,20);
        add(tfsub2);
        tfsub3 = new JTextField();
        tfsub3.setBounds(50,260,200,20);
        add(tfsub3);
        tfsub4 = new JTextField();
        tfsub4.setBounds(50,290,200,20);
        add(tfsub4);
        tfsub5 = new JTextField();
        tfsub5.setBounds(50,320,200,20);
        add(tfsub5);
        
        tfmark1 = new JTextField();
        tfmark1.setBounds(250,200,200,20);
        add(tfmark1);
        tfmark2 = new JTextField();
        tfmark2.setBounds(250,230,200,20);
        add(tfmark2);
        tfmark3 = new JTextField();
        tfmark3.setBounds(250,260,200,20);
        add(tfmark3);
        tfmark4 = new JTextField();
        tfmark4.setBounds(250,290,200,20);
        add(tfmark4);
        tfmark5 = new JTextField();
        tfmark5.setBounds(250,320,200,20);
        add(tfmark5);
        
        submit = new JButton("Submit");
        submit.setBounds(70, 360, 150, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(280, 360, 150, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent evt)
    {
        Object obj = evt.getSource();
        
        if(obj == submit)
        {
            try{
                
                Conn c = new Conn();
                
                String query1 = "insert into subject values('"+crollno.getSelectedItem()+"','"+cbsemester.getSelectedItem()+"' , '"+tfsub1.getText()+"', '"+tfsub2.getText()+"', '"+tfsub3.getText()+"', '"+tfsub4.getText()+"', '"+tfsub5.getText()+"' ) ";
                String query2 = "insert into marks values('"+crollno.getSelectedItem()+"','"+cbsemester.getSelectedItem()+"' , '"+tfmark1.getText()+"', '"+tfmark2.getText()+"', '"+tfmark3.getText()+"', '"+tfmark4.getText()+"', '"+tfmark5.getText()+"' ) ";
                
                c.stmt.executeUpdate(query1);
                c.stmt.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "Marks successfully inserted");
                setVisible(false);
            
            
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
    
    
    public static void main(String args[])
    {
        new EnterMarks();
    }
}
