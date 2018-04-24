public class SpecialShip extends SpaceShip{
    @Override
    public void doAction(SpaceWars game) {
        SpaceShip closet = game.getClosestShipTo(this);
        double angleFromSpecial = spaceShipPhysics.angleTo(closet.spaceShipPhysics);
        double angleToSpecial = closet.spaceShipPhysics.angleTo(spaceShipPhysics);
        double distance = spaceShipPhysics.distanceFrom(closet.spaceShipPhysics);

        if (distance <= 0.21) {
            fire(game);
        } else  if (distance <= 0.1) {
            shieldOn();
        } else {
            shieldOff();
        }

        if (distance < 0.25 && angleToSpecial < 0.23){
            teleport();
        }

        if (angleFromSpecial < 0){
            spaceShipPhysics.move(true, -1);
        } else {
            spaceShipPhysics.move(true, 1);
        }
        doActionExtra();
    }
}
