package gol;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class Rectangle extends JPanel implements ActionListener {

    Random rnd = new Random();

    World world1 = new World("World", 200, rnd.nextInt());
    WorldController worldController = new WorldController(world1);

    Timer timer = new Timer(200, this);

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        drawRect(g2d);
        drawLabel();
        timer.start();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    private void drawRect(Graphics2D g2d) {

        int cellDimension = 4;

        if (world1.getGeneration() == 1) {
            worldController.createWorld();
        }


        for (int i = 0; i < world1.getSize(); i++) {
            for (int j = 0; j < world1.getSize(); j++) {

//                if ((world1.getMatrix()[i][j]).equals(" ")) {
//
//                    g2d.setColor(new Color(207, 207, 207));
//                    g2d.drawRect(30 + cellDimension * j, 100 + cellDimension * i, cellDimension, cellDimension);
//                    //g2d.fillRect(30 + 30 * j, 30 + 30 * i, 30, 30);
//                } else {
//                    g2d.setColor(new Color(31, 21, 1));
//                    g2d.fillRect(30 + cellDimension * j, 100 + cellDimension * i, cellDimension, cellDimension);
//                }

                if ((world1.getMatrix()[i][j]).equals(" ")) {

                    g2d.setColor(new Color(97, 97, 97));
                    g2d.drawRect(30 + cellDimension * j, 100 + cellDimension * i, cellDimension, cellDimension);
                    //g2d.fillRect(30 + cellDimension * j, 100 + cellDimension * i, cellDimension, cellDimension);
                } else {
                    g2d.setColor(new Color(0, 0, 0));
                    g2d.fillRect(30 + cellDimension * j, 100 + cellDimension * i, cellDimension, cellDimension);
                }

            }

        }

        worldController.generate();

    }

    public void drawLabel() {

        JTextField t1 = new JTextField(" World name: " + world1.getName());
        t1.setBounds(30, 20, 150, 20);
        add(t1);

        JTextField t2 = new JTextField(" Generation #" + world1.getGeneration());
        t2.setBounds(30, 40, 150, 20);
        add(t2);

        JTextField t3 = new JTextField(" Alive: " + world1.getAliveCellsNumber());
        t3.setBounds(30, 60, 150, 20);
        add(t3);

    }
}
