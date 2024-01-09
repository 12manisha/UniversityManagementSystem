/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package universitymanagementsystem;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.awt.*;
/**
 *
 * @author INDIA
 */
public class AddStudent extends JFrame implements ActionListener {
    
    JTextField tfname , tffname , tfaddress, tfphoneno , tfx , tfxii, tfemail,tfaadhar;
    JLabel labelrollno;
    JDateChooser dcdob;
    JComboBox cbcourse,cbbranch;
    JButton submit,cancel;
    
    Random ran = new Random();
    int random = ran.nextInt(900) + 100;
    
    AddStudent()
    {
        setSize(900,600);
        setLocation(350,50);
        setLayout(null);
        
        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("Tahoma", Font.BOLD,20));
        add(heading);
        
        JLabel lblname = new JLabel("Student Name");
        lblname.setBounds(50,150,100,30);
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);
        
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(400,150,200,30);
        add(lblfname);
        
        tffname = new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);
        
        JLabel lblrollno = new JLabel("Roll No.");
        lblrollno.setBounds(50,200,200,30);
        add(lblrollno);
        
        labelrollno = new JLabel("2116"+random);
        labelrollno.setBounds(200,200,200,30);
        add(labelrollno);
        
        JLabel lbldob = new JLabel("Date Of Birth");
        lbldob.setBounds(400,200,200,30);
        add(lbldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(600,200,150,30);
        add(dcdob);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50,250,100,30);
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);
        
        JLabel lblphoneno = new JLabel("Phone No.");
        lblphoneno.setBounds(400,250,100,30);
        add(lblphoneno);
        
        tfphoneno = new JTextField();
        tfphoneno.setBounds(600,250,150,30);
        add(tfphoneno);
        
        JLabel lblx = new JLabel("X Marks");
        lblx.setBounds(50,300,100,30);
        add(lblx);
        
        tfx = new JTextField();
        tfx.setBounds(200,300,150,30);
        add(tfx);
        
        JLabel lblxii = new JLabel("XII Marks");
        lblxii.setBounds(400,300,100,30);
        add(lblxii);
        
        tfxii = new JTextField();
        tfxii.setBounds(600,300,150,30);
        add(tfxii);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(50,350,100,30);
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200,350,150,30);
        add(tfemail);
        
        JLabel lblaadhar = new JLabel("Aadhar No.");
        lblaadhar.setBounds(400,350,100,30);
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(600,350,150,30);
        add(tfaadhar);
        
        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(50,400,100,30);
        add(lblcourse);
        
        String course[] = {"BTech","BBA","BCA","Bsc","Msc","MBA","MCA","MA","BA","MCom"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(200,400,150,30);
        add(cbcourse);
        
        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(400,400,100,30);
        add(lblbranch);
        
        String branch[] = {"CSE","Civil","ECE","EEE","IT"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(600,400,150,30);
        add(cbbranch);
        
        submit = new JButton("Submit");
        submit.setBounds(250,470,150,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        add(submit);
        submit.addActionListener(this);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(450,470,150,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        add(cancel);
        cancel.addActionListener(this);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent evt)
    {
        Object obj = evt.getSource();
        
        if(obj == submit)
        {
            String name = tfname.getText();
            String fname = tffname.getText();
            String rollno = labelrollno.getText();
            String dob = ( (JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tfphoneno.getText();
            String email = tfemail.getText();
            String x = tfx.getText();
            String xii = tfxii.getText();
            String aadhar = tfaadhar.getText();
            String course = (String) cbcourse.getSelectedItem();
            String branch = (String) cbbranch.getSelectedItem();
            
            try{
                String query = "insert into student values ( '"+ name +"' ,'"+ fname +"' , '"+ rollno +"' ,'"+ dob +"' ,'"+ address +"' ,'"+ phone +"' ,'"+ email +"' ,'"+ x +"' ,'"+ xii +"' ,'"+ aadhar +"' ,'"+ course +"' ,'"+ branch +"'  ) " ;
                Conn con = new Conn();
                con.stmt.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Student Detail inserted successfully ");
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
        new AddStudent();
    }
}
