package com.auth;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;

public class Register implements ActionListener{
      // [[id], ["name"], ["role"] ["password"]] 
    public static String[][] user = {
        {"1", "nuel",  "cashier", "123"},
        {"2", "frans",  "manager", "123"},
        {"3", "rafael",  "cashier", "123"}
    };

    JFrame frame = new JFrame();

    JLabel registerLabel = new JLabel();
    JLabel usernameLabel = new JLabel();
    JLabel passwordLabel = new JLabel();

    JTextField usernameTextField = new JTextField();
    JTextField passwordTextField = new JTextField();
    

    JButton button = new JButton("Register");

    JMenuBar menuBar = new JMenuBar();

    JMenu authMenu = new JMenu("Auth");
    JMenuItem loginItem = new JMenuItem("Login");
    JMenuItem registerItem = new JMenuItem("Register");


    public Register(){
        this.frame.setJMenuBar(this.menuBar);
        this.menuBar.add(this.authMenu);

        this.authMenu.add(this.loginItem);
        this.authMenu.add(this.registerItem);

        this.registerLabel.setText("Register");
        this.usernameLabel.setText("Username : ");
        this.passwordLabel.setText("Password : ");

        this.registerLabel.setBounds(0,0,100,30);
        this.usernameLabel.setBounds(0,40,100,30);
        this.passwordLabel.setBounds(0,80,100,30);
        this.usernameTextField.setBounds(120,40,150,25);
        this.passwordTextField.setBounds(120,80,150,25);
        this.button.setBounds(120,130,150,25);

        this.button.addActionListener(this);
        this.loginItem.addActionListener(this);

        this.frame.add(this.button);
        this.frame.add(this.usernameTextField);
        this.frame.add(this.passwordTextField);
        this.frame.add(this.registerLabel);
        this.frame.add(this.usernameLabel);
        this.frame.add(this.passwordLabel);

        this.frame.setSize(300,300);
        this.frame.setResizable(false);
        this.frame.setLayout(null);
        this.frame.setVisible(true);

    }

       public void actionPerformed(ActionEvent e){
           if(e.getSource() == this.button){
                 try{
                     System.out.println("hello");
                     int counter = 0;

                    FileReader fileReader = new FileReader("users-database.txt");
                    BufferedReader bufferedReader = new BufferedReader(fileReader);

                    bufferedReader.mark(200);

                    String eachLine = bufferedReader.readLine();

                    while(eachLine != null){
                        String[] splittedEachLine = eachLine.split(",");

                        if(splittedEachLine[1].equals(this.usernameTextField.getText())){
                            System.out.println("Username u entered is exist!");

                            this.frame.dispose();
                        }
                        counter++;
                        eachLine = bufferedReader.readLine();
                    }



                    FileWriter fileWriter = new FileWriter("users-database.txt", true);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                    String newUserLine = (counter + 1) + "," + this.usernameTextField.getText() + "," + this.passwordTextField.getText() + "," + "cashier";

                    bufferedWriter.newLine();
                    bufferedWriter.write(newUserLine);
                    bufferedWriter.flush();

                    this.frame.dispose();
                }catch(Exception error){
                    System.err.println(error);
                }
           }

           if(e.getSource() == this.loginItem){
               this.frame.dispose();

               new Login();
           }
       }
    
}
