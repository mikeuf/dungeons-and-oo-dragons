/*
Knight.java

Knight object that can be used to fight against other knights

*/

import java.util.Scanner;

/**
 * These are the weapons available to the knights.
 * The number next to the weapon is a damage multiplier. A higher number means "more damage."
 * */
public class Knight {
  public String getName_() {
    return name_;
  }

  public void setName_(String name_) {
    this.name_ = name_;
  }

  public int getHealth_() {
    return health_;
  }

  public void setHealth_(int health_) {
    this.health_ = health_;
  }

  public int getNumBattles_() {
    return numBattles_;
  }

  public void setNumBattles_(int numBattles_) {
    this.numBattles_ = numBattles_;
  }

  public int getAge_() {
    return age_;
  }

  public void setAge_(int age_) {
    this.age_ = age_;
  }

  public int getGold_() {
    return gold_;
  }

  public void setGold_(int gold_) {
    this.gold_ = gold_;
  }

  public Weapon getWeapon_() {
    return weapon_;
  }

  public void setWeapon_(Weapon weapon_) {
    this.weapon_ = weapon_;
  }

  public Armor getArmor_() {
    return armor_;
  }

  public void setArmor_(Armor armor_) {
    this.armor_ = armor_;
  }

  public int getFightOrder_() {
    return fightOrder_;
  }

  public void setFightOrder_(int fightOrder_) {
    this.fightOrder_ = fightOrder_;
  }

  public Scanner getInput() {
    return input;
  }

  public void setInput(Scanner input) {
    this.input = input;
  }

  enum Weapon {
    NOTHING(1, "Nothing"),
    SPEAR(2, "Spear"),
    WAR_HAMMER(3, "War Hammer"),
    LONG_SWORD(4, "Long Sword"),
    BATTLE_AXE(5, "Battle Axe");

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

  /**
   * These are the types of armor available to the knights.
   * The number next to the weapon is the defense multiplier.
   * */
  enum Armor {
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

  /**
   * The name list for auto-generated knights
   * */
  enum AutoName {
    SIR_LANCELOT("Sir Lancelot"),
    SIR_ARTHUR("Sir Arthur"),
    SIR_LOIN("Sir Loin"),
    SIR_FRY("Sir Fry"),
    BARON_CRUMPET("Baron Crumpet"),
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

  private String name_ = null;
  private int health_ = 0;
  private int numBattles_ = 0;
  private int age_ = 0;
  private int gold_ = 0;
  private Weapon weapon_ = Weapon.NOTHING;
  private Armor armor_ = Armor.NOTHING;
  private int fightOrder_ = 0;

  private Scanner input = new Scanner(System.in);

  // default constructor
  public Knight() {
    setHealth_((int) ((Math.random() * 50) + 50));
    setNumBattles_((int) ((Math.random() * 10) + 1));
    setAge_((int) ((Math.random() * 47) + 18));
    setGold_((int) ((Math.random() * 1000) + 20));
  }

  // fully-parameterized constructor
  public Knight(String name, int health, int numBattles, int age, int gold,
                Weapon weapon, Armor armor) {
    setName_(name);
    setHealth_(health);
    setNumBattles_(numBattles);
    setAge_(age);
    setGold_(gold);
    setWeapon_(weapon);
    setArmor_(armor);
  }

  // constructor with only name specified
  public Knight(String name) {
    setName_(name);
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
    modifier = getWeapon_().getPower() - k.getArmor_().getDefense();

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
    modifier = getWeapon_().getPower() - e.defense_;

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
    setHealth_(getHealth_() - damage);
  }

  public void setName(String name) {
    setName_(name);
  }

  public void setHealth(int health) {
    setHealth_(health);
  }

  public void setNumBattles(int numBattles) {

    setNumBattles_(numBattles);
  }

  public void setAge(int age) {
    setAge_(age);
  }

  public void setGold(int gold) {
    setGold_(gold);
  }

  public void setWeapon(Weapon weapon) {
    setWeapon_(weapon);
  }


  public void setArmor(Armor armor) {
    setArmor_(armor);
  }

  public void setName() {
    System.out.printf("Enter the name of your Knight: ");
    setName_(getInput().nextLine());
  }

  public void setHealth() {
    System.out.printf("Enter health: ");

    setHealth_(getInput().nextInt());
  }

  public void setNumBattles() {
    System.out.printf("Enter number of battles: ");

    setNumBattles_(getInput().nextInt());
  }

  public void setAge() {
    System.out.printf("Enter age: ");

    setAge_(getInput().nextInt());
  }

