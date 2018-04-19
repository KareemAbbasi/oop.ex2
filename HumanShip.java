import oop.ex2.GameGUI;

import java.awt.*;

public class HumanShip extends SpaceShip {
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
        }

        if (gameGUI.isShotPressed()){
            fire(game);
        }

        doActionExtra();

        System.out.println(spaceShipPhysics.getAngle());

    }

    @Override
    public Image getImage() {
        if (isShieldUp){
            return GameGUI.SPACESHIP_IMAGE_SHIELD;
        } else {
            return GameGUI.SPACESHIP_IMAGE;
        }
    }
}
