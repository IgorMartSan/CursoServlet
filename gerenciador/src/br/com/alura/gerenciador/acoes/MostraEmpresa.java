package br.com.alura.gerenciador.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class MostraEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Banco banco = new Banco();
		Empresa em = banco.buscaEmpresaPelaId(id);
		System.out.println("procurando" + id);

		request.setAttribute("empresa", em);
		//RequestDispatcher rd = request.getRequestDispatcher("/formAlteraEmpresa.jsp");
		//rd.forward(request, response);
		return "Dispatcher:formAlteraEmpresa.jsp";

	}

}
