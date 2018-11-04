/**
 * Hobgoblin.java
 *
 * A hobgoblin is intended to be a weak monster.
 * It can also serve as the Foolish Consistency of Little Minds.
 **/
public class Hobgoblin extends NonPlayerCharacter {

  private final int GOLD_MULTIPLIER = 100;
  private final int HEALTH_MULTIPLIER = 20;

  public Hobgoblin() {
    name = "Hobgoblin";
    this.myWeapon = new Weapon("cast iron skillet", 3);
    this.myArmor = new Armor("trash can lid for a breastplate, suspended with bungee cords", 3);
    health = (int) ((Math.random() * HEALTH_MULTIPLIER) + 5);
    gold = (int) ((Math.random() * GOLD_MULTIPLIER) + 10);
  }
}
