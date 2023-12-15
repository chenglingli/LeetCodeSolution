import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L2469_Convert_the_Temperature {

    /*
    Kelvin = Celsius + 273.15
    Fahrenheit = Celsius * 1.80 + 32.00
     */
    public double[] convertTemperature(double celsius) {
        return new double[]{
                celsius + 273.15,
                celsius*1.8 + 32
        };
    }

    public static void main(String[] args) {

        L2469_Convert_the_Temperature s = new L2469_Convert_the_Temperature();
        long sysDate1 = System.currentTimeMillis();

        double celsius = 36.50;
        double[] res = s.convertTemperature(celsius);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}