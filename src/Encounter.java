import java.util.Scanner;

public class Encounter {

  Encounter(PlayerCharacter pc, NonPlayerCharacter npc) {

    System.out.printf("\n%s is bravely iterating through the Dungeon of Infinite Loops when\n" +
            " a dreaded %s leaps out from the darkness, brandishing... %s\n", pc.getName(), npc.getName(), npc.getWeapon());

// print pre-fight stats
    System.out.print("\nMONSTER STATS:");
    npc.printStats();
    System.out.printf("\n%s STATS:", pc.getName());
    pc.printStats();

       // The monsters always get first-strike since they are the attackers

  // one guy attacks the other
    // other guy takes damage

  // the other guy attacks back
    // other guy takes damage

  // did anyone die? -> postBattle
  // if the player is dead (from the last fight, break out of the loop)
      if (k.getHealth() < 0) {
    System.out.printf("\n%s has been vanquished before fighting all foes.\n" +
            "Woah to the vanquished... \n", pc.getName());

  //postbattle
    // print message saying what happened
    System.out.printf("\nThe %s makes off with %s's %d gold coins and donates them to\n" +
                    " a charity that supports underprivileged %ss of Middle Earth.\n",
            NON_PLAYER_CHARACTER_ARRAY.get(i - 1).getName(),
            pc.getName(),
            pc.getGold(),
            NON_PLAYER_CHARACTER_ARRAY.get(i - 1).getName());
    break;
  }
    // exchange gold
    // if player died, ask if they want to restart


  /**
   * Manage battle between knight and monster
   * Fight continues until someone's health drops to zero
   * Note: This is an overload of battle()
   */
  private static void battle() {
    int roundNumber = 0;

    do {
      System.out.print("\nPress Enter to continue...\n");
      Scanner input = new Scanner(System.in);
      String anyKey = null;

      try {
        anyKey = input.nextLine();
      } catch (Exception ex) {
        System.out.println("An unexpected error occured: " + ex);
      }

      // print updated stats at beginning of reach round
      System.out.printf("\n*** ROUND %d ***", ++roundNumber);
      System.out.printf("\nHEALTH LEVELS:\n" +
              "%s: %d \n" +
              "%s: %d \n", pc.getName(), pc.getHealth(), npc.getName(), npc.getHealth());




      // apply damage to opponent
      pc.setDamage(damage);

      // check to see if the opponent is dead
      if (k.getHealth() < 0) {
        System.out.printf("\n%s hath been slain by the %s!", pc.getName(), this.getName());
    }
    while ((pc.attack(npc) != 1) &&
            (npc.attack(pc) != 1));

    System.out.print("\nEnd of battle.\n");
  }

  /*
  // fighting a PlayerCharacter
  public int fight(Character opponent) {

         print battle-related messages and call the opponent's
        setDamage() method


      return 1;
    }

    return 0;
  }
  */


  /**
   * Fight another knight
   * */
  public int fight(PlayerCharacter k) {
    int modifier = 0;

    System.out.printf("\n%s strikes %s with his %s! ",
            this.getName(), pc.getName(), this.getWeapon());
    /*
     * when calculating damage amount include difference in the weapon strength vs opponent armor strength
     * damage is 5-13 hit points +/- the modifier
     */
    modifier = getWeapon().getPower() - pc.getArmor().getDefense();
    int damage = ((int) ((Math.random() * 8 + modifier + 5)));
    System.out.printf("(DAMAGE: %d)\n", damage);

    // apply damage to opponent
    pc.setDamage(damage);

    // check to see if the opponent is dead
    if (k.getHealth() < 0) {
      System.out.printf("\n%s hath been slain by %s!", pc.getName(), this.getName());
      return 1;
    }
    return 0;
  }

  /**
   * Fight a monster
   */
  public int fight(NonPlayerCharacter monst) {

        /* print battle-related messages and call the opponent's
        setDamage() method
         */

    int modifier = 0;

    System.out.printf("\n%s strikes the %s with his %s! ",
            this.getName(), monst.getName(), this.getWeapon());

    /*
     * when calculating damage amount include difference in the weapon strength vs opponent armor strength
     * damage is 5-13 hit points +/- the modifier
     */
    modifier = getWeapon().getPower() - monst.defense;

    int damage = ((int) ((Math.random() * 8 + modifier + 5)));

    System.out.printf("(DAMAGE: %d)\n", damage);

    // apply damage to opponent
    monst.setHealth(monst.getHealth() - damage);

    // check to see if the opponent is dead
    if (monst.getHealth() < 0) {
      System.out.printf("\nThe %s hath been slain by %s!", monst.getName(), this.getName());
      takeMonsterGold(monst);
      return 1;
    }
    return 0;
  }


}
