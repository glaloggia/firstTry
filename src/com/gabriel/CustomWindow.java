package com.gabriel;


import javax.swing.*;
import java.awt.*;

/**
 * CustomWindow is the container for the Custom Panel.
 * it controls the basic aspects of the window, size, location.
 * @see CustomPanel
 * @author Gabriel La Loggia - L00169720
 */
public class CustomWindow extends JFrame {

    private CustomPanel mainPanel;

    public CustomWindow(ShapesManager shapesManager)
    {
        mainPanel = new CustomPanel(shapesManager);

        //add our new panel to the frame
        add(mainPanel, BorderLayout.CENTER);

        //set the dimensions of the frame/window
        setSize(Consts.FRAME_WIDTH, Consts.FRAME_HEIGHT);
    }

}
