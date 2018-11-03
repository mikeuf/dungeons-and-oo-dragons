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
    myWeapon.setName("cast iron skillet");
    myWeapon.setAttackPower(3);
    myArmor.setName("metal trash can lid for a breastplate, suspended with bungee cords");
    myArmor.setDefenseLevel(3);
    health = (int) ((Math.random() * HEALTH_MULTIPLIER) + 5);
    gold = (int) ((Math.random() * GOLD_MULTIPLIER) + 10);
  }
}
