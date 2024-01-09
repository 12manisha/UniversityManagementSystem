package universitymanagementsystem;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    JButton login;
    JButton close;
    JTextField tfusername,tfpassword;
    
    Login() {
        setLayout(null); 

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 20, 100, 20);
        tfusername = new JTextField(15);
        tfusername.setBounds(150, 20, 150, 20);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 70, 100, 20);
        tfpassword = new JPasswordField(15);
        tfpassword.setBounds(150, 70, 150, 20);

        login = new JButton("Login");
        login.setBounds(40, 140, 120, 30);
        
        close = new JButton("Close");
        close.setBounds(180, 140, 120, 30);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);

        add(lblusername);
        add(tfusername);
        add(lblpassword);
        add(tfpassword);
        add(login);
        add(close);
        add(image);
        
        login.addActionListener(this);
        close.addActionListener(this);

        setSize(600, 300); 
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent evt)
    {
        Object obj = evt.getSource();
        
        if(obj == login)
        {
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            String query = "Select * from login where username = '"+username+"' and password = '"+password+"' ";
            
            try{
                Conn c = new Conn();
                ResultSet rs = c.stmt.executeQuery(query);
                
                if(rs.next())
                {
                    setVisible(false);
                    new Project();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid");
                }
            }catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        else if(obj == close)
        {
            setVisible(false);
        }
    }

    public static void main(String args[]) {
        new Login();
    }
}
