/*
Knight.java

Knight object that can be used to fight against other knights

*/

import java.util.Scanner;


public class Knight {
  enum Weapon {
        /* the number next to the weapon is the damage multiplier.
        Generally, "NOTHING" should not actually appear. */

    NOTHING(1, "Nothing"),
    LONG_SWORD(4, "Long Sword"),
    BATTLE_AXE(5, "Battle Axe"),
    SPEAR(2, "Spear"),
    WAR_HAMMER(3, "War Hammer");

    private final int power_;
    private final String mixedCaps_;

    Weapon(int power, String mixedCaps) {
      this.power_ = power;
      this.mixedCaps_ = mixedCaps;
    }


    public int getPower() {
      return power_;
    }

    public String getMixedCaps() {
      return mixedCaps_;
    }
  }

  enum Armor {
        /* the number next to the weapon is the defense multiplier.
        Generally, "NOTHING" should not actually appear. */

    NOTHING(1, "Nothing"),
    LEATHER(2, "Leather"),
    CHAIN_MAIL(3, "Chain mail"),
    PLATE_MAIL(4, "Plate mail"),
    MITHRIL(5, "Mithril");

    private final String mixedCaps_;
    private final int defense_;

    Armor(int defense, String mixedCaps) {
      this.defense_ = defense;
      this.mixedCaps_ = mixedCaps;
    }

    public String getMixedCaps() {
      return mixedCaps_;
    }

    public int getDefense() {
      return defense_;
    }

  }

  enum AutoName {

    /* name list for auto-generated knights */

    SIR_LANCELOT("Sir Lancelot"),
    SIR_CRUMPET("Sir Crumpet"),
    SIR_ARTHUR("Sir Authur"),
    SIR_LOIN("Sir Loin"),
    SIR_FRY("Sir Fry"),
    SIR_TIFICATE("Sir Tificate"),
    LORD_VADER("Lord Vader"),
    GRAND_ADMIRAL_SNOWFLAKE("Grand Admiral Snowflake");

    private final String mixedCaps_;

    AutoName(String mixedCaps) {
      this.mixedCaps_ = mixedCaps;
    }

    public String getMixedCaps() {
      return mixedCaps_;
    }
  }


  String name_ = null;
  int health_ = 0;
  int numBattles_ = 0;
  int age_ = 0;
  int gold_ = 0;
  Weapon weapon_ = Weapon.NOTHING;
  Armor armor_ = Armor.NOTHING;
  int fightOrder_ = 0;

  Scanner input = new Scanner(System.in);

  // default constructor
  public Knight() {
    health_ = (int) ((Math.random() * 50) + 50);
    numBattles_ = (int) ((Math.random() * 10) + 1);
    age_ = (int) ((Math.random() * 47) + 18);
    gold_ = (int) ((Math.random() * 1000) + 20);

  }

  // fully-parameterized constructor
  public Knight(String name, int health, int numBattles, int age, int gold,
                Weapon weapon, Armor armor) {
    name_ = name;
    health_ = health;
    numBattles_ = numBattles;
    age_ = age;
    gold_ = gold;
    weapon_ = weapon;
    armor_ = armor;
  }

  // constructor with only name specified
  public Knight(String name) {
    name_ = name;
  }

  // fighting another Knight
  public int fight(Knight k) {

        /* print battle-related messages and call the opponent's
        setDamage() method
         */

    int modifier = 0;

    System.out.printf("\n%s strikes %s with his %s! ",
            this.getName(), k.getName(), this.getWeapon());

    // calculate and report damage amount

    // include difference in the weapon strength vs opponent armor strength
    modifier = weapon_.getPower() - k.armor_.getDefense();

    // damage is 5-13 hit points +/- the modifier
    int damage = ((int) ((Math.random() * 8 + modifier + 5)));

    System.out.printf("(DAMAGE: %d)\n", damage);

    // apply damage to opponent
    k.setDamage(damage);

    // check to see if the opponent is dead
    if (k.getHealth() < 0) {
      System.out.printf("\n%s hath been slain by %s!", k.getName(), this.getName());
      return 1;
    }

    return 0;
  }


