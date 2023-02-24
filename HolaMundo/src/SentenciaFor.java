public class SentenciaFor {
    public static void main(String[] args) {
        
        for(int i = 0;i <= 5; i++){
            System.out.println("i = " + i);
        }

        // Tambien soporta de esta forma pero no es buena practica.
        int x = 0;
        for(;;){
            if(x > 5){
                break;
            }
            System.out.println("x = " + x);
            x++;
        }
        // Decremento
        for(int i = 10; i>=0; i--){
            System.out.println("i = " + i);
        }
        // Entre 2 variables
        for(int i = 1, j = 10; i < j; i++, j--){
            System.out.println(i + " = " + j);
        }
        // Solo impares
        for(int i = 0; i <= 10; i++){
            if (i % 2 == 0){
                continue;
            }
            System.out.println("i = " + i);
        }

    }
}
