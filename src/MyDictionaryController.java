import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MyDictionaryController {

	
    
    private Dictionary theDictionary; 
    

    @FXML private TextField deleteTermInput;

    @FXML private ListView<?> dictionaryList;

    @FXML private TextArea insertNewTermMeaningInput;

    @FXML private TextField insertNewTermNameInput;

    @FXML private TextField searchTermInput;

    @FXML private TextArea updateNewTermMeaning;

    @FXML private TextField updateTermNameInput;

    
    public void initialize() {
    	
    	theDictionary = new Dictionary();
    
    	
    }
    
    
    
    
    @FXML void deleteTermPressed(ActionEvent event) {

    }

    @FXML void insertNewTermPressed(ActionEvent event) {

    }

    @FXML void loadDicFromFilePressed(ActionEvent event) {

    }

    @FXML void saveToFilePressed(ActionEvent event) {

    }

    @FXML void searchPressed(ActionEvent event) {

    }

    @FXML void updateMeaningPressed(ActionEvent event) {

    }


}
