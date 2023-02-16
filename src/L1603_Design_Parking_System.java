public class L1603_Design_Parking_System {

    /**
     * Your L1603_Design_Parking_System.ParkingSystem object will be instantiated and called as such:
     * L1603_Design_Parking_System.ParkingSystem obj = new L1603_Design_Parking_System.ParkingSystem(big, medium, small);
     * boolean param_1 = obj.addCar(carType);
     */


    public static void main(String[] args) {

        L1603_Design_Parking_System s = new L1603_Design_Parking_System();
        long sysDate1 = System.currentTimeMillis();

        ParkingSystem obj = new ParkingSystem(1, 1, 0);
        boolean param_1 = obj.addCar(1);
        System.out.println(param_1);
        boolean param_2 = obj.addCar(2);
        System.out.println(param_2);
        boolean param_3 = obj.addCar(3);
        System.out.println(param_3);
        boolean param_4 = obj.addCar(1);
        System.out.println(param_4);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }

    public static class ParkingSystem {

        int size[];
        public ParkingSystem(int big, int medium, int small) {
            size = new int[] {big, medium, small};
        }

        public boolean addCar(int carType) {
            return size[carType - 1]-- > 0; // carType - 1] because carType (1,2,3) in index (0,1,2)
        }
    }
}