public class GameObjects {

    private int health ;
    private int power ;
    private Team team;
    boolean continueCombat = true;

    public GameObjects(Team team , int health , int power){
        this.health = health ;
        this.power = power ;
        this.team = team;
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

}
