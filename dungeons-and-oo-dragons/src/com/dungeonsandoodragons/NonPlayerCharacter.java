package com.dungeonsandoodragons;

/**
 * NonPlayerCharacter.java
 *
 * A NonPlayerCharacter (NPC) is automatically generated as a monster to fight with the PlayerCharacter (PC). Each
 * monster has multiple attack types, with different damage multipliers.
 */
public abstract class NonPlayerCharacter implements Character {

  protected String name;
  protected Weapon myWeapon;
  protected Armor myArmor;
  protected int health;
  protected int gold;

  // These are used in the calculations to autogenerate the values for their respective fields
  private final int ATTACK_MODIFIER = 4;
  private final int DEFENSE_MODIFIER = 1;

  NonPlayerCharacter() {
    this.health = 0;
    this.gold = 0;
  }

  @Override
  public int attack() {
    int damage = (int)((Math.random() * myWeapon.getAttackPower()) + ATTACK_MODIFIER);
    return damage;
  }

  @Override
  public int defend() {
    int defense = (int)((Math.random() * myArmor.getDefenseLevel()) + DEFENSE_MODIFIER);
    return defense;
  }

  @Override
  public void printStats() {
    System.out.println("Name: " + getName() +
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
