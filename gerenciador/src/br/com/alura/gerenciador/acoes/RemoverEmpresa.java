package br.com.alura.gerenciador.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;

public class RemoverEmpresa implements Acao {
	
	public String  executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		Banco banco = new Banco();
		banco.removeEmpresa(id);
		System.out.println("RemovaEmpresa"+id);
		
		ListaEmpresas le = new ListaEmpresas();
		le.executa(request, response);
		
		//response.sendRedirect("UnicaEntradaServlet?acao=ListaEmpresas");
		return "Redirect:UnicaEntradaServlet?acao=ListaEmpresas";
		

		
	}

}
