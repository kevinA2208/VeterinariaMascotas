package clases;

public class Mascota {
    
    //Atributos
    private String nombre, raza;
    private int edad;
    private TipoMascota tipoMascota;
    private boolean disponible;

    //Constructor
    public Mascota(String nombre, String raza, int edad, TipoMascota tipoMascota){
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.tipoMascota = tipoMascota;
        this.disponible = true;
    }
    //Metodos
    public String obtenerDatosMascota(){
        String datos_mascota = "Nombre: "+nombre+", Raza: "+raza+ ", Edad: "+edad+", datos tipo mascota: "+ tipoMascota.obtenerDatosTipoMascota() + ", disponible: " + disponible;
        return datos_mascota;
    }
    
    public static Mascota RegistrarMascota(String nombre, String raza, int edad, TipoMascota tipoMascota){
        Mascota mascota = new Mascota(nombre, raza, edad, tipoMascota);
        return mascota;
    }

    public static Mascota ActualizarMascota(Mascota mascotaActualizar, String nombre, String raza, int edad, TipoMascota tipoMascota){
        mascotaActualizar.nombre = nombre;
        mascotaActualizar.raza = raza;
        mascotaActualizar.edad = edad;
        mascotaActualizar.tipoMascota = tipoMascota;
        return mascotaActualizar;
    }

    public static void EliminarMascota(Mascota mascotaEliminar){
        mascotaEliminar = null;
    }


    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public TipoMascota getTipoMascota() {
        return tipoMascota.obtenerDatosTipoMascota();
    }

}
