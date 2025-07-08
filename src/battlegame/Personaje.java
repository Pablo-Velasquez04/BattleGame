package battlegame;

/**
 *
 * @author pablo
 */
public class Personaje {
    protected String nombre;
    protected int saludBase, ataque, defensa, vidaActual;
    
    public Personaje(String nombre, int saludBase, int ataque, int defensa){
        this.nombre = nombre;
        this.saludBase = saludBase;
        this.ataque = ataque;
        this.defensa = defensa;
        this.vidaActual = saludBase*10;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSaludBase() {
        return saludBase;
    }

    public void setSaludBase(int saludBase) {
        this.saludBase = saludBase;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public void setVidaActual(int vidaActual) {
        this.vidaActual = vidaActual;
    }
    
    
    @Override
    public String toString(){
        return "Personaje ->   "+
                "Nombre: "+nombre+", Salud: "+vidaActual+", Ataque: "+ataque+", defensa: "+defensa;
    }
}
