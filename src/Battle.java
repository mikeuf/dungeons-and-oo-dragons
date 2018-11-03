import java.util.Scanner;

public class Battle {

  Battle(Character opponent1, Character opponent2) {

  }

  // printstats
  opponent1.printStats();


  // mainbattle
  // one guy attacks the other
    // other guy takes damage

  // the other guy attacks back
    // other guy takes damage

  // did anyone die? -> postBattle

  //postbattle
    // print message saying what happened
    // exchange gold
    // if player died, ask if they want to restart


  /**
   * Manage battle between knights only (no monsters).
   * Fight continues until someone's health drops to zero
   */
  private static void battle(PlayerCharacter k1, PlayerCharacter k2) {
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
  private static void battle(PlayerCharacter k, NonPlayerCharacter e) {
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

  // fighting a PlayerCharacter
  public int fight(Character opponent) {

        /* print battle-related messages and call the opponent's
        setDamage() method
         */

    int modifier = 0;
    System.out.printf("\nThe %s attacks %s with his %s! ",
            this.getName(), k.getName(), this.getWeapon());

    // calculate and report damage amount

    // include difference in the weapon strength vs opponent armor strength
    modifier = weapon.getPower() - k.getArmor().getDefense();

    // damage is 5-13 hit points +/- the modifier
    int damage = ((int) ((Math.random() * 8 + modifier + 5)));

    System.out.printf("(DAMAGE: %d)\n", damage);

    // apply damage to opponent
    k.setDamage(damage);

    // check to see if the opponent is dead
    if (k.getHealth() < 0) {
      System.out.printf("\n%s hath been slain by the %s!", k.getName(), this.getName());
      return 1;
    }

    return 0;
  }


  /**
   * Fight another knight
   * */
  public int fight(PlayerCharacter k) {
    int modifier = 0;

    System.out.printf("\n%s strikes %s with his %s! ",
            this.getName(), k.getName(), this.getWeapon());
    /*
     * when calculating damage amount include difference in the weapon strength vs opponent armor strength
     * damage is 5-13 hit points +/- the modifier
     */
    modifier = getWeapon().getPower() - k.getArmor().getDefense();
    int damage = ((int) ((Math.random() * 8 + modifier + 5)));
    System.out.printf("(DAMAGE: %d)\n", damage);

    // apply damage to opponent
    k.setDamage(damage);

    // check to see if the opponent is dead
    if (k.getHealth() < 0) {
      System.out.printf("\n%s hath been slain by %s!", k.getName(), this.getName());
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
