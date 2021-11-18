package com.auth;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Login implements ActionListener{

  

    JFrame frame = new JFrame();

    JLabel loginLabel = new JLabel();
    JLabel usernameLabel = new JLabel();
    JLabel passwordLabel = new JLabel();

    JTextField usernameTextField = new JTextField();
    JTextField passwordTextField = new JTextField();

    JButton button = new JButton("Login");

    JMenuBar menuBar = new JMenuBar();

    JMenu authMenu = new JMenu("Auth");
    JMenuItem loginItem = new JMenuItem("Login");
    JMenuItem registerItem = new JMenuItem("Register");


    public Login(){
        this.loginLabel.setText("Login");
        this.usernameLabel.setText("Username : ");
        this.passwordLabel.setText("Password : ");

        this.loginLabel.setBounds(0,0,100,30);
        this.usernameLabel.setBounds(0,40,100,30);
        this.passwordLabel.setBounds(0,80,100,30);
        this.usernameTextField.setBounds(120,40,150,25);
        this.passwordTextField.setBounds(120,80,150,25);
        this.button.setBounds(120,130,150,25);

        this.button.addActionListener(this);
        this.registerItem.addActionListener(this);


        this.frame.setJMenuBar(this.menuBar);
        this.menuBar.add(this.authMenu);

        this.authMenu.add(this.loginItem);
        this.authMenu.add(this.registerItem);
      
        this.frame.add(this.button);
        this.frame.add(this.usernameTextField);
        this.frame.add(this.passwordTextField);
        this.frame.add(this.loginLabel);
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
                    FileReader fileReader = new FileReader("users-database.txt");
                    BufferedReader bufferedReader = new BufferedReader(fileReader);

                    bufferedReader.mark(200);

                    String eachLine = bufferedReader.readLine();

                    while(eachLine != null){
                        String[] splittedEachLine = eachLine.split(",");

                        if(splittedEachLine[1].equals(this.usernameTextField.getText()) && splittedEachLine[2].equals(this.passwordTextField.getText())){
                            System.out.println("Anda berhasil login");
                        }

                        eachLine = bufferedReader.readLine();
                    }

                }catch(IOException error){
                    System.err.println(error);
                }

            }   

            if(e.getSource() == this.registerItem){
                this.frame.dispose();

                new Register();
            }


       }
    
}
