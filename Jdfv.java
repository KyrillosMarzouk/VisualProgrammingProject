
package jdfv;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;


public class Jdfv extends Application {
    
   
    public static Stage window = new Stage();
    public static TabPane tpane = new TabPane();
    public static History history = new History();
    public static Scene s = new Scene(tpane);
    public static BookMarks bk = new BookMarks();
    @Override
    public void start(Stage stage) throws Exception {
        
     //   bk.reader();
       // history.reader();
        tpane.setPrefSize(1918, 1100);
         window = stage;
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
      //  Parent root2= FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        Parent root3 = FXMLLoader.load(getClass().getResource("mainBookMarks.fxml"));
        Scene scene = new Scene(root);
     //   Scene scene2 = new Scene(root2);
        window.setTitle("Candy Butcher");
       // stage.setFullScreen(true);
        window.setScene(scene);
        window.setOnCloseRequest((event) -> {
            bk.write();
          
            history.printData();
           history.write();
        window.close();
        });
        window.show();
        
        
    }
    

    public static void main(String[] args) {
        launch(args);
    }
   
    
}
