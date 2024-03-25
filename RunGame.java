import java.util.Scanner;

public class RunGame 
{
	Scanner keyboard = new Scanner(System.in); //Scanner to read in input from the user.
	private int hp; //The players health.
	private String inventory; //The players inventory.
	private int floor; //displays what floor the player is on.
	String name; //The name of the player
	String choice; //The players choice
	
	/**I've learned quite a bit in java 1 and java 2. Prior to taking intro to computer science I didn't have much programming experience.
	 * Last summer I started playing around with C# because a few of my friends are software engineers and they use it at their jobs.
	 * I had some fun with C# but I hardly knew how to do anything which is why I decided to go back to school for computer science.
	 * If I did not take this class I would not have 
	 * been able to make this game. I hardly knew what a constructors were, didn't understand the toString method, and
	 * I really didn't understand getters and setters very well.
	 * Almost everything I used to make this game were things that we used 
	 * in our programming assignments. I used a constructor, switch statements, if else statements,
	 * getters setters, and the toString method. 
	 * I also made a parameter list.
	 * 
	 */
	
	/**Constructor that accepts three arguments the players hp, inventory, and floor.
	 * 
	 * @param hp the players health.
	 * @param inventory the players inventory. 
	 * @param floor the players current floor.
	 */
	
	public RunGame(int hp, String inventory, int floor) 
	{
		this.hp = hp;
		this.inventory = inventory;
		this.floor = floor;
		
		//The start of the game.
		System.out.println("**************Welcome!****************************"
				+ "\n--You fall asleep and you wake up in this strange house------"
				+ "\n---Where the hell are you? and how do you get out?--------\n");
			System.out.println("*********************************");
				System.out.println("Enter your name. ");
				name = keyboard.next();
				System.out.println("Welcome to hell! " + name + " the only way to beat this game is if you make "
						+ "the right choices.....Good luck....");
				
		//calls the manHall method where the player starts.		
		mainHall();
		
	}

	/**
	 * mainHall method is called once the player enters their name they will be on the first
	 * floor in this weird house. For this program I used a lot of switch statements.
	 * I could have used if else statements but I thought the switch statements would
	 * make the code look better. Each switch statement has a default so the program will not
	 * crash if they player hits the wrong key. In some cases I punish you if you hit the wrong key
	 * you will make the worse choice of the two.
	 * 
	 * There is no random generator code because I thought I would make a game where 
	 * the outcome is different depending on the choice you make. 
	 * (just to make it a bit different from other text based games)
	 */

	public void mainHall() 
	{
		
		System.out.println("You're in the main hall in the house where will you go?"
				+ "\n\n*********************************\n\n"
				+ "HP: " + hp + " Inventory: " + inventory + "Floor: " + floor 
				+"\nPress (W) to enter the dining room."
				+ "\nPress (A) to enter the blue door on the east side."
				);
		choice = keyboard.next();
		
		switch(choice) 
		{
		
		case "W":
		case "w":
			
			diningRoom();
			break;
			
		case "A":
		case "a":
			blueDoor();
			break;
		
			default:
				blueDoor();
			break;
		} 
	}

	/**
	 * dingingRoom method is called when the player enters the dining room.
	 * In this room the player will find the sword that will become quite useful for them 
	 * for the rest of the game. 
	 */
	
	public void diningRoom() 
	{
	
		System.out.println("You have entered the dining room. You see a long table. There's a loud grandfather clock at the end of the hall."
				+ "\nYou spot a huge pool of blood on the floor. You see a sword near the clock and you pick it up. You see a door but it's locked so \n"
				+ "you decide to run back to the main hall and you go through that blue door room you saw earlier."); 
		
		inventory = inventory += "Sword";
		
		
		blueDoor();
		
		
		
		
	}
	
	/**
	 * blueDoor method is called when the player enters the blue door in the main hall.
	 * They will encounter a zombie!
	 * The player will die if they did not get the sword in the other room on the same floor. 
	 */
	
	public void blueDoor() 
	{
	
		
		System.out.println("You arrive in a small room. A strange looking creature walks towards you what will you do?"
				+ "\n\n*********************************\n\n"
				+ "HP: " + hp + " Inventory: " + inventory + " Floor: "+ floor 
				+"\nPress (W) to attack the zombie."
				+ "\nPress (A) to try and reason with him."
				);
			choice = keyboard.next();
			switch(choice) 
			{
			case "W":
			case "w":
				zombie(); 
				break;
				
			case "A":
			case "a":
				System.out.println("*******Excuse me sir are you okay? The monster lunges towards you and bites you \n"
						+ "************You try to push the zombie away and can't....The monster gets on top of you and bites your face off");
				 gameOver(); 
				
				
				break;
				
				default:
					System.out.println("*******Excuse me sir are you okay? The monster lunges towards you and bites you \n"
							+ "************You try to push the zombie away and can't....The monster gets on top of you and bites your face off");
					 gameOver(); 
					
			} 
		}
	/**
	 * secondFloor method is called when the player kills the zombie.
	 * They will see two doors and have the choice to go through one of them.
	 * On this floor the player will not die no matter what item they have or 
	 * do not have, but their health will be impacted. 
	 */
	
