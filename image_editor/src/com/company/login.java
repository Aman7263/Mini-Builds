package com.company;
//113
import edu.cmu.relativelayout.BindingFactory;
import edu.cmu.relativelayout.RelativeConstraints;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class login {

    static String strUserName = "";
    static String strPassword = "";


    public static void AddLoginPage(JPanel objPanel){

        objPanel.setBackground(new ColorUIResource(19,101,107));


        JLabel objLabel = new JLabel("UserName");
        objLabel.setFont(new Font("arial",Font.BOLD,20));


        JLabel objPassword = new JLabel("Password");
        objPassword.setFont(new Font("arial",Font.BOLD,20));

        JTextField objusernametextfield = new JTextField("      ");
        JPasswordField objpasswordtextfield = new JPasswordField();



        JButton objLoginButton = new JButton("Login");
        objLoginButton.setBackground(Color.cyan);

        objLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                strUserName = objusernametextfield.getText();
                strPassword = objpasswordtextfield.toString();
                System.out.println(" Login button Clicked!!! the value in user name text filed "+strUserName +" password is "+strPassword);
                ConnectToServerAndCheckForUserPresent();

            }
        });



        JButton objResetButton = new JButton("Reset");
        objResetButton.setBackground(Color.cyan);

        objResetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("reset button clicked");
            }
        });

       /* objResetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                objusernametextfield.setText(toString());
                objpasswordtextfield.setText(toString());
            }
        });
*/
        JButton objSignUpButton = new JButton("Sign Up");
        objSignUpButton.setBackground(Color.cyan);

        objSignUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                objPanel.removeAll();
                objPanel.invalidate();
                objPanel.repaint();

                ShowSignUpPage(objPanel);


            }
        });


        JButton objbacktoHomebutton = new JButton("Back to Home Page");
        objbacktoHomebutton.setBackground(Color.cyan);

        objbacktoHomebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                objPanel.removeAll();
                objPanel.invalidate();
                objPanel.repaint();

                AddLoginPage(objPanel);
            }
        });

        JLabel objintro = new JLabel("Hello Users, welcome to our Software if you are new please Sign Up First..");
        objintro.setFont(new Font("arial",Font.BOLD,10));


        BindingFactory objBindingFactory = new BindingFactory();

        objPanel.add(objintro,new RelativeConstraints(objBindingFactory.leftEdge(),objBindingFactory.topEdge()));

        objPanel.add(objLabel,new RelativeConstraints(objBindingFactory.below(objintro),objBindingFactory.leftEdge()));
        objBindingFactory.setHorizontalSpacing(40);
        objBindingFactory.setVerticalSpacing(20);

        objPanel.add(objPassword,new RelativeConstraints(objBindingFactory.leftEdge(),objBindingFactory.below(objLabel)));

        objPanel.add(objusernametextfield,new RelativeConstraints(objBindingFactory.rightOf(objLabel),objBindingFactory.below(objintro)));
        objusernametextfield.setColumns(15);

        objPanel.add(objpasswordtextfield,new RelativeConstraints(objBindingFactory.rightOf(objPassword),objBindingFactory.below(objusernametextfield)));
        objpasswordtextfield.setColumns(15);

        objPanel.add(objLoginButton,new RelativeConstraints(objBindingFactory.leftEdge(), objBindingFactory.below(objpasswordtextfield)));

        objPanel.add(objResetButton,new RelativeConstraints(objBindingFactory.rightOf(objLoginButton), objBindingFactory.below(objpasswordtextfield)));

        objPanel.add(objSignUpButton,new RelativeConstraints(objBindingFactory.leftEdge(),objBindingFactory.below(objLoginButton)));

        objPanel.add(objbacktoHomebutton,new RelativeConstraints(objBindingFactory.rightOf(objSignUpButton),objBindingFactory.below(objResetButton)));




    }
    static String username;
    static String address;
    static String password;
    static JFrame objFrame;
    public static void ShowSignUpPage(JPanel objPanel){



        JLabel objUserNameLable = new JLabel("UserName");
        objUserNameLable.setFont(new Font("arial",Font.BOLD,20));

        JTextField objUserNameText = new JTextField();

        JLabel objPasswordLable = new JLabel("Password");
        objPasswordLable.setFont(new Font("arial",Font.BOLD,20));

        JTextField objPasswordText = new JTextField();


        JButton objSignUpbutton = new JButton("Register");
        objSignUpbutton.setBackground(Color.cyan);



        JButton objResetButton1 = new JButton("Reset");
        objResetButton1.setBackground(Color.cyan);

        objResetButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                objUserNameText.setText("");
                objPasswordText.setText("");
            }
        });

        objSignUpbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                username = objUserNameText.getText();
                password = objPasswordText.getText();

                System.out.println(" username is "+username+" password is "+password);
                SignUpDataWithServer(objPanel);
            }
        });

        JButton objbacktologinbutton = new JButton("Back to login page");
        objbacktologinbutton.setBackground(Color.cyan);

        objbacktologinbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                objPanel.removeAll();
                objPanel.invalidate();
                objPanel.repaint();

                AddLoginPage(objPanel);
            }
        });
        BindingFactory objBindingFactory = new BindingFactory();

        objPanel.add(objUserNameLable,new RelativeConstraints(objBindingFactory.leftEdge(),objBindingFactory.topEdge()));
        objPanel.add(objPasswordLable,new RelativeConstraints(objBindingFactory.rightOf(objUserNameLable),objBindingFactory.topEdge()));
        objBindingFactory.setHorizontalSpacing(50);
        objBindingFactory.setVerticalSpacing(30);

        objPanel.add(objUserNameText,new RelativeConstraints(objBindingFactory.rightOf(objUserNameLable),objBindingFactory.topEdge()));
        objUserNameText.setColumns(15);
        objPanel.add(objPasswordText,new RelativeConstraints(objBindingFactory.rightOf(objPasswordLable),objBindingFactory.below(objUserNameText)));
        objPasswordText.setColumns(15);

        objPanel.add(objSignUpbutton,new RelativeConstraints(objBindingFactory.below(objPasswordLable),objBindingFactory.topEdge()));
        objPanel.add(objResetButton1,new RelativeConstraints(objBindingFactory.rightOf(objSignUpbutton),objBindingFactory.topEdge()));
        objPanel.add(objbacktologinbutton,new RelativeConstraints(objBindingFactory.rightOf(objSignUpbutton),objBindingFactory.below(objResetButton1)));




    }

    public static void SignUpDataWithServer(JPanel objPanel){
        try {
            URL objURL = new URL("http://localhost/signup.php?username="+username+"&password="+password);
            URLConnection objConnection = objURL.openConnection();//Open connection with server

            InputStream objInputStream = objConnection.getInputStream();


            //Login is Ok
            BufferedReader objBufferedReader = new BufferedReader(new InputStreamReader(objInputStream));

            String strLineFRomServer = objBufferedReader.readLine();



            System.out.println(strLineFRomServer);

            JOptionPane.showMessageDialog(objPanel,"New user registered Register sucessful");
            objPanel.removeAll();
            objPanel.invalidate();
            objPanel.repaint();

            AddLoginPage(objPanel);


        }catch(Exception e){
            System.out.println("Error is "+e.toString());
        }

    }
    public static void ConnectToServerAndCheckForUserPresent(){
        ///// Connect to server
        try {
            URL objURL = new URL("http://localhost/login.php?username="+strUserName+"&password="+strPassword);
            URLConnection objConnection = objURL.openConnection();

            InputStream objInputStream = objConnection.getInputStream();



            BufferedReader objBufferedReader = new BufferedReader(new InputStreamReader(objInputStream));

            String strLineFRomServer = objBufferedReader.readLine();

            if(strLineFRomServer.contains("failed")){
                JOptionPane.showMessageDialog(objFrame,"Login failed. New user please signup!!!");
            }else if(strLineFRomServer.contains("Sucess")){
                JOptionPane.showMessageDialog(objFrame,"Login sucessful");
            }


            System.out.println(strLineFRomServer);


        }catch(Exception e){
            System.out.println("Error is "+e.toString());
        }

    }




    }
