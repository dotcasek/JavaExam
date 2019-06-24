import java.io.Serializable;

// the Person class keeps track of the user scores and is written to a file as an object
// once the 2 scores have been set, the user is no longer allowed to attempt again
public class Person implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private double score1;
	private double score2;
	
	public Person(String s){
		score1 = -999;
		score2 = -999;
		setId(Integer.parseInt(s));
	}
	
	private void setId(int s){
		id = s;
	}
	
	public int getId(){
		return id;
	}
	
	public void setScore(double score){
		if(Double.compare(score1, -999) == 0){
			score1 = score;
			return;
		}
		if(Double.compare(score2, -999) == 0){
			score2 = score;
			return;
		}
	}
	public double highest(){
		
		if(score2 > score1){
			return (score2<0?0:score2);
		}
		else return (score1<0?0:score1);
	}
	
	public boolean isValid(){
		if(score1 == -999 || score2 == -999){
			return true;
		}
		else {
			return false;
		}
	}
	@Override
	public String toString(){
		return "First attempt: "+ score1 + " Second attempt: " + score2+"\n";
	}
	
}
