package com.example.picker;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DatePickerController {

    @FXML
    private DatePicker myDatePicker;

    @FXML
    private Label dateLabel;
    @FXML
    private AnchorPane scenePane;

    @FXML
    private javafx.scene.control.ColorPicker myColorPicker;
    @FXML
    private Slider mySlider;

    @FXML
    private Label sliderLabel;
    @FXML
    private ImageView imageView;

    @FXML
    void getDate (ActionEvent event){
        LocalDate myDate = myDatePicker.getValue();
        System.out.println(myDate.toString());
        String dateFormatter = myDate.format(DateTimeFormatter.ofPattern("dd.MM.yyy"));
        dateLabel.setText(dateFormatter);
    }

    @FXML
    void changeColor(ActionEvent event) {
        Color selectedColor = myColorPicker.getValue();
        scenePane.setBackground(new Background(new BackgroundFill(selectedColor, null, null)));
    }

    @FXML
    void chooseFile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));

        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            Image image = new Image(file.toURI().toString());
            imageView.setImage(image);
        }
    }

    public void initialize() {
        mySlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                int score = newValue.intValue();
                sliderLabel.setText(score + " балів");
            }
        });
    }
}

