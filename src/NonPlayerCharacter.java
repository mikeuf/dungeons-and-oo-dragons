/*
NonPlayerCharacter.java

The NonPlayerCharacter class allows the play to select how many random monsters they
want to fight in JavaBean Forest.

Each monster has multiple attack types, with different damage multipliers. The
weapons are selected at random.

Each of the enemies has a random amount of treasure. After each battle, the player
knight will take the treasure and update his gold_ member variable.

*/


import java.util.HashMap;
import java.util.Map;

public abstract class NonPlayerCharacter implements Character {

  // placeholders that will be extended by subclasses
  String name;
  //private Weapon weapon;
  Armor armor;
  int health;
  int gold;
  Weapon myWeapon;
  Armor myArmor;
  final int defense = 0;


  NonPlayerCharacter() {
    this.health = 0;
    this.gold = 0;
  }

  // public abstract int fight(PlayerCharacter k);

  public int attack(PlayerCharacter pc) {
    System.out.printf("\n%s strikes the %s with his %s! ", name, pc.getName(), myWeapon.getName());
    /*
     * when calculating damage amount include difference in the weapon strength vs opponent armor strength
     * damage is 5-13 hit points +/- the modifier
     */
    int modifier = myWeapon.getAttackPower() - pc.getDefenseLevel();

    int damage = ((int)(((Math.random() * 8) + modifier + 5)));

    return damage;
  }



  @Override
  public void printStats() {
    System.out.println("Name: " + getName() +
            "\nHealth: " + getHealth() +
            "\nGold: $" + getGold() +
            "\nWeapon: " + getWeapon() +
            "\nArmor: " + getArmor());
  }

  public void setHealth(int health) {
    this.health -= health;
  }

  // getters
  public String getName() {
    return this.name;
  }

  public int getHealth() {
    return this.health;
  }


  public int getGold() {
    return this.gold;
  }

  public int getDefenseLevel() {
    return myArmor.getDefenseLevel();
  }

  public String getWeapon() {
    return "";
  }

  String getArmor() {
    return "";
  }
}

