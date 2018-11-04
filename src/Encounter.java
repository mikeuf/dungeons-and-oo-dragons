import java.util.Scanner;

public class Encounter {
  PlayerCharacter pc;
  NonPlayerCharacter npc;

  Encounter(PlayerCharacter pc, NonPlayerCharacter npc) {
    this.pc = pc;
    this.npc = npc;
    System.out.printf("\n%s is bravely iterating through the Dungeon of Infinite Loops when\n" +
                    "a dreaded %s leaps out from the darkness, brandishing a %s\n",
            pc.getName(), npc.getName(), npc.myWeapon.getName() + ".");

// print pre-fight stats
    System.out.print("\nMONSTER STATS:");
    npc.printStats();
    System.out.printf("\n%s STATS:", pc.getName());
    pc.printStats();

    battle();
  }


  /**
   * Manage battle between knight and monster
   * Fight continues until someone's health drops to zero
   * Note: This is an overload of battle()
   */
  private void battle() {

    int roundNumber = 1;
    while ((pc.getHealth() > 0) && (npc.getHealth() > 0)) {

      System.out.print("\nPress Enter to continue the battle...\n");
      Scanner input = new Scanner(System.in);
      String anyKey = null;

      try {
        anyKey = input.nextLine();
      } catch (Exception ex) {
        System.out.println("An unexpected error occured: " + ex);
      }

      // The npc always get first-strike since they are the attackers
      int damage = npc.attack(pc);
      pc.setHealth(pc.getHealth() - damage);

      if (pc.getHealth() <= 0) {
        displayBattleLost();
      }

      damage = pc.attack(npc);
      npc.setHealth(npc.getHealth() - damage);

      if (npc.getHealth() <= 0) {
        displayBattleWon();
      }
      // print updated stats at beginning of reach round
      System.out.printf("\n*** ROUND %d ***", ++roundNumber);
      System.out.printf("\nHEALTH LEVELS:\n" +
              "%s: %d \n" +
              "%s: %d \n", pc.getName(), pc.getHealth(), npc.getName(), npc.getHealth());
    }
  }

  private void displayBattleLost () {
    System.out.printf("\nOh no! %s has been vanquished in battle." +
                    "\nThe %s makes off with %s's %d gold coins and donates them to\n" +
                    "\na charity that supports underprivileged %ss of Middle Earth.\n",
            npc.getName(), pc.getName(), pc.getGold(), pc.getName());

    // this ends the loop from the DungeonsAndObjectOrientedDragons class that called the Encounter class
    // because it is looping through all of the enemies.
    DungeonsAndObjectOrientedDragons.NON_PLAYER_CHARACTER_ARRAY.clear();
  }

  private void displayBattleWon () {
    System.out.printf("\nThe %s hath been slain by %s!" +
                    "\nThe %s had %d gold coins which %s is now pocketing.",
            npc.getName(), pc.getName(), npc.getName(), npc.getGold(), npc.getName());

// transfer the gold from the npc to the pc
    pc.setGold(pc.getGold() + npc.getGold());
    System.out.printf("\n%s now has %d gold coins.\n", pc.getGold());
  }
}
