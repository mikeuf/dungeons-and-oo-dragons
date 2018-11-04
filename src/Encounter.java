import java.util.Scanner;

public class Encounter {
  PlayerCharacter pc;
  NonPlayerCharacter npc;

  /*
  private enum GameStatus {
    GAME_IN_PROGRESS, GAME_OVER_PLAYER_LOST, GAME_OVER_PLAYER_WON;
  }*/


  private static Scanner keyboardInput = new Scanner(System.in);

  Encounter(PlayerCharacter pc, NonPlayerCharacter npc) {
    this.pc = pc;
    this.npc = npc;
    System.out.printf("\n%s is bravely iterating through the Dungeon of Infinite Loops when\n" +
                    "a dreaded %s leaps out from the darkness, brandishing a %s\n",
            pc.getName(), npc.getName(), npc.myWeapon.getName() + ".");

    System.out.printf("\n*** Monster Stats ***");
    npc.printStats();

    battle();

    if (GameStatus.theCurrentGameStatus == GameStatus.CurrentGameStatus.GAME_OVER_PLAYER_WON) {
      displayBattleWon();
    } else if (GameStatus.theCurrentGameStatus == GameStatus.CurrentGameStatus.GAME_OVER_PLAYER_LOST) {
      displayBattleLost();
    }
  }


  /**
   * Manage battle between knight and monster
   * Fight continues until someone's health drops to zero
   * Note: This is an overload of battle()
   */
  private void battle() {

    int roundNumber = 1;
    while ((pc.getHealth() > 0) && (npc.getHealth() > 0)) {
      // print updated stats at beginning of reach round
      System.out.printf("\n*** Starting Round %d ***", roundNumber++);
      /*
       * technically, the user can type any value here (not just "c"), and it will still work
       * the classic "press any key to continue" routine is apparently not easy with the Java Scanner class
       * and not worth the added complexity for simple proof-of-concept program
       */
      System.out.print("\nPress \"c\" to continue the battle...\n");
      String userInput = null;

      try {
        userInput = keyboardInput.nextLine();
      } catch (Exception ex) {
        System.out.println("An unexpected error occured: " + ex);
      }

      // The npc always get first-strike since they are the attackers
      int damage = npc.attack(pc);
      pc.setHealth(pc.getHealth() - damage);

      if (pc.getHealth() <= 0) {
        GameStatus.theCurrentGameStatus = GameStatus.CurrentGameStatus.GAME_OVER_PLAYER_LOST;
        break;
      }

      damage = pc.attack(npc);
      npc.setHealth(npc.getHealth() - damage);

      if (npc.getHealth() <= 0) {
        GameStatus.theCurrentGameStatus = GameStatus.CurrentGameStatus.GAME_OVER_PLAYER_WON;
        break;
      }

        System.out.printf("\n*** New Health Levels ***:\n" +
                "%s: %d \n" +
                "%s: %d \n", pc.getName(), pc.getHealth(), npc.getName(), npc.getHealth());
    }
  }

  private void displayBattleLost () {
    System.out.printf("\nOh no! %s has been vanquished in battle." +
                    "\nThe %s makes off with %s's %d gold coins and donates them to a charity that supports" +
                    "\nunderprivileged %ss of Middle Earth.\n",
            pc.getName(), npc.getName(), pc.getName(), pc.getGold(), npc.getName());

    /*
    // this ends the loop from the DungeonsAndObjectOrientedDragons class that called the Encounter class
    // because it is looping through all of the enemies.
    DungeonsAndObjectOrientedDragons.NON_PLAYER_CHARACTER_ARRAY.clear();
    */
  }

  private void displayBattleWon () {
    System.out.printf("\nThe %s hath been slain by %s! It had %d gold coins which %s is now pocketing.",
            npc.getName(), pc.getName(), npc.getGold(), pc.getName());

// transfer the gold from the npc to the pc
    pc.setGold(pc.getGold() + npc.getGold());
    System.out.printf("\n%s now has %d gold coins.\n", pc.getName(), pc.getGold());
  }
}
