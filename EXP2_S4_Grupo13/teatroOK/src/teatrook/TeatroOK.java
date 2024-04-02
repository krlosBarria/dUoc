
package teatrook;

import java.util.Scanner;

/**
 *
 * @author Carlos Barria Valdevenito
 * Fecha: 01 Abril 2024
 * Integrante: Sebastian Andres Cortes Negrete
 *             Carlos Alberto Barría Valdevenito
 * 
 * Actividad Formativa 4ta Semana
 */
public class TeatroOK {
    static Scanner teclado = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        menu();
    }
    
    //Metodo Menu principal
    public static void menu() {
        Proceso proceso = new Proceso();
        boolean deseaSalir =true;
        int opcion;
        
        //Ciclo do para ejecución de Menu con opciones
        do {         
            System.out.println("Bienvenido al Teatro Moto");
            System.out.println("Menu Principal ");
            System.out.println("1.- Comprar Entradas");
            System.out.println("2.- Ver Asientos");
            System.out.println("3.- Salir del Sistema.");
            System.out.println("Seleccion su opcion");
            opcion = teclado.nextInt();
            
            switch (opcion) {
                case 1:
                    System.out.println("Proceso de Compra Valor Gral $35000");
                    proceso.showAsientos();
                    proceso.Vender();
                    deseaSalir = false;
                    break;
                case 2:
                    proceso.showAsientos();
                    deseaSalir = false;
                    break;
                case 3:
                    deseaSalir = true;
                    System.out.println("Gracias por su visita, vuelva pronto.");
                    break;
                default:
                    System.out.println("Opcion no valida, intente nuevamente");
                    deseaSalir = false;
            }
        } while (deseaSalir != true);
        
        //Limpieza de datos
        proceso.limpiarDatos();
    }
}
