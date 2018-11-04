import java.util.ArrayList;
import java.util.Scanner;

/**
 * DungeonsAndObjectOrientedDragons.java
 *
 * This is a silly, "Dungeons and Dragons" inspired game. It is primarily an exercise in using common Object Oriented
 * Programming concepts (OOP) such as abstract classes, interfaces and inheritence. In this game, the user can creates
 * a PlayerCharacter (PC) in the form of a knight that is used to fight against NonPlayerCharacters (NPCs)
 * in the form of monsters.
 *
 * @author Mike Black
 * @version 1.0
 */
class DungeonsAndObjectOrientedDragons {

  private static PlayerCharacter pc;

  // stores the NPCs (monsters)
  private static final ArrayList<NonPlayerCharacter> NON_PLAYER_CHARACTER_ARRAY = new ArrayList<>();

  private static final Scanner keyboardInput = new Scanner(System.in);

  /**
   * Enter the dungeon and choose how many random NPCs to generate (and fight). For each NPC, an separate
   * encounter is generated.
   */
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
     * this creates an encounter for each NPC, But first verifies that the array is not empty and that
     * the PlayerCharacter is actually alive before creating an encounter.
     */
    for (NonPlayerCharacter npc : NON_PLAYER_CHARACTER_ARRAY) {
      if ((NON_PLAYER_CHARACTER_ARRAY.size() > 0) && //  null check
              (GameStatus.theCurrentGameStatus != GameStatus.CurrentGameStatus.GAME_OVER_PLAYER_LOST)) {
        Encounter currentEncounter = new Encounter(pc, npc);
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

  /**
   * Allows the user to decide if they want to create a PlayerCharacter interactively or automatically generate one.
   *
   * @return The menu option that is selected by the user
   */

  private static int chooseInteractiveOrAutomaticCreation() {
    System.out.println("\nChoose one of the following:" +
            "\n1) Interactively create a new knight" +
            "\n2) Automatically generate a new knight" +
            "\n\nYour choice, my liege? ");

    return keyboardInput.nextInt();
  }

  /**
   * Auto-generates a PlayerCharacter, including the name
   */
  private static void createPlayerCharacterAutomatically() {
    pc = new PlayerCharacter();
    pc.chooseNameAutomatically();
    pc.chooseWeaponAutomatically();
    pc.chooseArmorAutomatically();
  }

  /**
   * Allows user to interactively create a PlayerCharacter
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
   *
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

  public static void main(String[] args) {

    displayWelcomeMessage();

    String playAgain; // must be initialized outside of the loop for scoping reasons

    // the main loop that calls the functions that generate the characters and sends them to the dungeon. It loops
    // until the game is over
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

      // player enters the dungeon to fight monsters
      dungeonOfInfiniteLoops();

      // after the fighting is complete
      System.out.print("\nPlay again? (y/n): ");

      // running nextLine() twice to clear the buffer, so it doesn't auto trigger
      keyboardInput.nextLine();
      playAgain = keyboardInput.nextLine();

      // determine if the player wants to continue playing or exit
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
