package Database_connection;

import java.sql.Connection;
import java.sql.SQLException;

public interface DBService {
	public Connection getconnection() throws ClassNotFoundException, SQLException;

}