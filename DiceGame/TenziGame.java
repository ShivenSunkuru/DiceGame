import java.util.Scanner;
import java.util.ArrayList;

public class TenziGame {
    static Scanner input = new Scanner(System.in);
    static ArrayList<TenziPlayer> players;

    public static void main(String[]args){
  		      String play = "Y";
        while(play.equalsIgnoreCase("Y")) {
          		  playGame();
          		  System.out.println("\nWould you like to play again? (Y/N) : ");
            play = input.nextLine();
        }
      	  System.out.print("Thanks for Playing!\n");
    }

    public static void playGame() {
        System.out.println("_______________ TENZI! _______________");

		        players = new ArrayList<TenziPlayer>();
        System.out.println("\nHow many human players would you like? ");
        int numPlayers = input.nextInt();
        input.nextLine();
  				      for(int i = 0; i < numPlayers; i++) {
  	          System.out.println("Enter the desired name for player " + (i+1) + ": ");
        		    String playerName = input.nextLine();
       					     TenziPlayer player = new TenziPlayer(10, "", false);
   	     		    player.setName(playerName);
            players.add(player);
        }
        System.out.println("\nHow many computer players would you like? ");
        int numComp = input.nextInt();
        input.nextLine();
        for(int i = 0; i < numComp; i++) {
         		   players.add(new TenziPlayer(10, "Computer Player " + (i + 1), true));
        }

    			    int round = 0;
    		    while(true) {
            round++;
            System.out.println("\n---------------- Round #"+round+"----------------\n");
            for	(int i = 0; i < players.size(); i++){
                TenziPlayer p = players.get(i);
                System.out.println("\n>> "+ p.getName() + " <<" );
                p.roll();
                p.print();
                if(round == 1) {
            	    if(p.isComp()) {
                  		  int n = p.getMostFreqNum();
                    System.out.println("Chose --> "+n);
                    p.setTargetNum(n);
                }
                else
                {
                   			 System.out.println("Which number would you like to collect? ");
                    int n = input.nextInt();
                    input.nextLine();
               		     p.setTargetNum(n);
               	 }
			 }
              p.removeTargetDice();
                System.out.println("Left with: ");
                p.print();

             TenziPlayer winner = winner();
                if(winner != null) {
              System.out.println("TENZI! " + winner.getName() + " won in " + round + " rounds!");
                return;
                }
          	  }

          	  System.out.println("Press Enter to Roll again");
          	  input.nextLine();
		  }
	  }


   public static TenziPlayer winner() {
        for (TenziPlayer player : players)    {
      if (player.done()) {
        return player;
          		  }
     		   }
        return null;
  			  }
		}



