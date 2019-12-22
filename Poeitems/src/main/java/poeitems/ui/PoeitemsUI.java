/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poeitems.ui;

import poeitems.domain.Items;
import javafx.event.ActionEvent;
import poeitems.dao.GoogleItemsDao;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.text.Font;
import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * Class that generates program UI and its functionalities.
 */
public class PoeitemsUI extends Application {
    
    private static List<Items> itemlocations;
    private static ListView listViewCards;
    private static ListView listViewMaps;
    private static ListView listViewArea;
    private static ListView listViewNames;
    private static Button addLocation;
    private static Button clearLocation;
    private static Button addItem;
    private static Items newItem;
    private static TextField type;
    private static TextField name;
    private static TextField divCard;
    private static TextField map;
    private static TextField area;
    
    @Override
    public void init() throws Exception {
        listViewCards = new ListView();
        listViewMaps = new ListView();
        listViewArea = new ListView();
        listViewNames = new ListView();
        listViewCards.setPrefWidth(300);
        listViewMaps.setPrefWidth(250);
        listViewArea.setPrefWidth(250);
        listViewNames.setPrefWidth(300);
        addLocation = new Button("Add items");
        clearLocation = new Button("Clear items");
        addItem = new Button("Add item");
        
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        itemlocations = new ArrayList<>();
        
        primaryStage.setTitle("Path of Exile unique item database");
      
        TabPane mainview = new TabPane();
        mainview.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        
        Tab locations = new Tab("Item location");
        Tab addTab = new Tab("Add items");
        
        mainview.getTabs().addAll(locations, addTab);
        
        locations.setContent(itemLocationLayout());
        addTab.setContent(addItemLayout());
        Scene layout = new Scene(mainview, 760, 720);
        
        primaryStage.setScene(layout);
        
        primaryStage.show();
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }

    //Main layout of the character tab
    public Pane itemLocationLayout() throws Exception {
        BorderPane mainWindow = new BorderPane();
        
        mainWindow.setPadding(new Insets(40, 40, 40, 40));
        mainWindow.setLeft(itemSlots());
        mainWindow.setRight(addLocationButtons());
        mainWindow.setCenter(dropdownList());
        mainWindow.setBottom(locationLayout());
        
        return mainWindow;
    }
    
