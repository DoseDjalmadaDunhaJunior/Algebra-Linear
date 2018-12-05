public class SistemaLinear {
    
    public void popula(double a, double b, double c, double d){
        variaveris[pivoL][pivoC] = a;
        pivoC++;
        variaveris[pivoL][pivoC] = b;
        pivoC++;
        variaveris[pivoL][pivoC] = c;
        pivoC++;
        respostas[pivoL] = d;
        pivoL++;
        pivoC = 0;
    }

    public void dimencao(int l,int c){
        colunas = c;
        linhas = l;
    }

    public int getColunas() {
        return colunas;
    }

    public int getLinhas() {
        return linhas;
    }

    public void imprime() {
        imprime(variaveris,respostas);
    }
    
    public void escalona(){
        
        escalonado = variaveris;
        respostasEsc = respostas;
        if(escalonado[0][0] != 0){
            while ((escalonado[1][0] != 0) && (escalonado[2][0] != 0)){
                if(escalonado[1][0] != 0){
                    double a,b;
                    a = escalonado[0][0];
                    b = escalonado[1][0];
                    if((a > 0 && b > 0) || (a < 0 && b < 0)){
                        b = b*-1;
                    }
                    for (pivoC=0;pivoC < 3;pivoC++){
                        escalonado[0][pivoC] = escalonado[0][pivoC] * b;
                        escalonado[1][pivoC] = escalonado[1][pivoC] * a;
                    }
                    respostasEsc[0] = respostasEsc[0] * b;
                    respostasEsc[1] = respostasEsc[1] * a;

                }
                if(escalonado[2][0] != 0){
                    double a,b;
                    a = escalonado[0][0];
                    b = escalonado[2][0];
                    if((a > 0 && b > 0) || (a < 0 && b < 0)){
                        b = b*-1;
                    }
                    for (int pivoC=0;pivoC < 3;pivoC++){
                        escalonado[0][pivoC] = escalonado[0][pivoC] * b;
                        escalonado[2][pivoC] = escalonado[2][pivoC] * a;
                    }
                    respostasEsc[0] = respostasEsc[0] * b;
                    respostasEsc[2] = respostasEsc[2] * a;
                }
            }
            while (escalonado[2][1] != 0){
                if(escalonado[1][1] != 0 && escalonado[2][1] != 0){
                    double a,b;
                    a = escalonado[1][1];
                    b = escalonado[2][1];
                    if((a > 0 && b > 0) || (a < 0 && b < 0)){
                        b = b*-1;
                    }
                    for (int pivoC=0;pivoC < 3;pivoC++){
                        escalonado[1][pivoC] = escalonado[1][pivoC] * b;
                        escalonado[2][pivoC] = escalonado[2][pivoC] * a;
                    }
                    respostasEsc[1] = respostasEsc[1] * b;
                    respostasEsc[2] = respostasEsc[2] * a;
                }
            }
        }
        imprime(escalonado,respostasEsc);
    }

    private void valor(){
        double x,y,z;
        z = escalonado[2][2]/respostasEsc[2];
    }

    private void imprime(double[][] mat, double[] vet){
        pivoL = 0;
        pivoC = 0;
        for (pivoL = 0; pivoL < 3; pivoL++) {
            for (pivoC = 0; pivoC < 3; pivoC++) {
                System.out.print(mat[pivoL][pivoC]+ " ");
            }
            System.out.print("= "+ vet[pivoL]);
            System.out.print("\n");
        }
    }

    private int colunas;
    private int linhas;
    private double variaveris[][] = new double[3][3];
    private double escalonado[][] = new double[3][3];
    private double respostas[] = new double[3];
    private double respostasEsc[] = new double[3];
    private int pivoC = 0;
    private int pivoL = 0;
}
