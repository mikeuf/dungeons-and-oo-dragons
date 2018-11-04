class Weapon {

  private String name;
  private int attackPower;

  Weapon(String name, int attackPower) {
    this.name = name;
    this.attackPower = attackPower;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAttackPower() {
    return attackPower;
  }

  public void setAttackPower(int attackPower) {
    this.attackPower = attackPower;
  }
}
