import java.util.ArrayList;
public class TenziPlayer{

	private ArrayList<Die> dice;
	private int targetNum;
	private int numSavedDice;
	private String name;
	private boolean isComp;

	// Initialize dice, add numDice to list, set numSavedDice to zero
	public TenziPlayer(int numDice, String n,  boolean isComp){

		name = n;
		dice = new ArrayList<Die>();
		for(int i = 0; i < numDice; i++)
		dice.add(new Die(6));
		numSavedDice = 0;
		this.isComp = isComp;

	}

	// Initialize to start with the default 10 dice
	public TenziPlayer(){
		this(10, "", false); // Calls the int constructor with 10
	}

public int getMostFreqNum() {

	int[] count = new int[7];
	for(Die d : dice) {
	count[d.getLastRoll()]++;
}

int maxc = 0;
int MostFreqNum = -1;
for (int i = 1; i <= 6; i++) {
	if(count[i] > maxc) {
		maxc = count[i];
		MostFreqNum = i;
	}
}
return MostFreqNum;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

	 // Get the Target Number
	public int getTargetNum(){

		return targetNum;

	}


	//Get the Number of Saved Dice -
	public int getNumSavedDice(){
		return numSavedDice;
	}

	// Set the Target Number
	public void setTargetNum(int num){
		targetNum = num;
	}

	// Roll all Die in dice arraylist
	public void roll(){
		for(Die d : dice)
		d.roll();


	}

	// Remove all dice that have a last roll matching Target
	// print out how many were removed this round and
	// update overall number of saved dice


	public void removeTargetDice(){

int count = 0;

		for(int i = dice.size()-1; i >= 0; i--)
			{
				Die d = dice.get(i);

				if(d.getLastRoll() == targetNum) {
					dice.remove(i);
					count++;
					}
				}
				System.out.println("Removed "+count+" "+targetNum+"'s");
				numSavedDice += count;
	}

	public void print(){
		System.out.println(dice); // Simple print for now.  Can be enhanced later
	}


	// return true if ArrayList dice is empty.
	public boolean done(){
	return this.dice.isEmpty();
	}

	public boolean isComp() {
		return this.isComp;
	}

}