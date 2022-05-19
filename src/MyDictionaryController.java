import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.SortedMap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

public class MyDictionaryController {

	
    
    private Dictionary theDictionary; 
    

    @FXML private TextField deleteTermInput;

    @FXML private ListView<Label> dictionaryList;

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
    	
    	//Remove from ListView
		for (Label singleTerm : dictionaryList.getItems())
		{
			if (singleTerm.getText().contains(termToRemove) )	{
				dictionaryList.getItems().remove(singleTerm);
				break;
			}
		}
		
    	System.out.println(theDictionary);
    }
    

    @FXML void insertNewTermPressed(ActionEvent event) {

    	//Get values of inputs
    	String newTermName = insertNewTermNameInput.getText();
    	String newMeaning = insertNewTermMeaningInput.getText();
    	boolean insertRes;
    	int indexOfLabels = 0;
    	
    	
    	//Add to dictionary 
    	insertRes = theDictionary.addNewTerm(newTermName, newMeaning);
    	
    	// Insert new element to ListView if necessary
    	if (insertRes) {
	    	Label newElem = new Label();
	    	newElem.setText("Term: "+newTermName +"\n\nMeaning: "+newMeaning);
	    	
	    	//Insert in Sorted way to ListView
	    	if (dictionaryList.getItems().size() > 0)	{
	    		
				for (Label singleTerm : dictionaryList.getItems())
				{
					if (singleTerm.getText().compareTo(newTermName) > 0 )	{
						if (indexOfLabels > 0)
							dictionaryList.getItems().add(indexOfLabels - 1, newElem);
						else
							dictionaryList.getItems().add(indexOfLabels , newElem);
						
						break;
					}
					indexOfLabels++;
				}		
	    	}
	    	else
	    		dictionaryList.getItems().add(newElem);
	    	
    	}
    	
    	System.out.println(theDictionary);
    	//System.out.println(newTermName + " - "+ newMeaning);
    }


    @FXML void searchPressed(ActionEvent event) {

    	//Get value of input
    	String searchTerm = searchTermInput.getText();
    	
   
    	for (Label singleTerm : dictionaryList.getItems())
		{
			if (singleTerm.getText().contains(searchTerm) )	{
				dictionaryList.getSelectionModel().select(singleTerm);
				break;
			}
		}
    	
    	System.out.println(theDictionary.searchTerm(searchTerm));
    }

    @FXML void updateMeaningPressed(ActionEvent event) {

       	//Get values of inputs
    	String termName = updateTermNameInput.getText();
    	String newMeaning = updateNewTermMeaning.getText();
    	boolean updateRes;
    	
    	//Update dictionary 
    	updateRes = theDictionary.updateMeaningOfTerm(termName, newMeaning);
    	
    	// Insert new element to ListView if necessary
    	if (updateRes) {
	    	
    		for (Label singleTerm : dictionaryList.getItems())
    		{
    			if (singleTerm.getText().contains(termName) )
    				singleTerm.setText("Term: "+termName +"\n\nMeaning: "+newMeaning);
    		}
    	}
    
    	
    	System.out.println(theDictionary);
    }

    
    // File handling
    
    //Method that will invoke when click on Load from File
	@FXML void loadDicFromFilePressed(ActionEvent event) {

    	File fileToOpenWith = getFileFromUser();
    	
    	
		try {
			FileInputStream fi = new FileInputStream(fileToOpenWith);
			ObjectInputStream objInp = new ObjectInputStream(fi);
			
			theDictionary.setTermsWithMeanings( (SortedMap<String, String>) objInp.readObject() );
			
			objInp.close();
			fi.close();
	    	
			System.out.println(theDictionary);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}    	
   }   
    
    
    //Method that will invoke when click on Save to File
    @FXML void saveToFilePressed(ActionEvent event) {
    	
    	File fileToSaveIn = getFileFromUser();
    	
		try {
			
			FileOutputStream fo = new FileOutputStream(fileToSaveIn);
			ObjectOutputStream outObj = new ObjectOutputStream(fo);
			
	    	outObj.writeObject(theDictionary.getTermsWithMeanings());
	    	outObj.close();
	    	fo.close();
	    	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
    }
    
    // Method to get the File from the user, using a File Chooser window
    private File getFileFromUser() {
    	
    	FileChooser fileChooser = new FileChooser();
    	
    	fileChooser.setTitle("Select a file to save the dictionary");
    	fileChooser.setInitialDirectory(new File("."));
    	
    	return fileChooser.showOpenDialog(null);
    }

    
    

}
