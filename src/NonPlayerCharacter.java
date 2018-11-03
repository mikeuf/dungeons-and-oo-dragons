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
  final int defense = 0;


  NonPlayerCharacter() {
    generateWeapon();
    generateArmor();
    this.health = 0;
    this.gold = 0;
  }

  // public abstract int fight(PlayerCharacter k);


  @Override
  public void printStats() {
    System.out.println("Name: " + getName() +
            "\nHealth: " + getHealth() +
            "\nGold: $" + getGold() +
            "\nWeapon: " + getWeapon() +
            "\nArmor: " + getArmor());
  }


  public int attack(PlayerCharacter pc) {
    int modifier = 0;
    System.out.printf("\nThe %s attacks %s with his %s! ", name, pc.getName(), weapon);

    // calculate and report damage amount

    // include difference in the weapon strength vs opponent armor strength
    modifier = weapon.getPower() - pc.getArmor().getDefense();

    // damage is 5-13 hit points +/- the modifier
    int damage = ((int) ((Math.random() * 8 + modifier + 5)));

    System.out.printf("(DAMAGE: %d)\n", damage);
  }

  // setters
  public abstract void generateWeapon();

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


  public String getWeapon() {
    return "";
  }

  String getArmor() {
    return "";
  }
}

