public class PrimitivosFloat {

    static float varFlotante_sin_Ini;

    public static void main(String[] args) {

        float realFloat = 2.12e3f; //2120f
        float realFloat2 = 0.00000000015f; // 1.5e-10f
        System.out.println("realFloat = " + realFloat);
        System.out.println("realFloat2 = " + realFloat2);
        System.out.println("float corresponde en byte a " + Float.BYTES);
        System.out.println("float corresponde en bites a " + Float.SIZE);
        System.out.println("valor maximo de un float: " + Float.MAX_VALUE);
        System.out.println("valor minimo de un float: " + Float.MIN_VALUE);

        double realDouble = 3.4028235E39;
        System.out.println("realDouble = " + realDouble);
        System.out.println("double corresponde en byte a " + Double.BYTES);
        System.out.println("double corresponde en bites a " + Double.SIZE);
        System.out.println("valor maximo de un double: " + Double.MAX_VALUE);
        System.out.println("valor minimo de un double: " + Double.MIN_VALUE);
        
        var varFlotante = 3.1416d;
        System.out.println("varFlotante = " + varFlotante);
        System.out.println("varFlotante_sin_Ini = " + varFlotante_sin_Ini);
    }
}