  // fighting an Enemy (monster)
  public int fight(Enemy e) {

        /* print battle-related messages and call the opponent's
        setDamage() method
         */

    int modifier = 0;

    System.out.printf("\n%s strikes the %s with his %s! ",
            this.getName(), e.getName(), this.getWeapon());

    // calculate and report damage amount

    // include difference in the weapon strength vs opponent armor strength
    modifier = weapon_.getPower() - e.defense_;

    // damage is 5-13 hit points +/- the modifier
    int damage = ((int) ((Math.random() * 8 + modifier + 5)));

    System.out.printf("(DAMAGE: %d)\n", damage);

    // apply damage to opponent
    e.takeDamage(damage);

    // check to see if the opponent is dead
    if (e.getHealth() < 0) {
      System.out.printf("\nThe %s hath been slain by %s!", e.getName(), this.getName());
      takeEnemyGold(e);
      return 1;
    }

    return 0;
  }


  //setters
  public void setDamage(int damage) {
    health_ -= damage;
  }

  public void setName(String name) {
    name_ = name;
  }

  public void setHealth(int health) {
    health_ = health;
  }

  public void setNumBattles(int numBattles) {

    numBattles_ = numBattles;
  }

  public void setAge(int age) {
    age_ = age;
  }

  public void setGold(int gold) {
    gold_ = gold;
  }

  public void setWeapon(Weapon weapon) {
    weapon_ = weapon;
  }


  public void setArmor(Armor armor) {
    armor_ = armor;
  }

  public void setName() {
    System.out.printf("Enter the name of your Knight: ");
    name_ = input.nextLine();
  }

  public void setHealth() {
    System.out.printf("Enter health: ");

    health_ = input.nextInt();
  }

  public void setNumBattles() {
    System.out.printf("Enter number of battles: ");

    numBattles_ = input.nextInt();
  }

  public void setAge() {
    System.out.printf("Enter age: ");

    age_ = input.nextInt();
  }

  public void setGold() {
    System.out.printf("Enter amount of gold: ");

    gold_ = input.nextInt();
  }


  public void setWeapon() {
    /* allow user to select weapon */

    int choice = 0;
    do {
      System.out.printf("\nNow select your weapon! (Choose number):\n" +
              "1) Long Sword\n" +
              "2) Battle Axe\n" +
              "3) Spear\n" +
              "4) Warhammer\n" +
              "Your choice my liege? : ");

      choice = input.nextInt();

      if (choice < 0 || choice > 4) {
        System.out.printf("\nType a number between 1 and 4.\n");
      }
    }
    while (choice < 0 || choice > 4);

    switch (choice) {
      case 1:
        weapon_ = Weapon.LONG_SWORD;
        break;

      case 2:
        weapon_ = Weapon.BATTLE_AXE;
        break;

      case 3:
        weapon_ = Weapon.SPEAR;
        break;

      case 4:
        weapon_ = Weapon.WAR_HAMMER;
        break;

      default:
        System.out.printf("\nError while choosing weapon\n");
        System.exit(1);
    }
  }

  public void setArmor() {
    /* allow user to select armor */
    int choice = 0;
    do {
      System.out.printf("\nNow select your armor! (Choose number):\n" +
              "1) Leather\n" +
              "2) Chain mail\n" +
              "3) Plate mail\n" +
              "4) Mithril\n" +
              "Your choice my liege? : ");

      choice = input.nextInt();

      if (choice < 0 || choice > 4) {
        System.out.printf("\nType a number between 1 and 4.\n");
      }
    }
    while (choice < 0 || choice > 4);

    switch (choice) {
      case 1:
        armor_ = Armor.LEATHER;
        break;

      case 2:
        armor_ = Armor.CHAIN_MAIL;
        break;

      case 3:
        armor_ = Armor.PLATE_MAIL;
        break;

      case 4:
        armor_ = Armor.MITHRIL;
        break;

      default:
        System.out.printf("\nError while choosing armor\n");
        System.exit(1);
    }

  }

