import java.awt.*;

public class RunnerShip extends SpaceShip {
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
