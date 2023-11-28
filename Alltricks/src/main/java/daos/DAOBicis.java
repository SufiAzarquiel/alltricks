package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Bici;

public class DAOBicis {
	public ArrayList<Bici> getBicis(Connection con, int marca, String orden) throws SQLException {
		ResultSet rs;
		ArrayList<Bici> lista = new ArrayList<Bici>();

		Statement st;
		st = con.createStatement();
		String ordenSql = "SELECT * FROM bici";
		if (marca != 0) {
			ordenSql += " WHERE marca=" + marca;
		}
		if (orden != "") {
			ordenSql += " ORDER BY " + orden;
		}
		rs = st.executeQuery(ordenSql);
		System.out.println(ordenSql);

		while (rs.next()) {
			Bici bici = new Bici();
			bici.setId(rs.getInt("id"));
			bici.setFoto(rs.getString("foto"));
			bici.setMarca(rs.getInt("marca"));
			bici.setDescripcion(rs.getString("descripcion"));
			bici.setPrecio(rs.getFloat("precio"));
			bici.setFav(rs.getInt("fav"));

			Statement stMarca;
			stMarca = con.createStatement();
			String ordenSqlMarca = "SELECT nombre from marca where id=" + rs.getInt("marca");
			ResultSet rsMarca = stMarca.executeQuery(ordenSqlMarca);
			rsMarca.next();
			bici.setNombremarca(rsMarca.getString("nombre"));
			rsMarca.close();

			lista.add(bici);
		}
		rs.close();
		st.close();

		return lista;
	}

	public int actualizaFav(int idBici, int currentFav, Connection con) throws SQLException {
		int actualizados = -1;
		int fav = (currentFav == 0) ? 1 : 0;
		String ordenSQL = "UPDATE bici SET fav=? where id=?";
		PreparedStatement st = con.prepareStatement(ordenSQL);
		st.setInt(1, fav);
		st.setInt(2, idBici);
		actualizados = st.executeUpdate();
		st.close();

		return actualizados;
	}

}