    public Pane addItemLayout() {
        BorderPane addWindow = new BorderPane();
        addWindow.setPadding(new Insets(40, 40, 40, 40));
        
        addWindow.setLeft(addItemLabels());
        addWindow.setCenter(addItemTextFields());
        addWindow.setRight(addItemsButton());
        addWindow.setBottom(addItemTextsBottom());
        addWindow.setTop(addItemTextsTop());
        
        return addWindow;
    }
    /**
    *Sets on button click information to the listviews on the bottom of character layout.
     * @return 
    */
    public Button addToLocationList() {
        
        addLocation.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                itemlocations.stream().map((row) -> {
                    if (!listViewCards.getItems().contains(row.getDivCard())) {
                        listViewCards.getItems().add(row.getDivCard());
                    }
                    return row;
                }).map((row) -> {
                    if (!listViewMaps.getItems().contains(row.getMap())) {
                        listViewMaps.getItems().add(row.getMap());
                    }
                    return row;
                }).map((row) -> {
                    if (!listViewArea.getItems().contains(row.getArea())) {
                        listViewArea.getItems().add(row.getArea());
                    }
                    return row;
                }).filter((row) -> (!listViewNames.getItems().contains(row.getName()))).forEachOrdered((row) -> {
                    listViewNames.getItems().add(row.getName());
                });
            }
            
        });
        return addLocation;
    }
    /**
    *On button click adds a new item to the Google sheets.
     * @return 
    */
    public Button addToGoogleSheets() {
        
        addItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                try {
                    addNewItem(type, name, divCard, map, area);
                } catch (Exception ex) {
                    Logger.getLogger(PoeitemsUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
        });
        
        return addItem;
    }
    /**
    *Generates a new item object and uses the information to add new item to Google sheets.
     * @param type
     * @param name
     * @param divCard
     * @param area
     * @param map
     * @throws java.lang.Exception
    */
    public void addNewItem(TextField type, TextField name, TextField divCard, TextField map, TextField area) throws Exception {
        newItem = new Items(type.getText(), name.getText(), divCard.getText(), map.getText(), area.getText());
        GoogleItemsDao.addItemstoSheets(newItem.getType(), newItem.getName(), newItem.getDivCard(), newItem.getMap(), newItem.getArea());
    }
    
    /**
    *Clears the location list information.
     * @return 
    */
    public Button clearLocationLists() {
        
        clearLocation.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                
                listViewCards.getItems().clear();
                listViewMaps.getItems().clear();
                listViewArea.getItems().clear();
                listViewNames.getItems().clear();
                itemlocations = new ArrayList<>();
            }
            
        });
        return clearLocation;
    }

    //List of item slots and their layout
    public Pane itemSlots() {
        VBox itemlayout = new VBox();
        
        Label helmet = new Label("Helmet");
        helmet.setFont(new Font("Verdana", 18));
        
        Label armor = new Label("Body armor");
        armor.setFont(new Font("Verdana", 18));
        
        Label mainhand = new Label("Main hand");
        mainhand.setFont(new Font("Verdana", 18));
        
        Label offhand = new Label("Off hand");
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
    //Add labels to add item tab.
    public Pane addItemLabels() {
        
        VBox addItems = new VBox();
        addItems.setSpacing(20);
        addItems.setAlignment(Pos.CENTER_LEFT);
        
        Label type = new Label("Type");
        type.setFont(new Font("Verdana", 18));
        
        Label name = new Label("Name");
        name.setFont(new Font("Verdana", 18));
        
        Label divCard = new Label("Divination Card");
        divCard.setFont(new Font("Verdana", 18));
        
        Label map = new Label("Map");
        map.setFont(new Font("Verdana", 18));
        
        Label area = new Label("Area");
        area.setFont(new Font("Verdana", 18));
        
        addItems.getChildren().addAll(type, name, divCard, map, area);
        
        return addItems;
    }

    //Generates buttons for the character tab
    public VBox addLocationButtons() {
        
        VBox buttons = new VBox();
        buttons.setAlignment(Pos.CENTER);
        
        buttons.setSpacing(30);
        
        Button add = addToLocationList();
        Button clear = clearLocationLists();
        add.setStyle("-fx-font-size:16");
        clear.setStyle("-fx-font-size:16");
        
        buttons.getChildren().addAll(add, clear);
        
        return buttons;
    }
    
    public VBox addItemsButton() {
        
        VBox button = new VBox();
        
        button.setAlignment(Pos.CENTER_RIGHT);
        
        Button add = addToGoogleSheets();
        add.setStyle("-fx-font-size:16");
        
        button.getChildren().add(add);
        
        return button;
    }
    /**
    *Generates dropdown lists and their data.
     * @return 
     * @throws java.lang.Exception
    */
    public Pane dropdownList() throws Exception {
        
        List<String> helmetnames = GoogleItemsDao.getItems("helmet");
        ObservableList<String> helmets = FXCollections.observableArrayList(helmetnames);
        ComboBox helmet = new ComboBox(helmets);
        helmet.setOnAction(e -> setLocations((String) helmet.getValue()));
        
        List<String> armorNames = GoogleItemsDao.getItems("armor");
        ObservableList<String> armors = FXCollections.observableArrayList(armorNames);
        ComboBox armor = new ComboBox(armors);
        armor.setOnAction(e -> setLocations((String) armor.getValue()));
        
        List<String> mainHandNames = GoogleItemsDao.getItems("mainhand");
        ObservableList<String> mainhands = FXCollections.observableArrayList(mainHandNames);
        ComboBox mainHand = new ComboBox(mainhands);
        mainHand.setOnAction(e -> setLocations((String) mainHand.getValue()));
        
        List<String> offHandNames = GoogleItemsDao.getItems("offhand");
        ObservableList<String> offhands = FXCollections.observableArrayList(offHandNames);
        ComboBox offHand = new ComboBox(offhands);
        offHand.setOnAction(e -> setLocations((String) offHand.getValue()));
        
        List<String> amuletNames = GoogleItemsDao.getItems("amulet");
        ObservableList<String> amulets = FXCollections.observableArrayList(amuletNames);
        ComboBox amulet = new ComboBox(amulets);
        amulet.setOnAction(e -> setLocations((String) amulet.getValue()));
        
        List<String> ringNames1 = GoogleItemsDao.getItems("ring");
        ObservableList<String> rings1 = FXCollections.observableArrayList(ringNames1);
        ComboBox leftRing = new ComboBox(rings1);
        leftRing.setOnAction(e -> setLocations((String) leftRing.getValue()));
        
        List<String> rightRingNames = GoogleItemsDao.getItems("ring");
        ObservableList<String> rings2 = FXCollections.observableArrayList(rightRingNames);
        ComboBox rightRing = new ComboBox(rings2);
        rightRing.setOnAction(e -> setLocations((String) rightRing.getValue()));
        
        List<String> beltNames = GoogleItemsDao.getItems("belt");
        ObservableList<String> belts = FXCollections.observableArrayList(beltNames);
        ComboBox belt = new ComboBox(belts);
        belt.setOnAction(e -> setLocations((String) belt.getValue()));
        
        List<String> glovesNames = GoogleItemsDao.getItems("gloves");
        ObservableList<String> gloves = FXCollections.observableArrayList(glovesNames);
        ComboBox glove = new ComboBox(gloves);
        glove.setOnAction(e -> setLocations((String) glove.getValue()));
        
        List<String> bootsNames = GoogleItemsDao.getItems("boots");
        ObservableList<String> boots = FXCollections.observableArrayList(bootsNames);
        ComboBox boot = new ComboBox(boots);
        boot.setOnAction(e -> setLocations((String) boot.getValue()));
        
        VBox itemlist = new VBox();
        itemlist.setPadding(new Insets(0, 0, 0, 20));
        itemlist.setSpacing(10);
        
        itemlist.getChildren().addAll(helmet, armor, mainHand, offHand, amulet, leftRing, rightRing, belt, glove, boot);
        
        return itemlist;
    }
    
    public Pane addItemTextFields() {
        
        VBox texts = new VBox();
        texts.setSpacing(15);
        texts.setPadding(new Insets(0, 0, 0, 50));
        texts.setAlignment(Pos.CENTER);
        
        type = new TextField();
        type.setMaxWidth(200);
        
        name = new TextField();
        name.setMaxWidth(200);
        
        divCard = new TextField();
        divCard.setMaxWidth(200);
        
        map = new TextField();
        map.setMaxWidth(200);
        
        area = new TextField();
        area.setMaxWidth(200);
        
        texts.getChildren().addAll(type, name, divCard, map, area);
        
        return texts;
    }
    
    public Pane addItemTextsBottom() {
        VBox guideTexts = new VBox();
        guideTexts.setSpacing(20);
        guideTexts.setAlignment(Pos.TOP_LEFT);
        
        Label type = new Label("Please write type using only lowercase \nUse the following types: \nhelmet, armor, mainhand, offhand, amulet, ring, belt, gloves, boots.");
        type.setFont(new Font("Verdana", 14));
        Label reminder = new Label("Please use full names on items and location information.");
        reminder.setFont(new Font("Verdana", 14));
        
        guideTexts.getChildren().addAll(type, reminder);
        
        return guideTexts;
    }
    
    public Pane addItemTextsTop() {
        VBox headline = new VBox();
        headline.setSpacing(20);
        
        Label head = new Label("Add an missing item to the database");
        head.setFont(new Font("verdana", 18));
        
        Label note = new Label("Please note! \nYou have to restart the application for the new items to show \nin the items selection tab");
        note.setFont(new Font("verdana", 18));
        
        headline.getChildren().addAll(head, note);
        
        return headline;
    }
    
    public GridPane locationLayout() throws Exception {
        
        GridPane locationView = new GridPane();
        locationView.setPadding(new Insets(20, 0, 0, 0));
        locationView.setHgap(10);
        locationView.setVgap(10);
        
        Label names = new Label("Item");
        GridPane.setHalignment(names, HPos.CENTER);
        locationView.add(names, 0, 0);
        
        Label cards = new Label("Divination card");
        GridPane.setHalignment(cards, HPos.CENTER);
        locationView.add(cards, 2, 0);
        
        Label maps = new Label("Maps");
        GridPane.setHalignment(maps, HPos.CENTER);
        locationView.add(maps, 4, 0);
        
        Label area = new Label("Area");
        GridPane.setHalignment(area, HPos.CENTER);
        locationView.add(area, 6, 0);
        
        locationView.add(listViewNames, 0, 1);
        locationView.add(listViewCards, 2, 1);
        locationView.add(listViewMaps, 4, 1);
        locationView.add(listViewArea, 6, 1);
        
        return locationView;
        
    }
    /**
    *Gets the selected item information for location data generation.
    */
    public void setLocations(String name) {
        
        List<Items> locations = GoogleItemsDao.itemLocations(name);
        
        for (Items item : locations) {
            
            itemlocations.add(item);
            
        }
        
    }
    
}
