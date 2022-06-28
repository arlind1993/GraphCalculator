package com.company;

import javax.swing.*;
import java.awt.*;

public class InputPane extends JPanel {
    EventTrigger et;
    public InputPane(EventTrigger et){
        this.et=et;
        this.setLayout(null);
        this.setSize(200,600);
        this.setLocation(0,0);
        this.setBackground(Color.GRAY);

        initialise();
    }

    private void initialise() {

        JTextField tf=new JTextField(8);
        tf.setBounds(10,10,120,40);
        tf.setText("f(x)=");
        this.add(tf);
        et.setTF(tf);

        JButton bt=new JButton("Solve");
        bt.setBounds(140,10,40,40);
        bt.setBackground(Color.WHITE);
        bt.setBorder(null);
        bt.addActionListener(et);
        this.add(bt);
    }

}
