import oop.ex2.*;

public class SpaceShipFactory {
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
