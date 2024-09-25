package kg.geeks.game.players;

public class Hacker extends Hero{
    private final int stealHealth;
    public Hacker(int health, int damage, String name, int stealHealth) {
        super(health, damage, name, SuperAbility.STEAL);
        this.stealHealth = stealHealth;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] hero) {

        if (boss.getHealth() >= this.stealHealth) {
            boss.setHealth(boss.getHealth() - this.stealHealth);
            int randomHeroIndex = (int) (Math.random() * hero.length);
            hero[randomHeroIndex].setDamage(this.stealHealth);
            System.out.println("Hacker steal a :" + this.stealHealth + "XP and increased "+hero[randomHeroIndex].getName());

        } else {
            System.out.println(boss.getHealth() + " Boss has no health to stealing");
        }
    }





    }

