package hust.soict.globalict.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton penRadioButton;

    @FXML
    private RadioButton eraserRadioButton;

    @FXML
    private ToggleGroup toolsToggleGroup;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        if (event.getX() >= 0 && event.getY() >= 0) {
            Circle newCircle = new Circle(event.getX(), event.getY(), 4);
            
            if (penRadioButton.isSelected()) {
                newCircle.setFill(Color.BLACK); 
            } else if (eraserRadioButton.isSelected()) {
                newCircle.setFill(Color.WHITE); 
            }
            
            drawingAreaPane.getChildren().add(newCircle);
        }
    }
}