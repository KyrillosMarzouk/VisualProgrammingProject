
package jdfv;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class FXMLDocumentController implements Initializable {
    
    @FXML 
       private Button history;
    @FXML
       private Button bookmark;
    @FXML 
      private  ImageView google;
    @FXML 
       private ImageView youtube;
    @FXML 
       private  ImageView twitter;
    @FXML 
       private ImageView facebook;
    @FXML
       private  ImageView Github;
    @FXML 
       private  ImageView Kora;
    @FXML
        private Button NT;
    @FXML 
        private TextField search;
    @FXML 
        private ImageView glassSearch;
    @FXML 
        private Label msg;
    @FXML
        private ImageView candy;
    @FXML 
        private Label msgGoogle;
    @FXML 
        private Label msgYoutube;
    @FXML 
        private Label msgTwitter;
    @FXML 
        private Label msgFacebook;
    @FXML 
        private Label msgGithub;
    @FXML 
        private Label msgKoraa;
   
    
    public void Search(){  
        Tabs.addTab(Jdfv.tpane).tabLoad(search.getText());
//       Tabs t = new Tabs();
//      t.change();
//      t.addToHistory();
    }
    
    
    
    public void Ac (){
        NT.setOnAction((event) -> {
             Tabs.addTab(Jdfv.tpane);
             
        });
    }
    
    public void showMsg(){
        candy.setOnMouseMoved((event) -> {
           msg.setText("Candy Butcher");
        });
         
        candy.setOnMouseExited((event) -> {
           msg.setText("");
        });
        }
    
    
    public void GoBookMarks() throws IOException{
    
        
         Parent tableViewParent =FXMLLoader.load(getClass().getResource("mainBookMarks.fxml"));  
           Scene tableViewScene = new Scene(tableViewParent);     
           Stage window =new Stage();
             window.setTitle("Bookmarks");
              window.setScene(tableViewScene);
               window.show();
    
    }
    
    
    public  void hs(){
        
    jdfv.Jdfv.history.show();
    }
    
   public void GoogleScene() throws ClassNotFoundException {
        Tabs.addTab(Jdfv.tpane).tabLoad("www.google.com");
    
//         Stage window=(Stage) google.getScene().getWindow();
//         
//       try{
//       Parent tableViewParent =FXMLLoader.load(getClass().getResource("Scene2.fxml"));  
//       Scene tableViewScene = new Scene(tableViewParent); 
//       
//      //  Scene2Controller s= new Scene2Controller();
//      //  s.setWeb("https://www.google.com.eg");
//        
//       window.setScene(tableViewScene);
//        
//       window.show();
//     
//       } catch(IOException e){
//       e.getMessage();
//       }
   }  
   
    public void GMsg(){
    google.setOnMouseMoved((event) -> {
            msgGoogle.setText("Google");
        });
         
        google.setOnMouseExited((event) -> {
           msgGoogle.setText("");
        });
    
    }
   
   public void FaceBookScene() throws ClassNotFoundException {
       Tabs.addTab(Jdfv.tpane).tabLoad("https://www.facebook.com");
       
    
//         Stage window=(Stage)facebook.getScene().getWindow();
//       try{
//       Parent tableViewParent =FXMLLoader.load(getClass().getResource("Scene2.fxml"));  
//       Scene tableViewScene = new Scene(tableViewParent);  
//          Scene2Controller s= new Scene2Controller();
//          s.setWeb("https://www.youtube.com");
//       window.setScene(tableViewScene);
//       window.show();
//       } catch(IOException e){
//       e.getMessage();
//       }
   }  
   
    public void FMsg(){
    facebook.setOnMouseMoved((event) -> {
            msgFacebook.setText("Facebook");
        });
         
        facebook.setOnMouseExited((event) -> {
           msgFacebook.setText("");
        });
    
    }
   public void YoutubeScene() throws ClassNotFoundException {
    
      Tabs.addTab(Jdfv.tpane).tabLoad("https://www.youtube.com");
       
//         Stage window=(Stage) youtube.getScene().getWindow();
//       try{
//       Parent tableViewParent =FXMLLoader.load(getClass().getResource("Scene2.fxml"));  
//       Scene tableViewScene = new Scene(tableViewParent);  
//       
//       window.setScene(tableViewScene);
//       window.show();
//       } catch(Exception e){
//       e.getMessage();
//       }
   }
   
    public void YMsg(){
    youtube.setOnMouseMoved((event) -> {
            msgYoutube.setText("Youtube");
        });
         
        youtube.setOnMouseExited((event) -> {
           msgYoutube.setText("");
        });
    
    }
      public void TwitterScene() throws ClassNotFoundException {
          Tabs.addTab(Jdfv.tpane).tabLoad("https://www.Twitter.com");
    
//         Stage window=(Stage) twitter.getScene().getWindow();
//       try{
//       Parent tableViewParent =FXMLLoader.load(getClass().getResource("Scene2.fxml"));  
//       Scene tableViewScene = new Scene(tableViewParent);  
//       
//       window.setScene(tableViewScene);
//       window.show();
//       } catch(Exception e){
//       e.getMessage();
//       }
   }
      
       public void TMsg(){
    twitter.setOnMouseMoved((event) -> {
            msgTwitter.setText("Twitter");
        });
         
        twitter.setOnMouseExited((event) -> {
           msgTwitter.setText("");
        });
    
    }
      public void GithubScene() throws ClassNotFoundException {
    
          Tabs.addTab(Jdfv.tpane).tabLoad("https://www.github.com");
          
//         Stage window=(Stage) Github.getScene().getWindow();
//       try{
//       Parent tableViewParent =FXMLLoader.load(getClass().getResource("Scene2.fxml"));  
//       Scene tableViewScene = new Scene(tableViewParent);  
//       
//       window.setScene(tableViewScene);
//       window.show();
//       } catch(Exception e){
//       e.getMessage();
//       }
   }
      
       public void GTMsg(){
    Github.setOnMouseMoved((event) -> {
            msgGithub.setText("Github");
        });
         
        Github.setOnMouseExited((event) -> {
           msgGithub.setText("");
        });
    
    }
         public void KoraScene() throws ClassNotFoundException {
             
             Tabs.addTab(Jdfv.tpane).tabLoad("https://www.yallakora.com");
    
//         Stage window=(Stage) Kora.getScene().getWindow();
//       try{
//       Parent tableViewParent =FXMLLoader.load(getClass().getResource("Scene2.fxml"));  
//       Scene tableViewScene = new Scene(tableViewParent);  
//       
//       window.setScene(tableViewScene);
//       window.show();
//       } catch(Exception e){
//       e.getMessage();
//       }
   }
   
          public void KMsg(){
    Kora.setOnMouseMoved((event) -> {
            msgKoraa.setText("Kora");
        });
         
        Kora.setOnMouseExited((event) -> {
           msgKoraa.setText("");
        });
    
    }
         
         
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}


