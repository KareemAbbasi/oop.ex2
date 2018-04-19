public class BasherShip extends SpaceShip {

    @Override
    public void doAction(SpaceWars game) {
        SpaceShip closest = game.getClosestShipTo(this);
        double distance = spaceShipPhysics.distanceFrom(closest.spaceShipPhysics);
        double angleFromBasher = spaceShipPhysics.angleTo(closest.spaceShipPhysics);

        if (distance <= 0.19) {
            shieldOn();
        }

        if (angleFromBasher < 0){
            spaceShipPhysics.move(true, -1);
        } else {
            spaceShipPhysics.move(true, 1);
        }
        doActionExtra();
    }
}
