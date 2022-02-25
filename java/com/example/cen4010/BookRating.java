package com.example.cen4010.ratecommentfeature;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BookRating extends JPanel
        implements ActionListener {

    public BookRating() {
        super(new BorderLayout());

        String[] ratings = {"1", "2", "3", "4", "5"};

        JComboBox ratingList = new JComboBox(ratings);
        ratingList.setSelectedIndex(4);
        ratingList.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox) e.getSource();
        String rateNum = (String) cb.getSelectedItem();
    }

    static void showRating() {
        //Create and set up the window.
        JFrame frame = new JFrame("Star Rating");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new BookRating();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}
