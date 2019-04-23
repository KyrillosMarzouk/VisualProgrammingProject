
package jdfv;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class MainBookMarksController implements Initializable {
 
    
    @FXML
     private Button add;
    @FXML
     private Button delete;
    @FXML
     private Button edit;
    @FXML
     private Button clear;
    @FXML
     private ScrollPane scrl; 
    @FXML 
     private BorderPane brdpan;
   
    
   
    BookMarks book = new BookMarks();
     
     
    addMessage addmMessage = new addMessage(book);
   
    
    public void add(){
    addmMessage.show();
    }
    public void delete(){
    book.delete();
   
    
    }
    public void edit(){
         EditMessage editMessage = new  EditMessage(book);
    editMessage.show();
   
    }

        public void clear (){
       book.clear();
        
        }
        
            
        
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         
           scrl.setContent(book.getLayout());
         
          
    }    
    
}
