package com.company;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame=new JFrame("Graph");
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(815,640);

        Graph graph=new Graph();
        EventTrigger et=new EventTrigger(graph);
        InputPane inputPane=new InputPane(et);

        frame.add(graph);
        frame.add(inputPane);
        frame.setVisible(true);
    }
}