	public void secondFloor() 
	{
		floor = floor += 1;
		System.out.println("You have entered the second floor. There are two doors one to your left and one to your right. "
				+ " Which door will you go into?"
				+ "\n\n*********************************\n\n"
				+ "HP: " + hp + " Inventory: " + inventory + " Floor: "+ floor 
				+"\nPress (W) to go to the door on your left."
				+ "\nPress (A) to go to the door on your right."
				);
		choice = keyboard.next();
		switch(choice) 
		{
		case "W":
		case "w":
			secondFloorLeftDoor();
			break;
			
		case "A":
		case "a":
			secondFloorRightDoor();
			break;
			
			default:
				secondFloorLeftDoor();
				
		}
	}
	
	/**
	 * secondFloorLeftDoor method is called when the player enters the left door
	 * on the second floor. They will encounter the evil dog!
	 */

	public void secondFloorLeftDoor() 
	{
		System.out.println("You walk into a dimly lit room and you see and dog barking and growling inside a cage...."
				+ "The dog breaks out of its cage and charges right at you!"
				+ "\n\n"
				+ "HP: " + hp + " Inventory: " + inventory + " Floor: "+ floor 
				+"\nPress (W) to attack the dog."
				+ "\nPress (A) to give the dog a treat."
				);
		System.out.println(inventory.replaceAll("Sword","Treats"));
		choice = keyboard.next();
		switch(choice) 
		{
		case "W":
		case "w":
			niceDoggie();
			break;
			
		case "A":
		case "a":
			doggieTreat(); 
			break;
			
			default:
				niceDoggie();
		}
				
	}
	
	/**
	 * secondFloorRightDoor method is called when the player goes
	 * into the right door on the second floor.
	 * The player will find dog treats and will be added to their inventory.
	 */
	
	public void secondFloorRightDoor() 
	{
		
		inventory = inventory += "Treats";
		
		
		System.out.print("---You come into a small room and you see a desk. You search through the desk and you find \n"
				+ " -----Some dog treats.....Well I guess I'll take these I don't know why I'm doing this.\n\n");
		
		secondFloorLeftDoor(); 
		
	}
	
	/**
	 * thirdFloor method is called when the player gets passed the evil dog.
	 * Again the player will see two rooms and have to choices to make.
	 * 
	 */
	
	public void thirdFloor() 
	{
		floor = floor+= 1;
		System.out.println("You have entered the third floor. This floor looks the same as the second floor!"
				+ " You see two doors one on your left and one on your right. \n"
				+ "Which door will you go into?"
				+ "\n*********************************\n\n"
				+ "HP: " + hp + " Inventory: " + inventory + " Floor: "+ floor 
				+"\nPress (W) to go to the door on your left."
				+ "\nPress (A) to go to the door on your right."
				);
		choice = keyboard.next();
		switch(choice) 
		{
		
		case "W":
		case "w":
			thirdFloorLeftDoor();
			break;
		
		case "A":
		case "a":
			thirdFloorRightDoor();
			break;
		
		default:
			thirdFloorRightDoor();
		}
	}
	
	/**
	 * thirdFloorLefttDoor method is called when the player
	 * goes through the left door on the third floor. 
	 * The player will find gold.
	 */
	public void thirdFloorLeftDoor() 
	{
		inventory = inventory += "Gold";
		System.out.println("---You walk into a small bedroom. It doesn't look like there's anything useful in here----\n"
				+ "---hmmmm I wonder what's under the bed. You look under the bed and you find....A BUNCH OF GOLD!---- ");
		System.out.println("You decide to run into the right door.");
		thirdFloorRightDoor(); 
		
	}
	
	/**
	 * thirdFloorRightDoor method is called when the player
	 * goes through the right door on the third floor. They encounter the leprechaun.
	 * Decided to include a leprechaun in this game because I was thinking of 
	 * the leprechaun movie at the time.
	 */
	
