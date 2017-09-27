package AP3.Revision;

/**
 * Created by filip on 08/08/2017.
 */
public class Functions {

    public static double calculadora (double x, double y, String ope) {
        switch (ope) {
            case "soma": {
                return x+y;
            }
            case "sub": {
                return x-y;
            }
            case "div": {
                return x/y;
            }
            case "multi": {
                return x*y;
            }
            default:
                System.out.println("Operação inválida.");
                return 0;
        }

    }
}
