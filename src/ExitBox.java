import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ExitBox implements AlertBox{

	@Override
	public void display() {
		Stage popup = new Stage();
		
		popup.initModality(Modality.APPLICATION_MODAL);
		popup.setResizable(false);
		popup.setTitle("Exit");
		popup.setWidth(250);
		VBox vbox = new VBox(10);
		FlowPane fpane = new FlowPane(10, 10);
		Button btYes = new Button("Yes");
		Button btNo = new Button("No");
		Label message = new Label("Are you sure you want to exit?");
		fpane.getChildren().addAll(btYes, btNo);
		fpane.setAlignment(Pos.CENTER);
		vbox.setAlignment(Pos.CENTER);

		vbox.getChildren().addAll(message, fpane);
		Scene popupScene = new Scene(vbox);
		popup.setScene(popupScene);
		popup.show();

		btYes.setOnAction(e -> {
			System.exit(0);
		});

		// enter also confirms exit
		btYes.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER) {
				System.exit(0);
			}
		});

		btNo.setOnAction(e -> popup.close());
		
	}

}
