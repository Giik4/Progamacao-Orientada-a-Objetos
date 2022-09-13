//Nome: Giovanni Siervo - RA: 2144255

public abstract class Processador {

	private int nucleos;
	private int threads;
	private float clock;
	private String video;
	private Memoria memor;
	private int cod;

	public Processador(){
		nucleos = 0;
		threads = 0;
		clock = 0;
		video = "";
		memor = new Memoria();
		cod = 0;
	}

	public Memoria getMemor(){
		return memor;
	}

	public void setMemor(Memoria memor){
		this.memor = memor;
	}

	public int getNucleos(){
		return nucleos;
	}

	public int getThreads(){
		return threads;
	}

	public float getClock(){
		return clock;
	}

	public String getVideo(){
		return video;
	}

	public int getCod(){
		return cod;
	}

	public void setNucleos(int nucleos){
		this.nucleos = nucleos;
	}

	public void setThreads(int threads){
		this.threads = threads;
	}

	public void setClock(float clock){
		this.clock = clock;
	}

	public void setVideo(String video){
		this.video = video;
	}

	public void setCod(int cod){
		this.cod = cod;
	}
}
