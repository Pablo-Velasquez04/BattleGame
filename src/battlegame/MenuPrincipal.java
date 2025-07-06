package battlegame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author pablo
 */
public class MenuPrincipal {
    static ArrayList<Personaje> personajes = new ArrayList<Personaje>();
    
    static Scanner entrada = new Scanner(System.in);
    static int opcion;
    
    public static void mostrarMenu() throws InterruptedException{
        System.out.println("-------BIENVENIDO A BATTLE GAME-------");
        do{
            System.out.println("1. Cargar archivo");
            System.out.println("2. Jugar");
            System.out.println("3. Generar reporte de mayor ataque");
            System.out.println("4. Generar reporte con mayor defensa");
            System.out.println("5. Mostrar informacion del desarrollador");
            System.out.println("6. Salir");
            System.out.print("\nIngrese la opcion deseada: ");
            opcion = entrada.nextInt();
            
            switch(opcion){
                case 1: cargarArchivo();  //Cargar archivo
                    break;
                case 2:   //Jugar
                    break;
                case 3:   //Generar reporte de mayor ataque
                    break;
                case 4:   //Generar reporte con mayor defensa
                    break;
                case 5:  mostrarInformacionDesarrollador(); //Mostrar información del desarrollador
                    break;
                case 6:
                    opcion = 7;
                    System.out.println("\nSaliendo...\n"); //Salir
                    Thread.sleep(1500);
                    System.out.println("Programa finalizado!\n");
                    System.exit(0); 
                    break;
            }
            
        }while(opcion >= 1 && opcion <= 6);
    }
    
    public static void cargarArchivo(){        
        JFrame frame = new JFrame();
        frame.setAlwaysOnTop(true);
        
        JFileChooser cargarArchivo = new JFileChooser(System.getProperty("user.home")+"/Downloads");
        cargarArchivo.setDialogTitle("Seleccione un archivo de los personajes");
        
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo .lfp", "lfp");
        cargarArchivo.setFileFilter(filtro);
        
        int resultado = cargarArchivo.showOpenDialog(frame);

        if(resultado == JFileChooser.APPROVE_OPTION){
            File archivoSeleccionado = cargarArchivo.getSelectedFile();
            
            try(BufferedReader lectura = new BufferedReader(new FileReader(archivoSeleccionado))){
                String linea, nombre;
                int salud, ataque, defensa;
                Personaje personaje;
                
                lectura.readLine();
                
                while((linea = lectura.readLine()) != null){
                    String partes[] = linea.split("\\|");
                    
                    nombre = partes[0].trim();
                    salud = Integer.parseInt(partes[1].trim());
                    ataque = Integer.parseInt(partes[2].trim());
                    defensa = Integer.parseInt(partes[3].trim());
                    
                    personaje = new Personaje(nombre, salud, ataque, defensa);
                    
                    personajes.add(personaje);
                }
                
            }catch(IOException ex){  //Si sucede un error en la lectura, se nos notificara
                System.out.println("Error al leer el archivo "+ex.getMessage());
            } 
        }
        
        for(Personaje  p: personajes){
            System.out.println(p);
        }
        System.out.println("");
    }
    
    public static void mostrarInformacionDesarrollador(){
        System.out.println("\nInformacion del desarrollador: ");
        System.out.println("Nombre: Pablo Daniel Velasquez Hernandez"
                            +"\nCarnet: 202302232"
                            +"\nCarrera: Ingenieria en ciencias y sistemas\n");
    }
    
}
