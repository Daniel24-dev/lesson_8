package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Magic extends Hero {
    private int boostAmount;
    public Magic(int health, int damage, String name,int boostAmount) {

        super(health, damage, name, SuperAbility.BOOST);
        this.boostAmount = boostAmount;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {

        // TODO Here will be implementation of boosting
        for (Hero hero:heroes){
            hero.setDamage(hero.getDamage()+this.boostAmount);

        }
        System.out.println("Magican increase damage to: " +this.boostAmount);
    }
}
