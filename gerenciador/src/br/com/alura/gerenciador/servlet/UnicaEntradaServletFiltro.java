package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acoes.Acao;

/**
 * Servlet Filter implementation class UnicaEntradaServletFiltro
 */
//@WebFilter("/entrada")
public class UnicaEntradaServletFiltro implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}

	
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		System.out.println("UnicaEntradaServletFiltro");
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String paramAcao = request.getParameter("acao");
		chain.doFilter(request, response);
	
	
	String nome;
	System.out.println(paramAcao);
	
	String nomeDaClasse = "br.com.alura.gerenciador.acoes." + paramAcao;
	try {
		System.out.println("0");
		Class classe = Class.forName(nomeDaClasse);
		System.out.println("1");
		Acao obj = (Acao) classe.newInstance();		
		System.out.println("2");
		nome = obj.executa(request,response);
		System.out.println("3");
	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
		throw new ServletException(e);
	}
	
	String endereco[] = nome.split(":");

	if (endereco[0].equals("Dispatcher")) {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/view/" + endereco[1]);
		rd.forward(request, response);

	} else if (endereco[0].equals("Redirect")) {
		response.sendRedirect(endereco[1]);
	}

}
	

	

}
