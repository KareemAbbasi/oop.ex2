import oop.ex2.*;

public class SpaceShipFactory {
    public static SpaceShip[] createSpaceShips(String[] args) {
        HumanShip s1 = new HumanShip();
        //BasherShip s2 = new BasherShip();
        AggressiveShip s2 = new AggressiveShip();
        RunnerShip s3 = new RunnerShip();
        RunnerShip s4 = new RunnerShip();
        RunnerShip s5 = new RunnerShip();
        SpaceShip[] ss = new SpaceShip[5];
        ss[0] = s1;
        ss[1] = s2;
        ss[2] = s3;
        ss[3] = s4;
        ss[4] = s5;


        return ss;
    }
}
