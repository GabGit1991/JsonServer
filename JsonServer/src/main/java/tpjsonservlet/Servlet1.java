package tpjsonservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import Model.Client;
import ToJson.ClientToJson;
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

@WebServlet(name = "servletjson", displayName = "Exercice tojson", urlPatterns = "/ExoServJson", loadOnStartup = 1)

public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Servlet1() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		response.setContentType("text/html");
		response.setContentType("application/json");

		response.setBufferSize(8192);

		// instanciation du PojoDAO(ClientDAO) et de la fonction
		// ClientToJson qui transforme en json
		ClientDAO clientDAO = new ClientDAO();
		ClientToJson clienttojson = new ClientToJson();

		// Création des clients
		clientDAO.populate(10);

		// Récupérer l'identifiant depuis la requête (dans l'url)
		String idString = request.getParameter("id");
		if (idString == null) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing ID");
			return;
		}

		int id;
		try {
			id = Integer.parseInt(idString);
		} catch (NumberFormatException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid ID format");
			return;
		}
		id = Integer.parseInt(idString);

		if (clientDAO.getId(id) == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "ID not found");
			return;
		}
		// Vérifie si id existe dans la liste
//		if (clientDAO.getId(id) != null) {
//			response.sendError(HttpServletResponse.SC_NOT_FOUND, "ID not found");
//			return;
//		}

		String json = clienttojson.toJson(clientDAO.getId(id));

		System.out.println(json);

		try (PrintWriter out = response.getWriter()) {
			out.println("<html>" + "<head><title>Générée par une servlet</title></head>");
			out.println("<body  bgcolor=\"#ffffff\">" + "<h2>piou piou!!!</h2>" + "<p>" + json + "</p>");

			String username = request.getParameter("username");
			if (username != null && username.length() > 0) {
				out.println("Vous êtes : " + username);
			}
			out.println("</body></html>");
		}
	}

	@Override
	public String getServletInfo() {
		return "La première servlet .";

	}

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Init terminé");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
