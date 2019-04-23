
package jdfv;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class addMessage extends PopUpMessage {
    
     private VBox bx;
   private Label String_url;
   private Label String_name;
   private TextField url;
   private TextField name;
   private Button save;
   private Button exit;
    public addMessage(BookMarks bookmark ){
        bx = new VBox();
        url = new TextField();
        name = new TextField();
        String_url = new Label("URL"); 
        String_name = new Label("Name"); 
        bx.getChildren().addAll(String_url,url,String_name,name);
        setCenter(bx);
        save = getSave();
        exit = getExit();
        save.setOnAction(e->{
            bookmark.add(url.getText(), name.getText());
            bookmark.setBookMark();
            url.setText("");
            name.setText("");
            close();
        });
        
    }
    
    public String getName(){
        return name.getText();
    }
     public String getUrl(){
        return url.getText();
    }
    
}
