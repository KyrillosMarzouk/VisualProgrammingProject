
package jdfv;
import com.sun.prism.paint.Color;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.BLANCHEDALMOND;
import static javafx.scene.paint.Color.BLUE;
import javafx.stage.Stage;


public class Tabs extends Tab {
    private Button back = new Button();
    private Button forward = new Button();
    private Button reload = new Button();
    private Button load = new Button();
    private Button home = new Button();
    private Button newtab = new Button();
    private Button addBookMark = new Button();
    private Button save = new Button("save");
    private TextField url = new TextField();
    private ToolBar tb = new ToolBar();
    private WebView wv = new WebView();
    private  WebEngine we = new WebEngine();
    private Tab tab = new Tab("New Tab");
    String styleTool = "-fx-background-color: rgba(0, 0, 0, 1);";
    String styleButton = "-fx-background-color: rgba(103, 152, 255, 1);";
    Font font = new Font(20);    
    Tabs(int x){
      
    }
    
    Tabs(){
        this.tb.getItems().addAll(this.back, this.forward, this.load, this.reload, this.url, this.newtab,this.home, this.addBookMark);
        setStyles();
        VBox v = new VBox();
        newtab.setOnAction(event -> addTab(Jdfv.tpane));
        v.getChildren().addAll(tb, wv);
        this.addBookMark.setOnAction((event) -> {
            Jdfv.bk.add(this.url.getText(), this.tab.getText());
            System.out.println(Jdfv.bk.getBookMarkAt(0).getName());
        });
        this.back.setOnAction(event -> we.executeScript("history.back()"));
        this.reload.setOnAction(event -> we.reload());
        this.forward.setOnAction(event -> we.executeScript("history.forward()"));
        this.url.setOnAction(event ->{   
           this.tabLoad(this.url.getText());
            change();
            addToHistory();
            System.out.println("enter");
        });
        this.tab.setContent(v);
      
//        this.wv.setOnMouseClicked(event -> {
//        change();
//        addToHistory();
//        });
        we = wv.getEngine();
        load.setOnAction(event -> tabLoad(this.url.getText()));
        this.home.setOnAction((event) -> {
            try{
                Parent tableViewParent =( FXMLLoader.load(getClass().getResource("FXMLDocument.fxml")));  
                Scene tableViewScene = new Scene(tableViewParent);  
                Jdfv.window.setScene(tableViewScene);
                //Stage window=(Stage)((javafx.scene.Node)event.getSource()).getScene().getWindow();
                //tableViewScene.setRoot(tableViewParent);
                //window.setScene(tableViewScene);
                Jdfv.window.show();
            } catch(IOException e){
                e.getMessage();
            }
        });
              
        
    }
    Tabs(TabPane pane){
        Tabs t = new Tabs();
        pane.getTabs().add(t.tab);
        changeScene(pane);
    }
    public void setStyles(){
        tb.setStyle(styleTool);
        newtab.setStyle(styleTool);
        back.setStyle(styleTool);
        forward.setStyle(styleTool);
        load.setStyle(styleTool);
        reload.setStyle(styleTool);
        home.setStyle(styleTool);
        addBookMark.setStyle(styleTool);
        url.setFont(font);
        url.setPrefWidth(1050);
        back.setCursor(Cursor.HAND);
        forward.setCursor(Cursor.HAND);
        load.setCursor(Cursor.HAND);
        reload.setCursor(Cursor.HAND);
        newtab.setCursor(Cursor.HAND);
        home.setCursor(Cursor.HAND);
        addBookMark.setCursor(Cursor.HAND);
        wv.setPrefHeight(1800);
        back.setGraphic(new ImageView(getClass().getResource("images/arrow-back-icon.png").toExternalForm()));
        forward.setGraphic(new ImageView(getClass().getResource("images/arrow-forward-icon.png").toExternalForm()));
        load.setGraphic(new ImageView(getClass().getResource("images/load.png").toExternalForm()));
        reload.setGraphic(new ImageView(getClass().getResource("images/reload.png").toExternalForm()));
        newtab.setGraphic(new ImageView(getClass().getResource("images/add.png").toExternalForm()));
        home.setGraphic(new ImageView(getClass().getResource("images/home.png").toExternalForm()));
        addBookMark.setGraphic(new ImageView(getClass().getResource("images/book.png").toExternalForm()));
    }
  
//    public void Hom(ActionEvent event){
//        Button btn = (Button) event.getSource();
//        Scene sc =btn.getScene();
//        Parent root = MyApplication.
//        }
    
    public static Tabs addTab(TabPane pane){
        Tabs x = new Tabs();
        
        Jdfv.tpane.getTabs().add(x.tab);
        changeScene(Jdfv.tpane);
        return x;
    }
    public void tabLoad(String x){
        if (x.startsWith("https://")){
            loadURL(x);
        }
        else{
            String url1 = "https://" + x;
            loadURL(url1);
        }
    }
    public void change(){
        this.url.setText(this.we.getLocation());
        this.tab.setText((url.getText()).substring((url.getText()).indexOf(".") + 1, (url.getText()).indexOf(".com")));
    }
    public static void changeScene(TabPane pane){
        
        Jdfv.window.setScene(Jdfv.s);
        Jdfv.window.setMaximized(true);
        Jdfv.window.show();
    }
    public void loadURL(String URL){
        we.load(URL);
        this.url.setText(this.we.getLocation());
        addToHistory();
    } 
    public void addToHistory(){
        Jdfv.history.add(this.url.getText());
    }
   
}
