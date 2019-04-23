
package jdfv;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.geometry.Insets;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class History implements RW{
    LinkedList<HistoryNode> list = new LinkedList<>();

   private VBox layout ;
   private  Stage window;
   private Scene frame;
   private ScrollPane pane;
   private int  count = 0;
   private PrintWriter writer;

    History(){

        window = new Stage();
        window.setTitle("History");
    }

    public void add(String url){
        if(!list.isEmpty()){
            if(!list.get(list.size()-1).equals(url))
        list.add(new HistoryNode(url));
        }
         else{
            list.add(new HistoryNode(url));    
         }
    }
    public void add(String url , int index){
        list.add(index , new HistoryNode(url));
    }
    public HistoryNode getHistoryNodeAt(int index){
        return list.get(index);
    }
    public void printData(){
        if(list.size()!= 0){
        System.out.print("[");
        for(int i = 0 ; i < list.size()-1; i++)
            System.out.print(list.get(i).getUrl() + ",");

        System.out.print(list.get(list.size()-1).getUrl() + "]");
        }
    }
    public void setHistoryNode(HistoryNode data){
        list.add(data);
    }

    public LinkedList<HistoryNode> getHistory() {
        return list;
    }

    public void setHistory(History history) {
        this.list = history.getHistory();
    }

    public void remove(int index){
        list.remove(index);
    }
    public void clear(){
        list.clear();
    }
    public int getSize(){
        return list.size();
    }
  
    public void syce(){
        layout = new VBox();
        pane = new ScrollPane();
        pane.setMaxSize(700 ,700);
        pane.setContent(layout);
        pane.setPadding(new Insets(20,20,20,20));
        frame = new Scene(pane , 700,700);
        window.setScene(frame);
      for(int i = list.size()-1 ;i >=0; i--){
            FlowPane flow = new FlowPane();
            Text text =  new Text(list.get(i).getUrl() + "\t\t\t\t" + list.get(i).getDate() + "  " + list.get(i).getTime());
            text.setFont(Font.font(20));
            flow.setAlignment(Pos.CENTER);
            flow.getChildren().addAll(text , list.get(i).closeButton);
            layout.getChildren().add(flow);
        }
    }

    public void show(){
        syce();
        window.show();
    }

    public int getCount() {
        return count;
    }

    @Override
    public void reader() {
          BufferedReader bfr;
	  try {
		  bfr= new BufferedReader(new FileReader("History.txt"));
		  String line = bfr.readLine();
		  while (line!=null) {
			add(line);
		  }
		  bfr.close();
		    
		  }catch (IOException e) {
			e.printStackTrace();
		}
    }

     @Override
    public void write() {
     try {
        writer = new PrintWriter("History.txt");
        for(int i = 0; i  < list.size(); i++){
           writer.println(list.get(i).getUrl());
       }
        writer.close();
    } catch (FileNotFoundException ex) {
        Logger.getLogger(BookMarks.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
   

    // inner class
    public class HistoryNode {

        int numberOfTheObject;
        private String date;
        private String time;
        private String url;
        private Button closeButton;

        HistoryNode(String url){
            closeButton = new Button("X");
            numberOfTheObject = count;
            count++;
            this.url = url;
            Date d = new Date();
            SimpleDateFormat date = new SimpleDateFormat("MM/dd/y");
            this.date = date.format(d);
            SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss a");
            this.time = time.format(d);
            closeButton.setOnAction(e->{
                for(int i = 0 ; i < list.size(); i++){
                    if(numberOfTheObject == list.get(i).numberOfTheObject) {
                        list.remove(i);
                        syce();
                    }

                }
            });

        }

        public String getTime() {
            return time;
        }

        public int getNumberOfTheObject() {
            return numberOfTheObject;
        }

        public String getDate() {
            return date;
        }

        public String getUrl() {
            return url;
        }

        @Override
        public String toString() {
            return  url + " " + date + " " + time;
        }
    }
}