  public void setFightOrder(int fightOrder) {
    fightOrder_ = fightOrder;
  }

  public void takeEnemyGold(Enemy e) {
    System.out.printf("\n\n%s takes the %s's %d gold coins\n" +
            "and hands them to his accountant.\n", this.getName(), e.getName(), e.getGold());
    this.gold_ += e.getGold();
    System.out.printf("\n%s now has $%d.\n", this.getName(), this.getGold());
  }


  public void setAutoWeapon() {
    /* auto select a weapon for auto generated knights */
    int choice = ((int) ((Math.random() * 4) + 1));
    switch (choice) {
      case 1:
        weapon_ = Weapon.LONG_SWORD;
        break;

      case 2:
        weapon_ = Weapon.BATTLE_AXE;
        break;

      case 3:
        weapon_ = Weapon.SPEAR;
        break;

      case 4:
        weapon_ = Weapon.WAR_HAMMER;
        break;

      default:
        System.out.printf("\nError while choosing auto weapon\n");
        System.exit(1);
    }
  }

  public void setAutoArmor() {
    /* auto select armor for auto generated knights */

    int choice = ((int) ((Math.random() * 4) + 1));
    switch (choice) {
      case 1:
        armor_ = Armor.LEATHER;
        break;

      case 2:
        armor_ = Armor.CHAIN_MAIL;
        break;

      case 3:
        armor_ = Armor.PLATE_MAIL;
        break;

      case 4:
        armor_ = Armor.MITHRIL;
        break;

      default:
        System.out.printf("\nError while choosing armor\n");
        System.exit(1);
    }
  }

  public void setAutoName() {
    /* auto select name for auto generated knights */

    int choice = ((int) ((Math.random() * 8) + 1));

    switch (choice) {
      case 1:
        name_ = AutoName.SIR_LANCELOT.getMixedCaps();
        break;

      case 2:
        name_ = AutoName.SIR_CRUMPET.getMixedCaps();
        break;

      case 3:
        name_ = AutoName.SIR_ARTHUR.getMixedCaps();
        break;

      case 4:
        name_ = AutoName.SIR_LOIN.getMixedCaps();
        break;

      case 5:
        name_ = AutoName.SIR_FRY.getMixedCaps();
        break;

      case 6:
        name_ = AutoName.SIR_TIFICATE.getMixedCaps();
        break;

      case 7:
        name_ = AutoName.LORD_VADER.getMixedCaps();
        break;

      case 8:
        name_ = AutoName.GRAND_ADMIRAL_SNOWFLAKE.getMixedCaps();
        break;

      default:
        System.out.printf("\nError while choosing auto name\n");
        System.exit(1);
    }
  }

  // getters
  public String getName() {
    return this.name_;
  }

  public int getHealth() {
    return this.health_;
  }

  public int getNumBattles() {
    return this.numBattles_;
  }

  public int getAge() {
    return this.age_;
  }

  public int getGold() {
    return this.gold_;
  }

  public String getWeapon() {
    return this.weapon_.getMixedCaps();
  }

  public String getArmor() {
    return this.armor_.getMixedCaps();
  }

  public int getFightOrder() {
    return fightOrder_;
  }


  public void printKnightStats() {
        /* I used toString() for the name. I could have used toString()
        for the rest, but I used getters because they include some
        formatting to make it look nicer. I hope that's OK  */

    System.out.println("\nKnight Name: " + name_);
    System.out.println("Knight Health: " + getHealth());
    System.out.println("Knight Battles: " + getNumBattles());
    System.out.println("Knight Age: " + getAge());
    System.out.println("Knight Gold: $" + getGold());
    System.out.println("Knight Weapon: " + getWeapon());
    System.out.println("Knight Armor: " + getArmor());
  }
}


