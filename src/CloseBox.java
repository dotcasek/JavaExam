import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CloseBox implements AlertBox{

	// this alert box displays when the user attempts to exit mid-exam
	@Override
	public void display() {
	Stage popup = new Stage();
		
		popup.initModality(Modality.APPLICATION_MODAL);
		popup.setResizable(false);
		popup.setTitle("Cannot exit");
		popup.setWidth(350);
		VBox vbox = new VBox(10);
		vbox.setPadding(new Insets(5, 5, 5, 5));
		Label message = new Label("You may end the exam by pressing the 'SUBMIT' button");
		Button button = new Button("OK");
		button.setPrefWidth(45);
		vbox.setAlignment(Pos.CENTER);

		vbox.getChildren().addAll(message, button);
		Scene popupScene = new Scene(vbox); 
		popup.setScene(popupScene);
		popup.show();	
		
		button.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER) {
				popup.close();
			}
		});
		
		button.setOnAction(e->{
			popup.close();
		});
	}

}
