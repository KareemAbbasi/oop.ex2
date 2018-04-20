import oop.ex2.*;

public class SpaceShipFactory {
    public static SpaceShip[] createSpaceShips(String[] args) {
        HumanShip s1 = new HumanShip();
        //BasherShip s2 = new BasherShip();
        HumanShip s2 = new HumanShip();
        DrunkardShip s3 = new DrunkardShip();
        HumanShip s4 = new HumanShip();
        HumanShip s5 = new HumanShip();
        SpaceShip[] ss = new SpaceShip[5];
        ss[0] = s1;
        ss[1] = s2;
        ss[2] = s3;
        ss[3] = s4;
        ss[4] = s5;


        return ss;
    }
}
