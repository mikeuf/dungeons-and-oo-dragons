import java.util.ArrayList;
import java.util.Scanner;

/**
 * KnightDriver.java
 * Runs through a user interface that allows the user to create knights
 * and have them fight random monsters or each other.
 *
 * @author Mike Black
 * @version 1.0
 * */
class KnightDriver {

  /** stores knights for fighting */
  private static final ArrayList<Knight> knightArray = new ArrayList<>();

  /** stores monsters for fighting */
  private static final ArrayList<Enemy> enemyArray = new ArrayList<>();

  /** Reinitialize knight array  */
  private static void clearKnights() {
    knightArray.clear();
  }

  /** Reinitialize enemy array */
  private static void clearEnemies() {
    enemyArray.clear();
  }

  /**
   * Player can choose number of random enemies to generate.
   * Each enemy has multiple attack types, with different damage multipliers. The weapons are selected at random.
   * Each of the enemies has a random amount of treasure. After each battle, the player
   * knight will take the treasure and update his gold_ member variable.
   * */
  private static void dungeonOfInfiniteLoops() {

    // using the last knight generated
    Knight k = knightArray.get(knightArray.size() - 1);

    System.out.printf("\nHow many enemies would you like %s to dance with?\n", k.getName());
    Scanner input = new Scanner(System.in);
    int numEnemies = input.nextInt();

    // generate n number of random enemies
    try {
      buildEnemyArray(numEnemies);
    } catch (numNotAnInt numNotAnInt) {
      // custom exception to reject non-ints
      numNotAnInt.getMessage();
    }

    // loop through each enemy encounter
    for (int i = 0; i < (enemyArray.size()); ++i) {

      // if the player is dead (from the last fight, break out of the loop)
      if (k.getHealth() < 0) {
        System.out.printf("\n%s has been vanquished before fighting all foes.\n" +
                "Woah to the vanquished... \n", k.getName());

        System.out.printf("\nThe %s makes off with %s's %d gold coins and donates them to\n" +
                        " a charity that supports underprivileged %ss of Middle Earth.\n",
                enemyArray.get(i - 1).getName(),
                k.getName(),
                k.getGold(),
                enemyArray.get(i - 1).getName());
        break;
      }

      // assigning element to "e" for the sake of readability
      Enemy e = enemyArray.get(i);

      // each enemy class has multiple possible attacks
      e.setAutoWeapon();

      System.out.printf("\n%s is merrily traversing the Dungeon of Infinite Loops when a dreaded %s leaps out\n" +
              " from the darkness, brandishing... %s\n", k.getName(), e.getName(), e.getWeapon());

      // print stats for enemy and knight
      System.out.printf("\n*** FIGHT %d of %d ***\n", (i + 1), enemyArray.size());
      System.out.print("\nENEMY STATS:");
      e.printEnemyStats();

      System.out.printf("\n%s STATS:", k.getName());
      k.printKnightStats();

      // determine which knight goes first
      if (knightArray.size() > 0) {

        /* Start the battle
         * Note: The monsters always get first-strike since they are the attackers */
        battle(k, e);
      } else {
        System.out.print("\nError: knightArray is unexpectedly empty. Exiting...");
        System.exit(1);
      }
    }
  }

  /**
   * Displays short welcome message when the user starts the program
   */
  private static void welcomeMessage() {
    System.out.print("\nWelcome to Dungeons and Object Oriented Dragons (with Random-Monster-Matic)!\n");
  }

  private static void buildEnemyArray(int numEnemies) {
    for (int i = 0; i < numEnemies; ++i) {
      enemyArray.add(Enemy.getRandomEnemy());
    }
  }

  /**
   * Auto-generates a knight, including the name
   */
  private static void createKnightAutomatically() {
    knightArray.add(new Knight());

    /*
     * these will auto-select from an enumerated list of names, weapons and armor.
     * I didn't want to put any more methods into the constructor than I had to, so
     * I put them here, instead.
     */
    knightArray.get(knightArray.size() - 1).setAutoName();
    knightArray.get(knightArray.size() - 1).setAutoWeapon();
    knightArray.get(knightArray.size() - 1).setAutoArmor();
  }

  /**
   * Allows user to enter a name and choose weapon, but auto-generates the rest
   */
  private static void createKnightManually() {
    knightArray.add(new Knight());
    knightArray.get(knightArray.size() - 1).setName();
    knightArray.get(knightArray.size() - 1).setWeapon();
    knightArray.get(knightArray.size() - 1).setAutoArmor();
  }

