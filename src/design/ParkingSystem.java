package design;

public class ParkingSystem {
    int big;
    int medium;
    int small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        switch (carType) {
            case 1:
                if (big - 1 < 0) return false;
                big -= 1;
                break;
            case 2:
                if (medium - 1 < 0) return false;
                medium -= 1;
                break;
            case 3:
                if (small - 1 < 0) return false;
                small -= 1;
                break;
            default:
                break;
        }

        return true;
    }
}
