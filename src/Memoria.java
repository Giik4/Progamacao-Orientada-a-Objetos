//Nome: Giovanni Siervo - RA: 2144255

public class Memoria{
	
	private int max;
	private String tipo;
	private int cache;

	public Memoria(){
		max = 0;
		tipo ="";
		cache = 0;
	}

	public int getMax(){
		return max;
	}

	public String getTipo(){
		return tipo;
	}

	public int getCache(){
		return cache;
	}

	public void setMax(int max){
		this.max = max;
	}
	
	public void setTipo(String tipo){
		this.tipo = tipo;
	}

	public void  setCache(int cache){
		this.cache = cache;
	}

}
