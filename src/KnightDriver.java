/**
KnightDriver.java
Runs through a user interface that allows the user to create knights
and have them fight random monsters or each other.

@author Mike Black
@version 1.0
*/

import java.util.ArrayList;
import java.util.Scanner;

public class KnightDriver {

  /** stores knights for fighting */
  static ArrayList<Knight> knightArray = new ArrayList<Knight>();

  /** stores monsters for fighting */
  static ArrayList<Enemy> enemyArray = new ArrayList<Enemy>();

  /** Reinitialize knight array  */
  public static void clearKnights() {
    knightArray.clear();
  }

  /** Reinitialize enemy array */
  public static void clearEnemies() {
    enemyArray.clear();
  }

  /**
   * Player can choose number of random enemies to generate.
   * Each enemy has multiple attack types, with different damage multipliers. The weapons are selected at random.
   * Each of the enemies has a random amount of treasure. After each battle, the player
   * knight will take the treasure and update his gold_ member variable.
   * */
  public static void dungeonOfInfiniteLoops() {

    // using the last knight generated
    Knight k = knightArray.get(knightArray.size() - 1);

    System.out.printf("\nHow many enemies would you like %s to dance with?\n", k.getName());
    Scanner input = new Scanner(System.in);
    int numEnemies = input.nextInt();

    // generate n number of random enemies
    try {
      if (numEnemies == numEnemies) {
        buildEnemyArray(numEnemies);
      } else {
        throw (new numNotAnInt());
      }
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
      System.out.printf("\nENEMY STATS:");
      e.printEnemyStats();

      System.out.printf("\n%s STATS:", k.getName());
      k.printKnightStats();

      // determine which knight goes first
      if (knightArray.size() > 0) {

        /* Start the battle
         * Note: The monsters always get first-strike since they are the attackers */
        battle(k, e);
      } else {
        System.out.printf("\nError: knightArray is unexpectedly empty. Exiting...");
        System.exit(1);
      }
    }
  }

  /**
   * Displays short welcome message when the user starts the program
   */
  public static void welcomeMessage() {
    System.out.printf("\nWelcome to Dungeons and Object Oriented Dragons (with Random-Monster-Matic)!\n");
  }

  public static void buildEnemyArray(int numEnemies) {
    for (int i = 0; i < numEnemies; ++i) {
      enemyArray.add(Enemy.getRandomEnemy());
    }
  }

