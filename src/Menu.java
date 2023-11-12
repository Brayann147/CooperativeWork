import java.util.Arrays;

import javax.swing.JOptionPane;

public class Menu {
    public static void main(String[] args) {
      int accion = 6;
        do {
            accion = JOptionPane.showOptionDialog(null, "Que desea realizar", "Opciones", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Numero romano", "Factores Primos", "Nombre propio", "punto 4", "punto 5", "punto 6", "Terminar"},null);
        
            switch (accion) {
                //Numeros romanos
                case 0:
                    
                    break;
                //Factores primos
                case 1:
                    
                    break;
                //Nombre propio
                case 2:
                    
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
    public static int getAddition(int numero) {
        int suma = 0;
        for (int i = 1; i <= numero / 2; i++) {
            if (numero % i == 0) {
                suma += i;
            }
        }
        return suma;
    }

    // Método que verifica si dos números son amigos
    public static boolean FriendsNumbers(int nu1, int nu2) {
        // Obtener la suma de los divisores propios de nu1
        int sumaDivisoresNu1 = getAddition(nu1);

        // Obtener la suma de los divisores propios de nu2
        int sumaDivisoresNu2 = getAddition(nu2);

        // Verificar si son amigos
        return (sumaDivisoresNu1 == nu2) && (sumaDivisoresNu2 == nu1);
    }
}
