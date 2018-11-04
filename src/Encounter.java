import java.util.Scanner;

class Encounter {
  private final PlayerCharacter pc;
  private final NonPlayerCharacter npc;

  /*
  private enum GameStatus {
    GAME_IN_PROGRESS, GAME_OVER_PLAYER_LOST, GAME_OVER_PLAYER_WON;
  }*/


  private static final Scanner keyboardInput = new Scanner(System.in);

  Encounter(PlayerCharacter pc, NonPlayerCharacter npc) {
    this.pc = pc;
    this.npc = npc;
    System.out.printf("\n%s is bravely iterating through the Dungeon of Infinite Loops when\n" +
                    "a dreaded %s leaps out from the darkness, brandishing a %s\n",
            pc.getName(), npc.getName(), npc.myWeapon.getName() + ".");

    System.out.println("\n*** Monster Stats ***");
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
        System.out.println("An unexpected error occurred: " + ex);
      }

      // Monsters/NPCs attack first
      System.out.printf("\nThe %s assails %s with its %s, ", npc.getName(), pc.getName(), npc.getWeaponName());
      int damage = npc.attack() - pc.defend();

      if (damage > 0) {
        System.out.printf("causing %d damage!\n", damage);
        pc.setHealth(pc.getHealth() - damage);
      } else { // if the defense value is higher than the attack, the attack is a "miss"
        System.out.printf("and misses!");
      }

      // check to see if the player was killed
      if (pc.getHealth() <= 0) {
        GameStatus.theCurrentGameStatus = GameStatus.CurrentGameStatus.GAME_OVER_PLAYER_LOST;
        return;
      }

      // Now the player attacks the NPC/Monster
      System.out.printf("\n%s swings at the %s with his %s, ", pc.getName(), npc.getName(), pc.getWeaponName());
      damage = pc.attack() - npc.defend();

      // if we are past round three, double the damage to the NPC to speed things up
      if (roundNumber > 3) {
        damage *= 2;
      }
      // if we are past around five, triple the damage (1.5 * 2 * original damage)
      if (roundNumber > 5) {
        damage *= 1.5;
      }

      if (damage > 0) {
        System.out.printf("causing %d damage!\n", damage);
        npc.setHealth(npc.getHealth() - damage);
      } else {
        System.out.printf("and misses!");
      }

      // check to see if the NPC/monster was killed
      if (npc.getHealth() <= 0) {
        GameStatus.theCurrentGameStatus = GameStatus.CurrentGameStatus.GAME_OVER_PLAYER_WON;
        return;
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
  }

  private void displayBattleWon () {
    System.out.printf("\nThe %s hath been slain by %s! It had %d gold coins which %s is now pocketing.",
            npc.getName(), pc.getName(), npc.getGold(), pc.getName());

// transfer the gold from the npc to the pc
    pc.setGold(pc.getGold() + npc.getGold());
    System.out.printf("\n%s now has %d gold coins.\n", pc.getName(), pc.getGold());
  }
}
