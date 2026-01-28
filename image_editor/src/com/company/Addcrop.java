package com.company;
import java.awt.*;
import javax.swing.*;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
public class Addcrop extends JFrame{
    Image image;
    Insets insets;

    public Addcrop() {
        super("Crop Image");
        ImageIcon icon = new ImageIcon("D:\\ImageEditor\\res\\Walpaper2.jpg");
        image = icon.getImage();
        image = createImage(new FilteredImageSource(image.
                getSource(),new CropImageFilter(75, 70, 200, 150)));

    }
    public void paint(Graphics g) {
        super.paint(g);
        if (insets == null) {
            insets = getInsets();
        }
        g.drawImage(image, insets.left, insets.top, this);
    }
    /*
    public static void main(String args[]) {
        JFrame frame = new Main();
        frame.setSize(250, 250);
        frame.show();
    }*/
}
