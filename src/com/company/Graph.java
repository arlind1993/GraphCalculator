package com.company;

import javax.swing.*;
import java.awt.*;

public class Graph extends JPanel {

    String expression="";

    public Graph (){
        this.setLayout(null);
        this.setSize(600,600);
        this.setLocation(200,0);
        this.setBackground(Color.WHITE);
    }

    public void setExpression(String expression) {
        this.expression = expression;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawLine(0,300,600,300);
        g.drawLine(300,0,300,600);

        g.drawLine(295,5,300,0);
        g.drawLine(305,5,300,0);
        g.drawLine(595,295,600,300);
        g.drawLine(595,305,600,300);

        g.fillOval(298,298,4,4);
        draw(g);
    }

    private void draw(Graphics g) {
        int xFirstValue=1;
        int xValues=10;
        int xSpacing=this.getWidth()/(xValues*2);
        for (int i = 0; i < xValues*2; i++) {
            if (i != xValues) {
                g.drawLine(i * xSpacing, 295, i * xSpacing, 305);
                g.drawString("" + (xFirstValue *(i -  xValues)), i * xSpacing - 3, 317);
            }
        }

        int yFirstValue=1;
        int yValues=10;
        int ySpacing=this.getHeight()/(yValues*2);
        for (int i = 0; i < yValues*2; i++) {
            if (i != yValues) {
                g.drawLine(295, i * ySpacing, 305, i * ySpacing);
                g.drawString("" + (-(yFirstValue *(i - yValues))),  280, i * xSpacing+3);
            }
        }

        double xPrecision=1.0/(xFirstValue*xSpacing);
        if (!expression.equals("")){
            for (double x = -xFirstValue*xValues;  x<=xFirstValue*xValues; x+=xPrecision) {
                String exp=replaceX(expression,x);
                double y=Calculator.calculator(exp);

                int pointX=(int)Math.round((x+xValues)*xFirstValue*xSpacing);
                int pointY=(int)Math.round((-y+yValues)*yFirstValue*ySpacing);
                System.out.println(x + " ; " + y+"||"+ pointX+" ; "+pointY);
                g.drawOval(pointX,pointY,1,1);
            }
        }
    }

    private String replaceX(String expression, double x) {
        x=(double)Math.round(x*100000)/100000;
        if (expression.charAt(0)=='x'){
            expression ="("+ String.valueOf(x) +")" + expression.substring(1);
        }
        if (expression.charAt(expression.length()-1)=='x'){
            expression = expression.substring(0,expression.length()-1) + "("+ x +")";
        }
        for (int i = 1; i < expression.length()-1; i++) {
            if (expression.charAt(i)=='x'){
                expression = expression.substring(0,i) + "("+ x +")" + expression.substring(i+1);
            }
        }
        return expression;
    }
}
