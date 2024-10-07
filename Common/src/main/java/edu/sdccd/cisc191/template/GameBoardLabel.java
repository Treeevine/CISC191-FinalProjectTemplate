package edu.sdccd.cisc191.template;

import javafx.geometry.Insets;
import javafx.scene.control.Label;

public class GameBoardLabel extends Label {
    public static Insets LABEL_PADDING = new Insets(20, 20, 20, 20);

    /**
     * Creates a label with any specified style to it.
     * The only one used is the padding.
     */
    public GameBoardLabel() {
        setPadding(LABEL_PADDING);
    }

}
