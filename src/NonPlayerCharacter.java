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

  NonPlayerCharacter() {
    this.health = 0;
    this.gold = 0;
  }

  public int attack(PlayerCharacter pc) {
    System.out.printf("\nThe %s assails %s with its %s, ", name, pc.getName(), myWeapon.getName());
    /*
     * when calculating damage amount include difference in the weapon strength vs opponent armor strength
     * damage is 5-13 hit points +/- the modifier
     */
    int modifier = myWeapon.getAttackPower() - pc.getDefenseLevel();
    if (modifier < 1) { //  if a weak weapon is up again powerful armor, just default to 1 instead of a negative
      modifier = 1;
    }

    int damage = ((int)(((Math.random() * 8) + modifier + 5)));
    System.out.printf("causing %d damage!\n", damage);

    return damage;
  }

  @Override
  public void printStats() {
    System.out.println("\nName: " + getName() +
            "\nHealth: " + getHealth() +
            "\nGold: $" + getGold() +
            "\nWeapon: " + myWeapon.getName() +
            "\nArmor: " + myArmor.getName());
  }

  public int getDefenseLevel() {
    return myArmor.getDefenseLevel();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Weapon getMyWeapon() {
    return myWeapon;
  }

  public void setMyWeapon(Weapon myWeapon) {
    this.myWeapon = myWeapon;
  }

  public Armor getMyArmor() {
    return myArmor;
  }

  public void setMyArmor(Armor myArmor) {
    this.myArmor = myArmor;
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

