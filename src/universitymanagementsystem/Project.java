/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package universitymanagementsystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author INDIA
 */
public class Project extends JFrame implements ActionListener {
    
    Project()
    {
        setSize(1540,850);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(600, 100, 100, 100);

        setLayout(null);

        JLabel heading = new JLabel("<html>University<br/>Management System  </html>");
        heading.setBounds(70, 50, 400, 200);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);
        
        JLabel name = new JLabel("<html> Developed By: Manisha Joshi <br/>  &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp BV'25 </html>");
        name.setBounds(70, 200, 600, 200);
        name.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(name);
        
        JMenuBar mb = new JMenuBar();
        
        //NEW INFORMATION
        
        JMenu newinformation = new JMenu("New Information");       
        mb.add(newinformation);
        
        JMenuItem facultyinfo = new JMenuItem("New Faculty Information");
        newinformation.add(facultyinfo);
        facultyinfo.addActionListener(this);
        
        JMenuItem studentinfo = new JMenuItem("New Student Information");
        newinformation.add(studentinfo);
        studentinfo.addActionListener(this);
        
        //DETAILS

        JMenu details = new JMenu("View Details");       
        mb.add(details);
        
        JMenuItem facultydetails = new JMenuItem("View Faculty Details");
        details.add(facultydetails);
        facultydetails.addActionListener(this);
        
        JMenuItem studentdetails = new JMenuItem("View Student Details");
        details.add(studentdetails);
        studentdetails.addActionListener(this);
        
        //LEAVE

        JMenu leave = new JMenu("Apply Leave");       
        mb.add(leave);
        
        JMenuItem facultyleave = new JMenuItem("Faculty Leave");
        leave.add(facultyleave);
        facultyleave.addActionListener(this);
        
        
        JMenuItem studentleave = new JMenuItem("Student Leave");
        leave.add(studentleave);
        studentleave.addActionListener(this);
        
        //LEAVE DETAILS
        
        JMenu leaveDetails = new JMenu("Leave Details");       
        mb.add(leaveDetails);
        
        JMenuItem facultyleavedetails = new JMenuItem("Faculty Leave Details");
        leaveDetails.add(facultyleavedetails);
        facultyleavedetails.addActionListener(this);
        
        JMenuItem studentleavedetails = new JMenuItem("Student Leave Details");
        leaveDetails.add(studentleavedetails);
        studentleavedetails.addActionListener(this);
        
        //EXAMS
        
        JMenu exam = new JMenu("Examination");       
        mb.add(exam);
        
        JMenuItem examinationdetails = new JMenuItem("Examination Details");
        exam.add(examinationdetails);
        examinationdetails.addActionListener(this);
        
        JMenuItem enterMarks = new JMenuItem("Enter Marks");
        exam.add(enterMarks);
        enterMarks.addActionListener(this);
        
        //UPDATE INFO
        
        JMenu updateinfo = new JMenu("Update Details");       
        mb.add(updateinfo);
        
        JMenuItem updatefacultyinfo = new JMenuItem("Update Faculty Details");
        updateinfo.add(updatefacultyinfo);
        updatefacultyinfo.addActionListener(this);
        
        JMenuItem updatestudentinfo = new JMenuItem("Update Student Details");
        updateinfo.add(updatestudentinfo);
        updatestudentinfo.addActionListener(this);
        
        // FEE DETAILIS
        JMenu fee = new JMenu("Fee Details");       
        mb.add(fee);
        
        JMenuItem feestructure = new JMenuItem("Fee Structure");
        fee.add(feestructure);
        feestructure.addActionListener(this);
        
        JMenuItem feeform = new JMenuItem("Student fee form");
        fee.add(feeform);
        feeform.addActionListener(this);
        
        //EXIT
        
        JMenu exit = new JMenu("Exit");
        mb.add(exit);
        
        JMenuItem ex = new JMenuItem("Exit");
        ex.addActionListener(this);
        exit.add(ex);
        
        setJMenuBar(mb);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent evt)
    {
        String msg = evt.getActionCommand();
        
        if(msg.equals("Exit"))
            setVisible(false);
        
        else if(msg.equals("New Faculty Information"))
            new AddTeacher();
        
        else if(msg.equals("New Student Information"))
            new AddStudent();
        
        else if(msg.equals("View Faculty Details"))
            new TeacherDetails();
        else if(msg.equals("View Student Details"))
            new StudentDetails();
        
        else if(msg.equals("Faculty Leave"))
            new TeacherLeave();
        else if(msg.equals("Student Leave"))
            new StudentLeave();
        
        else if(msg.equals("Faculty Leave Details"))
            new TeacherLeaveDetail();
        else if(msg.equals("Student Leave Details"))
            new StudentLeaveDetail();
        
        else if(msg.equals("Update Faculty Details"))
            new UpdateTeacher();
        else if(msg.equals("Update Student Details"))
            new UpdateStudent();
        
        else if(msg.equals("Enter Marks"))
            new EnterMarks();
        else if(msg.equals("Examination Details"))
            new ExaminationDetails();
        
        else if(msg.equals("Fee Structure"))
            new FeeStructure();
        else if(msg.equals("Student fee form"))
            new StudentFeeForm();
        
        
    }
    
    public static void main(String args[])
    {
        new Project();
    }
}
