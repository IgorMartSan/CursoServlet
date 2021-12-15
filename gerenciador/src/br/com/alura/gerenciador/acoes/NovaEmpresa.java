package br.com.alura.gerenciador.acoes;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class NovaEmpresa implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response)  {
				return "Dispatcher:formNovaEmpresa.jsp";

	}

}
