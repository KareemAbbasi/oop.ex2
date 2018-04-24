import java.util.Random;

/**
 * The Drunk ship moves in a random way like someone who had too much drink.
 */

public class DrunkardShip extends SpaceShip {
    /** The probability that the ship will accelerate. (Max = 100).*/
    private int accelerateProbability = 20;
    /** The probability that the ship will teleport. (Max = 100).*/
    private int teleportProbability = 50;
    /** The probability that the ship will shoot. (Max = 100).*/
    private int shootProbability = 10;
    /** The probability that the ship will move in one of the directions. (Max = 100).*/
    private int moveDirectionProbability = 50;

    /**
     * Does the actions of this ship for this round.
     * This is called once per round by the SpaceWars game driver.
     *
     * @param game the game object to which this ship belongs.
     */
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
