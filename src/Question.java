import java.util.ArrayList;
import java.util.Collections;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class Question extends GridPane{


	private String answer = "";
	private int difficulty;
	private ToggleButton tbA = new ToggleButton("A");
	private ToggleButton tbB = new ToggleButton("B");
	private ToggleButton tbC = new ToggleButton("C");
	private ToggleButton tbD = new ToggleButton("D");
	private ToggleGroup tg = new ToggleGroup();	
	private ArrayList<Label> lb = new ArrayList<>();

	// constructor takes the arguments 
	//(Question, Correct answer, difficulty level, and the 3 incorrect answers)
	public Question(String q, String a, int d, String d1, String d2, String d3) {
		answer += a;
		difficulty = d;
		tbA.setToggleGroup(tg);
		tbB.setToggleGroup(tg);
		tbC.setToggleGroup(tg);
		tbD.setToggleGroup(tg);

		setAlignment(Pos.CENTER_LEFT);
		setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		setHgap(5.5);
		setVgap(5.5);
		
		lb.add(new Label(a));
		lb.add(new Label(d1));
		lb.add(new Label(d2));
		lb.add(new Label(d3));

		// randomize the order of the choices
		Collections.shuffle(lb);
		
		add(new Label(q), 0, 0);
		add(new HBox(10, tbA, lb.get(0)), 0, 1);
		add(new HBox(10, tbB, lb.get(1)), 0, 2);
		add(new HBox(10, tbC, lb.get(2)), 0, 3);
		add(new HBox(10, tbD, lb.get(3)), 0, 4);
	}
	
	public int getDifficulty(){
		return difficulty;
	}
	
	public boolean isCorrect(){
		String s = "";
		
		if(tbA.isSelected()){
			s = lb.get(0).getText();
		}
		else if(tbB.isSelected()){
			s = lb.get(1).getText();
		}
		else if(tbC.isSelected()){
			s = lb.get(2).getText();
		}
		else if(tbD.isSelected()){
			s = lb.get(3).getText();
		}
		else{
			AlertBox a = new GenError("Incorrect, No Answer Selected");
			a.display();
		}
		return answer.equals(s);
	}
	
}
