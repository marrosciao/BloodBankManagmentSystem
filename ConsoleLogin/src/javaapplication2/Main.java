package javaapplication2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{
            Class.forName("org.postgresql.Driver");
            
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BloodBank","postgres","postgresql");
            Scanner scanner = new Scanner(System.in);
            String username = scanner.next();
            String password = scanner.next();
            PreparedStatement rs = connection.prepareStatement("select * from donor where username='"+username+"' and password='"+password+"'");
            ResultSet rsa = rs.executeQuery();
            boolean login=rsa.next();
            if(login)
                System.out.println("You Are an Authenticated User");
            else
                System.out.println("You Are not an Authenticated User");
            
        }catch(Exception exp){
        System.out.println(exp.fillInStackTrace());
        }
    }

}
