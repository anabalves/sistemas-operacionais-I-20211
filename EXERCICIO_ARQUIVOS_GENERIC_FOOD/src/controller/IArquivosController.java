package controller;

import java.io.IOException;

public interface IArquivosController {

	void readFile(String path, String nome) throws IOException;

}
