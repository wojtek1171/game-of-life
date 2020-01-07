package gol;

import javax.swing.*;

public class Frame extends JFrame {

    public Frame() {

        super("Game of Life");
        Rectangle rects = new Rectangle();
        JFrame frame = new JFrame("Game of Life");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(rects);
        frame.setSize(1000, 1000);
        frame.setLocationRelativeTo(null);

        JLabel lblName= new JLabel();
        lblName.setText("Your Name");
        lblName.setBounds(0,0, 100,30);
        add(lblName);

        frame.setVisible(true);


    }

}
