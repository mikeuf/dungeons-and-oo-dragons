/**
 * Balrog.java
 *
 * A Balrog is intended to be a powerful monster, with a lot of treasure.
 */
public class Balrog extends NonPlayerCharacter {

  private final int GOLD_MULTIPLIER = 500;
  private final int HEALTH_MULTIPLIER = 50;

  public Balrog() {
    name = "Balrog";
    this.myWeapon = new Weapon("fiery flail", 5);
    this.myArmor = new Armor("enchanted hide", 5);
    health = (int) ((Math.random() * HEALTH_MULTIPLIER) + 100);
    gold = (int) ((Math.random() * GOLD_MULTIPLIER) + 500);
  }
}
