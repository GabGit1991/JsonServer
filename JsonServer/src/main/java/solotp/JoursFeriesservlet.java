package solotp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import Model.Client;
import ToJson.ClientToJson;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tpjson.dao.ClientDAO;

/**
 * Servlet implementation class Servlet1
 * 
 * 
 */

@WebServlet(name = "servletjoursferies", displayName = "Exercice joursferies", urlPatterns = "/jour-ferie", loadOnStartup = 1)

public class JoursFeriesservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public JoursFeriesservlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	@Inject
	private JoursFerieService jourferiesemaine;
	
	public void init() throws ServletException {
		super.init();
		System.out.println("bambi dead");
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			
			int jour = Integer.parseInt(request.getParameter("j"));
			System.out.println(jour);
			int mois = Integer.parseInt(request.getParameter("m"));
			System.out.println(mois);
			int annee = Integer.parseInt(request.getParameter("a"));
			System.out.println(annee);

			String resultat = jourferiesemaine.calculerjours(jour, mois, annee);

			
			
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>Résultat</title></head><body>");
			out.println(resultat);
			out.println("</body></html>");
		} catch (NumberFormatException e) {
			// Gestion de l'exception si les paramètres ne sont pas des entiers valides
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().println("Les paramètres doivent être des entiers valides.");
		} catch (Exception e) {
			// Gestion de toutes les autres exceptions
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			response.getWriter().println("Une erreur s'est produite : " + e.getMessage());
		}
	}

}
