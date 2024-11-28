// Concrete Accessory: Bracelet กำไล
class Bracelet implements Accessory {
    private String name;
    private int agilityBonus;

    public Bracelet(String name, int agilityBonus) {
        this.name = name;
        this.agilityBonus = agilityBonus;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void applyEffect(Character character) {
        if (character instanceof Warrior) {
            ((Warrior) character).increaseAgility(agilityBonus);
        } else if (character instanceof Mage) {
            ((Mage) character).increaseAgility(agilityBonus);
        }
    }

    @Override
    public void removeEffect(Character character) {
        if (character instanceof Warrior) {
            ((Warrior) character).increaseAgility(-agilityBonus);
        } else if (character instanceof Mage) {
            ((Mage) character).increaseAgility(-agilityBonus);
        }
    }
}

