import oop.ex2.GameGUI;

import java.awt.*;

/**
 * This class is responsible for the ship that is controlled by the user.
 */

public class HumanShip extends SpaceShip {
    /**
     * Does the actions of this ship for this round.
     * This is called once per round by the SpaceWars game driver.
     *
     * @param game the game object to which this ship belongs.
     */
    public void doAction(SpaceWars game){

        GameGUI gameGUI = game.getGUI();

        int turnValue = 0;
        if (gameGUI.isRightPressed() && gameGUI.isLeftPressed()) {
            turnValue = 0;
        } else if (gameGUI.isLeftPressed()){
            turnValue = 1;
        } else if (gameGUI.isRightPressed()) {
            turnValue = -1;
        }

        if (gameGUI.isTeleportPressed()){
            teleport();
        }
        spaceShipPhysics.move(gameGUI.isUpPressed(), turnValue);

        if (gameGUI.isShieldsPressed()){
            shieldOn();
        } else {
            shieldOff();
        }

        if (gameGUI.isShotPressed()){
            fire(game);
        }

        doActionExtra();
    }

    /**
     * Overrides the original getImage in the SpaceShip class and returns the image of the HumanShip instead of the
     * enemy ship.
     * @return
     */
    @Override
    public Image getImage() {
        if (isShieldUp){
            return GameGUI.SPACESHIP_IMAGE_SHIELD;
        } else {
            return GameGUI.SPACESHIP_IMAGE;
        }
    }
}