	public void thirdFloorRightDoor() 
	{
		System.out.println("You walk into a dark room...You hear something laughing at you. A light shines into your face...."
				+ "\nYou look down and you see a leprechaun holding a lantern.\n"
				+ " ----I'm looking for my pot of gold....Do you have any gold for me---?\n\n"
				+ "HP: " + hp + " Weapons: " + inventory + " Floor: "+ floor 
				+"\nPress (W) give him some gold."
				+ "\nPress (A) to kill this creepy person."
				);
		choice = keyboard.next();
		
		switch(choice) 
		{
		case "W":
		case "w":
			giveLeprechaunGold();
		break;
		
		case "A":
		case "a":
			attackLeprechaun();
			break;
		
		default:
			attackLeprechaun();
		}
	}
	
	/**
	 * forthFloor method is called when the player reaches the fourth floor.
	 * The puzzle was the most fun thing to make with this program.
	 * I wanted to make each floor different in some way.
	 * The player will lose 30 hp if they make the wrong choice.
	 */
	
	public void fourthFloor() 
	{
		if (hp < 1) 
		{
			gameOver();
			
		}
		floor = floor+= 1;
		System.out.println("\n--You have entered the fourth floor. You see one door on this floor so you go through it.\n"
				+ "This room is much different from the previous rooms. The room is fully lit up with a bunch of pictures on the wall.\n"
				+ "---You see some writing on the wall.-------\n---If every person in life starts as a baby. What if we went through life"
				+ " backwards?----\n---There is a picture of an old man will you touch it? Press (W) \n"
				+ "---There is a picture of a teenager will you touch it? Press (A)\n"
				+ "---There is a picture of a baby will you touch it? Press (S)\n"
				+ "---There is a picture of a man going through his mid-life crisis. Will you touch it? Press (D)\n"
				
				+ "HP: " + hp + " Inventory: " + inventory + " Floor: "+ floor 
				);
		
		choice = keyboard.next();
		
		//player makes the right choice go to the next method if not
		//then they lose 30 hp and can try again.
		
		if (choice.equalsIgnoreCase("w")) 
		{
			System.out.println("Correct! what else?");
			oldMan();
		}
		
		else 
		{
			System.out.println("WRONG ");
			hp = hp -30;
			floor = floor -1; //subtract the floor count otherwise the program will keep adding floors.
			fourthFloor();
		}
		
		
	}
	
	/**
	 * oldMan method is called when the player presses the picture
	 * of the old man. The player will lose 30 hp if they
	 * make the wrong choice.
	 */
	
	public void oldMan() 
	{
		if (hp < 1) 
		{
			gameOver();
		}
		System.out.println("---There is a picture of a teenager will you press it? Press (A)\n"
				+ "---There is a picture of a baby will you press it? Press (S)\n"
				+ "---There is a picture of a man going through his mid-life crisis. Will you press it? Press (D)\n"
				+ "\n" + "HP:" + hp + " Inventory: " + inventory + " Floor: "+ floor );	
		choice = keyboard.next();
		
		if (choice.equalsIgnoreCase("d"))
		{
			System.out.println("Correct!");
			midLifeCrisis();
		}
		
		else 
		{
			System.out.println("WRONG");
			hp = hp -30;
			oldMan();
		}
		
	}
	
	/**
	 * midLifeCrisis method is called when the player presses the picture
	 * of the guy going through his mid-life crisis picture. The player will lose 30 hp if they
	 * make the wrong choice.
	 */
	
	public void midLifeCrisis() 
	{
		if (hp < 1) 
		{
			gameOver();
		}
		System.out.println("---There is a picture of a teenager will you press it? Press (A)\n"
				+ "---There is a picture of a baby will you press it? Press (S)\n"
				+ "\n" + "HP:" + hp + " Inventory: " + inventory + " Floor: "+ floor );	
		choice = keyboard.next();
		
		if (choice.equalsIgnoreCase("a")) 
		{
			System.out.println("CORRECT!");
			teenager();
		}
		
		else 
		{
			System.out.println("WRONG");
			hp = hp -30;
			midLifeCrisis();
		}
		
	}
	
	/**
	 * teenager method is called when the player presses the picture
	 * of the teenager picture. The player will lose 30 hp if they
	 * make the wrong choice.
	 */
	
	public void teenager() 
	{
		if (hp < 1) 
		{
			gameOver();
		}
		System.out.println("---There is a picture of a baby will you press it? Press (S)\n"
				+ "\n" + "HP:" + hp + " Inventory: " + inventory + " Floor: "+ floor );	
		choice = keyboard.next();
		
		if (choice.equalsIgnoreCase("s")) 
		{
			System.out.println("CORRECT!");
			roof();
		}
		
		else 
		{
			System.out.println("WRONG");
			hp = hp -10;
			teenager();
		}
	}
	
