package teatrook;

public class Cliente {
    public String nomCliente;
    public int  edadCliente;
    public double pagoCliente;
    public Estados estadoCliente;
    
    public Cliente(){
        nomCliente = "";
        edadCliente = 0;
        pagoCliente = 0;
        estadoCliente = Estados.Disponible;
    }
}
