//package java.com.company;

import edu.cmu.relativelayout.BindingFactory;
import edu.cmu.relativelayout.RelativeConstraints;
import edu.cmu.relativelayout.RelativeLayout;
//import jdk.internal.org.jline.reader.Widget;

import java.awt.Color;
import java.awt.Font;
import java.text.NumberFormat.Style;
import java.util.jar.Attributes.Name;

//import java.awt.Font;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import javax.swing.*;
//import javax.swing.plaf.ActionMapUIResource;
import javax.swing.plaf.ColorUIResource;
//import javax.swing.plaf.DimensionUIResource;
//import javax.swing.text.AttributeSet.ColorAttribute;
import javax.swing.plaf.FontUIResource;



public class Main{

    public static void main(String[] args) {

        JFrame objWindow = new JFrame();


        JTabbedPane objTabPane = new JTabbedPane();

        RelativeLayout objRelativeLayout = new RelativeLayout();
        BindingFactory bf = new BindingFactory();
        JPanel objPanel = new JPanel(objRelativeLayout);

        JLabel objintro = new JLabel("IMAGE EDITOR..");
        objintro.setBackground(Color.DARK_GRAY);
        objintro.setSize(23,42);
        bf.setLeftMargin(bf.getLeftMargin() + 20);
        bf.setTopMargin(bf.getTopMargin() + 20);

        objPanel.add(objintro, new RelativeConstraints(bf.leftEdge(), bf.topEdge()));


        JButton objButton = new JButton("Start Editing.....");

        bf.setLeftMargin(bf.getLeftMargin() + 800);
        bf.setTopMargin(bf.getTopMargin() + 500);



        objButton.setBackground(Color.GREEN);
        objPanel.setBackground(new ColorUIResource(19,101,107));




        objPanel.add(objButton, new RelativeConstraints(bf.leftEdge(), bf.topEdge()));


        JButton objButton1 = new JButton("Premium users11111.....");
        bf.setLeftMargin(bf.getLeftMargin() - 50);
        bf.setTopMargin(bf.getTopMargin() - 500);

        objPanel.add(objButton1, new RelativeConstraints(bf.leftEdge(), bf.topEdge()));
        objTabPane.add("Home1111", objPanel);




        objWindow.setSize(900,900);
        objWindow.add(objTabPane);
        objWindow.setVisible(true);

    }

}

