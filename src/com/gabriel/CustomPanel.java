package com.gabriel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * CustomPanel is the container for all the GUI elements of the application.
 * Includes the shapes manager, which is in charge of interacting with all the shapes.
 * Also, it handles the mouse interactions.
 * @see ShapesManager
 * @author Gabriel La Loggia - L00169720
 */
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
