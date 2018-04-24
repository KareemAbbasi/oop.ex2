/**
 * The RunnerShip always tries to avoid other SpaceShips by running away.
 */
public class RunnerShip extends SpaceShip {
    /**
     * Does the actions of this ship for this round.
     * This is called once per round by the SpaceWars game driver.
     *
     * @param game the game object to which this ship belongs.
     */
    @Override
    public void doAction(SpaceWars game) {
        SpaceShip closest = game.getClosestShipTo(this);
        double distance = spaceShipPhysics.distanceFrom(closest.spaceShipPhysics);
        double closestAngleToRunner = closest.spaceShipPhysics.angleTo(spaceShipPhysics);
        double angleFromRunner = spaceShipPhysics.angleTo(closest.spaceShipPhysics);

        if (distance < 0.25 && closestAngleToRunner < 0.23){
            teleport();
        }

        if (angleFromRunner < 0){
            spaceShipPhysics.move(true, 1);
        } else {
            spaceShipPhysics.move(true, -1);
        }
        doActionExtra();
    }

}
