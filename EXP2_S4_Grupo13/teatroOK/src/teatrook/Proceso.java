package teatrook;


public class Proceso {
    Cliente espacios[][]= new Cliente[3][10];
    
    //Creacion de clase Cliente para almacenar los datos del arreglo
    public Proceso(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                espacios[i][j] = new Cliente();
            }
        }
    }
    
    //Metodo de compra de entradas
    public void Vender(){
        String nombre;
        int edad;
        int fila, asiento, valorGral = 35000;
        
        System.out.println("Ingrese su nombre: ");TeatroOK.teclado.nextLine();
        nombre = TeatroOK.teclado.nextLine();
        System.out.println("Ingrese su Edad: ");
        edad = TeatroOK.teclado.nextInt();
        
        System.out.println("Seleccione la Fila  [1..3] :");
        fila = TeatroOK.teclado.nextInt();
        System.out.println("Seleccione el asiento [1..10] :");
        asiento = TeatroOK.teclado.nextInt();
        
        if (espacios[fila-1][asiento-1].estadoCliente == Estados.Disponible) {
            espacios[fila-1][asiento-1].nomCliente = nombre;
            espacios[fila-1][asiento-1].edadCliente = edad;
            if (edad <=18) {
                espacios[fila-1][asiento-1].pagoCliente = valorGral - (valorGral * 0.10);
                System.out.println("Descuento Estudiante 10% $"+(valorGral * 0.10));
                System.out.println("Ticket Fila: "+fila+" Asiento: "+asiento);
                System.out.println("Total a Pagar: $"+espacios[fila-1][asiento-1].pagoCliente);
            }else{
                if (edad >=60) {
                    espacios[fila-1][asiento-1].pagoCliente = valorGral - (valorGral * 0.15);
                    System.out.println("Descuento 3era Edad 15% $"+(valorGral * 0.15));
                    System.out.println("Ticket Fila: "+fila+" Asiento: "+asiento);
                    System.out.println("Total a Pagar: $"+espacios[fila-1][asiento-1].pagoCliente);
                } else {
                    espacios[fila-1][asiento-1].pagoCliente = valorGral;
                    //System.out.println("Valor sin descuento $"+espacios[fila-1][asiento-1].pagoCliente);
                    System.out.println("Ticket Fila: "+fila+" Asiento: "+asiento);
                    System.out.println("Total a Pagar: $"+espacios[fila-1][asiento-1].pagoCliente);
                }
            }
                
            espacios[fila-1][asiento-1].estadoCliente = Estados.Ocupado;
            System.out.println("El Ticket de asiento esta reservado\n");
        } else {
            System.out.println("El Asiento no esta disponible");
        }
    }
    
    //Metodo mostrar los asientos del Teatro
    public void showAsientos(){
        
        System.out.println("Distribucion Asientos");
        System.out.println(" 1  2  3  4  5  6  7  8  9  10 |");
        for (int i = 0; i < 3; i++) {
            System.out.println("Fila "+(i+1));
            for (int j = 0; j < 10; j++) {
//                System.out.print(" | "+(j+1));
                if (espacios[i][j].estadoCliente == Estados.Disponible){
                    System.out.print(" _ ");
                } else {
                    System.out.print(" X ");
                }
             }
            System.out.println(" |");
            System.out.println("\n");
                    
        }
    }

    //Limpiaar los datos del sistema
    public void limpiarDatos(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                espacios[i][j].estadoCliente = Estados.Disponible;
             }
        }
        TeatroOK.teclado.close();
    }
}
