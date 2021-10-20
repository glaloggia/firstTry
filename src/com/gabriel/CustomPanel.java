package com.gabriel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class CustomPanel extends JPanel {

    private ShapesManager shapesManager;

    public CustomPanel(ShapesManager shapesManager){
        this.shapesManager = shapesManager;
        addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(e.getButton()==1)
                    primaryButtonClick(e);
                if(e.getButton()==3)
                    secondaryButtonClick(e);
            }
        });
    }

    private void secondaryButtonClick(MouseEvent e) {
        shapesManager.moveOrRotate(e);
        super.repaint();
    }

    private void primaryButtonClick(MouseEvent e){
        shapesManager.toggleFilling(e);
        super.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        shapesManager.drawShapes(g);

    }
}
