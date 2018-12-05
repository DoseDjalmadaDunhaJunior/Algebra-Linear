public class Main {

    public static void main(String[] args) {
        SistemaLinear oi = new SistemaLinear();
        oi.dimencao(3,3);
        oi.popula(1,2,1,4);
        oi.popula(1.24,3,-1,3);
        oi.popula(2,-1,1,2);
        oi.imprime();
        oi.escalona();
    }
}
