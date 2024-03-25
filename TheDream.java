public class TheDream 
{

	public static void main(String[] args) 
	{	
		//The players stats on when they start the game.
		int hp = 100;
		String inventory = "";
		int floor = 1;
		
		//Call the RunGame class
		RunGame game = new RunGame(hp, inventory, floor);
		//print out the game object.
		System.out.println(game);
		
	}
}

