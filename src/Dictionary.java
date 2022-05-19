import java.io.Serializable;
import java.util.SortedMap;
import java.util.TreeMap;

public class Dictionary implements Serializable{

	private SortedMap<String, String> termsWithMeanings;

	
	public Dictionary() {
		this.termsWithMeanings = new TreeMap<String,String>();
	}

	//Get of the dictionary
	public SortedMap<String, String> getTermsWithMeanings() {
		return termsWithMeanings;
	}

	// Set the Dictionary by the parameter
	public void setTermsWithMeanings(SortedMap<String, String> termsWithMeanings) {
		
		if (termsWithMeanings instanceof SortedMap<?,?>)
			this.termsWithMeanings = termsWithMeanings;
	}

	
	public void addNewTerm(String termName, String meaning) {
		
		this.termsWithMeanings.put(termName, meaning);
		
		
	}
	


	public void updateMeaningOfTerm(String termName, String newMeaning) {

		
		if ( this.termsWithMeanings.containsKey(termName) )
			this.termsWithMeanings.put(termName, newMeaning);		
		
	}
	
	public void removeTerm(String termNameToRemove) {
		
		this.termsWithMeanings.remove(termNameToRemove);
	}
	
	
	public String searchTerm(String termNameToSearch) {
		
		return this.termsWithMeanings.get(termNameToSearch) ;
		
	}

	
	@Override
	public String toString() {
		return "Dictionary [termsWithMeanings= \n" + termsWithMeanings + "\n]";
	}
	
	
}
