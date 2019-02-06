import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import java.awt.Container;


import java.awt.*;

// for images
import java.lang.Object;
import javax.imageio.ImageIO;

import java.awt.Image;

import javax.swing.border.LineBorder;

//import java.util.*;
//import java.applet.Applet;
//import java.io.File;

/*import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
*/
public class main {

    public static void main (String[] args) {
        /// calls to add widgets
        main w = new main();
    }

    private static void setLayout(JPanel pane, GridBagConstraints c){
        //For each component to be added to this container:
        //...Create the component...
        //...Set instance variables in the GridBagConstraints instance...
        //...pane.add(theComponent, c);
        // ... ^ taken from oracle.com



        // working on tools section
        //set the layoutgrid
        JPanel tools = new JPanel(new GridLayout(3,2));
        tools.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        // init all of the buttons
        JButton pointer = new JButton();
        JButton eraser = new JButton();
        JButton line = new JButton();
        JButton circle = new JButton();
        JButton rec = new JButton();
        JButton bucket = new JButton();

        // set the corect img for every button
        try {
            ImageIcon pointerImg = new ImageIcon("src/pictures/pointer.png");
            // resiez image
            Image image = pointerImg.getImage(); // transform it
            Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            pointerImg = new ImageIcon(newimg);  // transform it back
            pointer.setIcon(pointerImg);

            ImageIcon eraserImg = new ImageIcon("src/pictures/eraser.png");
            // resiez image
            image = eraserImg.getImage(); // transform it
            newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            eraserImg = new ImageIcon(newimg);  // transform it back
            eraser.setIcon(eraserImg);

            ImageIcon lineImg = new ImageIcon("src/pictures/line.png");
            // resiez image
            image = lineImg.getImage(); // transform it
            newimg = image.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            lineImg = new ImageIcon(newimg);  // transform it back
            line.setIcon(lineImg);

            ImageIcon circleImg = new ImageIcon("src/pictures/circle.png");
            // resiez image
            image = circleImg.getImage(); // transform it
            newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            circleImg = new ImageIcon(newimg);  // transform it back
            circle.setIcon(circleImg);

            ImageIcon recImg = new ImageIcon("src/pictures/rectangle.png");
            // resiez image
            image = recImg.getImage(); // transform it
            newimg = image.getScaledInstance(100, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            recImg = new ImageIcon(newimg);  // transform it back
            rec.setIcon(recImg);

            ImageIcon bucketImg = new ImageIcon("src/pictures/bucket.jpg");
            // resiez image
            image = bucketImg.getImage(); // transform it
            newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            bucketImg = new ImageIcon(newimg);  // transform it back
            bucket.setIcon(bucketImg);

        } catch (Exception ex) {
            System.out.println(ex);
        }


        // add the buttons to the tools grid
        tools.add(pointer);
        tools.add(eraser);
        tools.add(line);
        tools.add(circle);
        tools.add(rec);
        tools.add(bucket);



        // setting the constraints
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.gridheight = 3;
        c.weightx = 0.05;
        c.weighty = 0.3;
        c.anchor = GridBagConstraints.FIRST_LINE_START; // top left of teh page
        pane.add(tools, c);



        // colour palette ... creating component
        JPanel colour = new JPanel(new GridLayout(3,2));
        colour.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        // set the colour buttons
        JButton blue = new JButton();
        blue.setBackground(Color.BLUE);
        blue.setOpaque(true);
        blue.setBorder(new LineBorder(Color.BLACK));
        JButton red = new JButton();
        red.setBackground(Color.RED);
        red.setOpaque(true);
        red.setBorder(new LineBorder(Color.BLACK));
        JButton orange = new JButton();
        orange.setBackground(Color.ORANGE);
        orange.setOpaque(true);
        orange.setBorder(new LineBorder(Color.BLACK));
        JButton yellow = new JButton();
        yellow.setBackground(Color.YELLOW);
        yellow.setOpaque(true);
        yellow.setBorder(new LineBorder(Color.BLACK));
        JButton green = new JButton();
        green.setBackground(Color.GREEN);
        green.setOpaque(true);
        green.setBorder(new LineBorder(Color.BLACK));
        JButton pink = new JButton();
        pink.setBackground(Color.PINK);
        pink.setOpaque(true);
        pink.setBorder(new LineBorder(Color.BLACK));

        UIManager.put("Button.select", Color.BLACK);

        // add buttons to colour paette
        colour.add(blue);
        colour.add(red);
        colour.add(orange);
        colour.add(yellow);
        colour.add(green);
        colour.add(pink);


        // setting the constraints for the gridBag
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2;
        c.gridheight = 3;
        c.weightx = 0.05;
        c.weighty = 0.6;
        //c.gridy = GridBagConstraints.RELATIVE;
        c.anchor = GridBagConstraints.LINE_START; // top left of teh page
        pane.add(colour, c);


        // thickness tool
        JPanel thick = new JPanel(new GridLayout(3,1));
        thick.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        //setting buttons
        JButton smallest = new JButton();
        JButton medium = new JButton();
        JButton largest = new JButton();

        //setting button images
        try {
            ImageIcon smallestImg = new ImageIcon("src/pictures/smallest.png");
            // resiez image
            Image image = smallestImg.getImage(); // transform it
            Image newimg = image.getScaledInstance(120, 10, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            smallestImg = new ImageIcon(newimg);  // transform it back
            smallest.setIcon(smallestImg);

            ImageIcon mediumImg = new ImageIcon("src/pictures/medium.jpg");
            // resiez image
            image = mediumImg.getImage(); // transform it
            newimg = image.getScaledInstance(140, 20, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            mediumImg = new ImageIcon(newimg);  // transform it back
            medium.setIcon(mediumImg);

            ImageIcon largestImg = new ImageIcon("src/pictures/largest.png");
            // resiez image
            image = largestImg.getImage(); // transform it
            newimg = image.getScaledInstance(200, 10, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            largestImg = new ImageIcon(newimg);  // transform it back
            largest.setIcon(largestImg);
        }catch(Exception ex) {
            System.out.println(ex);
        }

        //add to the panel
        thick.add(smallest);
        thick.add(medium);
        thick.add(largest);

        // setting the constraints for the gridBag
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 2;
        c.gridheight = 3;
        c.weightx = 0.05;
        c.weighty = 0.2;
        //c.gridy = GridBagConstraints.RELATIVE;
        c.anchor = GridBagConstraints.LAST_LINE_START; // top left of teh page
        pane.add(thick, c);




        JPanel canvas = new JPanel();
        canvas.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        canvas.setBackground(Color.WHITE);
        // setting the constraints
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 2;
        c.gridy = 0;
        c.weightx = 1.3;
        c.weighty = 1;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.gridheight = GridBagConstraints.REMAINDER;
        c.anchor = GridBagConstraints.PAGE_START; // top left of teh page
        pane.add(canvas, c);
    }


    main() {

        // create a window
        JFrame frame = new JFrame("Doodle (a6bagher)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create a menu
        JMenu menu = new JMenu("File");

        // create some menu choices
        for (String s : new String[]{"New", "Open", "Exit"}) {
            // add this menu item to the menu
            JMenuItem mi = new JMenuItem(s);
            // add this menu item to the menu
            menu.add(mi);
        }

        //create a menuBar
        JMenuBar menubar = new JMenuBar();
        //add the first menu to the menuBar
        menubar.add(menu);

        // create a menu
        JMenu menu2 = new JMenu("Edit");
        // create some menu choices
        for (String s : new String[]{"Cut", "Copy", "Paste"}) {
            // add this menu item to the menu
            JMenuItem mi = new JMenuItem(s);
            // add this menu item to the menu
            menu2.add(mi);
        }

        //add the second menu to the menuBar
        menubar.add(menu2);
        // add to the frame
        frame.setJMenuBar(menubar);


        //this will be the main panel going on top of the frame.
        JPanel pane = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        //call the private layout function which adds the layout to the pane.
        setLayout(pane, c);

        // add the tools to the frame
        frame.add(pane);
        frame.validate();

        frame.repaint();

        // set window behaviour and display it
        frame.setResizable(false);
        frame.setSize(1200, 800);
        //frame.setSize(frame.getPreferredSize());
        frame.setVisible(true);
    }
}