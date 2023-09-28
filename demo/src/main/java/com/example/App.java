package com.example;

import java.util.ArrayList;

import clases.Mascota;
import clases.TipoMascota;
import clases.adopciones.GestionAdopciones;
import clases.clientes.Clientes;
import clases.mascotas.Comportamiento;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        System.out.flush();
        boolean salir= false;
		int opcion;
        
        ArrayList<TipoMascota>arrayListTiposMascotas=new ArrayList<>();
        ArrayList<Clientes>arrayListClientes=new ArrayList<>();
        ArrayList<GestionAdopciones>arrayListAdopciones=new ArrayList<>();
        ArrayList<Mascota>arrayListMascotas=new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        while (salir == false) {
            int i = 1;
            String menu_opciones = "Veterinaria Mascotas \n"+ 
                    "1. Registrar Tipos de Mascotas\n" + 
                    "2. Registrar Clientes\n" + 
                    "3. Registrar Mascotas\n" + 
                    "4. Registrar Adopciones\n" +
                    "5. Mostrar Adopciones\n" + 
                    "6. Actualizar Cliente\n" +
                    "7. Mostrar Mascotas\n" +
                    "8. Actualizar datos de mascota\n" +
                    "9. Eliminar Mascota\n" +
                    "10. Eliminar Cliente\n" +
                    "11. Mostrar clientes\n"+
                    "12. Salir\n"+
                    "Seleccione una opcion: ";
            System.out.println(menu_opciones);

            opcion = sc.nextInt();

            switch(opcion) {
                case 1: //Registrar Tipo de mascota
                    System.out.println("Ingrese el nombre del Tipo de mascota: ");
                    String nombreTipoMascota = sc.next();

                    System.out.println("Ingrese el comportamiento del tipo de mascota: ");
                    String descripcionComportamientoTipoMascota = sc.next();


                    TipoMascota tipoMascotaObj = TipoMascota.registrarTipoMascota(nombreTipoMascota, descripcionComportamientoTipoMascota);
                    arrayListTiposMascotas.add(tipoMascotaObj);
                    System.out.println("Tipo de mascota "+ nombreTipoMascota + " Registrado");
                    break;
                case 2: //Registrar Cliente
                    System.out.println("Ingrese nombres del cliente: ");
                    String nombre = sc.next();
                    System.out.println("Ingrese apellidos del cliente: ");
                    String apellido = sc.next();
                    System.out.println("Ingrese el numero de cedula del cliente: ");
                    String cedula = sc.next();
                    System.out.println("Ingrese la dirección del cliente: ");
                    String direccion = sc.next();
                    System.out.println("Ingrese telefono del cliente: ");
                    int telefono = sc.nextInt();

                    Clientes clienteObj = Clientes.registrarCliente(nombre, apellido, cedula, direccion, telefono);
                    arrayListClientes.add(clienteObj);
                    System.out.println("Cliente "+ nombre + " registrado");
                    break;
                case 3: //Registrar Mascota
                    System.out.println("Ingrese el nombre de la mascota: ");
                    String nombreMascota = sc.next();
                    System.out.println("Ingrese la raza de la mascota: ");
                    String raza = sc.next();
                    System.out.println("Ingrese la edad de la mascota: ");
                    int edad = sc.nextInt();

                    System.out.println("Tipos de mascota: ");
                    
                    for (TipoMascota tipoMascota : arrayListTiposMascotas) {
                        System.out.println("Opción " + (i++) + ": " + tipoMascota.getNombreTipoMascota());
                    }
                    i = 1;
                    System.out.println("Seleccione el número de la opción del tipo de mascota: ");
                    int opcionTipoMascota = sc.nextInt();
                    TipoMascota tipoMascota = arrayListTiposMascotas.get(opcionTipoMascota-1);
                    Mascota mascotaObj = Mascota.RegistrarMascota(nombreMascota, raza, edad, tipoMascota);
                    arrayListMascotas.add(mascotaObj);
                    System.out.println("Mascota "+ nombreMascota + " registrado");
                    break;

                case 4: //Registrar Adopciones
                    System.out.println("Ingrese la fecha de adopcion: ");
                    String fechaAdopcion = sc.next();
                    
                    System.out.println("Clientes registrados: ");
                    
                    for (Clientes cliente : arrayListClientes) {
                        System.out.println("Opción " + (i++) + ": " + cliente.mostrarDatosCliente());
                    }
                    i = 1;
                    System.out.println("Seleccione el número de la opción del cliente que hizo la adopción: ");
                    int opcionCliente = sc.nextInt();
                    Clientes cliente = arrayListClientes.get(opcionCliente-1);
                    
                    System.out.println("Mascotas: ");
                    
                    for (Mascota mascota : arrayListMascotas) {
                        System.out.println("Opción " + (i++) + ": " + mascota.obtenerDatosMascota());
                    }
                    i = 1;
                    System.out.println("Seleccione el número de la opción de la mascota que se adoptó: ");
                    int opcionMascota = sc.nextInt();
                    Mascota mascota = arrayListMascotas.get(opcionMascota-1);
                    if(mascota.isDisponible()){
                        GestionAdopciones adopcion = new GestionAdopciones(fechaAdopcion, cliente, mascota);
                        mascota.setDisponible(false);
                        arrayListAdopciones.add(adopcion);
                        System.out.println("Adopción registrada");
                        break;
                    }
                    else{
                        System.out.println("Mascota no disponible");
                        break;
                    }
                    
                case 5: //Mostrar adopciones
                    System.out.println("Adopciones registradas:");
                    
                    for (GestionAdopciones adopcionFiltrada : arrayListAdopciones) {
                        System.out.println("Opción " + (i++) + ": " + adopcionFiltrada.mostrarHistoricoAdopciones());
                    }
                    i = 1;
                    break;
                case 6: //Actualizar Cliente
                    System.out.println("Clientes registrados: ");
                    
                    for (Clientes clienteFiltrado : arrayListClientes) {
                        System.out.println("Opción " + (i++) + ": " + clienteFiltrado.mostrarDatosCliente());
                    }
                    i = 1;
                    System.out.println("Seleccione el número de la opción del cliente que desea actualizar: ");
                    int opcionClienteActualizar = sc.nextInt();
                    Clientes clienteActualizar = arrayListClientes.get(opcionClienteActualizar-1);
                    System.out.println("Ingrese nombres del cliente: ");
                    String nombreClienteActualizado = sc.next();
                    System.out.println("Ingrese apellidos del cliente: ");
                    String apellidoClienteActualizado = sc.next();
                    System.out.println("Ingrese el numero de cedula del cliente: ");
                    String cedulaClienteActualizado = sc.next();
                    System.out.println("Ingrese la dirección del cliente: ");
                    String direccionClienteActualizado = sc.next();
                    System.out.println("Ingrese el numero de telefono del cliente: ");
                    int telefonoClienteActualizado = sc.nextInt();
                    Clientes actualizarCliente = Clientes.actualizarCliente(clienteActualizar, nombreClienteActualizado, apellidoClienteActualizado, cedulaClienteActualizado, direccionClienteActualizado, telefonoClienteActualizado);
                    System.out.println("Cliente actualizado \\n" + actualizarCliente.mostrarDatosCliente() );
                    break;
                case 7: //Mostrar Mascotas
                    System.out.println("Mascotas registradas: ");
                    
                    for (Mascota mascotaFiltrada : arrayListMascotas) {
                        System.out.println("Opción " + (i++) + ": " + mascotaFiltrada.obtenerDatosMascota());
                    }
                    i = 1;
                    break;
                case 8: //Actualizar datos de mascota
                    System.out.println("Mascotas registradas: ");
                    
                    for (Mascota mascotaFiltrada : arrayListMascotas) {
                        System.out.println("Opción " + (i++) + ": " + mascotaFiltrada.obtenerDatosMascota());
                    }
                    i = 1;
                    System.out.println("Seleccione el número de la opción de la mascota que desea actualizar: ");
                    int opcionMascotaActualizar = sc.nextInt();
                    Mascota mascotaActualizar = arrayListMascotas.get(opcionMascotaActualizar-1);

                    System.out.println("Tipos de mascota: ");
                    
                    for (TipoMascota tiposMascota : arrayListTiposMascotas) {
                        System.out.println("Opción " + (i++) + ": " + tiposMascota.getNombreTipoMascota());
                    }
                    i = 1;
                    System.out.println("Seleccione el número de la opción del tipo de mascota: ");
                    int opcionTipoMascotaActualizar = sc.nextInt();
                    TipoMascota tipoMascotaActualizar = arrayListTiposMascotas.get(opcionTipoMascotaActualizar-1);

                    System.out.println("Ingrese el nombre de la mascota: ");
                    String nombreMascotaActualizado = sc.next();
                    System.out.println("Ingrese la raza de la mascota: ");
                    String razaMascotaActualizado = sc.next();
                    System.out.println("Ingrese la edad de la mascota: ");
                    int edadMascotaActualizado = sc.nextInt();
                    Mascota actualizarMascota = Mascota.ActualizarMascota(mascotaActualizar, nombreMascotaActualizado, razaMascotaActualizado, edadMascotaActualizado, tipoMascotaActualizar);
                    System.out.println("Mascota actualizada \\n" + actualizarMascota.obtenerDatosMascota() );
                    break;
                case 9: //Eliminar mascota
                    System.out.println("Mascotas registradas: ");
                    
                    for (Mascota mascotaFiltrada : arrayListMascotas) {
                        System.out.println("Opción " + (i++) + ": " + mascotaFiltrada.obtenerDatosMascota());
                    }
                    i = 1;
                    System.out.println("Seleccione el número de la opción de la mascota que desea eliminar: ");
                    int opcionMascotaEliminar = sc.nextInt();
                    Mascota mascotaAEliminar = arrayListMascotas.get(opcionMascotaEliminar-1);
                    Mascota.EliminarMascota(mascotaAEliminar);
                    arrayListMascotas.remove(mascotaAEliminar);
                    System.out.println("Mascota eliminada");
                    break;
                case 10: //Eliminar cliente
                    System.out.println("Clientes registrados: ");
                    
                    for (Clientes clienteFiltrado : arrayListClientes) {
                        System.out.println("Opción " + (i++) + ": " + clienteFiltrado.mostrarDatosCliente());
                    }
                    i = 1;
                    System.out.println("Seleccione el número de la opción del cliente que desea eliminar: ");
                    int opcionClienteEliminar = sc.nextInt();
                    Clientes clienteAEliminar = arrayListClientes.get(opcionClienteEliminar-1);
                    Clientes.eliminarCliente(clienteAEliminar);
                    arrayListClientes.remove(clienteAEliminar);
                    System.out.println("Cliente eliminado");
                    break;
                case 11: //Mostrar clientes
                    System.out.println("Clientes registrados: ");
                    
                    for (Clientes clienteFiltrado : arrayListClientes) {
                        System.out.println("Opción " + (i++) + ": " + clienteFiltrado.mostrarDatosCliente());
                    }
                    i = 1;
                    break;
                case 12: //SALIR
                    System.out.println("Vuelva pronto!");
                    salir = true;
                    break;

                
            }
        }
    }
}
