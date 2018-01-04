package ups.edu.ec.filtros;

import java.io.IOException;

import javax.inject.Inject;
import javax.security.auth.login.AppConfigurationEntry.LoginModuleControlFlag;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import ups.edu.ec.controlador.LoginControlador;

@WebFilter(urlPatterns={"/admin/*", "/login/*"} )
public class ControlAcesoFiltro implements Filter {
	
	@Inject
	protected LoginControlador logcontrol;
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, 
			FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Entrando no filtro");
		if(logcontrol.getAsistente()==null){
			HttpServletResponse resp = (HttpServletResponse)response;
			resp.sendRedirect("index-3.jsf");
			return;
		}
		chain.doFilter(request, response);
	}
	
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
			
	}

}
