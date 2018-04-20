import java.util.Random;

public class DrunkardShip extends SpaceShip {

    private int movingInCirclesRound = 0;
    private boolean isMovingInCircles;

    private float accelerateProbability = 0.7f;
    private float teleportProbability = 0.7f;
    private float shootProbability = 0.2f;
    private float moveInCirclesProbability = 0.3f;
    private float moveDirectionProbability = 0.5f;

    @Override
    public void doAction(SpaceWars game) {

        //create a number of different scenarios for the ships movement.
        //moving in circles
        //randomly teleporting
        //randomly shooting
        //randomly accelerating




        boolean willAccelerate;




        if (accelerateProbability >= (new Random().nextInt(11)/10)){
            willAccelerate = true;
        } else {
            willAccelerate = false;
        }

        if (isMovingInCircles && movingInCirclesRound + 20 >= currentRound && movingInCirclesRound != 0) {
            spaceShipPhysics.move(willAccelerate, -1);
        } else {
            isMovingInCircles = false;
            movingInCirclesRound = 0;
        }

        if (teleportProbability >= (new Random().nextInt(11)/10)) {
            teleport();
        } else if (shootProbability >= (new Random().nextInt(11)/10)) {
            fire(game);

        }
        if (moveInCirclesProbability >= (new Random().nextInt(11)/10)) {
            movingInCirclesRound = currentRound;
            isMovingInCircles = true;
            spaceShipPhysics.move(willAccelerate, -1);

        } else {
            spaceShipPhysics.move(willAccelerate,0);
        }

//        } else if (moveDirectionProbability >= (new Random().nextInt(11)/10)) {
//            spaceShipPhysics.move(willAccelerate, 1);
//        } else {
//            spaceShipPhysics.move(willAccelerate, -1);
//        }







       doActionExtra();
    }
}
