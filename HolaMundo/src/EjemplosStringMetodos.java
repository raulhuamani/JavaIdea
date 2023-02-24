public class EjemplosStringMetodos {
    public static void main(String[] args) {
        
        String nombre = "Raul";

        System.out.println("nombre.length() = " + nombre.length());
        System.out.println("nombre.toUpperCase(Locale.ROOT) = " + nombre.toUpperCase());
        System.out.println("nombre.toLowerCase() = " + nombre.toLowerCase());
        System.out.println("nombre.equals(\"Raul\") = " + nombre.equals("Raul"));
        System.out.println("nombre.equals(\"raul\") = " + nombre.equals("raul"));
        System.out.println("nombre.compareToIgnoreCase(\"raul\") = " + nombre.equalsIgnoreCase("raul"));
        System.out.println("nombre.compareTo(\"Raul\") = " + nombre.compareTo("Raul"));
        System.out.println("nombre.compareTo(\"Aaron\") = " + nombre.compareTo("Aaron"));
        System.out.println("nombre.charAt(0) = " + nombre.charAt(0));
        System.out.println("nombre.charAt(1) = " + nombre.charAt(1));
        System.out.println("nombre.charAt(nombre.length() -1) = " + nombre.charAt(nombre.length() -1));

        System.out.println("nombre.substring(1) = " + nombre.substring(1));
        System.out.println("nombre.substring(1, 3) = " + nombre.substring(1, 3));
        System.out.println("nombre.substring(nombre.length()-2) = " + nombre.substring(nombre.length()-2));

        String trabalengua = "trabalenguas";
        System.out.println("trabalengua = " + trabalengua.replace("a", "."));
        System.out.println("trabalengua = " + trabalengua);
        System.out.println("trabalengua.indexOf('a') = " + trabalengua.indexOf('a'));
        System.out.println("trabalengua.indexOf('t') = " + trabalengua.indexOf('t'));
        System.out.println("trabalengua.contains(\"lenguas\") = " + trabalengua.contains("lenguas"));
        System.out.println("trabalengua.startsWith(\"tr\") = " + trabalengua.startsWith("tr"));
        System.out.println("trabalengua.endsWith(\"lenguas\") = " + trabalengua.endsWith("lenguas"));
        System.out.println("  trabalenguas ");
        System.out.println("  trabalenguas ".trim());
    }
}
