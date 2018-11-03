interface Character {
  enum Weapon {};
 // enum Armor {};

  int attack(Character opponent);
  void printStats();
  void generateWeapon();
  void generateArmor();


}
