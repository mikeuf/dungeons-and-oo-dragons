package com.dungeonsandoodragons;

/**
 * Bugbear.java
 *
 * A Bugbear is intended to be a "medium-strength" monster.
 */
class Bugbear extends NonPlayerCharacter {
  private final int GOLD_MULTIPLIER = 200;
  private final int HEALTH_MULTIPLIER = 15;

  public Bugbear() {
    name = "Bugbear";
    this.myWeapon = new Weapon("Really Big Fly Swatter", 8);
    this.myArmor = new Armor("Hefty Garbage Bag, with Holes Cut Out for Arms", 4);
    health = (int) ((Math.random() * HEALTH_MULTIPLIER) + 10);
    gold = (int) ((Math.random() * GOLD_MULTIPLIER) + 20);
  }
}

