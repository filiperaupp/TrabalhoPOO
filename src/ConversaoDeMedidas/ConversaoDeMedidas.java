package ConversaoDeMedidas;

/**
 * Created by filip on 30/08/2017.
 */
public class ConversaoDeMedidas {

    public static double metrosParaJardas(double num) {
        num = num*1.09361;
        return num;
    }

    public static double metrosParaKm(double num) {
        num = num/1000;
        return num;
    }

    public static double metrosParaMilha(double num) {
        num = num*0.000621371;
        return num;
    }

    public static double milhasParaKm(double num) {
        num = num*1.60934;
        return num;
    }

    static double milhasParaJardas(double num) {
        num = num*1760;
        return num;
    }
}
