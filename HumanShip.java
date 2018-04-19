import oop.ex2.GameGUI;

import java.awt.*;

public class HumanShip extends SpaceShip {
    public void doAction(SpaceWars game){
        doActionExtra();

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
