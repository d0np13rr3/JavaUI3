package Game;

import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.*;

public class PopUpWindows {

    public static void main(String[] args){
        JFrame f = new JFrame("ATTACKING TEAM"); //creates jframe f
        GridLayout grid = new GridLayout(1, 3); //creates a gridlayout
        f.setLayout(grid); //sets the layout of the jframe to the gridlayout
        f.setBackground(Color.BLACK);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //this is your screen size

        f.setUndecorated(false); //removes the surrounding border

        ImageIcon image00 = new ImageIcon("C:\\Users\\ppauwelb\\IdeaProjects\\JavaUI3\\src\\Images\\DV3.png"); //imports the image
        ImageIcon image01 = new ImageIcon("C:\\Users\\ppauwelb\\IdeaProjects\\JavaUI3\\src\\Images\\BT3.png"); //imports the image
        ImageIcon image02 = new ImageIcon("C:\\Users\\ppauwelb\\IdeaProjects\\JavaUI3\\src\\Images\\JD3.png"); //imports the image


        JLabel lbl00 = new JLabel(image00); //puts the image into a jlabel
        JLabel lbl01 = new JLabel(image01);
        JLabel lbl02 = new JLabel(image02);

        f.getContentPane().add(lbl00); //puts label inside the jframe
        f.getContentPane().add(lbl01);
        f.getContentPane().add(lbl02);
        f.getContentPane().setBackground(Color.BLACK);

//        f.setSize(image00.getIconWidth()+image01.getIconWidth()+image02.getIconWidth(), image00.getIconHeight()); //gets h and w of image and sets jframe to the size
        f.setSize(image00.getIconWidth()+image01.getIconWidth()+image02.getIconWidth(), 400);
        int x = (screenSize.width - f.getSize().width)/2; //These two lines are the dimensions
        int y = (screenSize.height - f.getSize().height)/2;//of the center of the screen

        f.setLocation(x, y); //sets the location of the jframe
        f.setVisible(true); //makes the jframe visible
    }
}