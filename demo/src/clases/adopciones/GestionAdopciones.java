package clases.adopciones;

import clases.Mascota;
import clases.clientes.Clientes;

public class GestionAdopciones {
    
    private String fechaAdopcion;
    private Clientes cliente;
    private Mascota mascota;


    public GestionAdopciones(String fechaAdopcion, Clientes cliente, Mascota mascota) {
        this.fechaAdopcion = fechaAdopcion;
        this.cliente = cliente;
        this.mascota = mascota;
    }


    public String mostrarHistoricoAdopciones(){
        return "Fecha de adopcion: " + fechaAdopcion + "\n" + "Cliente: " + cliente.mostrarDatosCliente()
        + "\n" + "Mascota: " + mascota.obtenerDatosMascota() +"\n";
    }

    public GestionAdopciones registrarAdopcion(String fechaAdopcion, Clientes cliente, Mascota mascota){
        GestionAdopciones adopcion = new GestionAdopciones(fechaAdopcion, cliente, mascota);
        return adopcion;
    }


    public String getFechaAdopcion() {
        return fechaAdopcion;
    }
    public void setFechaAdopcion(String fechaAdopcion) {
        this.fechaAdopcion = fechaAdopcion;
    }
    public Clientes getCliente() {
        return cliente;
    }
    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }
    public Mascota getMascota() {
        return mascota;
    }
    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }


}
