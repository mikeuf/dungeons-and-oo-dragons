import java.util.ArrayList;
import java.util.Scanner;

/**
 * DungeonsAndObjectOrientedDragons.java
 * Runs through a user interface that allows the user to create knights
 * and have them fight random monsters or each other.
 *
 * @author Mike Black
 * @version 1.0
 * */
class DungeonsAndObjectOrientedDragons {

  /** stores player character (PC) for fighting */
  private static PlayerCharacter pc;

  /** stores non-player characters (NPCs) for fighting */
  private static ArrayList<NonPlayerCharacter> NON_PLAYER_CHARACTER_ARRAY = new ArrayList<>();

  /**
   * Character can choose number of random enemies to generate.
   * Each monster has multiple attack types, with different damage multipliers. The weapons are selected at random.
   * Each of the enemies has a random amount of treasure. After each battle, the player
   * knight will take the treasure and update his gold_ member variable.
   * */
  private static void dungeonOfInfiniteLoops() {

    System.out.printf("\nHow many monsters would you like %s to fight?\n", pc.getName());
    Scanner input = new Scanner(System.in);
    int numberOfNonPlayerCharacters = 0;

    try {
      numberOfNonPlayerCharacters = input.nextInt();
    } catch (Exception ex) {
      System.out.println("Enter a number.");
    }


    generateNonPlayerCharacters(numberOfNonPlayerCharacters);

    // create a battle for each NPC
    for (NonPlayerCharacter npc : NON_PLAYER_CHARACTER_ARRAY) {
      Encounter anEncounter = new Encounter(pc, npc);
    }
  }

  /**
   * Displays short welcome message when the user starts the program
   */
  private static void welcomeMessage() {
    System.out.print("Welcome to Dungeons and Object Oriented Dragons!" +
            "You are a brave knight who is about to enter the Dungeon of Infinite Loops.");
  }

  private static void buildMonsterArray(int numEnemies) {
    for (int i = 0; i < numEnemies; ++i) {
    }
  }

  /**
   * Auto-generates a PC, including the name
   */
  private void generatePlayerCharacter() {
    PlayerCharacter pc = new PlayerCharacter();
    pc.generateName();
    pc.generateWeapon();
    pc.generateArmor();
  }

  /**
   * Allows user to enter a name and choose weapon, but auto-generates the rest
   */
  private static void createPlayerCharacterManually() {
    PlayerCharacter pc = new PlayerCharacter();
    pc.generateName();

    System.out.print("Enter the name of your knight: ");
    private final Scanner input = new Scanner(System.in);
    String name = input.nextLine();
    pc.setName(name);
    pc.chooseWeapon();
    pc.generateArmor();
  }

  /**
   * Populates the array with random NPCs based on the number that the player requests
   * @param numberOfNonPlayerCharacters
   */
  public static void generateNonPlayerCharacters(int numberOfNonPlayerCharacters) {

    for (int i = 0; i < numberOfNonPlayerCharacters; ++i) {

      // creates random NPC object for player to fight
      int randomInteger = ((int) ((Math.random() * 3) + 1));

      switch (randomInteger) {
        case 1: {
          NON_PLAYER_CHARACTER_ARRAY.add(new Hobgoblin());
        }
        case 2: {
          NON_PLAYER_CHARACTER_ARRAY.add(new Bugbear());
        }
        case 3: {
          NON_PLAYER_CHARACTER_ARRAY.add(new Balrog());
        }
        default:
          System.out.print("\nError while generating monster. Exiting\n");
          System.exit(1);
      }
    }
  }

  /*
   * main() runs through the general user interface script
   * */
  public static void main(String[] args) {

    welcomeMessage();

    Scanner input = new Scanner(System.in);
    String playAgain = null; // must be initialized outside of the loop for scoping reasons

    do {
      NON_PLAYER_CHARACTER_ARRAY.clear();
      createPlayerCharacterManually();
      dungeonOfInfiniteLoops();

      // after the fighting is complete
      System.out.print("\nPlay again? (y/n): ");

      // running nextLine() twice to clear the buffer, so it doesn't auto trigger
      playAgain = input.nextLine();

      if (playAgain.equalsIgnoreCase("n")) {
        System.out.print("\nExiting program... \n");
        System.exit(0);
      } else if ((!(playAgain.equalsIgnoreCase("n")) &&
              (!(playAgain.equalsIgnoreCase("y"))))) {
        System.out.println("Enter either \"y\" or \"n.\"");
      }
    }
    while (playAgain.equalsIgnoreCase("y"));
  }
}
