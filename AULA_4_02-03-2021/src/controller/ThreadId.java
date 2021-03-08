package controller;

// extends Thread
//Parametros por construtor
//método run()

public class ThreadId extends Thread {

	private int idThread;
	
	public ThreadId(int idThread) {
		this.idThread = idThread;
	}

	@Override
	public void run() {
		//Só se executa o que está aqui dentro
		System.out.println(idThread);
	}
	
}
