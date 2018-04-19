import java.awt.Image;
import oop.ex2.*;

/**
 * The API spaceships need to implement for the SpaceWars game. 
 * It is your decision whether SpaceShip.java will be an interface, an abstract class,
 *  a base class for the other spaceships or any other option you will choose.
 *  
 * @author oop
 */
public abstract class SpaceShip{

    protected SpaceShipPhysics spaceShipPhysics = new SpaceShipPhysics();
    private int maximalEnergyLevel = 210;
    private int currentEnergyLevel = 190;
    private int health = 22;

    protected boolean isShieldUp = false;

   
    /**
     * Does the actions of this ship for this round. 
     * This is called once per round by the SpaceWars game driver.
     * 
     * @param game the game object to which this ship belongs.
     */
    public abstract void doAction(SpaceWars game);

    /**
     * This method 
     */
    public void doActionExtra() {
        //current energy goes up by one every round
        if (currentEnergyLevel < maximalEnergyLevel){
            currentEnergyLevel ++;
        }

        // if shields are up reduce 3 energy units.
        // check if there is available energy if not turn off shield.
        if (isShieldUp){
            if (currentEnergyLevel >= 3) {
                currentEnergyLevel -= 3;
            } else {
                isShieldUp = false;
            }
        }
    }

    /**
     * This method is called every time a collision with this ship occurs 
     */
    public void collidedWithAnotherShip(){
        if (!isShieldUp){
            health --;
            maximalEnergyLevel -= 10;
            if (currentEnergyLevel > maximalEnergyLevel){
                currentEnergyLevel = maximalEnergyLevel;
            }
        } else {
            maximalEnergyLevel += 18;
            currentEnergyLevel += 18;
        }
    }

    /** 
     * This method is called whenever a ship has died. It resets the ship's 
     * attributes, and starts it at a new random position.
     */
    public void reset(){
        spaceShipPhysics = new SpaceShipPhysics();
        maximalEnergyLevel = 210;
        currentEnergyLevel = 190;
        health = 22;
        isShieldUp = false;
    }

    /**
     * Checks if this ship is dead.
     * 
     * @return true if the ship is dead. false otherwise.
     */
    public boolean isDead() {
        return (health <= 0);
    }

    /**
     * Gets the physics object that controls this ship.
     * 
     * @return the physics object that controls the ship.
     */
    public SpaceShipPhysics getPhysics() {
        return spaceShipPhysics;
    }

    /**
     * This method is called by the SpaceWars game object when ever this ship
     * gets hit by a shot.
     */
    public void gotHit() {
        if (!isShieldUp) {
            health--;
            maximalEnergyLevel -= 10;
            if (currentEnergyLevel > maximalEnergyLevel) {
                currentEnergyLevel = maximalEnergyLevel;
            }
        }
    }

    /**
     * Gets the image of this ship. This method should return the image of the
     * ship with or without the shield. This will be displayed on the GUI at
     * the end of the round.
     * 
     * @return the image of this ship.
     */
    public abstract Image getImage();

    /**
     * Attempts to fire a shot.
     * 
     * @param game the game object.
     */
    public void fire(SpaceWars game) {
        if (currentEnergyLevel >= 19) {
            currentEnergyLevel -= 19;
            game.addShot(spaceShipPhysics);
        }

    }

    /**
     * Attempts to turn on the shield.
     */
    public void shieldOn() {
        if (currentEnergyLevel >= 3){
            isShieldUp = true;
        }
    }

    /**
     * Attempts to teleport.
     */
    public void teleport() {
        if (currentEnergyLevel >= 140){
            currentEnergyLevel -= 140;
            spaceShipPhysics = new SpaceShipPhysics();
        }

    }
    
}