	/*
	 * roof method is called when the player completes the puzzle.
	 */
	
	public void roof() 
	{
		//If the players hp is greater than 0 continue if not they are dead.
		if (hp < 1) 
		{
			gameOver();
		}
		floor = floor += 1;
		System.out.println("The wall opens up which leads to stairs you go up the stairs to the roof! "
				+ "YOU DID IT CONGRADULATIONS You have made it to the roof! You see a helicopter flying above.\n"
				+ "A maniac with a hockey mask and a knife appears and chases after you! There's a flare on the ground maybe"
				+ " you can get the helicopters attention. \n"
				+ "---This guy must have followed me---\nWhat will you do? \n"
				+ "Press (W) to attack the maniac.\n"
				+ "Press (A) to use the flare.\n"
				+ "HP: " + hp + " Inventory: " + inventory + " Floor: " + floor);
		
		choice = keyboard.next();

		switch(choice) 
		{
		case "W":
		case "w":
			maniac();
			break;
			
		case "A":
		case "a":
			useFlare(); 
			break;
			
			default:
			useFlare();
		
		}
		
		
	}
	
	/**
	 * Zombie method is called when the player decides to attack the zombie. 
	 * if the player did not get the sword in the other room then 
	 * they are screwed and they die.
	 */
	public void zombie() 
	{
		//Check if the player has the sword in their inventory. 
		if (inventory.equals("Sword")) 
		{
		int zombiehp = 5;
		System.out.println("-----You attack the zombie--------- \n");
		zombiehp = zombiehp -2;
		System.out.println("Zombie HP: " + zombiehp + "\n");
		System.out.println("-----The bastard lunges at you and you lose hp. You push him back and stab him in the gut with your sword--------- ");
		hp = hp -4;
		zombiehp = zombiehp -3;
		System.out.println("Zombie HP: " + zombiehp + "\nIt looks he's dead.\n");
		System.out.println("-----You stare down at the twitching zombie.....WHAT THE HELL IS WRONG WITH THIS PLACE---------");
		System.out.println("-----You go back to the main hall....Hmmm maybe I'll look upstairs-------\n");
		secondFloor();
		}
		
		//If the player does not have the sword then it's game over!
		else 
		{
			System.out.println("The zombie claws at you and....EATS YOUR BRAINS OUT ");
			gameOver();
			
		}
	}
	
	/**
	 * niceDoggie method is called when the player decides to attack the dog or they did not get
	 * the dog treats in the other room.
	 */
	
	
	public void niceDoggie() 
	{
		int doggieHp = 10;
		System.out.println("---------You attack the dog----------");
		System.out.println("Doggie HP: " + doggieHp + " -----");
		System.out.println("The dog jumps at you...and bites your hand..---");
		
		hp = hp -30;
		System.out.println("---GET OFF OF ME YOUR BASTARD!-------");
		doggieHp = doggieHp -5;
		System.out.println("---You shake him off...AND YOU STAB IT WITH YOUR SWORD!------");
		doggieHp = doggieHp -5;
		System.out.println("Doggie HP: " + doggieHp);
		System.out.println("---You look down at the dog....and it looks like it's dead---");
		System.out.println("---You run out of the room and decide to head up the staircase to the third floor---\n");
		
		thirdFloor();
	}
	
	/**
	 * doggieTreat method is called if the player gets the dog treats from the other room.
	 */
	
	public void doggieTreat() 
	{
		// Checks if the player has the dog treats in their inventory.
		if (inventory.equals("SwordTreats")) 
		{
		System.out.println("---hmmmmmmm maybe he's just hungry... You decide to throw the dog treats you found---- ");
		System.out.println("----The dog calms down and eats the treat and then goes to sleep...I guess he was just hungry----");
		System.out.println("----You see another set of stairs and run up them to the third floor\n");
		
		thirdFloor();
		}
		
		//If the player does not have the dog treats then they must attack the dog.
		else 
		{
			System.out.println("You don't have ANY TREATS to give him so you attack it with your sword.");
			niceDoggie(); 
			
		}
	}
		
	/**
	 * Method is called when the player either does not have the gold or attacks the leprechaun.
	 */
	
