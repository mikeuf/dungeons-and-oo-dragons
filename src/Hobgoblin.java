/**
 * Hobgoblin.java
 *
 * A hobgoblin is intended to be a weak monster.
 * It can also serve as the Foolish Consistency of Little Minds.
 **/

public class Hobgoblin extends NonPlayerCharacter {

  private final int GOLD_MULTIPLIER = 100;
  private final int HEALTH_MULTIPLIER = 20;
  private final int ATTACK_MULTIPLIER = 3;
  private final String WEAPON = "cast iron skillet";
  private final String ARMOR = "metal trash can lid for a breastplate, suspended with bungee cords";

  public Hobgoblin() {
    name = "Hobgoblin";
    health = (int) ((Math.random() * HEALTH_MULTIPLIER) + 5);
    gold = (int) ((Math.random() * GOLD_MULTIPLIER) + 10);
  }

  public void attack(PlayerCharacter pc) {};
}
