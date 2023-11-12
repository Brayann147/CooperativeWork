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
                    break;
                //Numero magico
                case 4:
                    break;
                //Numeros amigos
                case 5:
                    break;
                //Terminar
                case 6:
                    break;
                default:
                    break;
            }
        
        } while (accion!=6);


}}
