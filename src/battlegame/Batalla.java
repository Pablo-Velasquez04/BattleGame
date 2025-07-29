package battlegame;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author pablo
 */
public class Batalla {
    private static ArrayList<Personaje> listaPersonajes = new ArrayList<Personaje>();
    static int danioP1, danioP2;
    
    public Personaje combatir(Personaje p1, Personaje p2){
        Torneo torneo = new Torneo();
        int vidaP1 = p1.getVidaActual();
        int vidaP2 = p2.getVidaActual();
        Personaje ganadorCombate;
        Random random = new Random();
        
        while (vidaP1 > 0 && vidaP2 > 0) {
            danioP1 = p1.getAtaque() - p2.getDefensa();
            danioP2 = p2.getAtaque() - p1.getDefensa();
            
            if(danioP1 <= 0 && danioP2 <= 0){
                System.out.println("No se causo ningun danio.  Se elige uno ganador al azar");
                return random.nextBoolean() ? p1 : p2;
            } else {
                vidaP2 -= Math.max(danioP1, 0);
                vidaP1 -= Math.max(danioP2, 0) ;
            }
            mostrarCombate(p1, p2);
        }
        
        if(vidaP2 > 0){
            ganadorCombate = p2;
        }else{
            ganadorCombate = p1;
        }
        
        torneo.obtenerGanadoresRonda(ganadorCombate);
        return ganadorCombate;
    }
    
    public void mostrarCombate(Personaje p1, Personaje p2){
        System.out.println(p1.getNombre()+" ataca a "+p2.getNombre()+" causando "+danioP1+" de danio.");
        System.out.println(p2.getNombre()+" ataca a "+p1.getNombre()+" causando "+danioP2+" de danio.");
        System.out.println("");
    }
}
