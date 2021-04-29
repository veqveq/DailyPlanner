package ru.veqveq.client.guicontrollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.springframework.stereotype.Component;

@Component
public class MainController {
    @FXML
    private Button button;

    public void buttonCLicked(ActionEvent actionEvent) {
        button.setText("Thank you!");
    }
}

