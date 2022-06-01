package it.prova.gestionebiglietti.web.servlet.login;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionebiglietti.model.Ruolo;
import it.prova.gestionebiglietti.model.Utente;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String loginInput = request.getParameter("inputUsername");
		String passwordInput = request.getParameter("inputPassword");

		if (loginInput.equals("admin") && passwordInput.equals("admin")) {
			request.getSession().setAttribute("userInfo",
					new Utente(loginInput, passwordInput, "Admin", "User", Arrays.asList(new Ruolo(Ruolo.ADMIN_ROLE))));
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}

		if (loginInput.equals("user") && passwordInput.equals("user")) {
			request.getSession().setAttribute("userInfo", new Utente(loginInput, passwordInput, "Classic", "User",
					Arrays.asList(new Ruolo(Ruolo.CLASSIC_USER_ROLE))));
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}

		request.setAttribute("messaggio", "Credenziali errate");
		request.getRequestDispatcher("login.jsp").forward(request, response);

	}

}
