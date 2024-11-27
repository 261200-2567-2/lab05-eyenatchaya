// Lab05 class for testing
public class Main {
    public static void main(String[] args) {
        // Create characters
        Character warrior = new Warrior("Baldor", 10);
        Character mage = new Mage("Merlin", 12);

        // Create accessories
        Accessory strengthRing = new Ring("Ring of Strength", 5, 0);
        Accessory intelligenceRing = new Ring("Ring of Intelligence", 0, 5);

        // Equip accessories
        warrior.equipAccessory(strengthRing);
        mage.equipAccessory(intelligenceRing);

        // Display characters' stats
        System.out.println(warrior);
        System.out.println(mage);

        // Use abilities
        System.out.println(warrior.useAbility("Power Slash"));
        System.out.println(mage.useAbility("Fireball"));

        // Unequip accessories
        warrior.unequipAccessory(strengthRing);
        mage.unequipAccessory(intelligenceRing);

        // Display stats after unequipping
        System.out.println("After unequipping:");
        System.out.println(warrior);
        System.out.println(mage);
    }
}