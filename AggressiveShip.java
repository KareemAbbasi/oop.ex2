public class AggressiveShip extends SpaceShip{

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