	public void attackLeprechaun() 
	{
		
		int leprechaunHP = 30;
		System.out.println("---------You attack the leprechaun----------");
		System.out.println("Leprechaun HP: " + leprechaunHP + " -----");
		System.out.println("You stab the leprechaun with your sword and it...EXPLODES. ");
		leprechaunHP = leprechaunHP - 30;
		System.out.println("Leprechaun HP: " + leprechaunHP + " -----");
		System.out.println("AAAAAAhhhhhhhhh It looks like there is nothing left of him...Another set of stairs appears. You run up"
				+ " to the fourth floor.");
		hp = hp -66;
		
		if (hp < 1) 
		{
		gameOver();
		}
		fourthFloor();
	}
	
	/**
	 * The giveLeprechaunGold method is called when the player decides to give the weird leprechaun some gold.
	 */
	
	public void giveLeprechaunGold() 
	{
		//As long as the player has the gold in their inventory this method will be called.
		if (inventory.equals("SwordTreatsGold")) 
		{
		System.out.println("----You give the little weirdo some gold----");
		System.out.println("----THANK YOU SOOOO MUCH----tehe---the weirdo gives you a potion. Another set of stairs appears. You"
				+ " run up them to the fourth floor");
		hp = hp += 20;
		fourthFloor();
		}
		
		else if (inventory.equals("SwordGold")) 
		{
		System.out.println("----You give the little weirdo some gold----");
		System.out.println("----THANK YOU SOOOO MUCH----tehe---the wierdo gives you a potion. Another set of stairs appears.You"
				+ " run up them to the fourth floor");
		hp = hp += 20;
		fourthFloor();
		}
		
		//Player is forced to attack the leprechaun if they did not pick up the gold in the other room.
		else 
		{
			System.out.println("You don't have ANY GOLD to give him so you attack it with your sword.");
			attackLeprechaun();
		}
		
	}
	/**
	 * This method is called when the player decides to attack the maniac.
	 */
	public void maniac() 
	{
		
		int maniacHP = 100;
		System.out.println("------You attack the maniac-------");
		System.out.println("You stab the maniac with your sword! Maniac HP: " + maniacHP);
		maniacHP = maniacHP -30;
		System.out.println("The maniac fights back ");
		hp = hp -40;
		maniacHP = maniacHP -70;
		if (hp < 1) 
		{
			gameOver();
		}
		System.out.println("-----You stab him one last time-----and you WIN \nManiac HP: " + maniacHP);
		
		congrats();
		
	}
	
	/**
	 * The useFlare method is called if the player decides to use the flare to get the helicopters attention.
	 */
	public void useFlare() 
	{
		if (hp < 1) 
		{
			gameOver();
		}
	
		System.out.println("You grab the flare and wave------The maniac runs towards you and stabs you!");
		hp = hp -20;
		System.out.println("Maybe I should just attack him?\n");
		roof();
		
	}
	
	/**
	 * The congrats method is called when the player kills the maniac.
	 */
	
	public void congrats() 
	{
		System.out.println("----YOU WIN congrats " + name + " YOU KILLED THE MANIAC----\n"
				+ "the guy in the helicopter finally sees you...The helicopter lands near you....and....... \n"
				+ "YOU WAKE UP IN YOUR BEDROOM."
				+ "\n----boy I gotta lay off the sleeping pills what a crazy dream.---");
		System.out.println("Your stats were as follows");
	}
	
	
	/**
	 * 
	 * @return player hp.
	 */
	public int getHp() 
	{
		return hp;
	}

	/**
	 * 
	 * @param hp the players hp.
	 */
	public void setHp(int hp) 
	{
		this.hp = hp;
	}
	
/**
 * 
 * @return inventory
 */

	public String getInventory() 
	{
		return inventory;
	}

	/**
	 * 
	 * @param inventory the players inventory.
	 */

	public void setWeapon(String inventory) 
	{
		this.inventory = inventory;
	}

	/**
	 * 
	 * @return the floor the player is on.
	 */
	
	public int getFloor() 
	{
		return floor;
	}

	/**
	 * 
	 * @param floor the floor the player is on.
	 */
	
	public void setFloor(int floor) 
	{
		this.floor = floor;
	}
	
	
	/**
	 * toString method returns the getters and displays them at the end of the program.
	 * I used this method so that when the player completes the game they will see their stats.
	 */
	public String toString() 
	{
		String value ="";
		value = value += "HP: " + getHp() + "\n";
		value += "Inventory: " + getInventory() + "\n";
		value += "Floor: " + getFloor() + "\n";
		return value;
	}
	
	/**
	 * The gameOver method. This method is called when the players hp is less than 1.
	 */

	public void gameOver() 
	{
		
			System.out.println("***YOU ARE DEAD**...");
			System.out.println("Make better choices next time.");
			System.exit(0); //terminate the program when the player dies.
			
		}
    }