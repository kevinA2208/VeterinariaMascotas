package clases;

public class TipoMascota {
    
    private String nombreTipoMascota;
    private String comportamientoTipoMascota;

    
    public TipoMascota(String nombreTipoMascota, String comportamientoTipoMascota) {
        this.nombreTipoMascota = nombreTipoMascota;
        this.comportamientoTipoMascota = comportamientoTipoMascota;
    }

    public static TipoMascota registrarTipoMascota(String nombreTipoMascota, String comportamientoTipoMascota){
        TipoMascota tipoMascota = new TipoMascota(nombreTipoMascota, comportamientoTipoMascota);
        return tipoMascota;
    }

    public String obtenerDatosTipoMascota(){
        return "Nombre: "+nombreTipoMascota + " Comportamiento: "+ comportamientoTipoMascota;
    }

    public String getNombreTipoMascota() {
        return nombreTipoMascota;
    }

    public void setNombreTipoMascota(String nombreTipoMascota) {
        this.nombreTipoMascota = nombreTipoMascota;
    }

    public String getComportamientoTipoMascota() {
        return comportamientoTipoMascota;
    }

    public void setComportamientoTipoMascota(String comportamientoTipoMascota) {
        this.comportamientoTipoMascota = comportamientoTipoMascota;
    }


}
