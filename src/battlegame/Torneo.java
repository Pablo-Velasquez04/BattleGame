package battlegame;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author pablo
 */
public class Torneo {

    private ArrayList<Personaje> personajes = new ArrayList<Personaje>();
    private static ArrayList<Personaje> listaPersonajesSobrevivientes = new ArrayList<Personaje>();
    int rondaActual = 1;
    Random random = new Random();

    public Torneo(ArrayList<Personaje> personajes) {
        this.personajes = new ArrayList<>(personajes);
    }
    public Torneo(){
        
    }

    public void iniciarTorneo() {         
        do{
            listaPersonajesSobrevivientes = new ArrayList<>(); //Limpiamos la lista de personajes sobrevivientes para que este vacia en cada ronda

            if (((personajes.size()) % 2) != 0) {
                int indicePersonaje = random.nextInt(personajes.size());
                Personaje personajePasa = personajes.get(indicePersonaje);

                listaPersonajesSobrevivientes.add(personajePasa);
                personajes.remove(personajePasa);
            }

            while (!personajes.isEmpty() && (personajes.size() >= 2)) {
                int indiceP1 = random.nextInt(personajes.size());
                int indiceP2;

                //Evitamos que se elijan el mismo personaje
                do {
                    indiceP2 = random.nextInt(personajes.size());
                } while (indiceP1 == indiceP2);

                Personaje p1 = personajes.get(indiceP1);
                Personaje p2 = personajes.get(indiceP2);

                Batalla iniTorneo = new Batalla();
                System.out.println("===== NUEVA RONDA " + rondaActual + " =====");
                
                if(random.nextBoolean()){
                    Personaje perSobreViviente = iniTorneo.combatir(p1, p2);
                    listaPersonajesSobrevivientes.add(perSobreViviente);
                } else{
                    Personaje perSobreViviente = iniTorneo.combatir(p2, p1);
                    listaPersonajesSobrevivientes.add(perSobreViviente);
                }
                rondaActual++;
                personajes.remove(p1);
                personajes.remove(p2);  
            }

            personajes = listaPersonajesSobrevivientes;

        }while(personajes.size() > 1);
        
        Personaje campeon = personajes.get(0);
        System.out.println("\n"+campeon.getNombre()+" es el campeon del torneo!!!\n");
    }
    
    public void obtenerGanadoresRonda(Personaje ganador){
        System.out.println(ganador.getNombre()+" gana la batalla");
    }
}