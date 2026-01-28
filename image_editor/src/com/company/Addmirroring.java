package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class Addmirroring extends JPanel{

    public void paint(Graphics g) {
        Image myImage = new ImageIcon("D:\\ImageEditor\\res\\Walpaper2.jpg").getImage();
        BufferedImage bufferedImage = new BufferedImage(myImage.getWidth(null), myImage.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = (Graphics2D) g;

        Graphics gb = bufferedImage.getGraphics();
        gb.drawImage(myImage, 0, 0, null);
        gb.dispose();

        AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
        tx.translate(-myImage.getWidth(null), 0);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        bufferedImage = op.filter(bufferedImage, null);

        g2d.drawImage(myImage, 10, 10, null);
        g2d.drawImage(bufferedImage, null, 700, 10);
    }
}