package DeckOfCards;

public class CardIdentifier {
	
	//Functions to print which images in the 'img' folder belongs to what suit
	public void printImagesWithClubSuit() {
		printImagesWithSuit("Cards with Club suit:   [",1,49);
	}
	
	public void printImagesWithDiamondSuit() {
		printImagesWithSuit("Cards with Diamond suit:[",2,50);
	}
	
	public void printImagesWithHeartSuit() {
		printImagesWithSuit("Cards with Heart suit:  [",3,51);
	}
	
	public void printImagesWithSpadeSuit() {
		printImagesWithSuit("Cards with Spade suit:  [",4,52);
	}
	
	//Algorithm to create String that will display which images in the 'img' folder belongs to what suit
	private void printImagesWithSuit(String x, int Ace, int King) {
		
		for(int i = Ace; i <= King; i+=4) {
			
			if(i != King) x += i + ", ";
			else x += i + "]";
			
		}
		
		System.out.println(x);
		
	}
	
	//Functions for identifying if randomlyChosenCard belongs to either of the four suits
	public boolean hasClubSuit(int pick) {
		return hasSuit(pick,1,49);
	}
	
	public boolean hasDiamondSuit(int pick) {
		return hasSuit(pick,2,50);
	}
	
	public boolean hasHeartSuit(int pick) {
		return hasSuit(pick,3,51);
	}
	
	public boolean hasSpadeSuit(int pick) {
		return hasSuit(pick,4,52);
	}
	
	//Algorithm for checking if randomlyChosenCard belongs to a range of cards belonging to a suit
	public boolean hasSuit(int pick, int Ace, int King) {
		
		for(int i = Ace; i <= King; i+=4) 
			
			if(pick == i) return true;
		
		return false;
	}

	//Functions for returning full name of randomlyChosenCard
	public String identifyClubCard(int pick) {
		return identifyCard(pick,1,49,0,"Clubs");
	}
	
	public String identifyDiamondCard(int pick) {
		return identifyCard(pick,2,50,1,"Diamonds");
	}
	
	public String identifyHeartCard(int pick) {
		return identifyCard(pick,3,51,2,"Hearts");
	}
	
	public String identifySpadeCard(int pick) {
		return identifyCard(pick,4,52,3,"Spades");
	}
	
	//Algorithm that returns the full name of the randomlyChosenCard
	private String identifyCard(int pick, int Ace, int King, int j, String suit) {
		
		for(int i = Ace; i <= King; i+=4) {
			
			if(pick == Ace) return  "Ace of " + suit;
			else if(pick == King - 8) return "Joker of " + suit;
			else if(pick == King - 4) return "Queen of " + suit;
			else if(pick == King) return "King of " + suit;
			else if(pick == i) return pick - j + " of " + suit;
			
			j += 3;
		}
		
		return "null";
	}
	
}