  /**
   * Randomly determine which knight attacks first using a "coin toss"
   */
  private static void coinToss(Knight knight1, Knight knight2) {
    int coinToss = ((int) ((Math.random() * 2) + 1));

    if (coinToss == 1) {
      knight1.setFightOrder(1);
      knight2.setFightOrder(2);
      System.out.printf("\n%s wins the coin toss!\n", knight1.getName());
    } else if (coinToss == 2) {
      knight1.setFightOrder(2);
      knight2.setFightOrder(1);
      System.out.printf("\n%s wins the coin toss!", knight2.getName());
    } else {
      System.out.printf("\nError: coinToss returned unexpected value: %d\n", coinToss);
      System.exit(1);
    }
  }

  /**
   * Manage battle between knights only (no monsters).
   * Fight continues until someone's health drops to zero
   */
  private static void battle(Knight k1, Knight k2) {
    int roundNumber = 0;

    // print stats at beginning of reach round
    do {
      System.out.printf("\n*** ROUND %d ***", ++roundNumber);
      System.out.printf("\nHEALTH LEVELS:\n" +
              "%s: %d \n" +
              "%s: %d \n", k1.getName(), k1.getHealth(), k2.getName(), k2.getHealth());
    }
    while ((k1.fight(k2) != 1) &&
            (k2.fight(k1) != 1));

    System.out.print("\nEnd of battle.\n");
  }

  /**
   * Manage battle between knight and monster
   * Fight continues until someone's health drops to zero
   * Note: This is an overload of battle()
   */
  private static void battle(Knight k, Enemy e) {
    int roundNumber = 0;
    Scanner input = new Scanner(System.in);

    do {
      System.out.print("\nPress Enter to continue...\n");
      String anyKey = input.nextLine();

      // print stats at beginning of reach round
      System.out.printf("\n*** ROUND %d ***", ++roundNumber);
      System.out.printf("\nHEALTH LEVELS:\n" +
              "%s: %d \n" +
              "%s: %d \n", k.getName(), k.getHealth(), e.getName(), e.getHealth());
    }
    while ((k.fight(e) != 1) &&
            (e.fight(k) != 1));

    System.out.print("\nEnd of battle.\n");
  }

  /**
   * When the user indicates, at the main menu, that they want to fight another night, this gives
   * them a chance to generate an opponent, either automatically, or manually.
   * Once a knight has been created, the stats are printed and the battle begins
   */
  private static void knightFight() {
    Scanner input = new Scanner(System.in);
    String response = "";

    do {
      System.out.print("\nWould you like to auto-generate an opponent? (yes/no)\n");
      response = input.nextLine();

      if (response.equalsIgnoreCase("yes")) {
        createKnightAutomatically();
      } else if (response.equalsIgnoreCase("no")) {
        createKnightManually();
      } else {
        System.out.printf("\nYou entered \"%s\".", response);
        System.out.print("\nPlease enter exactly \"yes\" or \"no.\"\n");
      }
    } while ((!(response.equalsIgnoreCase("yes")) &&
            (!(response.equalsIgnoreCase("no")))));

    System.out.print("\nHere are the stats for your knights:\n");

    for (int i = 0; i < knightArray.size(); ++i) {
      System.out.printf("\n*** Knight %d ***", (i + 1));
      knightArray.get(i).printKnightStats();
    }

    do {
      System.out.print("\nEnter \"y\" to begin the fight, or \"n\" to exit: ");
      response = input.nextLine();

      if (response.equalsIgnoreCase("n")) {
        System.out.print("\nExiting program... \n");
        System.exit(0);
      } else if (response.equalsIgnoreCase("y")) {

        // determine which knight goes first
        if (knightArray.size() > 1) {
          coinToss(knightArray.get(knightArray.size() - 2), knightArray.get(knightArray.size() - 1));
        } else {
          System.out.print("\nERROR: knightArray is smaller than expected. Exiting...");
        }

        // start the actual battle
        if (knightArray.get(knightArray.size() - 2).getFightOrder() == 1) {
          battle(knightArray.get(knightArray.size() - 2), knightArray.get(knightArray.size() - 1));
        } else {
          battle(knightArray.get(knightArray.size() - 1), knightArray.get(knightArray.size() - 2));
        }
      } else {
        System.out.print("\nEnter exactly \"y\" or \"n\".");
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

      // this doesn't start until after the fighting is complete
        System.out.print("\nPlay again? (y/n): ");

        // running nextLine() twice to clear the buffered newline from the previous menu
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
} // end class
