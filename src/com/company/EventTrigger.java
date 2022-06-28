package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventTrigger implements ActionListener {
    Graph graph;
    JTextField tf;
    EventTrigger(Graph graph){
        this.graph=graph;
    }

    public void setTF(JTextField tf) {
        this.tf=tf;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String temp=tf.getText();
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i)=='='){
                temp=temp.substring(i+1);
            }
        }
        graph.setExpression(temp);
    }
}
