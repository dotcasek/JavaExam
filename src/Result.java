
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Result extends BorderPane{
	private double score;
	
	public Result(int numCorrect, int numQuestions){
		Stage popup = new Stage();

		popup.initModality(Modality.APPLICATION_MODAL);
		popup.setResizable(false);
		popup.setTitle("Results");
		popup.setWidth(400);
		VBox vbox = new VBox(10);
		vbox.setAlignment(Pos.CENTER);
		
		Label lb1 = new Label();
		lb1.setText("You answered " + numCorrect + "/" + numQuestions + " Correct");
				
		String rank = setRank(numCorrect, numQuestions);
		
		Label lbsc = new Label(String.format("Score: %.2f", getScore()));
		
		Label lb2 = new Label();
		lb2.setText(rank);
		
		Button button = new Button("OK");
		
		vbox.getChildren().addAll(lb1, lbsc, lb2, button);
		
		this.setCenter(vbox);
		
		
		Scene popupScene = new Scene(this);
		popup.setScene(popupScene);

		popup.show();
		
		button.setOnAction(e->{
			popup.close();
		});

	}
	
	public double getScore(){
		return score;
	}


	// calculate the score and display the title
	private String setRank(int c, int q){
		int i = q - c;
		
		double modifier = (1.0 - ((double)c/q)) * i;
		
		score = c * 5 - modifier;
		
		if (score >= 85){
			return "You have earned the title of: Java Certified Architect";
		}
		else if (score >= 75 && score < 85){
			return "You have earned the title of: Jave Certified Developer";
		}
		else if (score >= 65 && score < 75){
			return "You have earned the title of: Java Cerified Programmer";
		}
		else{
			return "Sorry, you did not pass - try again";
		}
	}
}



