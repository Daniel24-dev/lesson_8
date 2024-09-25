package kg.geeks.game.players;

public class Reaper extends Hero{
    private static final int DAMAGE_MULTIPLIER_30 = 3;
    private static final int DAMAGE_MULTIPLIER_15 = 2;
    public Reaper(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.SCYTHE);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] hero) {
        if (this.getHealth()<=15){
            this.setDamage(this.getDamage() * DAMAGE_MULTIPLIER_15);
            System.out.println("Reaper increase his damage to 15 percent");
        }else if (this.getHealth() <= 30){
            this.setDamage(this.getDamage()*DAMAGE_MULTIPLIER_30);
            System.out.println("Reaper increase his damage ot 30 percent");
        }
    }
}
