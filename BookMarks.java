package jdfv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
public class BookMarks implements RW{
private static LinkedList<Book_Mark_Node> list = new LinkedList<>();
private Button add; 
private VBox layout;
private PrintWriter writer;
      BookMarks() {
          layout = new VBox();
           
      }
    public VBox getLayout(){
        syce();
    return layout;
    }
  
    public void add(String url , String name){
        list.add(new Book_Mark_Node(url , name));
    }
    public Book_Mark_Node getBookMarkAt(int index){
        return list.get(index);
    }
    public void remove( int index){
        list.remove(index);
    }
    public void clear(){
        list.clear();
        layout.getChildren().clear();
    }
    
   public int getSize(){
       return list.size();
   }
 
    public void getBookMarks(ChoiceBox box){
        if(list.size()!= 0){
       for(int i = 0 ; i < list.size(); i++)
            box.getItems().add(list.get(i).getButton().getText());
        }
        }
    
       public void delete (){
           System.out.println(list.size());
             for(int i = 0 ; i < list.size(); i++){ 
                 
            if(list.get(i).isChecked()){
                System.out.println(list.get(i).isChecked());
               list.remove(i);
             layout.getChildren().remove(i);
            }
           
            }
             
       } 
       
       
     public void syce(){
       layout= new VBox();
     for(int i = 0 ; i < list.size(); i++){
       FlowPane flow = new FlowPane();
       flow.setHgap(50);
       flow.getChildren().addAll(list.get(i).getButton(),list.get(i).getBox());
       layout.getChildren().add(flow);
     } 
     }  
        
    
        public  void setBookMark(){  
      FlowPane flow = new FlowPane();
       flow.setHgap(50);
       
         flow.getChildren().addAll(list.get(list.size()-1).getButton(),list.get(list.size()-1).getBox());
        layout.getChildren().add(flow);
        
        
        }

    @Override
    public void reader() {
         
	  BufferedReader bfr;
	  try {
		  bfr= new BufferedReader(new FileReader("BookMark.txt"));
		  String line = bfr.readLine();
                  String name;
                  String url;
		  while (line!=null) {
                      name = line.substring(0, line.indexOf('$'));
                      url = line.substring(line.indexOf('$' )+1, line.length());
                      add(url, name);
		  }
		  bfr.close();
		    
		  }catch (IOException e) {
			e.printStackTrace();
		}
    }
   

    @Override
    public void write() {
    try {
        writer = new PrintWriter("BookMark.txt");
        for(int i = 0; i  < list.size(); i++){
           writer.println(list.get(i).getUrl() + "$" + list.get(i).getName());
       }
        writer.close();
    } catch (FileNotFoundException ex) {
        Logger.getLogger(BookMarks.class.getName()).log(Level.SEVERE, null, ex);
    }
       
    }
    
//    public void print(){
//        for(int i = 0; i < list.size(); i++){
//            System.out.println(list.get(i).getUrl());
//        }
//    }
        
    
}