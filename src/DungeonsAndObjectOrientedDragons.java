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
  private static final ArrayList<NonPlayerCharacter> NON_PLAYER_CHARACTER_ARRAY = new ArrayList<>();

  private static final Scanner keyboardInput = new Scanner(System.in);
  /**
   * Character can choose number of random enemies to generate.
   * Each monster has multiple attack types, with different damage multipliers. The weapons are selected at random.
   * Each of the enemies has a random amount of treasure. After each battle, the player
   * knight will take the treasure and update his gold_ member variable.
   * */
  private static void dungeonOfInfiniteLoops() {
    System.out.printf("\nHow many monsters would you like %s to fight?\n", pc.getName());
    int numberOfNonPlayerCharacters = 0;

    try {
      numberOfNonPlayerCharacters = keyboardInput.nextInt();
    } catch (Exception ex) {
      System.out.println("Enter a number.");
    }

    generateNonPlayerCharacters(numberOfNonPlayerCharacters);

    System.out.println("\nNow entering the dungeon...");

    /*
     * for each NPC, create an encounter
     * Verify that the array is not empty and that the game is not lost before creating an encounter
     */
    for (NonPlayerCharacter npc : NON_PLAYER_CHARACTER_ARRAY) {
      if ((NON_PLAYER_CHARACTER_ARRAY.size() > 0) &&
              (GameStatus.theCurrentGameStatus != GameStatus.CurrentGameStatus.GAME_OVER_PLAYER_LOST)) {
        Encounter anEncounter = new Encounter(pc, npc);

      }
    }
  }

  /**
   * Displays short welcome message when the user starts the program
   */
  private static void displayWelcomeMessage() {
    System.out.println("Welcome to Dungeons and Object Oriented Dragons!" +
            "\nYou are a brave knight who is about to enter the Dungeon of Infinite Loops.");
  }

  private static int chooseInteractiveOrAutomaticCreation() {
    System.out.println("\nChoose one of the following:" +
            "\n1) Interactively create a new knight" +
            "\n2) Automatically generate a new knight" +
            "\n\nYour choice, my liege? ");

    return keyboardInput.nextInt();
  }

  /**
   * Auto-generates a PC, including the name
   */
  private static void createPlayerCharacterAutomatically() {
    pc = new PlayerCharacter();
    pc.chooseNameAutomatically();
    pc.chooseWeaponAutomatically();
    pc.chooseArmorAutomatically();
  }

  /**
   * Allows user to enter a name, choose a weapon and armor, but auto-generates the rest
   */
  private static void createPlayerCharacterInteractively() {
    pc = new PlayerCharacter();

    System.out.println("\nEnter the name of your knight: ");
    String name = null;
    try {
      keyboardInput.nextLine(); // advancing to avoid repeat of previous entry
      name = keyboardInput.nextLine();
    }
    catch (Exception ex) {
    System.out.println("An unexpected error occurred: " + ex);
    }
    pc.setName(name);

    pc.chooseWeaponInteractively();
    pc.chooseArmorInteractively();
  }

  /**
   * Populates the array with random NPCs based on the number that the player requests
   * @param numberOfNonPlayerCharacters the desired number of monsters to create
   */
  private static void generateNonPlayerCharacters(int numberOfNonPlayerCharacters) {
    for (int i = 0; i < numberOfNonPlayerCharacters; ++i) {
      int randomInteger = ((int) ((Math.random() * 3) + 1));
      switch (randomInteger) {
        case 1: {
          NON_PLAYER_CHARACTER_ARRAY.add(new Hobgoblin());
          break;
        }
        case 2: {
          NON_PLAYER_CHARACTER_ARRAY.add(new Bugbear());
          break;
        }
        case 3: {
          NON_PLAYER_CHARACTER_ARRAY.add(new Dragon());
          break;
        }
        default:
          System.out.print("\nError while generating non-player characters. Exiting\n");
          System.exit(1);
      }
    }
  }

  /*
   * main() runs through the general user interface script
   * */
  public static void main(String[] args) {

    displayWelcomeMessage();

    String playAgain; // must be initialized outside of the loop for scoping reasons

    do {
      GameStatus.theCurrentGameStatus = GameStatus.CurrentGameStatus.GAME_IN_PROGRESS;

      NON_PLAYER_CHARACTER_ARRAY.clear();

      // player can create a new knight interactively or have the program automatically generate one
      int userChoice = chooseInteractiveOrAutomaticCreation();
      if (userChoice == 1) {
        createPlayerCharacterInteractively();
      }
      else if (userChoice == 2) {
        createPlayerCharacterAutomatically();
      }

      System.out.println("\nYour knight has been created! Here are your stats:");
      pc.printStats();



      dungeonOfInfiniteLoops();

      // after the fighting is complete
      System.out.print("\nPlay again? (y/n): ");

      // running nextLine() twice to clear the buffer, so it doesn't auto trigger
      keyboardInput.nextLine();
      playAgain = keyboardInput.nextLine();

      if (playAgain.equalsIgnoreCase("n")) {
        System.out.print("\nExiting program. I wish you good fortune in the wars to come...\n");
        System.exit(0);
      } else if ((!(playAgain.equalsIgnoreCase("n")) &&
              (!(playAgain.equalsIgnoreCase("y"))))) {
        System.out.println("Enter either \"y\" or \"n.\"");
      }
    }
    while (playAgain.equalsIgnoreCase("y"));
  }
}
