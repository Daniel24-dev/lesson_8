package kg.geeks.game.logic;

import kg.geeks.game.players.*;

import java.util.Random;

public class RPG_Game {
    public static Random random = new Random();
    private static int roundNumber;

    public static void startGame() {

        Boss boss = new Boss(4000, 30, "Skeleton");
        Warrior warrior1 = new Warrior(280, 10, "Knight");
        Warrior warrior2 = new Warrior(290, 15, "Ahiles");
        Magic magic = new Magic(270, 10, "Skymag",10);
        Medic doc = new Medic(250, 5, "Dumbledor", 15);
        Medic assistant = new Medic(300, 5, "Shaman", 5);
        Berserk berserk = new Berserk(260, 10, "Guts");
        Hacker hacker = new Hacker(200,9,"Anonymous", random.nextInt(10));
        Bomber bomber = new Bomber(150,10,"Mahmud");
        Reaper reaper = new Reaper(100,11,"LYCH");

        Hero[] heroes = {warrior1, doc, warrior2, magic, berserk, assistant,hacker,bomber,reaper};

        showStatistics(boss, heroes);
        while (!isGameOver(boss, heroes)) {
            playRound(boss, heroes);
        }
    }

    private static void playRound(Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.chooseDefence();
        boss.attack(heroes);
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0 && boss.getHealth() > 0 &&
                    hero.getAbility() != boss.getDefence()) {
                hero.attack(boss);
                hero.applySuperPower(boss, heroes);
            }
        }
        showStatistics(boss, heroes);
    }

    private static boolean isGameOver(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
            return true;
        }
        return false;
    }

    private static void showStatistics(Boss boss, Hero[] heroes) {
        System.out.println("ROUND " + roundNumber + " -------------");
        System.out.println(boss);
        for (Hero hero : heroes) {
            System.out.println(hero);
        }
    }
}
