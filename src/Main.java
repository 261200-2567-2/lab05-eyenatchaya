public class Main {
    public static void main(String[] args) {
        // สร้างตัวละคร
        Character warrior = new Warrior("Thorin", 10); // นักรบ
        Character mage = new Mage("Elrond", 12); // นักเวทย์

        // สร้างอุปกรณ์
        Accessory strengthRing = new Ring("Ring of Strength", 5, 0); // แหวนเพิ่มพลังโจมตี
        Accessory agilityBracelet = new Bracelet("Bracelet of Agility", 3); // กำไลเพิ่มความคล่องแคล่ว

        // ติดตั้งอุปกรณ์
        System.out.println("Before the fight:");
        warrior.equipAccessory(strengthRing); // ติดตั้งแหวน
        mage.equipAccessory(agilityBracelet); // ติดตั้งกำไล

        System.out.println(warrior);
        System.out.println(mage);

        // การต่อสู้
        System.out.println("\nFight begins!");
        System.out.println(warrior.getName() + " attacks " + mage.getName() + "!");
        ((Mage) mage).reduceEnergy(15); // Mage เสียพลังงานจากการถูกโจมตี
        System.out.println(mage.getName() + " counterattacks with Fireball!");
        System.out.println(mage.useAbility("Fireball"));
        ((Warrior) warrior).reduceEnergy(10); // Warrior เสียพลังงานจากการตอบโต้

        // ฟื้นฟูพลังงานของ Mage
        System.out.println("\n" + mage.getName() + " regenerates energy.");
        ((Mage) mage).regenerateEnergy();

        // ถอดอุปกรณ์หลังจากการต่อสู้
        System.out.println("\nAfter the fight:");
        warrior.unequipAccessory(strengthRing); // ถอดแหวน
        mage.unequipAccessory(agilityBracelet); // ถอดกำไล

        System.out.println(warrior);
        System.out.println(mage);

        // ผลการแข่งขัน
        if (warrior.getEnergy() > mage.getEnergy()) {
            System.out.println("\nBattle Result: " + warrior.getName() + " wins the battle!");
        } else if (mage.getEnergy() > warrior.getEnergy()) {
            System.out.println("\nBattle Result: " + mage.getName() + " wins the battle!");
        } else {
            System.out.println("\nBattle Result: It's a draw!");
        }
    }
}
