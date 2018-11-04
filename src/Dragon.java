/**
 * Dragon.java
 *
 * A Dragon is intended to be a powerful monster, with a lot of treasure.
 */
class Dragon extends NonPlayerCharacter {

  private final int GOLD_MULTIPLIER = 500;
  private final int HEALTH_MULTIPLIER = 50;

  public Dragon() {
    name = "Dragon";
    this.myWeapon = new Weapon("Snoutful of Flames", 5);
    this.myArmor = new Armor("Enchanted Hide", 5);
    health = (int) ((Math.random() * HEALTH_MULTIPLIER) + 100);
    gold = (int) ((Math.random() * GOLD_MULTIPLIER) + 500);
  }
}
