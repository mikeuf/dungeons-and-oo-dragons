/**
 * Hobgoblin.java
 *
 * A hobgoblin is intended to be a weak monster.
 * It can also serve as the Foolish Consistency of Little Minds.
 **/
class Hobgoblin extends NonPlayerCharacter {

  private final int GOLD_MULTIPLIER = 100;
  private final int HEALTH_MULTIPLIER = 20;

  public Hobgoblin() {
    name = "Hobgoblin";
    this.myWeapon = new Weapon("Cast Iron Skillet", 3);
    this.myArmor = new Armor("Trash Can Lid for a Breastplate, Suspended with Bungee Cords", 3);
    health = (int) ((Math.random() * HEALTH_MULTIPLIER) + 5);
    gold = (int) ((Math.random() * GOLD_MULTIPLIER) + 10);
  }
}