  /**
   * Auto-generates a knight, including the name
   */
  public static void createKnightAutomatically() {
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
  public static void createKnightManually() {
    knightArray.add(new Knight());
    knightArray.get(knightArray.size() - 1).setName();
    knightArray.get(knightArray.size() - 1).setWeapon();
    knightArray.get(knightArray.size() - 1).setAutoArmor();
  }

  /**
   * Randomly determine which knight attacks first using a "coin toss"
   */
  public static void coinToss(Knight knight1, Knight knight2) {
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
  public static void battle(Knight k1, Knight k2) {
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

    System.out.printf("\nEnd of battle.\n");
  }

  /**
   * Manage battle between knight and monster
   * Fight continues until someone's health drops to zero
   * Note: This is an overload battle()
   */
  public static void battle(Knight k, Enemy e) {
    int roundNumber = 0;
    Scanner input = new Scanner(System.in);

    do {
      System.out.printf("\nPress Enter to continue...\n");
      String anyKey = input.nextLine();

      // print stats at beginning of reach round
      System.out.printf("\n*** ROUND %d ***", ++roundNumber);
      System.out.printf("\nHEALTH LEVELS:\n" +
              "%s: %d \n" +
              "%s: %d \n", k.getName(), k.getHealth(), e.getName(), e.getHealth());
    }
    while ((k.fight(e) != 1) &&
            (e.fight(k) != 1));

    System.out.printf("\nEnd of battle.\n");
  }

  /**
   * When the user indicates, at the main menu, that they want to fight another night, this gives
   * them a chance to generate an opponent, either automatically, or manually.
   * Once a knight has been created, the stats are printed and the battle begins
   */
  static void knightFight() {
    Scanner input = new Scanner(System.in);
    String response = "";

    do {
      System.out.printf("\nWould you like to auto-generate an opponent? (yes/no)\n");
      response = input.nextLine();

      if (response.equalsIgnoreCase("yes")) {
        createKnightAutomatically();
      } else if (response.equalsIgnoreCase("no")) {
        createKnightManually();
      } else {
        System.out.printf("\nYou entered \"%s\".", response);
        System.out.printf("\nPlease enter exactly \"yes\" or \"no.\"\n");
      }
    } while ((!(response.equalsIgnoreCase("yes")) &&
            (!(response.equalsIgnoreCase("no")))));

    System.out.printf("\nHere are the stats for your knights:\n");

    for (int i = 0; i < knightArray.size(); ++i) {
      System.out.printf("\n*** Knight %d ***", (i + 1));
      knightArray.get(i).printKnightStats();
    }

    do {
      System.out.printf("\nEnter \"y\" to begin the fight, or \"n\" to exit: ");
      response = input.nextLine();

      if (response.equalsIgnoreCase("n")) {
        System.out.printf("\nExiting program... \n");
        System.exit(0);
      } else if (response.equalsIgnoreCase("y")) {

        // determine which knight goes first
        if (knightArray.size() > 1) {
          coinToss(knightArray.get(knightArray.size() - 2), knightArray.get(knightArray.size() - 1));
        } else {
          System.out.printf("\nERROR: knightArray is smaller than expected. Exiting...");
        }

        // start the actual battle
        if (knightArray.get(knightArray.size() - 2).getFightOrder() == 1) {
          battle(knightArray.get(knightArray.size() - 2), knightArray.get(knightArray.size() - 1));
        } else {
          battle(knightArray.get(knightArray.size() - 1), knightArray.get(knightArray.size() - 2));
        }
      } else {
        System.out.printf("\nEnter exactly \"y\" or \"n\".");
      }
    }
    while ((!(response.equalsIgnoreCase("y")) &&
            (!(response.equalsIgnoreCase("n")))));
  } // end knightFight()

  /*
   * main() runs through the general user interface script
   * */
  public static void main(String[] args) throws IllegalArgumentException {

    // these need to be declared outside of the upcoming loops
    Scanner input = new Scanner(System.in);
    int menu1Choice = 0;
    String response = "";
    String playAgain = "";

    // clear existing knights and enemies
    do {
      clearKnights();
      clearEnemies();
      welcomeMessage();
      createKnightManually();

      // print directions asking if they want to go to the Dungeon, or fight other knights.
      do {
        System.out.printf("\nWhat would you like to do?\n");
        System.out.printf("\n1) Enter the Dungeon of Infinite Loops (fight random monsters).");
        System.out.printf("\n2) Fight another knight.");
        System.out.printf("\n3) Exit program.\n\n");

        // get user selection
        menu1Choice = input.nextInt();

        try {
          if ((menu1Choice != 1) &&
                  (menu1Choice != 2) &&
                  (menu1Choice != 3)) ;

          {
            throw new IllegalArgumentException();
          }
        } catch (IllegalArgumentException ex) {
          ex.getMessage();
        }

        if (menu1Choice == 1) {
          dungeonOfInfiniteLoops();
        } else if (menu1Choice == 2) {
          knightFight();
        } else if (menu1Choice == 3) {
          System.out.printf("\nExiting program...\n");
        } else {
          System.out.printf("\nYou entered \"%s\".", response);
          System.out.printf("\nPlease enter exactly \"1\", \"2\" or \"3\".\n");
        }
      } while ((menu1Choice < 1) && (menu1Choice > 3));

      do {
        System.out.printf("\nPlay again? (y/n): ");

        // running this twice to clear the buffered newline from the previous menu
        playAgain = input.nextLine();

        try {
          if ((!(playAgain.equalsIgnoreCase("n")) &&
                  (!(playAgain.equalsIgnoreCase("y"))))) {
            throw new IllegalArgumentException();
          }
        } catch (IllegalArgumentException ex) {
          ex.getMessage();
        }

        if (playAgain.equalsIgnoreCase("n")) {
          System.out.printf("\nExiting program... \n");
          System.exit(0);
        } else if ((!(playAgain.equalsIgnoreCase("n")) &&
                (!(playAgain.equalsIgnoreCase("y"))))) {

          System.out.printf("\ny or n required \n");
        }
      }
      while (!(playAgain.equalsIgnoreCase("y")) &&
              (!(playAgain.equalsIgnoreCase("n"))));
    }
    while (playAgain.equalsIgnoreCase("y"));
  }
} // end class
