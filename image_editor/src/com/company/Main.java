package com.company;

import edu.cmu.relativelayout.BindingFactory;
import edu.cmu.relativelayout.RelativeConstraints;
import edu.cmu.relativelayout.RelativeLayout;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Main {
    public static String path;

        public static void main(String[] args) {

            JFrame objWindow = new JFrame(); //creating window


            JTabbedPane objTabPane = new JTabbedPane();

            RelativeLayout objRelativeLayout = new RelativeLayout();
            BindingFactory bf = new BindingFactory();

            ImageIcon objimageicon = new ImageIcon("D:\\image_editor\\res\\image editor.png");
            JLabel objjlabel = new JLabel(objimageicon);

            JButton objButton = new JButton("Start Editing.....");
            objButton.setPreferredSize(new Dimension(200,50));
            JPanel objPanel = new JPanel(objRelativeLayout);
            bf.setLeftMargin(bf.getLeftMargin() + 800);
            bf.setTopMargin(bf.getTopMargin() + 500);

            objButton.setBackground(Color.GREEN);
            objPanel.setBackground(new Color(19,101,107));
            objPanel.add(objjlabel,new RelativeConstraints(bf.directlyAbove(objButton)));

objButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Start Button Clicked");
//
//        objPanel.removeAll();
//        objPanel.invalidate();
//        objPanel.repaint();
//       // objTabPane.removeAll();
//        JPanel objpanel1 = new JPanel();
//      //  JTabbedPane objTabPane2 = new JTabbedPane();
//        BindingFactory bf = new BindingFactory();
//
//       // objTabPane2.add("Start Your Editing...",objPanel);
//
//       // BindingFactory objBindingFactory = new BindingFactory();
//
//        JButton objbutton3 =new JButton("Back To Home Page");
//        objpanel1.add(objbutton3,new RelativeConstraints(bf.rightEdge(),bf.topEdge()));
//        JButton objbrowsebutton = new JButton("Browse image");
//        objpanel1.add(objbrowsebutton,new RelativeConstraints(bf.topEdge(),bf.leftEdge()));
//
//objbutton3.addActionListener(new ActionListener() {
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        System.out.println("Back button clicked ");
//
//    }
//});

        //objWindow.add(objpanel1);
        JFrame objframe = new JFrame("Image Editor");

        JLabel objLabel = new JLabel();


        RelativeLayout objrelativelayout = new RelativeLayout();
        BindingFactory objbindingfactory = new BindingFactory();
        JPanel objpanel = new JPanel(objrelativelayout);
        ImageIcon objrotateimageicon = new ImageIcon("D:\\ImageEditor\\res\\icons8-rotate-right-96.png", "ROTATE\n");
        JButton objrotatebutton = new JButton("\nROTATE", objrotateimageicon);
        objrotatebutton.setBackground(Color.WHITE);
        objrotatebutton.setFont(new Font("Tahoma", Font.BOLD, 12));
        JButton objbrowsefilebutton = new JButton("Browse Image");
        objbrowsefilebutton.setBackground(Color.WHITE);
        objbrowsefilebutton.setFont(new Font("Tahoma", Font.BOLD, 13));
        JButton mirrorbutton = new JButton("Mirror Image");
        mirrorbutton.setBackground(Color.WHITE);
        mirrorbutton.setFont(new Font("Tahoma", Font.BOLD, 13));
        JButton Cropbutton = new JButton("Crop");
        Cropbutton.setBackground(Color.WHITE);
        Cropbutton.setFont(new Font("Tahoma", Font.BOLD, 13));
        objframe.getContentPane().add(objbrowsefilebutton);
        objbrowsefilebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

             System.out.println("Browsing image is ongoing");
                JFileChooser file = new JFileChooser();
                file.setCurrentDirectory(new File(System.getProperty("user.home")));
                //filter the files
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
                file.addChoosableFileFilter(filter);
                int result = file.showOpenDialog(null);
                //if the user click on save in Jfilechooser
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = file.getSelectedFile();
                    path = selectedFile.getAbsolutePath();
                    objLabel.setIcon(new ImageIcon(path));

                } else if (result == JFileChooser.CANCEL_OPTION) {
                    System.out.println("No File Select");
                }

            }

        });
        objrotatebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Image rotation in processing");
                new Addrotation();

            }
        });
        mirrorbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Flip image");
                frame.add(new Addmirroring());
                System.out.println("Displayed Mirror Image");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(1600, 900);
                frame.setVisible(true);
            }
        });

        Cropbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Crop in progress.... and completed");
                JFrame frame = new Addcrop();
                frame.setSize(400, 300);
                frame.show();
            }
        });



        objpanel.add(objbrowsefilebutton, new RelativeConstraints(objbindingfactory.topEdge(), objbindingfactory.leftEdge()));
        objbrowsefilebutton.setPreferredSize(new Dimension(150, 40));
        objpanel.add(objrotatebutton, new RelativeConstraints(objbindingfactory.leftEdge(), objbindingfactory.below(objbrowsefilebutton)));
        objrotatebutton.setPreferredSize(new Dimension(150, 40));
        objpanel.add(mirrorbutton, new RelativeConstraints(objbindingfactory.leftEdge(),objbindingfactory.below(objrotatebutton)));
        mirrorbutton.setPreferredSize(new Dimension(150, 40));
        objpanel.add(Cropbutton, new RelativeConstraints(objbindingfactory.leftEdge(),objbindingfactory.below(mirrorbutton)));
        Cropbutton.setPreferredSize(new Dimension(150, 40));
        objpanel.add(objLabel, new RelativeConstraints(objbindingfactory.topEdge(), objbindingfactory.rightOf(objrotatebutton)));
        objframe.add(objpanel);

        objframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        objframe.setSize(1600, 900);
        objframe.setVisible(true);

    }
});


            objPanel.add(objButton, new RelativeConstraints(bf.leftEdge(), bf.topEdge()));

            JButton objButton1 = new JButton("Premium users.....");
            // JPanel objPanel1 = new JPanel(objRelativeLayout);
            bf.setLeftMargin(bf.getLeftMargin() - 50);
            bf.setTopMargin(bf.getTopMargin() - 500);

            objPanel.add(objButton1, new RelativeConstraints(bf.leftEdge(), bf.topEdge()));

            //action perfrom to the premium button

            objButton1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("premium button clicked");


                    ////// this is the button ok sir
                    //ye q essa ho raha tha
                    // Kyunki ab got it yes sir
                    // any other issue yes sir
                    //sir login page maine alag banaya hai ussko main me kese add kere issue aa jaa raha hai
                    // Ok


                    //for removing all element in the home

                    objPanel.removeAll();
                    objPanel.invalidate();
                    objPanel.repaint();
                    objTabPane.removeAll();


                    //for tab of premium users

                    JTabbedPane objTabPane1 = new JTabbedPane();
                    RelativeLayout objRelativeLayout1 = new RelativeLayout();
                    BindingFactory bf = new BindingFactory();

                    //for adding two java file
                    login objLogin = new login();
                    objLogin.AddLoginPage(objPanel);


                    objTabPane1.add("Premium users...",objPanel);





                    objWindow.add(objTabPane1);


                }
            });


            objTabPane.add("Home",objPanel);





            objWindow.setSize(1200,900);
            objWindow.add(objTabPane);

            objWindow.setVisible(true);

        }

    }

