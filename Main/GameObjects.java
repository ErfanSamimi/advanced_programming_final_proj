package Main;

import Main.Heroes_Package.*;

public class GameObjects {

    static int number = 1;

    private int health ;
    private int power ;
    private Team team;
    private int locationX;
    private int locationY;
    boolean continueCombat = true;
    boolean killed = false ;
    public String name;
    boolean combating = false ;
    static Object lockObj = new Object();

    public GameObjects(Team team , int health , int power , int locationX , int locationY){
        this.health = health ;
        this.power = power ;
        this.team = team;
        this.locationX = locationX ;
        this.locationY = locationY;


        if(this instanceof IceHero)
            this.name = team.teamName + " IceHero " + number;
        else if (this instanceof EarthHero)
            this.name = team.teamName + " Earth Hero " + number;
        else if (this instanceof WindHero)
            this.name = team.teamName + " wind hero " + number;
        else if (this instanceof FireHero)
            this.name = team.teamName + " fire Hero " + number;
        else
            this.name = team.teamName + " Castle";

        number ++;
    }


    public void combat( GameObjects enemy ) throws InterruptedException {

        this.combating = true;
        enemy.combating =true;

        if (this instanceof Heroes)
            ((Heroes) this).move = false;

        if (enemy instanceof Heroes)
            ((Heroes) enemy).move = false;

        //-------------------------------------------------

        while (continueCombat){





            synchronized (lockObj) {
                System.out.println("++++  " + this.name + " and " + enemy.name + " combating ");
                this.health -= enemy.power;

                Thread.sleep(1000);

                enemy.health -= this.power;


                System.out.println(this.name + " Health : " + this.health);
                System.out.println(enemy.name + " Health : " + enemy.health);
            }

            if(this.health<=0 ){
                this.killed = true;
//                this.team.gameObjects.remove(this);

                System.out.println("xxx");
                enemy.combating = false;
                continueCombat = false;
            }

            if (enemy.health <=0){
                enemy.killed = true;
                System.out.println("xxx");

//                enemy.team.gameObjects.remove(enemy);
                this.combating = true;
                continueCombat = false;

            }


        }

        //-------------------------------------------------

        if (this instanceof Heroes)
            ((Heroes) this).move = true;

        if (enemy instanceof Heroes)
            ((Heroes) enemy).move = true;

        continueCombat = true ;
    }

    public void setLocation(int x , int y){
        this.locationY = y ;
        this.locationX = x ;
    }

    public int[] getLocation(){
        int[] location = new int[2];

        location[0] = this.locationX;
        location[1] = this.locationY;

        return location ;
    }

    public Team getTeam(){
        return this.team;
    }

    public void kill(){
        this.killed = true;
    }

    public boolean isKilled(){
        return this.killed;
    }

    public boolean sameLocation(GameObjects obj){

        if (this.locationY == obj.locationY && this.locationX == obj.locationX)
            return true;

        return false;
    }

}
