import java.io.Serializable;
import java.util.SortedMap;
import java.util.TreeMap;

public class Dictionary implements Serializable{

	private SortedMap<String, String> termsWithMeanings;

	
	public Dictionary() {
		this.termsWithMeanings = new TreeMap<String,String>();
	}



	public SortedMap<String, String> getTermsWithMeanings() {
		return termsWithMeanings;
	}


	public void addNewTerm(String termName, String meaning) {
		
		this.termsWithMeanings.put(termName, meaning);
		
	}

	
	@Override
	public String toString() {
		return "Dictionary [termsWithMeanings= \n" + termsWithMeanings + "\n]";
	}
	
	
	public static void main(String[] args) {
		
		Dictionary d = new Dictionary();

		d.addNewTerm("Segev", "Kesten");
		
		System.out.println(d);
	}
}
