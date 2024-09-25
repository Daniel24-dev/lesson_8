package kg.geeks.game.players;

public class Bomber extends Hero{
    private static final int EXPLOSION_DAMAGE = 100;
    public Bomber(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.EXPLODE);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (this.getHealth() <= 0){
           boss.setHealth(boss.getHealth()-EXPLOSION_DAMAGE);

       }
        System.out.println("Bomber explode-----------------------------------"+EXPLOSION_DAMAGE);



    }
}
