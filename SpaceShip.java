import java.awt.Image;
import oop.ex2.*;

/**
 * The API spaceships need to implement for the SpaceWars game. 
 * This class is an abstract class with one abstract method and all the other SpaceShip types inherit this class.
 *
 */
public abstract class SpaceShip{

    /** The physics component for the SpaceShip.*/
    protected SpaceShipPhysics spaceShipPhysics = new SpaceShipPhysics();
    /** The max energy level for the SpaceShip.*/
    private int maximalEnergyLevel = 210;
    /** The current energy level for the SpaceShip.*/
    private int currentEnergyLevel = 190;
    /** The health of the SpaceShip.*/
    private int health = 22;

    /** The number of the current round since the beginning of the game.*/
    protected int currentRound = 0;
    /** The number of the last round the ship shot in.*/
    private int lastRoundShot = 0;
    /** A boolean variable that show if the ship has its shields up or not.*/
    protected boolean isShieldUp = false;

   
    /**
     * Does the actions of this ship for this round. 
     * This is called once per round by the SpaceWars game driver.
     * 
     * @param game the game object to which this ship belongs.
     */
    public abstract void doAction(SpaceWars game);

    /**
     * Does the actions that all types of ships do in every round.
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

        currentRound ++;
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
    public Image getImage(){
        if (isShieldUp){
            return GameGUI.ENEMY_SPACESHIP_IMAGE_SHIELD;
        } else {
            return GameGUI.ENEMY_SPACESHIP_IMAGE;
        }
    }

    /**
     * Attempts to fire a shot.
     * 
     * @param game the game object.
     */
    public void fire(SpaceWars game) {
        if ((lastRoundShot != 0 && lastRoundShot + 7 <= currentRound) || lastRoundShot == 0) {
            if (currentEnergyLevel >= 19) {
                currentEnergyLevel -= 19;
                game.addShot(spaceShipPhysics);
                lastRoundShot = currentRound;
            }
        }

    }

    /**
     * Attempts to turn on the shield.
     */
    public void shieldOn() {
        if (currentEnergyLevel >= 3){
            currentEnergyLevel -= 3;
            isShieldUp = true;
        }
    }

    /**
     * Turns the shield off.
     */
    public void shieldOff() {
        isShieldUp = false;
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
