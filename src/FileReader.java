import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class FileReader {
	
	
	// this class reads all test data from an array of person objects
	private ArrayList<Person> tests;
	
	public FileReader(){
		
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream("testScores.dat"));
			tests = (ArrayList<Person>) input.readObject();
			input.close();

		} catch (IOException e) {
		} catch (ClassNotFoundException e) {}
	}

	public ArrayList<Person> getTests(){
		return tests;
	}

	



}
