package login;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class Main {

    public static void main(String[] args) {
            //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
                createAndShowGUI();
//            }
//        });
    }
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add the ubiquitous "Hello World" label.
        final JLabel username = new JLabel("Username");
        final JTextField user = new JTextField();
        final JLabel password = new JLabel("Password");
        final JPasswordField pass = new JPasswordField();
        final JButton login = new JButton("Login");
        final JLabel status = new JLabel();
        final JPanel statuspanel = new JPanel();
        final JPanel ContainerPanel = new JPanel(new GridLayout(4,4));
        
        login.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                status.setText("Wait");
                try{
                    String u = user.getText();
                    String p = pass.getText();
                    
                    Class.forName("org.postgresql.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BloodBank","postgres","postgresql");
                     PreparedStatement rs = connection.prepareStatement("select * from donor where username='"+u+"' and password='"+p+"'");
                    ResultSet rsa = rs.executeQuery();
                    boolean check=rsa.next();
                    if(check)
                        status.setText("Correct");
                    else
                        status.setText("Incorrect");
            
                }
                catch(Exception ex){
                    ex.fillInStackTrace();
                }
                System.out.println("Button Click");
            }
        });
        frame.getContentPane().setLayout(new GridLayout(2,1));
        frame.getContentPane().add(ContainerPanel);
        ContainerPanel.add(username);
        ContainerPanel.add(user);
        ContainerPanel.add(password);
        ContainerPanel.add(pass);
        ContainerPanel.add(login);
        ContainerPanel.add(login);
        frame.getContentPane().add(statuspanel);
        statuspanel.add(status);
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

}
