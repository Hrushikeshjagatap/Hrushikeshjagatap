package Database_connectivity;
import java.sql.Connection;
import java.sql.SQLException;

public interface DBService {
	public Connection getconnection() throws ClassNotFoundException, SQLException;

}