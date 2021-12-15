package br.com.alura.gerenciador.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		System.out.println("Logado usu�rio:" + login + " " + senha);
		Banco banco = new Banco();
		Usuario usuario = banco.existeUsuario(login, senha);

		if (usuario != null) {
			System.out.println("Usu�rio existe:" + usuario.getLogin() + " " + usuario.getSenha());
			
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuarioLogado", usuario);
			return "Redirect:UnicaEntradaServlet?acao=ListaEmpresas";
		} else {

			return "Redirect:UnicaEntradaServlet?acao=LoginForm";
		}

		// response.sendRedirect("UnicaEntradaServlet?acao=ListaEmpresas");
		// return "Redirect:UnicaEntradaServlet?acao=ListaEmpresas";

	}

}
