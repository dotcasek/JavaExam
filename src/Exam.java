import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Exam extends BorderPane {
	//private ArrayList<Question> current = new ArrayList<>();
	private Question q;
	private int numCorrect;
	private int numQuestions;
	private Button btSubmit;

	public Exam() {
		numQuestions = 0;
		numCorrect = 0;
		Stage popup = new Stage();

		// set layout
		popup.initModality(Modality.APPLICATION_MODAL);
		popup.setResizable(false);
		popup.setTitle("Java Exam");
		popup.setWidth(400);
		popup.setHeight(400);
		VBox vbox = new VBox(10);
		vbox.setAlignment(Pos.CENTER);
		
		btSubmit = new Button("Submit");
		btSubmit.setAlignment(Pos.CENTER_RIGHT);

		ProgressBar pBar = new ProgressBar(0);
		Label lbProg = new Label("");

		// start a thread which will run in the background binding the progress
		// bar to the overall progress of the exam out of 20 questions
		Service<Void> bgThread = new Service<Void>() {

			@Override
			protected Task<Void> createTask() {
				return new Task<Void>() {

					@Override
					protected Void call() throws Exception {
						updateProgress(0.0, 1);
						updateMessage(0.0 + "% Completed");
						while (numQuestions <= 20) {
							updateProgress(numQuestions / 20.00, 1.0);
							updateMessage((int) ((numQuestions / 20.00) * 100) + "% Completed");
						}
						return null;
					}
				};
			}
		};
		bgThread.setOnSucceeded(new EventHandler<WorkerStateEvent>() {

			@Override
			public void handle(WorkerStateEvent event) {
				btSubmit.fire();
			}
		});
		// bind progress bar
		pBar.progressProperty().bind(bgThread.progressProperty());
		lbProg.textProperty().bind(bgThread.messageProperty());
		bgThread.restart();

	

		HBox hb = new HBox();
		hb.setSpacing(5);
		hb.setAlignment(Pos.CENTER_LEFT);
		hb.getChildren().addAll(pBar, lbProg);

		HBox hb2 = new HBox();
		hb2.setPadding(new Insets(10, 0, 5, 0));
		hb2.setSpacing(100);
		hb2.getChildren().addAll(hb, btSubmit);
		hb2.setAlignment(Pos.CENTER);

		this.setCenter(vbox);
		this.setBottom(hb2);

		HBox btBox = new HBox(50);

		//Button btPrev = new Button("Prev");

		Button btNext = new Button("Next");

		btBox.getChildren().add(btNext);
		btBox.setAlignment(Pos.CENTER);
		
		// randomly generate difficulty of first question
		Random r = new Random();
		int i = r.nextInt(4);
		QuestionLoader ql = new QuestionLoader();
		q = ql.select(i).get(0);
		//current.add(q);

		vbox.getChildren().addAll(q, btBox);
		Scene popupScene = new Scene(this);
		popup.setScene(popupScene);

		popup.show();

		// next button handler
		btNext.setOnAction(e -> {
			// set counter for number of questions
			numQuestions++;

			boolean correct = q.isCorrect();

			int diff = q.getDifficulty();
			// remove current question from the list
			ql.pop(ql.select(diff));

			// increase difficulty if correct, decrease if incorrect
			if (correct) {
				numCorrect++;
				if (diff == 3) {
					q = ql.select(diff).get(0);
				} else {
					q = ql.select(diff + 1).get(0);
				}
			} else {
				if (diff == 0) {
					q = ql.select(diff).get(0);

				} else {
					q = ql.select(diff - 1).get(0);
				}
			}
			
			if (numQuestions == 20) {
				// show results after 20 questions
				btSubmit.fire();
			}

			// display new question
			vbox.getChildren().clear();
			vbox.getChildren().addAll(q, btBox);
		});

		// Submit Button handler
		btSubmit.setOnAction(e -> {
			// end test
			popup.close();
			// calculate results
			Result res = new Result(numCorrect, numQuestions);
			// read working person's file
			try {
				ObjectInputStream input = new ObjectInputStream(new FileInputStream("person.dat"));
				Person p = (Person) input.readObject();
				input.close();
				// update score
				p.setScore(res.getScore());
				
				// write updated info back to the file
				new FileWriter(p);


				ArrayList<Person> alp = new ArrayList<>();
				
				// get this person's index from arraylist
				FileReader fr = new FileReader();
				alp = fr.getTests();
				int index = -1;
				// if no records exist, add it
				if (alp.size() == 0) {
					alp.add(p);
				} else {
					boolean found = false;
					for (Person person : alp) {

						// replace the persons file with updated scores
						if (person.getId() == p.getId()) {
							found = true;
							index = alp.indexOf(person);
							alp.remove(index);

							alp.add(index, p);
						}

					}
					// add new test record if necessary
					if(!found){
						alp.add(p);
					}
				}

				// write the updated data back to the file

				ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("testScores.dat", false));
				output.writeObject(alp);
				output.close();

			} catch (IOException ioe) {
			} catch (ClassNotFoundException cnfe) {
			}
		});

		popup.setOnCloseRequest(e -> {
			e.consume();
			AlertBox a = new CloseBox();
			a.display();
		});

	}

	// start method is invoked at the beginning of the exam
	public void start() {

		Label lb = new Label();
		lb.setStyle("-fx-font-size: 20pt;");
		this.setTop(lb);
		setAlignment(getTop(), Pos.CENTER);

		
		// this starts a background thread which runs a timer for 10 minutes
		// for the user to complete the exam
		Service<Void> bgThread = new Service<Void>() {

			@Override
			protected Task<Void> createTask() {
				return new Task<Void>() {

					@Override
					protected Void call() throws Exception {
						updateMessage("10:00");
						for (int min = 9; min >= 0; min--) {
							for (int sec = 59; sec >= 0; sec--) {
								Thread.sleep(1000);
								updateMessage(String.format("%02d:%02d", min, sec));
							}
						}
						return null;
					}
				};
			}
		};
		bgThread.setOnSucceeded(new EventHandler<WorkerStateEvent>() {

			@Override
			public void handle(WorkerStateEvent event) {
				btSubmit.fire();
			}
		});
		lb.textProperty().bind(bgThread.messageProperty());
		bgThread.restart();
	}
}
