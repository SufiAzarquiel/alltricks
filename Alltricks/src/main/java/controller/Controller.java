package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connection.Conexion;
import daos.DAOBicis;
import daos.DAOMarcas;
import model.Bici;
import model.Marca;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String op = request.getParameter("op");
		ArrayList<Marca> marcas = null;
		ArrayList<Bici> bicis = null;

		// Singleton connection
		Connection con = (Connection) session.getAttribute("con");
		if (con == null) {
			try {
				con = Conexion.conecta();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			session.setAttribute("con", con);
		}

		switch (op) {
		case "inicio": {
			try {
				bicis = new DAOBicis().getBicis(con, 0, "");
				marcas = new DAOMarcas().getAllMarcas(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			session.setAttribute("bicis", bicis);
			session.setAttribute("marcas", marcas);
			request.getRequestDispatcher("page.jsp").forward(request, response);
			break;
		}
		case "vamarca": {
			int idmarca = Integer.parseInt(request.getParameter("idmarca"));
			try {
				bicis = new DAOBicis().getBicis(con, idmarca, "");
				marcas = new DAOMarcas().getAllMarcas(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			session.setAttribute("bicis", bicis);
			request.getRequestDispatcher("page.jsp").forward(request, response);
			break;
		}
		case "vaorden": {
			String orden = request.getParameter("orden");
			try {
				bicis = new DAOBicis().getBicis(con, 0, orden);
				marcas = new DAOMarcas().getAllMarcas(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			session.setAttribute("orden", orden);
			session.setAttribute("bicis", bicis);
			request.getRequestDispatcher("page.jsp").forward(request, response);
			break;
		}
		case "fav": {
			int id = Integer.parseInt(request.getParameter("idbici"));
			int fav = Integer.parseInt(request.getParameter("fav"));
			try {
				new DAOBicis().actualizaFav(id, fav, con);
				String orden = (String) session.getAttribute("orden");
				bicis = new DAOBicis().getBicis(con, 0, orden);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			session.setAttribute("bicis", bicis);
			request.getRequestDispatcher("page.jsp").forward(request, response);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + op);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
