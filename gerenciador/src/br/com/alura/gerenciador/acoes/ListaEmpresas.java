package br.com.alura.gerenciador.acoes;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class ListaEmpresas implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//verificar cooking
	
		long antes = System.currentTimeMillis();
		
		System.out.println("ListaEmpresa Executando");
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresas();
		request.setAttribute("empresas", lista);
		//RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");
		//rd.forward(request, response);
		long depois = System.currentTimeMillis();
		
		System.out.println("Tempo: "+ (depois - antes));
		
		return "Dispatcher:listaEmpresas.jsp";
		
		
		

	}

}
