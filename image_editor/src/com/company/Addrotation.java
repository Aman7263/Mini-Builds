package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Addrotation extends Main {

    public  Addrotation(){
        JFrame frame = new JFrame("Rotation Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            final BufferedImage bi = ImageIO.read(new File(path));


            frame.add(new JLabel() {

                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(bi.getWidth(), bi.getHeight());
                }

                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2 = (Graphics2D) g;
                    g2.rotate(Math.PI / 2 , bi.getWidth() / 2, bi.getHeight() / 2);//pi----180,pi/2-rotate 90 degree,pi/2*3----270 degree,pi/2*4------360degree
                    g2.drawImage(bi, 0, 0, null);
                }
            });
        }catch (Exception e4){
           System.out.println("error "+e4);
        }
        frame.setSize(1600,900);
        //frame.pack();
        frame.setVisible(true);
    }

}