  public void setGold() {
    System.out.printf("Enter amount of gold: ");

    setGold_(getInput().nextInt());
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

      choice = getInput().nextInt();

      if (choice < 0 || choice > 4) {
        System.out.printf("\nType a number between 1 and 4.\n");
      }
    }
    while (choice < 0 || choice > 4);

    switch (choice) {
      case 1:
        setWeapon_(Weapon.LONG_SWORD);
        break;

      case 2:
        setWeapon_(Weapon.BATTLE_AXE);
        break;

      case 3:
        setWeapon_(Weapon.SPEAR);
        break;

      case 4:
        setWeapon_(Weapon.WAR_HAMMER);
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

      choice = getInput().nextInt();

      if (choice < 0 || choice > 4) {
        System.out.printf("\nType a number between 1 and 4.\n");
      }
    }
    while (choice < 0 || choice > 4);

    switch (choice) {
      case 1:
        setArmor_(Armor.LEATHER);
        break;

      case 2:
        setArmor_(Armor.CHAIN_MAIL);
        break;

      case 3:
        setArmor_(Armor.PLATE_MAIL);
        break;

      case 4:
        setArmor_(Armor.MITHRIL);
        break;

      default:
        System.out.printf("\nError while choosing armor\n");
        System.exit(1);
    }

  }

  public void setFightOrder(int fightOrder) {
    setFightOrder_(fightOrder);
  }

  public void takeEnemyGold(Enemy e) {
    System.out.printf("\n\n%s takes the %s's %d gold coins\n" +
            "and hands them to his accountant.\n", this.getName(), e.getName(), e.getGold());
    this.setGold_(this.getGold_() + e.getGold());
    System.out.printf("\n%s now has $%d.\n", this.getName(), this.getGold());
  }


  public void setAutoWeapon() {
    /* auto select a weapon for auto generated knights */
    int choice = ((int) ((Math.random() * 4) + 1));
    switch (choice) {
      case 1:
        setWeapon_(Weapon.LONG_SWORD);
        break;

      case 2:
        setWeapon_(Weapon.BATTLE_AXE);
        break;

      case 3:
        setWeapon_(Weapon.SPEAR);
        break;

      case 4:
        setWeapon_(Weapon.WAR_HAMMER);
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
        setArmor_(Armor.LEATHER);
        break;

      case 2:
        setArmor_(Armor.CHAIN_MAIL);
        break;

      case 3:
        setArmor_(Armor.PLATE_MAIL);
        break;

      case 4:
        setArmor_(Armor.MITHRIL);
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
        setName_(AutoName.SIR_LANCELOT.getMixedCaps());
        break;

      case 2:
        setName_(AutoName.BARON_CRUMPET.getMixedCaps());
        break;

      case 3:
        setName_(AutoName.SIR_ARTHUR.getMixedCaps());
        break;

      case 4:
        setName_(AutoName.SIR_LOIN.getMixedCaps());
        break;

      case 5:
        setName_(AutoName.SIR_FRY.getMixedCaps());
        break;

      case 6:
        setName_(AutoName.SIR_TIFICATE.getMixedCaps());
        break;

      case 7:
        setName_(AutoName.LORD_VADER.getMixedCaps());
        break;

      case 8:
        setName_(AutoName.GRAND_ADMIRAL_SNOWFLAKE.getMixedCaps());
        break;

      default:
        System.out.printf("\nError while choosing auto name\n");
        System.exit(1);
    }
  }

  // getters
  public String getName() {
    return this.getName_();
  }

  public int getHealth() {
    return this.getHealth_();
  }

  public int getNumBattles() {
    return this.getNumBattles_();
  }

  public int getAge() {
    return this.getAge_();
  }

  public int getGold() {
    return this.getGold_();
  }

  public String getWeapon() {
    return this.getWeapon_().getMixedCaps();
  }

  public String getArmor() {
    return this.getArmor_().getMixedCaps();
  }

  public int getFightOrder() {
    return getFightOrder_();
  }


  public void printKnightStats() {
        /* I used toString() for the name. I could have used toString()
        for the rest, but I used getters because they include some
        formatting to make it look nicer. I hope that's OK  */

    System.out.println("\nKnight Name: " + getName_());
    System.out.println("Knight Health: " + getHealth());
    System.out.println("Knight Battles: " + getNumBattles());
    System.out.println("Knight Age: " + getAge());
    System.out.println("Knight Gold: $" + getGold());
    System.out.println("Knight Weapon: " + getWeapon());
    System.out.println("Knight Armor: " + getArmor());
  }
}


