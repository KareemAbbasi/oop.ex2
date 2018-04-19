import oop.ex2.*;

public class SpaceShipFactory {
    public static SpaceShip[] createSpaceShips(String[] args) {
        HumanShip s1 = new HumanShip();
        SpaceShip[] ss = new SpaceShip[2];
        ss[0] = s1;
        ss[1] = s1;
        return ss;
    }
}
