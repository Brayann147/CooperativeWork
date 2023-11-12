import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

public class Menu {
    public static void main(String[] args) {
      int accion = 6;
        do {
            accion = JOptionPane.showOptionDialog(null, "Que desea realizar", "Opciones", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Numero romano", "Factores Primos", "Nombre propio", "Numeros egolatras", "Numero magico", "Numeros amigos", "Terminar"},null);
        
            switch (accion) {
                //Numeros romanos
                case 0:
                int romanNumerasl = Integer.parseInt(JOptionPane.showInputDialog("Digte el numero"));
                    String number1 = romanNumerasl1(romanNumerasl);
                    JOptionPane.showMessageDialog(null,"El numero en romano es: "+number1);
                    break;
                //Factores primos
                case 1:
                int numFactor = Integer.parseInt(JOptionPane.showInputDialog("Digte el numero"));
                    String factors = primeFactors(numFactor);
                    JOptionPane.showMessageDialog(null,"El numero en sus factores primos es: "+factors);   
                    break;
                //Nombre propio
                case 2:
                String name = JOptionPane.showInputDialog(null, "Ingresa tu nombre:");
                    String fullName = ownName(name);
                    JOptionPane.showMessageDialog(null,"El nombre propio queda asi: "+fullName);   
                    break;
                //Numero egolatras
                case 3:
                // Solicitar al usuario que ingrese un número
                String input = JOptionPane.showInputDialog("Ingrese un número:");
                int a = Integer.parseInt(input);
                String aToString = Integer.toString(a);
                int cifras = aToString.length();
                int temp = a, suma = 0;
                while (temp > 0) {
                 int digito = temp % 10;
                suma += Math.pow(digito, cifras);
                temp /= 10;
                }
                if (suma == a) {
                JOptionPane.showMessageDialog(null, "Verdadero");
                } else {
                JOptionPane.showMessageDialog(null, "Falso");
                }
                case 4:
                String inputNumber = JOptionPane.showInputDialog("Ingrese un número:");
                int number = Integer.parseInt(inputNumber);
                if (MagicNumber(number)) {
                JOptionPane.showMessageDialog(null, "Verdadero");
                } else {
                JOptionPane.showMessageDialog(null, "Falso");
                }
                    break;
                //Numeros amigos
                case 5:
                String inputNu1 = JOptionPane.showInputDialog("Ingrese el primer número:");
                String inputNu2 = JOptionPane.showInputDialog("Ingrese el segundo número:");
                int nu1 = Integer.parseInt(inputNu1);
                int nu2 = Integer.parseInt(inputNu2);
                if (FriendsNumbers(nu1, nu2)) {
                JOptionPane.showMessageDialog(null, "Verdadero");
                } else {
                JOptionPane.showMessageDialog(null, "Falso");
                }
                    break;
                //Terminar
                case 6:
                    break;
                default:
                    break;
            }
        
        } while (accion!=6);


}
    /**
     * Método principal para realizar la conversión y mostrar el resultado, La clase RomanConverter convierte números enteros a su representación en notación romana..
     * @param recibe un numero entero para la conversion a numeros romanos.
     * @return una cadena que representa el numero en romano.
     */
public static String romanNumerasl1(int num){

    String[] romans = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX",
                            "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC",
                            "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM",
                            "", "M", "MM", "MMM"};
        String roman = "";
        int i = 0;
        while (num > 0) {
            int digit = num % 10;
            roman = romans[digit + i * 10] + roman;
            i++;
            num = num / 10;
        }
        return roman;
}
/**
 * Método para obtener los factores primos de un número y representarlos como una cadena de texto.
 * @param num Número entero para el cual se desean calcular los factores primos.
 * @return Una cadena que representa los factores primos del número en el formato "p^a * q^b * ..."
 */
    public static String primeFactors(int num){

    String data1 = "";
	    	for (int i = 2; i <= num; i++) {
	    	    int cont = 0;
	    	    while (num % i == 0) {
	    	        cont++;
	    	        num /= i;
	    	    }
	    	    if (cont > 0) {
	    	        if (data1.length() > 0) {
	    	            data1 += " * ";
	    	        }
	    	        data1 += i + "^" + cont;
	    	    }
	    	}
            String[] arrayNum = data1.split(" ");
	    	List<String> numInver = Arrays.asList(arrayNum);
	    	Collections.reverse(numInver);
	    	String invertedNumbersString = String.join(" ", numInver);
            
            return invertedNumbersString;
    }
/**
 * Método para formatear una cadena de nombres propios, capitalizando la primera letra de cada palabra y
 * convirtiendo las demás letras en minúsculas.
 *
 * @param nameString Cadena de nombres a formatear.
 * @return Una cadena de nombres propios formateada.
 */
public static String ownName(String nameString) {
        
    String[] name2 = nameString.split(" ");
    StringBuilder rewrite = new StringBuilder();
    for (int i = 0; i < name2.length; i++) {
        if (name2[i].length() > 1) {
            rewrite.append(Character.toUpperCase(name2[i].charAt(0)))
                    .append(name2[i].substring(1).toLowerCase());
            if (i < name2.length - 1) {
                rewrite.append(" ");
            }
        } else {
            rewrite.append(name2[i].toLowerCase());
            if (i < name2.length - 1) {
                rewrite.append(" ");
            }
        }
    }
    String name3 = rewrite.toString();
    String finalName = name3.replaceAll("\\s+", " ");
    return finalName;
}
/**
 * Comprueba si un número es un "número mágico".
 * Un número mágico es aquel cuya diferencia entre su forma invertida y su forma ordenada es igual al número original.
 *
 * @param num El número a verificar si es mágico.
 * @return true si el número es mágico, false de lo contrario.
 */
public static boolean MagicNumber(int num) {
        // Convertir el número a una cadena para manipular los dígitos
        String numToString = Integer.toString(num);

        // Obtener el número invertido
        String invertNumber = new StringBuilder(numToString).reverse().toString();

        // Ordenar los dígitos del número invertido de manera descendente
        char[] descendNumber = invertNumber.toCharArray();
        Arrays.sort(descendNumber);

        // Ordenar los dígitos del número de manera ascendente
        char[] ascendNumber = numToString.toCharArray();
        Arrays.sort(ascendNumber);

        // Calcular la diferencia entre el número invertido y el número con los dígitos ordenados de manera descendente
        int difference = Integer.parseInt(new String(descendNumber)) - Integer.parseInt(new String(ascendNumber));

        // Verificar si la diferencia es igual al número original
        return difference == num;
    }
    /**
 * Calcula la suma de los divisores propios de un número.
 *
 * @param numero El número del cual se calcula la suma de los divisores propios.
 * @return La suma de los divisores propios del número.
 */
    public static int getAddition(int numero) {
        int suma = 0;
        for (int i = 1; i <= numero / 2; i++) {
            if (numero % i == 0) {
                suma += i;
            }
        }
        return suma;
    }

/**
 * Verifica si dos números son "números amigos". Dos números son amigos si la suma de los divisores
 * propios de uno es igual al otro y viceversa.
 *
 * @param nu1 El primer número.
 * @param nu2 El segundo número.
 * @return true si los números son amigos, false de lo contrario.
 */
    public static boolean FriendsNumbers(int nu1, int nu2) {
        // Obtener la suma de los divisores propios de nu1
        int sumaDivisoresNu1 = getAddition(nu1);

        // Obtener la suma de los divisores propios de nu2
        int sumaDivisoresNu2 = getAddition(nu2);

        // Verificar si son amigos
        return (sumaDivisoresNu1 == nu2) && (sumaDivisoresNu2 == nu1);
    }
}
