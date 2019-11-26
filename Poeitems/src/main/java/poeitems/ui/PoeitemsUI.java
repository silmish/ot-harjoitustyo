/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poeitems.ui;

import poeitems.dao.GoogleItemsDao;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.text.Font;
import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import static javax.swing.Spring.width;

/**
 *
 * @author patrhenr
 */
public class PoeitemsUI extends Application {

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Path of Exile unique item database");

        //Add tabs to the main window       
        TabPane mainview = new TabPane();
        mainview.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Tab character = new Tab("Character");
        Tab lootlocation = new Tab("Loot location");

        mainview.getTabs().addAll(character, lootlocation);

        character.setContent(characterLayout());
        Scene layout = new Scene(mainview, 1024, 720);

        primaryStage.setScene(layout);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    //Main layout of the character tab
    private Pane characterLayout() {
        BorderPane mainwindow = new BorderPane();
        mainwindow.setPadding(new Insets(60, 60, 60, 60));
        mainwindow.setLeft(itemSlots());
        mainwindow.setRight(clearButtons());
        mainwindow.setCenter(dropdownList());

        return mainwindow;
    }

    //List of item slots and their layout
    private Pane itemSlots() {
        VBox itemlayout = new VBox(35);

        Label helmet = new Label("Helmet");
        helmet.setFont(new Font("Verdana", 18));

        Label armor = new Label("Body armor");
        armor.setFont(new Font("Verdana", 18));

        Label mainhand = new Label("Main hand");
        mainhand.setFont(new Font("Verdana", 18));

        Label secondhand = new Label("Second hand");
        secondhand.setFont(new Font("Verdana", 18));

        Label amulet = new Label("Amulet");
        amulet.setFont(new Font("Verdana", 18));

        Label leftring = new Label("Left ring");
        leftring.setFont(new Font("Verdana", 18));

        Label rightring = new Label("Right ring");
        rightring.setFont(new Font("Verdana", 18));

        Label belt = new Label("Belt");
        belt.setFont(new Font("Verdana", 18));

        Label gloves = new Label("Gloves");
        gloves.setFont(new Font("Verdana", 18));

        Label boots = new Label("Boots");
        boots.setFont(new Font("Verdana", 18));

        itemlayout.getChildren().addAll(helmet, armor, mainhand, secondhand, amulet, leftring, rightring, belt, gloves, boots);
        return itemlayout;
    }

    //Generates multiple clear buttons for the character tab
    private VBox clearButtons() {

        VBox clearbuttons = new VBox();

        clearbuttons.setSpacing(30);

        for (int i = 0; i < 10; i++) {
            clearbuttons.getChildren().add(new Button("clear"));
        }
        return clearbuttons;
    }

    private Pane dropdownList() {

        ObservableList<String> items = FXCollections.observableArrayList(
                "Item 1",
                "item 2"
        );

        VBox itemlist = new VBox();
        itemlist.setPadding(new Insets(-40, 0, 0, 0));
        itemlist.setSpacing(30);
        itemlist.setAlignment(Pos.CENTER);

        for (int i = 0; i < 10; i++) {
            itemlist.getChildren().add(new ComboBox(items));
        }

        return itemlist;
    }

}
