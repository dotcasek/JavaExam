import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		// create file if needed
		// load data from file
		ArrayList<Person> tests = new ArrayList<>();
		File file = new File("testScores.dat");
		if (!file.exists()) {
			file.createNewFile();
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("testScores.dat", false));
			output.writeObject(tests);
			output.close();
		}

		// set layout
		BorderPane pane = new BorderPane();

		Label lbHeader = new Label("Welcome to the Java Certification Exam");
		lbHeader.setStyle("-fx-font-size: 16pt;");
		lbHeader.setPadding(new Insets(10, 0, 0, 0));
		BorderPane.setAlignment(lbHeader, Pos.CENTER);
		pane.setTop(lbHeader);

		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(5);
		grid.setHgap(5);
		grid.setAlignment(Pos.CENTER);

		Label lbFirstName = new Label("First Name: ");
		GridPane.setConstraints(lbFirstName, 0, 0);
		grid.getChildren().add(lbFirstName);

		TextField tfFirstName = new TextField();
		GridPane.setConstraints(tfFirstName, 1, 0);
		grid.getChildren().add(tfFirstName);

		Label lbLastName = new Label("Last Name: ");
		GridPane.setConstraints(lbLastName, 0, 1);
		grid.getChildren().add(lbLastName);

		TextField tfLastName = new TextField();
		GridPane.setConstraints(tfLastName, 1, 1);
		grid.getChildren().add(tfLastName);

		Label lbPassword = new Label("ID: ");
		GridPane.setConstraints(lbPassword, 0, 2);
		grid.getChildren().add(lbPassword);

		PasswordField tfPassword = new PasswordField();
		GridPane.setConstraints(tfPassword, 1, 2);
		grid.getChildren().add(tfPassword);

		Button bt1 = new Button("Submit");
		GridPane.setHalignment(bt1, HPos.RIGHT);
		GridPane.setConstraints(bt1, 1, 3);
		grid.getChildren().add(bt1);

		pane.setCenter(grid);

		// SUBMIT Button handler
		bt1.setOnAction(e -> {
			
			// validate text fields
			if (tfFirstName.getText().length() == 0 || tfLastName.getText().length() == 0
					|| !tfPassword.getText().matches("^[0-9]{4}$")) {
				
				java.awt.Toolkit.getDefaultToolkit().beep();
				AlertBox ac = new GenError("All Fields Required - id must be 4 digits");
				ac.display();
			} else {
				
				// create new person object using id as key
				Person user = new Person(tfPassword.getText());
				
				// load past data from file
				FileReader fr = new FileReader();
				// if no records exist
				if (fr.getTests().size() == 0) {
					// create new record for the user
					new FileWriter(user);
					// begin test
					AlertBox a = new StartBox();
					a.display();
				} else {
					boolean found = false;
					// search for matching id's in the data file
					for (Person person : fr.getTests()) {
						if (person.getId() == user.getId()) {
							found = true;
							// check if more tests available
							if (person.isValid()) {
								AlertBox a = new StartBox();
								a.display();
							} else {
								AlertBox ab = new GenError(String.format("No More Attempts Allowed\n"
										+ "Highest score: %.2f", person.highest()));
								ab.display();
							}
						}

					}
					if (!found) {
						// add new id to record
						new FileWriter(user);
						AlertBox a = new StartBox();
						a.display();
					}
				}
			}
			tfPassword.clear();
		});

		Scene myScene = new Scene(pane);

		// confirm exit
		primaryStage.setOnCloseRequest(e -> {
			e.consume();
			quitApp();
		});

		primaryStage.setScene(myScene);
		primaryStage.setTitle("Java Certification Exam");
		primaryStage.setWidth(400);
		primaryStage.setHeight(400);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	/************************************************************
	 * Quit Application
	 ************************************************************/
	private void quitApp() {
		AlertBox a = new ExitBox();
		a.display();
	}

}
