
// The class will represent the single Term with its meanings in the dictionary
// the dictionary will include Terms With their meanings

public class TermWithMeaning {

	private String termName;
	private String meaning;
	
	
	public TermWithMeaning(String newTerm, String newMeaning) {
		
		termName = newTerm;
		meaning = newMeaning;
		
	}
	
	public String getTermName() {
		return termName;
	}
	
	
	public String getMeaning() {
		return meaning;
	}
	
	
	public void setMeaning(String newMeaning) {
		
		if (newMeaning != null && newMeaning instanceof String)		
			meaning = newMeaning;
	}
	
	
}
