import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class StartBox implements AlertBox{

	// this class displays a popup which the user presses enter to begin the test
	@Override
	public void display() {
		Stage popup = new Stage();
		
		popup.initModality(Modality.APPLICATION_MODAL);
		popup.setResizable(false);
		popup.setTitle("Begin Test");
		popup.setWidth(250);
		VBox vbox = new VBox(10);
		vbox.setPadding(new Insets(5, 5, 5, 5));
		Label message = new Label("You have 10 minutes to complete this test");
		Label message2 = new Label("Press 'ENTER' to begin");
		vbox.setAlignment(Pos.CENTER);

		vbox.getChildren().addAll(message, message2);
		Scene popupScene = new Scene(vbox);
		popup.setScene(popupScene);
		popup.show();

		// enter to Begin test
		popupScene.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER) {
				popup.close();
				Exam exam = new Exam();
				exam.start();
			}
		});

		popup.setOnCloseRequest(e -> {
			e.consume();
			AlertBox a = new ExitBox();
			a.display();
		});
	}

}
