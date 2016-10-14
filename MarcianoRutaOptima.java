package es.upm.dit.adsw.pract1;

/**
 * Marcianito que analiza la forma mas corta de llegar al jugador y empieza a recorrerla.
 *
 * @author Jose A. Manas
 * @version 24/3/2012
 */
public class MarcianoRutaOptima
        extends Marciano {

    /**
     * Constructor.
     *
     * @param laberinto el laberinto en el que se mueve.
     * @param celda     posicion inicial.
     * @param dt        delta de tiempo para irse moviendo.
     */
    public MarcianoRutaOptima(Laberinto laberinto, Celda celda, int dt) {
        super(laberinto, celda, dt);
        setImagen("Anibal.png");
    }

    /**
     * Determina en que direccion vamos a movernos.
     * Calcula la ruta optima entre el marciano y la posicion actual del jugador y da un primer paso en esa ruta.
     * Hay que recalcular continuamente porque el jugador puede moverse de sitio.
     *
     * @return direccion del proximo movimiento.
     */
    protected Direccion seleccionDireccion() {
        Direccion optima = Direccion.NORTE;
        int distanciaTemporal = Integer.MAX_VALUE;
        Direccion[] direcciones = Direccion.values();
        int[][] distancias  = getLaberinto().getJugador().getDistancias();
        Celda celdaMarciano = getCelda();
        for(int i = 0; i < direcciones.length; i++){
        	Celda temp = celdaMarciano.getCelda(direcciones[i]);
    		if(temp != null){
    			if(getCelda().hayPared(temp) == false){
    				int x = temp.getPunto().getX();
    				int y = temp.getPunto().getY();
    				int distancia = distancias[x][y];
    				if(distancia < distanciaTemporal){
    					distanciaTemporal = distancia;
    					optima = direcciones[i];
    				}
    			}
    		}
        }
        return optima;
    }
}
