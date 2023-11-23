package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Bici;

public class DAOBicis {
	public ArrayList<Bici> getBicis(Connection con, int marca, int orden) throws SQLException {
		ResultSet rs;
		ArrayList<Bici> lista = new ArrayList<Bici>();

		Statement st;
		st = con.createStatement();
		String ordenSql = "SELECT * FROM bici";
		if (marca != 0) {
			ordenSql += " WHERE marca=" + marca;
		}
		if (orden != 0) {
			switch (orden) {
			case 1: { // Ascendiente
				ordenSql += " ORDER BY precio";
				break;
			}
			case 2: { // Descendiente
				ordenSql += " ORDER BY precio DESC";
				break;
			}
			case 3: { // Marca
				ordenSql += " ORDER BY marca";
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + orden);
			}
		}
		rs = st.executeQuery(ordenSql);

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
			lista.add(bici);

			lista.add(bici);
		}
		rs.close();
		st.close();

		return lista;
	}
}
