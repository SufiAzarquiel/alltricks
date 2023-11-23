package view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.Conexion;
import daos.DAOBicis;
import model.Bici;

public class View {
	public static void main(String[] args) {
		try {
			Connection con = Conexion.conecta();
			ArrayList<Bici> bicis = new DAOBicis().getBicis(con, 2, 1);
			for (Bici bici : bicis) {
				System.out.println(bici);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
