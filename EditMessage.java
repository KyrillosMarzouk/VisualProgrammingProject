
package jdfv;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class EditMessage extends PopUpMessage {
    
     private Button save;
    private ChoiceBox box;
    GridPane pane;
    private TextField name;
    private BookMarks bookmark;
    private Label lb;
    public EditMessage(BookMarks bookmark) {
        pane = new GridPane();
        pane.setHgap(20);
        pane.setMinSize(200, 200);
        save = getSave();
        box = new ChoiceBox();
        this.bookmark=bookmark;
        bookmark.getBookMarks(box);
        setCenter(pane);
        box.getSelectionModel().select(0);
        box.setMinSize(70, 20);
        name = new TextField();
        lb = new Label("Name :");
        pane.add(lb, 0, 0);
        pane.add(name, 1, 0);
        pane.add(box, 2 ,1 );
                
        pane.setAlignment(Pos.TOP_CENTER);
        save.setOnAction(e-> {
            edit();
            close();        
        });
    }
    
    public void edit(){
        
        for (int i = 0 ; i < bookmark.getSize(); i++){
            if(bookmark.getBookMarkAt(i).getName().equals(box.getValue())){
                bookmark.getBookMarkAt(i).setName(name.getText());
                i = bookmark.getSize();
            }
        }
    }
    
}
