/**
 * The AggressiveShip always moves towards the nearest ship and tries to shoot at it.
 */
public class AggressiveShip extends SpaceShip{
    /**
     * Does the actions of this ship for this round.
     * This is called once per round by the SpaceWars game driver.
     *
     * @param game the game object to which this ship belongs.
     */
    @Override
    public void doAction(SpaceWars game) {
        SpaceShip closest = game.getClosestShipTo(this);
        double angleFromAggressive = spaceShipPhysics.angleTo(closest.spaceShipPhysics);

        if (angleFromAggressive <= 0.21) {
            fire(game);
        }

        if (angleFromAggressive < 0){
            spaceShipPhysics.move(true, -1);
        } else {
            spaceShipPhysics.move(true, 1);
        }

        doActionExtra();
    }
}
