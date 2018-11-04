/**
 * Used by characters to defend against attacks. Each armor type has a name and a defenseLevel that determines the
 * reduction in damage caused by other characters.
 */
class Armor {
    private String name;
    private int defenseLevel;

    Armor(String name, int defenseLevel) {
     this.name = name;
     this.defenseLevel = defenseLevel;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getDefenseLevel() {
      return defenseLevel;
    }

    public void setDefenseLevel(int defenseLevel) {
      this.defenseLevel = defenseLevel;
    }
  }

