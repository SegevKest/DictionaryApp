import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MyDictionaryController {

    @FXML private Button deleteTermBtn;
    @FXML private TextField deleteTermInput;
    @FXML private ListView<?> dictionaryList;
    @FXML private Button insertNewTermBtn;
    @FXML private TextArea insertNewTermMeaningInput;
    @FXML private TextField insertNewTermNameInput;
    @FXML private Button loadDicFromFileBtn;
    @FXML private Button saveToFileBtn;
    @FXML private Button searchBtn;
    @FXML private TextField searchTermInput;
    @FXML private Button updateMeaningBtn;
    @FXML private TextArea updateNewTermMeaning;
    @FXML private TextField updateTermNameInput;
    
    
    



    @FXML void onDeleteTerm(MouseEvent event) {
    	System.out.println("Delete");
    } 

    @FXML void onInsertNewTerm(MouseEvent event) {
    	System.out.println("Insert");
    }

    @FXML void onSearchTerm(MouseEvent event) {
    	System.out.println("Search");
    }
 
    @FXML void onUpdateMeaning(MouseEvent event) {
    	System.out.println("Update");
    }

    
    // File handling
    @FXML void loadFromFile(MouseEvent event) {
		System.out.println("Load");
    }
    @FXML void saveDicToFile(MouseEvent event) {
    	System.out.println("save");
    }

}
