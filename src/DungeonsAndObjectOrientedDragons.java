import java.util.ArrayList;
import java.util.Scanner;


// EMERGENCY EMERGENCY MAY DAY MAY DAY

/**
 * DungeonsAndObjectOrientedDragons.java
 * Runs through a user interface that allows the user to create knights
 * and have them fight random monsters or each other.
 *
 * @author Mike Black
 * @version 1.0
 * */
class DungeonsAndObjectOrientedDragons {

  /** stores player characters (PCs) for fighting */
  private static final ArrayList<PlayerCharacter> PLAYER_CHARACTER_ARRAY = new ArrayList<>();

  /** stores non-player characters (NPCs) for fighting */
  private static final ArrayList<NonPlayerCharacter> NON_PLAYER_CHARACTER_ARRAY = new ArrayList<>();

  /** Reinitialize knight array  */
  private static void clearPlayerCharacters() {
    PLAYER_CHARACTER_ARRAY.clear();
  }

  /** Reinitialize monster array */
  private static void clearEnemies() {
    NON_PLAYER_CHARACTER_ARRAY.clear();
  }

  /**
   * Character can choose number of random enemies to generate.
   * Each monster has multiple attack types, with different damage multipliers. The weapons are selected at random.
   * Each of the enemies has a random amount of treasure. After each battle, the player
   * knight will take the treasure and update his gold_ member variable.
   * */
  private static void dungeonOfInfiniteLoops() {

    // using the last knight generated
    PlayerCharacter pc = PLAYER_CHARACTER_ARRAY.get(PLAYER_CHARACTER_ARRAY.size() - 1);

    System.out.printf("\nHow many enemies would you like %s to fight?\n", pc.getName());
    Scanner input = new Scanner(System.in);
    int numEnemies = input.nextInt();

    // generate n number of random enemies
    try {
      buildMonsterArray(numEnemies);
    } catch (numNotAnInt numNotAnInt) {
      // custom exception to reject non-ints
      numNotAnInt.getMessage();
    }

    // loop through each NPC encounter
    for (int i = 0; i < (NON_PLAYER_CHARACTER_ARRAY.size()); ++i) {

      // if the player is dead (from the last fight, break out of the loop)
      if (k.getHealth() < 0) {
        System.out.printf("\n%s has been vanquished before fighting all foes.\n" +
                "Woah to the vanquished... \n", pc.getName());

        System.out.printf("\nThe %s makes off with %s's %d gold coins and donates them to\n" +
                        " a charity that supports underprivileged %ss of Middle Earth.\n",
                NON_PLAYER_CHARACTER_ARRAY.get(i - 1).getName(),
                pc.getName(),
                pc.getGold(),
                NON_PLAYER_CHARACTER_ARRAY.get(i - 1).getName());
        break;
      }

      // assigning element to "e" for the sake of readability
      NonPlayerCharacter e = NON_PLAYER_CHARACTER_ARRAY.get(i);

      // each monster class has multiple possible attacks
      npc.generateWeapon();

      System.out.printf("\n%s is merrily traversing the Dungeon of Infinite Loops when a dreaded %s leaps out\n" +
              " from the darkness, brandishing... %s\n", pc.getName(), e.getName(), e.getWeapon());

      // print stats for monster and knight
      System.out.printf("\n*** FIGHT %d of %d ***\n", (i + 1), NON_PLAYER_CHARACTER_ARRAY.size());
      System.out.print("\nMONSTER STATS:");
      npc.printStats();

      System.out.printf("\n%s STATS:", pc.getName());
      pc.printStats();

      // determine which knight goes first
      if (PLAYER_CHARACTER_ARRAY.size() > 0) {

        /* Start the battle
         * Note: The monsters always get first-strike since they are the attackers */
        battle(k, e);
      } else {
        System.out.print("\nError: PLAYER_CHARACTER_ARRAY is unexpectedly empty. Exiting...");
        System.exit(1);
      }
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

  public void generateNonPlayerCharacter(int numberOfNonPlayerCharacters) {

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

    // these need to be declared outside of the upcoming loops
    Scanner input = new Scanner(System.in);
    int menu1Choice = 0;
    String response = "";
    String playAgain = "";

    welcomeMessage();

    do {
      clearPlayerCharacters();
      clearEnemies();
      createPlayerCharacterManually();






      // after the fighting is complete
      System.out.print("\nPlay again? (y/n): ");

      // running nextLine() twice to clear the buffer, so it doesn't auto trigger
      input.nextLine();
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
