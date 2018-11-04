/**
 * Bugbear.java
 *
 * A Bugbear is intended to be a "medium-strength" monster.
 */
class Bugbear extends NonPlayerCharacter {

  private final int GOLD_MULTIPLIER = 200;
  private final int HEALTH_MULTIPLIER = 30;

  public Bugbear() {
    name = "Bugbear";
    this.myWeapon = new Weapon("Really Big Fly Swatter", 4);
    this.myArmor = new Armor("Hefty Garbage Bag, with Holes Cut Out for Arms", 2);
    health = (int) ((Math.random() * HEALTH_MULTIPLIER) + 20);
    gold = (int) ((Math.random() * GOLD_MULTIPLIER) + 20);
  }
}

