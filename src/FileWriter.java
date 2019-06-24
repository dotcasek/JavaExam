import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileWriter {

	public FileWriter(Person p) {

		// this class creates and writes personal test data to a file
		File file = new File("person.dat");
		try {
			if (!file.exists()) {
				file.createNewFile();
			}

			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("person.dat", false));

			output.writeObject(p);

			output.close();
		} catch (IOException e) {}
	}
}
