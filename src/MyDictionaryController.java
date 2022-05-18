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
    	
    	//Get value of input
    	String termToRemove = deleteTermInput.getText();

    	// Remove the term recieved
    	theDictionary.removeTerm(termToRemove);
    	
    	
    	System.out.println(theDictionary);
    }

    @FXML void insertNewTermPressed(ActionEvent event) {

    	//Get values of inputs
    	String newTermName = insertNewTermNameInput.getText();
    	String newMeaning = insertNewTermMeaningInput.getText();
    	
    	
    	//Add to dictionary 
    	theDictionary.addNewTerm(newTermName, newMeaning);
    	
    	System.out.println(theDictionary);
    	//System.out.println(newTermName + " - "+ newMeaning);
    }


    @FXML void searchPressed(ActionEvent event) {

    	//Get value of input
    	String searchTerm = searchTermInput.getText();
    	
   
    	System.out.println(theDictionary.searchTerm(searchTerm));
    }

    @FXML void updateMeaningPressed(ActionEvent event) {

       	//Get values of inputs
    	String termName = updateTermNameInput.getText();
    	String newMeaning = updateNewTermMeaning.getText();
    	
    	//Update dictionary 
    	theDictionary.updateMeaningOfTerm(termName, newMeaning);
    	
    	System.out.println(theDictionary);
    }

    
    // File handling
    
    @FXML void loadDicFromFilePressed(ActionEvent event) {

    	System.out.println("load");
    }

    @FXML void saveToFilePressed(ActionEvent event) {

    	System.out.println("saveTo");
    }

    

}
