
public class Nodo {

	protected Object  vuelo;
	protected Nodo nodo_sig;

	public Nodo(Object vuelo2) {
		this.vuelo = vuelo2;
		this.nodo_sig = null;
	}
	
	@Override
	public String toString() {
		return  vuelo.toString();
	}

	public Object getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

	public Nodo getNodo_sig() {
		return nodo_sig;
	}

	public void setNodo_sig(Nodo nodo_sig) {
		this.nodo_sig = nodo_sig;
	}

}
