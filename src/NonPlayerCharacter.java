/*
NonPlayerCharacter.java

The NonPlayerCharacter class allows the play to select how many random monsters they
want to fight in JavaBean Forest.

Each monster has multiple attack types, with different damage multipliers. The
weapons are selected at random.

Each of the enemies has a random amount of treasure. After each battle, the player
knight will take the treasure and update his gold_ member variable.

*/
public abstract class NonPlayerCharacter implements Character {
  protected String name;
  protected Weapon myWeapon;
  protected Armor myArmor;
  protected int health;
  protected int gold;
  private final int ATTACK_MODIFIER = 3;
  private final int DEFENSE_MODIFIER = 1;

  NonPlayerCharacter() {
    this.health = 0;
    this.gold = 0;
  }

  public int attack() {
    int damage = (int)((Math.random() * myWeapon.getAttackPower()) + ATTACK_MODIFIER);
    return damage;
  }

  public int defend() {
    int defense = (int)((Math.random() * myArmor.getDefenseLevel()) + DEFENSE_MODIFIER);
    return defense;
  }

  @Override
  public void printStats() {
    System.out.println("\nName: " + getName() +
            "\nHealth: " + getHealth() +
            "\nGold: $" + getGold() +
            "\nWeapon: " + myWeapon.getName() +
            "\nArmor: " + myArmor.getName());
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getWeaponName() {
    return myWeapon.getName();
  }

  public String getArmorName() {
    return myArmor.getName();
  }

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public int getGold() {
    return gold;
  }

  public void setGold(int gold) {
    this.gold = gold;
  }

}

