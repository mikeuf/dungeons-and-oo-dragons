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

  /** stores knights for fighting */
  private static final ArrayList<PlayerCharacter> PLAYER_CHARACTER_ARRAY = new ArrayList<>();

  /** stores monsters for fighting */
  private static final ArrayList<NonPlayerCharacter> NON_PLAYER_CHARACTER_ARRAY = n  ew ArrayList<>();

  /** Reinitialize knight array  */
  private static void clearKnights() {
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
    PlayerCharacter k = PLAYER_CHARACTER_ARRAY.get(PLAYER_CHARACTER_ARRAY.size() - 1);

    System.out.printf("\nHow many enemies would you like %s to dance with?\n", k.getName());
    Scanner input = new Scanner(System.in);
    int numEnemies = input.nextInt();

    // generate n number of random enemies
    try {
      buildMonsterArray(numEnemies);
    } catch (numNotAnInt numNotAnInt) {
      // custom exception to reject non-ints
      numNotAnInt.getMessage();
    }

    // loop through each monster encounter
    for (int i = 0; i < (NON_PLAYER_CHARACTER_ARRAY.size()); ++i) {

      // if the player is dead (from the last fight, break out of the loop)
      if (k.getHealth() < 0) {
        System.out.printf("\n%s has been vanquished before fighting all foes.\n" +
                "Woah to the vanquished... \n", k.getName());

        System.out.printf("\nThe %s makes off with %s's %d gold coins and donates them to\n" +
                        " a charity that supports underprivileged %ss of Middle Earth.\n",
                NON_PLAYER_CHARACTER_ARRAY.get(i - 1).getName(),
                k.getName(),
                k.getGold(),
                NON_PLAYER_CHARACTER_ARRAY.get(i - 1).getName());
        break;
      }

      // assigning element to "e" for the sake of readability
      NonPlayerCharacter e = NON_PLAYER_CHARACTER_ARRAY.get(i);

      // each monster class has multiple possible attacks
      e.generateWeapon();

      System.out.printf("\n%s is merrily traversing the Dungeon of Infinite Loops when a dreaded %s leaps out\n" +
              " from the darkness, brandishing... %s\n", k.getName(), e.getName(), e.getWeapon());

      // print stats for monster and knight
      System.out.printf("\n*** FIGHT %d of %d ***\n", (i + 1), NON_PLAYER_CHARACTER_ARRAY.size());
      System.out.print("\nMONSTER STATS:");
      e.printStats();

      System.out.printf("\n%s STATS:", k.getName());
      k.printStats();

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
    System.out.print("\nWelcome to Dungeons and Object Oriented Dragons (with Random-NonPlayerCharacter-Matic)!\n");
  }

  private static void buildMonsterArray(int numEnemies) {
    for (int i = 0; i < numEnemies; ++i) {
      NON_PLAYER_CHARACTER_ARRAY.add(getRandomMonster());
    }
  }


  public void setName() {
    System.out.print("Enter the name of your PlayerCharacter: ");
    private final Scanner input = new Scanner(System.in);
    setName(input.nextLine());
  }

  /**
   * Auto-generates a knight, including the name
   */
  private static void createKnightAutomatically() {
    PLAYER_CHARACTER_ARRAY.add(new PlayerCharacter());

    /*
     * these will auto-select from an enumerated list of names, weapons and armor.
     * I didn't want to put any more methods into the constructor than I had to, so
     * I put them here, instead.
     */
    PLAYER_CHARACTER_ARRAY.get(PLAYER_CHARACTER_ARRAY.size() - 1).setAutoName();
    PLAYER_CHARACTER_ARRAY.get(PLAYER_CHARACTER_ARRAY.size() - 1).generateWeapon();
    PLAYER_CHARACTER_ARRAY.get(PLAYER_CHARACTER_ARRAY.size() - 1).setAutoArmor();
  }

  /**
   * Allows user to enter a name and choose weapon, but auto-generates the rest
   */
  private static void createKnightManually() {
    PLAYER_CHARACTER_ARRAY.add(new PlayerCharacter());
    PLAYER_CHARACTER_ARRAY.get(PLAYER_CHARACTER_ARRAY.size() - 1).setName();
    PLAYER_CHARACTER_ARRAY.get(PLAYER_CHARACTER_ARRAY.size() - 1).setWeapon();
    PLAYER_CHARACTER_ARRAY.get(PLAYER_CHARACTER_ARRAY.size() - 1).setAutoArmor();
  }

  public static NonPlayerCharacter getRandomMonster() {

    // creates random monster object for knight to fight
    System.out.print("\ngetRandomMonster()\n");
    int monsterChooser = ((int) ((Math.random() * 3) + 1));

    switch (monsterChooser) {
      case 1: {
        return new Hobgoblin();
      }
      case 2: {
        return new Bugbear();
      }
      case 3: {
        return new Balrog();
      }
      default:
        System.out.print("\nError while generating monster. Exiting\n");
    }
// should not get here -- but adding this to satisfy the return value requirement
    return new Hobgoblin();
  }


  /**
   * When the user indicates, at the main menu, that they want to fight another night, this gives
   * them a chance to generate an opponent, either automatically, or manually.
   * Once a knight has been created, the stats are printed and the battle begins
   */
  private static void knightFight() {
    Scanner input = new Scanner(System.in);
    String response = "";

    createKnightAutomatically();

    System.out.print("\nHere are the pre-fight stats for the knights:\n");

    for (int i = 0; i < PLAYER_CHARACTER_ARRAY.size(); ++i) {
      System.out.printf("\n*** PlayerCharacter %d ***", (i + 1));
      PLAYER_CHARACTER_ARRAY.get(i).printStats();
    }

    do {
      System.out.print("\nPress any key to begin the fight.");
      response = input.nextLine();


      // determine which knight goes first
      if (PLAYER_CHARACTER_ARRAY.size() > 1) {
        coinToss(PLAYER_CHARACTER_ARRAY.get(PLAYER_CHARACTER_ARRAY.size() - 2), PLAYER_CHARACTER_ARRAY.get(PLAYER_CHARACTER_ARRAY.size() - 1));
      } else {
        System.out.print("\nERROR: PLAYER_CHARACTER_ARRAY is smaller than expected. Exiting...");
      }

      // start the actual battle
      if (PLAYER_CHARACTER_ARRAY.get(PLAYER_CHARACTER_ARRAY.size() - 2).getFightOrder() == 1) {
        battle(PLAYER_CHARACTER_ARRAY.get(PLAYER_CHARACTER_ARRAY.size() - 2), PLAYER_CHARACTER_ARRAY.get(PLAYER_CHARACTER_ARRAY.size() - 1));
      } else {
        battle(PLAYER_CHARACTER_ARRAY.get(PLAYER_CHARACTER_ARRAY.size() - 1), PLAYER_CHARACTER_ARRAY.get(PLAYER_CHARACTER_ARRAY.size() - 2));
      }
    }
    while ((!(response.equalsIgnoreCase("y")) &&
            (!(response.equalsIgnoreCase("n")))));
  } // end knightFight()

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
      clearKnights();
      clearEnemies();
      createKnightManually();

      System.out.println("What would you like to do?");
      System.out.println("1) Enter the Dungeon of Infinite Loops (fight random monsters).");
      System.out.println("2) Fight another knight.");
      System.out.println("3) Exit program.");

      // get user selection
      try {
        menu1Choice = input.nextInt();
      }
      catch (Exception ex) {
        System.out.println("This menu only accepts integers.\n" + "(" + ex + ")");
      }

      if (menu1Choice == 1) {
        dungeonOfInfiniteLoops();
      } else if (menu1Choice == 2) {
        knightFight();
      } else if (menu1Choice == 3) {
        System.out.print("\nExiting program ...\n");
        System.exit(0);
      } else {
        System.out.println("Please enter exactly 1, 2 or 3.");
      }

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
