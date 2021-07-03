package Main;

public class GameObjects {

    private int health ;
    private int power ;
    private Team team;
    private int locationX;
    private int locationY;
    boolean continueCombat = true;
    boolean killed = false ;

    public GameObjects(Team team , int health , int power , int locationX , int locationY){
        this.health = health ;
        this.power = power ;
        this.team = team;
        this.locationX = locationX ;
        this.locationY = locationY;
    }


    public void combat( GameObjects enemy ) throws InterruptedException {

        while (continueCombat){

            this.health -= enemy.power;

            Thread.sleep(1000);

            enemy.health -= this.power;

            if (this.health<=0 || enemy.health <=0)
                break;

        }

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

}
