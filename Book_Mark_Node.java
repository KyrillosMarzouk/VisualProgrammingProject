package jdfv;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class Book_Mark_Node {
    private String name;
    private String url;
    private Button bt ;
    private CheckBox box;
    
    Book_Mark_Node() {
        
    }
    
    public Book_Mark_Node(String url, String name) {
        this.url = url;
        this.name = name;
         bt =new Button (name);
         bt.setMinSize(200, 20);
         box = new CheckBox();
         bt.setOnAction(e-> Tabs.addTab(Jdfv.tpane).tabLoad(url));
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        bt.setText(name);
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public Button getButton (){
        return bt;
    }

    public CheckBox getBox() {
        return box;
    }
    
   public boolean isChecked(){
       return box.isSelected();
   }
    
    
}