import javax.swing.*;
import javax.swing.event.MouseInputListener;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.Container;
import java.awt.Image;
import java.awt.geom.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.vecmath.*;

import java.lang.*;
import java.lang.Math;


//import java.util.ArrayList;
import java.util.*;


public class main extends JPanel {

    //abstract static class MenuActionListener implements ActionListener {};

    public static void main (String[] args) {
        /// calls to add widgets
        //main w = new main();
        // create a window
        JFrame frame = new JFrame("Doodle (a6bagher)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create a menu
        JMenu menu = new JMenu("File");

        // create some menu choices
        //for (String s : new String[]{"New", "Load", "Save"}) {
            // add this menu item to the menu
        JMenuItem newOption = new JMenuItem("New");
        JMenuItem loadOption = new JMenuItem("Load");
        JMenuItem saveOption = new JMenuItem("Save");


            // add this menu item to the menu
        menu.add(newOption);
        menu.add(loadOption);
        menu.add(saveOption);
        //}

        //create a menuBar
        JMenuBar menubar = new JMenuBar();
        //add the first menu to the menuBar
        menubar.add(menu);

        newOption.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                int len = sList.size();
                for(int i = len-1; i >= 0; i--) {
                    sList.remove(0);
                }
            }
        });

        loadOption.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {

            }
        });
        saveOption.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                //try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("drawing.txt"), "utf-8"))) {
                //    writer.write(""+ sList.size());

                //}
            }
        });


       /* // create a menu
        JMenu menu2 = new JMenu("Edit");
        // create some menu choices
        for (String s : new String[]{"Cut", "Copy", "Paste"}) {
            // add this menu item to the menu
            JMenuItem mi = new JMenuItem(s);
            // add this menu item to the menu
            menu2.add(mi);
        }

        //add the second menu to the menuBar
        menubar.add(menu2);*/
        // add to the frame
        frame.setJMenuBar(menubar);


        //this will be the main panel going on top of the frame.
        JPanel pane = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        //For each component to be added to this container:
        //...Create the component...
        //...Set instance variables in the GridBagConstraints instance...
        //...pane.add(theComponent, c);
        // ... ^ taken from oracle.com



        // working on tools section
        //set the layoutgrid
        JPanel tools = new JPanel(new GridLayout(3,2));
        tools.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        // init all of the buttons
        JButton pointer = new JButton();
        JButton eraser = new JButton();
        JButton line = new JButton();
        JButton circle = new JButton();
        JButton rec = new JButton();
        JButton bucket = new JButton();

        // set the corect img for every button, need a try,catch block in case the images throw an exception
        try {
            ImageIcon pointerImg = new ImageIcon("src/pictures/pointer.png");
            // resiez image
            Image image = pointerImg.getImage(); // transform it
            Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
            pointerImg = new ImageIcon(newimg);  // transform it back
            pointer.setIcon(pointerImg);
            pointer.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            //setting the listener event for this button
            pointer.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {// use anonymous inner class instead of MyMouseAdapter class
                    //setAction("p")
                    action = "p";
                    //System.out.println(action);
                }
            });

            ImageIcon eraserImg = new ImageIcon("src/pictures/eraser.png");
            // resiez image
            image = eraserImg.getImage(); // transform it
            newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
            eraserImg = new ImageIcon(newimg);  // transform it back
            eraser.setIcon(eraserImg);
            eraser.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            //setting the listener event for this button
            eraser.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {        // use anonymous inner class instead of MyMouseAdapter class
                    //setAction("e");
                    action = "e";
                }
            });

            ImageIcon lineImg = new ImageIcon("src/pictures/line.png");
            // resiez image
            image = lineImg.getImage(); // transform it
            newimg = image.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH);
            lineImg = new ImageIcon(newimg);  // transform it back
            line.setIcon(lineImg);
            line.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            //setting the listener event for this button
            line.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {        // use anonymous inner class instead of MyMouseAdapter class
                    action = "l";
                }
            });


            ImageIcon circleImg = new ImageIcon("src/pictures/circle.png");
            // resiez image
            image = circleImg.getImage(); // transform it
            newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
            circleImg = new ImageIcon(newimg);  // transform it back
            circle.setIcon(circleImg);
            circle.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            //setting the listener event for this button
            circle.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {        // use anonymous inner class instead of MyMouseAdapter class
                    action = "c";
                }
            });


            ImageIcon recImg = new ImageIcon("src/pictures/rectangle.png");
            // resiez image
            image = recImg.getImage(); // transform it
            newimg = image.getScaledInstance(100, 50,  java.awt.Image.SCALE_SMOOTH);
            recImg = new ImageIcon(newimg);  // transform it back
            rec.setIcon(recImg);
            rec.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            //setting the listener event for this button
            rec.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {        // use anonymous inner class instead of MyMouseAdapter class
                    action = "r";
                }
            });


            ImageIcon bucketImg = new ImageIcon("src/pictures/bucket.jpg");
            // resiez image
            image = bucketImg.getImage(); // transform it
            newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
            bucketImg = new ImageIcon(newimg);  // transform it back
            bucket.setIcon(bucketImg);
            bucket.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            bucket.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {        // use anonymous inner class instead of MyMouseAdapter class
                    action = "b";
                }
            });

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
        colour.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        // set the colour buttons
        JButton blue = new JButton();
        blue.setBackground(Color.BLUE);
        blue.setOpaque(true);
        blue.setBorder(new LineBorder(Color.BLACK));
        blue.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {        // use anonymous inner class instead of MyMouseAdapter class
                setColour = Color.BLUE;
            }
        });

        JButton red = new JButton();
        red.setBackground(Color.RED);
        red.setOpaque(true);
        red.setBorder(new LineBorder(Color.BLACK));
        red.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {        // use anonymous inner class instead of MyMouseAdapter class
                setColour = Color.RED;
            }
        });

        JButton orange = new JButton();
        orange.setBackground(Color.ORANGE);
        orange.setOpaque(true);
        orange.setBorder(new LineBorder(Color.BLACK));
        orange.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {        // use anonymous inner class instead of MyMouseAdapter class
                setColour = Color.ORANGE;
            }
        });

        JButton yellow = new JButton();
        yellow.setBackground(Color.YELLOW);
        yellow.setOpaque(true);
        yellow.setBorder(new LineBorder(Color.BLACK));
        yellow.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {        // use anonymous inner class instead of MyMouseAdapter class
                setColour = Color.YELLOW;
            }
        });

        JButton green = new JButton();
        green.setBackground(Color.GREEN);
        green.setOpaque(true);
        green.setBorder(new LineBorder(Color.BLACK));
        green.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {        // use anonymous inner class instead of MyMouseAdapter class
                setColour = Color.GREEN;
            }
        });

        JButton pink = new JButton();
        pink.setBackground(Color.PINK);
        pink.setOpaque(true);
        pink.setBorder(new LineBorder(Color.BLACK));
        pink.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {        // use anonymous inner class instead of MyMouseAdapter class
                setColour = Color.PINK;
            }
        });


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
        c.anchor = GridBagConstraints.LINE_START; // top left of the page
        pane.add(colour, c);


        // thickness tool
        JPanel thick = new JPanel(new GridLayout(3,1));
        thick.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        //setting buttons
        JButton smallest = new JButton();
        smallest.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        JButton medium = new JButton();
        medium.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        JButton largest = new JButton();
        largest.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        smallest.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {        // use anonymous inner class instead of MyMouseAdapter class
                setThick = 1;
                smallest.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                medium.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                largest.setBorder(BorderFactory.createLineBorder(Color.black, 1));
            }
        });
        medium.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {        // use anonymous inner class instead of MyMouseAdapter class
                setThick = 2;
                medium.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                smallest.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                largest.setBorder(BorderFactory.createLineBorder(Color.black, 1));
            }
        });
        largest.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {        // use anonymous inner class instead of MyMouseAdapter class
                setThick = 5;
                largest.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                smallest.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                medium.setBorder(BorderFactory.createLineBorder(Color.black, 1));
            }
        });

        //setting button images
        try {
            ImageIcon smallestImg = new ImageIcon("src/pictures/smallest.png");
            // resiez image
            Image image = smallestImg.getImage(); // transform it
            Image newimg = image.getScaledInstance(120, 10, java.awt.Image.SCALE_SMOOTH);
            smallestImg = new ImageIcon(newimg);  // transform it back
            smallest.setIcon(smallestImg);

            ImageIcon mediumImg = new ImageIcon("src/pictures/medium.jpg");
            // resiez image
            image = mediumImg.getImage(); // transform it
            newimg = image.getScaledInstance(140, 20, java.awt.Image.SCALE_SMOOTH);
            mediumImg = new ImageIcon(newimg);  // transform it back
            medium.setIcon(mediumImg);

            ImageIcon largestImg = new ImageIcon("src/pictures/largest.png");
            // resiez image
            image = largestImg.getImage(); // transform it
            newimg = image.getScaledInstance(200, 10, java.awt.Image.SCALE_SMOOTH);
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
        c.anchor = GridBagConstraints.LAST_LINE_START; // top left of the page
        pane.add(thick, c);


        //canvas
        main canvas = new main();
        canvas.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        canvas.setBackground(Color.WHITE);
        // setting the constraints
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 2;
        c.gridy = 0;
        c.weightx = 1.3;
        c.weighty = 1;
        //c.gridwidth = GridBagConstraints.REMAINDER;
        c.gridheight = GridBagConstraints.REMAINDER;
        c.anchor = GridBagConstraints.FIRST_LINE_END; // top left of teh page
        pane.add(canvas, c);


        frame.add(pane);

        frame.validate();
        // set window behaviour and display it
        frame.setResizable(false);
        frame.setSize(1200, 800);
        //frame.setSize(frame.getPreferredSize());
        frame.setVisible(true);
    }

    // Object properties
    Point M = new Point();
    //private int mouseX;
    //private int mouseY;
    static String action = "l";
    static Color setColour = Color.BLUE;
    static int setThick = 2;

    // stack holding the shapes
    static Vector<Shape> sList = new Vector();


    // constructor for the class. looks out for mouse events on the canvas.
    main(){
        setBackground(Color.WHITE);
        // this is an example of an anonymous inner class
        this.addMouseListener( new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                M.x = e.getX();
                M.y = e.getY();

                switch (action){
                    case "p":
                        break;

                    case "e":
                        break;

                    case "l":
                        // draw a line
                        Line l = new Line(M, setThick);
                        sList.add(l);
                        break;

                    case "c":
                        // push a circle onto the list
                        Circle circ = new Circle(M.x, M.y ,1);
                        sList.add(circ);
                        break;

                    case"r":
                        // push a circle onto the list
                        sList.add(new Rectangle(M.x, M.y));
                        break;

                    case"b":
                        //
                        break;
                }
                repaint();
            }
        });


        this.addMouseListener( new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                M.x = e.getX();
                M.y = e.getY();

                switch (action){
                    case "p":
                        break;

                    case "e":
                        break;

                    case "l":
                        // draw a line
                        Shape myL = sList.lastElement();
                        myL.P1.x = M.x;
                        myL.P1.y = M.y;
                        break;

                    case "c":
                        Shape myC = sList.lastElement();

                        //calculates the distance from the mouse to the origin, giving the diameter.
                        int diffX = M.x - myC.P0.x;
                        int diffY = M.y - myC.P0.y;
                        double s = (double) (diffX*diffX) + (diffY*diffY);
                        int d = (int)(Math.sqrt(s));
                        myC.radius = d/2;
                        myC.diameter = d;


                        // stores the centre accordingly
                        myC.centre.x = myC.P0.x + d/2;
                        myC.centre.y = myC.P0.y + d/2;
                        break;

                    case"r":
                        //
                        Shape myR = sList.lastElement();
                        myR.P1.x = M.x;
                        myR.P1.y = M.y;
                        //sList.push(myR);
                        break;

                    case"b":
                        //
                        break;
                }
                //System.out.println(M.x);
                //System.out.println(M.y);
                repaint();
            }
        });




        this.addMouseMotionListener( new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {

                // We dont update the mouse right away because we need the older mouse position
                // for dragging objects.

                switch (action){
                    case "p":
                        // if the pointer is selected and
                        for(Shape obj1 : sList) {
                            if(obj1.selected){
                                if (obj1.type == "line" || obj1.type == "rectangle"){
                                    obj1.P0.x += e.getX() - M.x;
                                    obj1.P0.y += e.getY() - M.y;
                                    obj1.P1.x += e.getX() - M.x;
                                    obj1.P1.y += e.getY() - M.y;
                                }else if(obj1.type =="circle"){
                                    obj1.P0.x += e.getX() - M.x;
                                    obj1.P0.y += e.getY() - M.y;
                                    obj1.centre.x += e.getX() - M.x;
                                    obj1.centre.y += e.getY() - M.y;
                                }
                            }
                        }
                        break;

                    case "e":
                        break;

                    case "l":
                        M.x = e.getX();
                        M.y = e.getY();
                        // draw a line

                        Shape myL = sList.lastElement();
                        myL.P1.x = M.x;
                        myL.P1.y = M.y;
                        break;

                    case "c":
                        M.x = e.getX();
                        M.y = e.getY();
                        Shape myC = sList.lastElement();

                        int diffX = M.x - myC.P0.x;
                        int diffY = M.y - myC.P0.y;
                        double s = (double) (diffX*diffX) + (diffY*diffY);
                        int r = (int)(Math.sqrt(s));
                        myC.radius = r/2;
                        myC.diameter = r;

                        myC.centre.x = myC.P0.x + r/2;
                        myC.centre.y = myC.P0.y + r/2;

                        //sList.push(myC);
                        break;

                    case"r":
                        M.x = e.getX();
                        M.y = e.getY();
                        Shape myR = sList.lastElement();
                        myR.P1.x = M.x;
                        myR.P1.y = M.y;
                        //sList.push(myR);
                        break;

                    case"b":
                        //
                        break;
                }

                // make sure the mouse is updated.
                M.x = e.getX();
                M.y = e.getY();

                repaint();
            }
        });


        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                M.x = e.getX();
                M.y = e.getY();

                // flag that will tell us if an object was clicked
                boolean flag = false;

                //check what shape was clicked by iterating thgough the entire stack.
                LOOP:
                for(Shape obj : sList) {

                    if (obj.type == "circle"){
                        int diffX = Math.abs(M.x - obj.centre.x);
                        int diffY = Math.abs(M.y - obj.centre.y);
                        double s = (double) (diffX*diffX) + (diffY*diffY);
                        int dist = (int)(Math.sqrt(s));

                        //if this is the one selected, set flag true.
                        if(dist <= obj.radius){
                            //for(Shape obj1 : sList) {
                            //    obj1.selected = false;
                            //}
                            //Obj1.drag = true;
                            obj.selected = true;
                            flag = true;
                        }
                    }else if(obj.type == "line"){
                        Point2d ccPoint = closestPoint(M, obj.P0, obj.P1);
                        Point cPoint = new Point();
                        cPoint.x = (int)ccPoint.x;
                        cPoint.y = (int)ccPoint.y;

                        if (getDist(M, cPoint) <= 2){
                            //for(Shape obj1 : sList) {
                            //    obj1.selected = false;
                            //}
                            //Obj1.drag = true;
                            obj.selected = true;
                            flag = true;
                        }

                    }else if(obj.type == "rectangle"){
                        if (obj.P0.x <= M.x && obj.P0.y <= M.y &&
                                obj.P1.x >= M.x && obj.P1.y >= M.y){

                           // for(Shape obj1 : sList) {
                           //     obj1.selected = false;
                            //}
                            //Obj1.drag = true;
                            obj.selected = true;
                            flag = true;
                        }
                    }

                    // break the loop if an object was clicked.
                    if(flag){
                        break LOOP;
                    }
                }

                if (action == "p") {
                    if (!flag){
                        for(Shape obj1 : sList) {
                            obj1.selected = false;
                        }
                    }
                }else if(action == "e") {
                    // if something was clicked, find it and remove it
                    if (flag){
                        for(Shape obj1 : sList) {
                            if(obj1.selected){
                                sList.remove(obj1);
                            }
                        }
                    }
                }else if(action == "b"){
                    if (flag){
                        for(Shape obj1 : sList) {
                            if(obj1.selected && obj1.type != "line"){
                                obj1.fillColor = true;
                                obj1.colour = setColour;
                                break;
                            }else{
                                obj1.selected = false;
                            }
                        }
                    }
                }
                repaint();
            }
        });
    }

    int getDist(Point P0, Point P1){
        int diffX = P1.x - P0.x;
        int diffY = P1.y - P0.y;
        double s = (double) (diffX*diffX) + (diffY*diffY);
        return (int)(Math.sqrt(s));
    }

    // gotten from lecture notes of CS 349.
    // find closest point using projection method
    static Point2d closestPoint(Point mm, Point Pp0, Point Pp1) {
        Point2d P0 = new Point2d();
        Point2d P1 = new Point2d();
        Point2d m = new Point2d();
        m.x = mm.x;
        m.y = mm.y;
        P0.x = Pp0.x;
        P0.y = Pp0.y;
        P1.x = Pp1.x;
        P1.y = Pp1.y;

        Vector2d v = new Vector2d();
        v.sub(P1,P0); // v = P1 - P0

        // early out if line is less than 1 pixel long
        if (v.lengthSquared() < 0.5)
            return P0;

        Vector2d u = new Vector2d();
        u.sub(m,P0);

        // scalar of vector projection ...
        double s = u.dot(v) / v.dot(v);

        // find point for constrained line segment
        if (s < 0)
            return P0;
        else if (s > 1)
            return P1;
        else {
            Point2d I = P0;
            Vector2d w = new Vector2d();
            w.scale(s, v); // w = s * v
            I.add(w); // I = P0 + w
            return I;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); // JPanel paint
        Graphics2D g2 = (Graphics2D)g;

        Collections.reverse(sList);

        for(Shape obj : sList) {
            obj.draw(g2);
        }
        Collections.reverse(sList);

        //pane.add(g2);

    }

    private void setAction(String a){
        action = a;
    }

    // abstract class that will store information about all of the shapes.
    abstract class Shape{
        Color colour ;//= Color.BLACK;
        boolean fillColor;
        int thick;//= "medium";
        boolean selected;// = false;
        abstract void draw(Graphics g);
        Point P0 = new Point();
        Point P1 = new Point();
        String type;
        Point centre = new Point();

        // diameter and radius for the circles
        int radius;
        int diameter;


        //boolean drag;
    }

    class Circle extends Shape{

        Circle(int x, int y, int r){
            P0.x = x;
            P0.y = y;
            //centre = m;
            type = "circle";
            colour = setColour;
            thick = setThick;
            selected = true;
            //drag = false;
            fillColor = false;
        }

        void draw(Graphics g){
            Graphics2D g2 = (Graphics2D)g;

            // set the thickness of the line
            g2.setStroke(new BasicStroke(thick));

            //if the line was selected, change the stroke
            Stroke original = g2.getStroke();
            if (selected){
                Stroke dashed = new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
                g2.setStroke(dashed);
            }
            g2.setColor(this.colour);

            if(!fillColor){
                g2.drawOval(this.P0.x, this.P0.y, this.diameter, this.diameter);
            }else{
                if (selected){
                    g2.setColor(Color.BLACK);
                    Stroke dashed = new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
                    g2.setStroke(dashed);
                    g2.drawOval(this.P0.x, this.P0.y, this.diameter, this.diameter);
                }
                g2.setColor(this.colour);
                g2.fillOval(this.P0.x, this.P0.y, this.diameter, this.diameter);
            }

            g2.setStroke(original);
            repaint();
        }
    }

    class Rectangle extends Shape{

        Rectangle(int x, int y){
            P0.x = x;
            P0.y = y;
            colour = setColour;
            thick = setThick;
            selected = true;
            type = "rectangle";
            //drag = false;
            fillColor = false;
        }

        void draw(Graphics g){
            Graphics2D g2 = (Graphics2D)g;

            // set the thickness of the line
            g2.setStroke(new BasicStroke(thick));

            //if the line was selected, change the stroke
            Stroke original = g2.getStroke();
            if (selected){
                Stroke dashed = new BasicStroke(thick, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
                g2.setStroke(dashed);
            }
            g2.setColor(this.colour);
            if(!fillColor){
                g2.drawRect(this.P0.x, this.P0.y, Math.abs(this.P0.x - this.P1.x), Math.abs(this.P0.y - this.P1.y));
            }else{
                if (selected){
                    g2.setColor(Color.BLACK);
                    Stroke dashed = new BasicStroke(thick, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
                    g2.setStroke(dashed);
                    g2.drawRect(this.P0.x, this.P0.y, Math.abs(this.P0.x - this.P1.x), Math.abs(this.P0.y - this.P1.y));
                }
                g2.setColor(this.colour);
                g2.fillRect(this.P0.x, this.P0.y, Math.abs(this.P0.x - this.P1.x), Math.abs(this.P0.y - this.P1.y));
            }

            g2.setStroke(original);
            repaint();
        }
    }

    class Line extends Shape{
        Line(Point m, int setThick){
            P0.x = m.x;
            P0.y = m.y;
            P1.x = m.x;
            P1.y = m.y;
            colour = setColour;
            thick = setThick;
            selected = true;
            type = "line";
        }

        void draw(Graphics g){
            Graphics2D g2 = (Graphics2D)g;

            // set the thickness of the line
            g2.setStroke(new BasicStroke(thick));

            //if the line was selected, change the stroke
            Stroke original = g2.getStroke();
            if (selected){
                Stroke dashed = new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
                g2.setStroke(dashed);
            }

            //reset the color and draw the line
            g2.setColor(this.colour);
            g2.drawLine(this.P0.x, this.P0.y, this.P1.x, this.P1.y);

            g2.setStroke(original);
            repaint();
        }
    }
}
