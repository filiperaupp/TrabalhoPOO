package ConversaoDeMedidas;

/**
 * Created by filip on 30/08/2017.
 */
public class MainConversao {
    public static void main(String[] args) {
        System.out.println("Metros para Jardas: "+ConversaoDeMedidas.metrosParaJardas(100));
        System.out.println("Metros para km: "+ConversaoDeMedidas.metrosParaKm(100));
        System.out.println("Metros para milhas: "+ConversaoDeMedidas.metrosParaMilha(100));
        System.out.println("Milhas para km: "+ConversaoDeMedidas.milhasParaKm(10));
        System.out.println("Milhas para jardas: "+ConversaoDeMedidas.milhasParaJardas(10));
    }
}
