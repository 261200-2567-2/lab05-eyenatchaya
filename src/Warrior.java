// Concrete Character: Warrior
class Warrior implements Character {
    private String name;
    private int level;
    private int strength = 10;  // พลังโจมตีทางกายภาพ
    private int intelligence = 5;  // ความสามารถทางปัญญา
    private int agility = 7;  // ความคล่องแคล่วและความเร็ว
    private int energy = 100;  // พลังงานเริ่มต้น
    private Accessory equippedAccessory;  // เก็บอุปกรณ์ที่ติดตั้ง

    // Constructor
    public Warrior(String name, int level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public String useAbility(String abilityName) {
        int energyCost = 20;  // ค่าใช้พลังงานต่อความสามารถ
        if (energy >= energyCost) {
            energy -= energyCost;
            return name + " used " + abilityName + " as a Warrior!";
        }
        return name + " doesn't have enough energy to use " + abilityName + "!";
    }

    public void reduceEnergy(int amount) {
        energy = Math.max(0, energy - amount);  // ลดพลังงาน แต่ไม่ให้ต่ำกว่า 0
    }

    public void increaseEnergy(int amount) {
        energy = Math.min(100, energy + amount);  // เพิ่มพลังงาน แต่ไม่ให้เกิน 100
    }

    public void regenerateEnergy() {
        int regenAmount = 10;  // ฟื้นฟูพลังงาน 10 หน่วย
        energy = Math.min(100, energy + regenAmount);
    }

    @Override
    public int getEnergy() {
        return energy; // คืนค่าพลังงาน
    }

    // ปรับค่าความสามารถพื้นฐาน
    public void increaseStrength(int amount) { strength += amount; }
    public void increaseIntelligence(int amount) { intelligence += amount; }
    public void increaseAgility(int amount) { agility += amount; }

    @Override
    public void equipAccessory(Accessory accessory) {
        if (equippedAccessory != null) {
            unequipAccessory(equippedAccessory);  // ถอดอุปกรณ์เก่าก่อนติดตั้งใหม่
        }
        equippedAccessory = accessory;
        accessory.applyEffect(this);  // ใช้ผลกระทบของอุปกรณ์
    }

    @Override
    public void unequipAccessory(Accessory accessory) {
        if (equippedAccessory == accessory) {
            accessory.removeEffect(this);  // ยกเลิกผลกระทบของอุปกรณ์
            equippedAccessory = null;
        }
    }

    @Override
    public String toString() {
        return String.format(
                "Warrior{name='%s', level=%d, strength=%d, intelligence=%d, agility=%d, energy=%d}",
                name, level, strength, intelligence, agility, energy
        );
    }
}
