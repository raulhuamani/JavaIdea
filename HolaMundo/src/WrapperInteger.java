public class WrapperInteger {
    public static void main(String[] args) {

        int intPrimitivo = 32768;
        Integer intObjeto = Integer.valueOf(32768);
        Integer intObjeto2 = intPrimitivo;
        System.out.println("intObjeto = " + intObjeto);

        int num = intObjeto;
        System.out.println("num = " + num);
        int num2 = intObjeto.intValue();
        System.out.println("num2 = " + num2);

        String valorTVLcd = "67000";
        Integer valor = Integer.valueOf(valorTVLcd);
        System.out.println("valorTVLcd = " + valorTVLcd);
        System.out.println("valor = " + valor);

        short shortObjeto = intObjeto.shortValue();
        System.out.println("shortObjeto = " + shortObjeto);
        
        Byte byteObjeto = intObjeto.byteValue();
        System.out.println("byteObjeto = " + byteObjeto);
        
        Long longObjeto = intObjeto.longValue();
        System.out.println("longObjeto = " + longObjeto);

    }
}
