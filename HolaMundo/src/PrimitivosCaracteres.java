public class PrimitivosCaracteres {
    public static void main(String[] args) {

        // ver pagina para ver los codigos Unicode
        // https://unicode-table.com/es/

        //char caracter = 'A';
        //var caracter = '\u0040';       // @ en unicode es \u0040
        //var decimal = 64;              // @ en decimal es 64

        char caracter = '\u0040';       // @ en unicode es \u0040
        char decimal = 64;              // @ en decimal es 64
        System.out.println("caracter = " + caracter);
        System.out.println("decimal = " + decimal);
        System.out.println("decimal = caracter : " + (decimal == caracter));

        char simbolo = '@';
        System.out.println("simbolo = " + simbolo);
        System.out.println("simbolo = caracter: " + (simbolo == caracter));

        //char espacio = ' ';
        char espacio = '\u0020';
        char retroceso = '\b';
        char tabulador = '\t';
        char nuevaLinea = '\n';
        char retornoCarro = '\r';

        //System.out.println("char corresponde en Byte:" + System.getProperty("line.separator") + Character.BYTES);
        //System.out.println("char corresponde en Byte:" + System.lineSeparator() + Character.BYTES);
        System.out.println("char corresponde en Byte:" + nuevaLinea + retornoCarro + Character.BYTES);
        System.out.println("char corresponde en Bites = " + Character.SIZE);
        System.out.println("Character.MIN_VALUE = " + Character.MIN_VALUE);
        System.out.println("Character.MAX_VALUE = " + Character.MAX_VALUE);
    }
}
