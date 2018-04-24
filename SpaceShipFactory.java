import oop.ex2.*;

/**
 * This class is responsible for receiving the types of ships the user wants in the game and creates them.
 */
public class SpaceShipFactory {
    /**
     * Creates the SpaceShips for the game according to the types given by the user.
     * @param args An array of strings that each represent a type of SpaceShips.
     * @return An array of SpaceShips according to the types specified by the user.
     */
    public static SpaceShip[] createSpaceShips(String[] args) {
        SpaceShip[] spaceShipArray = new SpaceShip[args.length];
        for (int i = 0; i < args.length; i++){
           switch (args[i]) {
               case "r": spaceShipArray[i] = new RunnerShip();
               break;
               case "a": spaceShipArray[i] = new AggressiveShip();
               break;
               case "d": spaceShipArray[i] = new DrunkardShip();
               break;
               case "b": spaceShipArray[i] = new BasherShip();
               break;
               case "s": spaceShipArray[i] = new SpecialShip();
               break;
               case "h": spaceShipArray[i] = new HumanShip();
               break;
           }
        }
        return spaceShipArray;
    }
}
