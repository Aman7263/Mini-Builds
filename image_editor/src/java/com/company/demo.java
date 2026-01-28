package java.com.company;
//import static com.company.login.AddLoginPage;
import edu.cmu.relativelayout.BindingFactory;
import edu.cmu.relativelayout.RelativeConstraints;
import edu.cmu.relativelayout.RelativeLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.plaf.ActionMapUIResource;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.text.AttributeSet.ColorAttribute;

import static com.company.login.AddLoginPage;


public class demo {

        public static void main(String[] args) {

            JFrame objWindow = new JFrame();


            JTabbedPane objTabPane = new JTabbedPane();

            RelativeLayout objRelativeLayout = new RelativeLayout();
            BindingFactory bf = new BindingFactory();



            JButton objButton = new JButton("Start Editing.....");
            JPanel objPanel = new JPanel(objRelativeLayout);
            bf.setLeftMargin(bf.getLeftMargin() + 800);
            bf.setTopMargin(bf.getTopMargin() + 500);



            objButton.setBackground(Color.GREEN);
            objPanel.setBackground(new ColorUIResource(19,101,107));




            objPanel.add(objButton, new RelativeConstraints(bf.leftEdge(), bf.topEdge()));


            JButton objButton1 = new JButton("Premium usersssss.....");
            bf.setLeftMargin(bf.getLeftMargin() - 50);
            bf.setTopMargin(bf.getTopMargin() - 500);

            objPanel.add(objButton1, new RelativeConstraints(bf.leftEdge(), bf.topEdge()));
            objTabPane.add("Home222222", objPanel);

            objButton1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    objPanel.removeAll();
                    objPanel.invalidate();
                    objPanel.repaint();
                    AddLoginPage(objPanel);
                }

            });


            objWindow.setSize(1200,900);
            objWindow.add(objTabPane);
            objWindow.setVisible(true);

        }

    }

