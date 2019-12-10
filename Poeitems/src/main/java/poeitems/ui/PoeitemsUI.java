/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poeitems.ui;

import com.google.common.collect.Table;
import domain.Items;
import domain.ItemsService;
import java.awt.event.ActionEvent;
import poeitems.dao.GoogleItemsDao;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javafx.scene.text.Font;
import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import static javax.swing.Spring.width;
import poeitems.dao.GoogleSheetsConnector;
import poeitems.dao.ItemsDao;

/**
 *
 * @author patrhenr
 */
public class PoeitemsUI extends Application {

    private static List<List<Object>> itemlocations;

    private ItemsService itemService;
    private ItemsDao itemsDao;
    private static Button button;

    public void init() throws Exception {
        itemService = new ItemsService(itemsDao);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        itemlocations = new ArrayList<>();

        primaryStage.setTitle("Path of Exile unique item database");

        //Add tabs to the main window       
        TabPane mainview = new TabPane();
        mainview.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Tab character = new Tab("Character");
        Tab addTab = new Tab("Add items");

        mainview.getTabs().addAll(character, addTab);

        character.setContent(characterLayout());
        Scene layout = new Scene(mainview, 680, 720);

        primaryStage.setScene(layout);

        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    //Main layout of the character tab
    private Pane characterLayout() throws Exception {
        BorderPane mainwindow = new BorderPane();
        mainwindow.setPadding(new Insets(40, 40, 40, 40));
        mainwindow.setLeft(itemSlots());
        mainwindow.setRight(clearButtons());
        mainwindow.setCenter(dropdownList());
        mainwindow.setBottom(locationLayout());

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

        Label offhand = new Label("Second hand");
        offhand.setFont(new Font("Verdana", 18));

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

        itemlayout.getChildren().addAll(helmet, armor, mainhand, offhand, amulet, leftring, rightring, belt, gloves, boots);
        itemlayout.setSpacing(15);
        return itemlayout;
    }

    //Generates multiple clear buttons for the character tab
    private VBox clearButtons() {

        VBox clearbuttons = new VBox();

        clearbuttons.setSpacing(10);

        for (int i = 0; i < 10; i++) {
            clearbuttons.getChildren().add(new Button("clear"));
        }

        return clearbuttons;
    }

    private Pane dropdownList() throws Exception {

        List<Object> helmetnames = GoogleItemsDao.readHelmets();
        ObservableList<Object> helmets = FXCollections.observableArrayList(helmetnames);
        ComboBox helmet = new ComboBox(helmets);
        //helmet.setOnAction(e -> setLocations(helmet.getValue()));

        List<List<String>> armornames = GoogleItemsDao.readArmors();
        ObservableList<Object> armors = FXCollections.observableArrayList(armornames);
        ComboBox armor = new ComboBox(armors);

        List<List<String>> mainhandnames = GoogleItemsDao.readMainHands();
        ObservableList<Object> mainhands = FXCollections.observableArrayList(mainhandnames);
        ComboBox mainhand = new ComboBox(mainhands);

        List<List<String>> offhandnames = GoogleItemsDao.readOffHands();
        ObservableList<Object> offhands = FXCollections.observableArrayList(offhandnames);
        ComboBox offhand = new ComboBox(offhands);

        List<List<String>> amuletnames = GoogleItemsDao.readAmulets();
        ObservableList<Object> amulets = FXCollections.observableArrayList(amuletnames);
        ComboBox amulet = new ComboBox(amulets);

        List<List<String>> ringnames1 = GoogleItemsDao.readRings();
        ObservableList<Object> rings1 = FXCollections.observableArrayList(ringnames1);
        ComboBox ring1 = new ComboBox(rings1);

        List<List<String>> ringnames2 = GoogleItemsDao.readRings();
        ObservableList<Object> rings2 = FXCollections.observableArrayList(ringnames2);
        ComboBox ring2 = new ComboBox(rings2);

        List<List<String>> beltnames = GoogleItemsDao.readBelts();
        ObservableList<Object> belts = FXCollections.observableArrayList(beltnames);
        ComboBox belt = new ComboBox(belts);

        List<List<String>> glovesnames = GoogleItemsDao.readGloves();
        ObservableList<Object> gloves = FXCollections.observableArrayList(glovesnames);
        ComboBox glove = new ComboBox(gloves);

        List<List<String>> bootsnames = GoogleItemsDao.readBoots();
        ObservableList<Object> boots = FXCollections.observableArrayList(bootsnames);
        ComboBox boot = new ComboBox(boots);

        VBox itemlist = new VBox();
        itemlist.setPadding(new Insets(0, 0, 0, 20));
        itemlist.setSpacing(10);

        itemlist.getChildren().addAll(helmet, armor, mainhand, offhand, amulet, ring1, ring2, belt, glove, boot);

        return itemlist;
    }

    private static ListView locationLayout() throws Exception {

        //List<List<Object>> bootsnames = GoogleItemsDao.readBoots();
        //ObservableList<Object> locationsList = FXCollections.observableArrayList(bootsnames);
        TableView locations = new TableView();

        Label label = new Label("Divination card drop locations");
        label.setFont(new Font("Verdana", 20));

        ListView maps = new ListView<>();

        //maps.setItems(locationsList);
        return maps;

    }

    /*public static void setLocations(Object name) {

        //List<List<Object>> locations = GoogleItemsDao.itemLocations(name);
        System.out.println(Arrays.toString(locations.get(0).toArray()));

        itemlocations.addAll(locations);
        
        
    }*/
    public static List getLocations() {

        if (itemlocations.isEmpty()) {
            return new ArrayList<>();
        } else {
            return itemlocations.get(0);
        }

    }

}
