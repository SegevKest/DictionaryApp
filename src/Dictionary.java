import java.io.Serializable;
import java.util.SortedMap;
import java.util.TreeMap;

public class Dictionary implements Serializable{

	private SortedMap<String, String> termsWithMeanings;

	// Const
	public Dictionary() {
		this.termsWithMeanings = new TreeMap<String,String>();
	}

	//Get of the dictionary
	public SortedMap<String, String> getTermsWithMeanings() {
		return termsWithMeanings;
	}

	// Set the Dictionary according to the parameter
	public void setTermsWithMeanings(SortedMap<String, String> termsWithMeanings) {
		
		if (termsWithMeanings instanceof SortedMap<?,?>)
			this.termsWithMeanings = termsWithMeanings;
	}	
	
	// Add new Term to the dictionary. Returns true if insertion happened, false if already exist
	public boolean addNewTerm(String termName, String meaning) {
	
		if ( !this.termsWithMeanings.containsKey(termName) ) {
			this.termsWithMeanings.put(termName, meaning);
			return true;
		}
		else
			return false;
	}
	

	// The method updates the Term meaning in the Dictionary only if it is exist
	public boolean updateMeaningOfTerm(String termName, String newMeaning) {

		
		if ( this.termsWithMeanings.containsKey(termName) )	{
			this.termsWithMeanings.put(termName, newMeaning);		
			return true;
		}
		
		return false;
	}
	
	// Remove the Term from the Dictionary
	public void removeTerm(String termNameToRemove) {
		
		this.termsWithMeanings.remove(termNameToRemove);
	}
	
	// Search the term in the Dictionary - return null if not exist, its value if exist
	public String searchTerm(String termNameToSearch) {
		
		return this.termsWithMeanings.get(termNameToSearch) ;
		
	}

	
	@Override
	public String toString() {
		return "Dictionary [termsWithMeanings= \n" + termsWithMeanings + "\n]";
	}
	
	
}
