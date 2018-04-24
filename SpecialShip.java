/**
 * The SpecialShip moves in a way that is a combination of all the other types of ships.
 */
public class SpecialShip extends SpaceShip{
    /**
     * Does the actions of this ship for this round.
     * This is called once per round by the SpaceWars game driver.
     *
     * @param game the game object to which this ship belongs.
     */
    @Override
    public void doAction(SpaceWars game) {
        SpaceShip closet = game.getClosestShipTo(this);
        double angleFromSpecial = spaceShipPhysics.angleTo(closet.spaceShipPhysics);
        double angleToSpecial = closet.spaceShipPhysics.angleTo(spaceShipPhysics);
        double distance = spaceShipPhysics.distanceFrom(closet.spaceShipPhysics);

        if (distance < 0.25 && angleToSpecial < 0.23){
            teleport();
        }

        if (distance <= 0.21) {
            fire(game);
        } else  if (distance <= 0.1) {
            shieldOn();
        } else {
            shieldOff();
        }



        if (angleFromSpecial < 0){
            spaceShipPhysics.move(true, -1);
        } else {
            spaceShipPhysics.move(true, 1);
        }
        doActionExtra();
    }
}
