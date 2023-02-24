public class EjemploMatricesBuscar {
    public static void main(String[] args) {

        int[][] matrizDeEnteros = {
                {35, 90, 3, 1978},
                {15, 2020, 10, 5},
                {677, 127, 32767, 1999}
        };

        int elmentoBuscar = 1999;
        boolean encontrado = false;
        int i = 0, j = 0;

        buscar:
        for (i = 0; i < matrizDeEnteros.length; i++){
            for (j = 0; j < matrizDeEnteros[0].length; j++){
                if(matrizDeEnteros[i][j] == elmentoBuscar){
                    encontrado = true;
                    break buscar;
                }
            }
        }
        if(encontrado){
            System.out.println("Encontrado "+ elmentoBuscar + " en las coordenadas " + i + ", "+ j);
        } else {
            System.out.println(elmentoBuscar + " no se encontró en la matriz!");
        }
    }
}
