/**
 * Characters can either be PlayerCharacters (PCs) or NonPlayerCharacters (NPCs). In this game, the NPCs are monsters
 * that will be generated for the PC, controlled by the player, to fight.
 */
interface Character {

  /**
   * All characters have the ability to attack and cause damage to another character. The amount of damage is
   * determined by a formula that factors the weapon used.
   * @return damage - int amount of damage caused during the attack
   */
  int attack();

  /**
   * All characters can defend against attacks from other characters. Depending on their armor, they can block a
   * portion of the attack or cause the attacker to miss entirely.
   *
   * @return defense - int amount to reduce the damage caused by an attacker
   */
  int defend();

  /**
   * Print a list of statistics for the character. This is similar to "toString()" except only select fields
   * are returned.
   */
  void printStats();
}
