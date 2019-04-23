
package jdfv;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PopUpMessage {
 
      private BorderPane layout ;
    private Stage frame;
    private Button save ;
    private Button exit ;
    private boolean contiue;
    private HBox bottomLayout ;

    public PopUpMessage() {
        bottomLayout = new HBox();
        frame = new Stage();
        frame.setTitle("Pop Up Message");
        save = new Button("Save");
        exit = new Button("Exit");
        bottomLayout.getChildren().addAll(save, exit);
        bottomLayout.setAlignment(Pos.CENTER);
        bottomLayout.setSpacing(20);
        layout = new BorderPane();
        layout.setBottom(bottomLayout);
        contiue =  false;
        frame.setScene(new Scene(layout , 500, 300));
        exit.setOnAction(e->close());
    }

    public Button getSave() {
        return save;
    }

    public Button getExit() {
        return exit;
    }
    
    
    
    public void setCenter(Pane centerLayout){
        layout.setCenter(centerLayout);
    }
    public void show(){
        frame.show();
    }
    public void close(){
        frame.close();
    }

    public boolean getContinue(){
        return contiue;
    }
    
    
    
    
    public BorderPane getLayout() {
        return layout;
    }
    
    
}
