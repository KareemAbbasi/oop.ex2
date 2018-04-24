/**
 * The BasherShip always tries to hit the other SpaceShips.
 */
public class BasherShip extends SpaceShip {
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
        double angleFromBasher = spaceShipPhysics.angleTo(closest.spaceShipPhysics);

        if (distance <= 0.19) {
            shieldOn();
        } else {
            shieldOff();
        }

        if (angleFromBasher < 0){
            spaceShipPhysics.move(true, -1);
        } else {
            spaceShipPhysics.move(true, 1);
        }
        doActionExtra();
    }
}
