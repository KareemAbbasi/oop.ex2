import java.util.Random;

public class DrunkardShip extends SpaceShip {


    private int accelerateProbability = 20;
    private int teleportProbability = 50;
    private int shootProbability = 10;
    private int moveDirectionProbability = 50;


    @Override
    public void doAction(SpaceWars game) {

        boolean willAccelerate;

        if (accelerateProbability >= (new Random().nextInt(100))){
            willAccelerate = true;
        } else {
            willAccelerate = false;
        }

        if (teleportProbability >= (new Random().nextInt(100))) {
            teleport();
        } else if (shootProbability >= (new Random().nextInt(100))) {
            fire(game);

        }

        if (moveDirectionProbability >= (new Random().nextInt(100))) {
            spaceShipPhysics.move(willAccelerate, 1);
        } else {
            spaceShipPhysics.move(willAccelerate, -1);
        }

       doActionExtra();
    }
}
