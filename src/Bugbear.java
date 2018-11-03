/**
 * Bugbear.java
 *
 * A Bugbear is intended to be a "medium-strength" monster.
 */
public class Bugbear extends NonPlayerCharacter {

  private final int GOLD_MULTIPLIER = 200;
  private final int HEALTH_MULTIPLIER = 30;

  public Bugbear() {
    name = "Bugbear";
    myWeapon.setName("really big fly swatter");
    myWeapon.setAttackPower(4);
    myArmor.setName("Hefty garbage bag, with holes cut-out for arms");
    myArmor.setDefenseLevel(2);
    health = (int) ((Math.random() * HEALTH_MULTIPLIER) + 20);
    gold = (int) ((Math.random() * GOLD_MULTIPLIER) + 20);
  }
}

