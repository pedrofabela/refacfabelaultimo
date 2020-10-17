package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import mappers.Mapper;

public interface DAOFactory {
	abstract void createStatement() throws Exception ;
	abstract Statement createStatement2(Connection conn) throws Exception ;
	public void closeAll(ResultSet rs, Statement st, Connection conn1) throws SQLException;
	abstract void closeConnection() throws SQLException;
	abstract void updateQuery(String sql) throws Exception;
	abstract Object queryForObject(final String sql, final Mapper m) throws Exception;
	abstract ResultSet queryResultSet(String sql)throws Exception;
	public boolean queryForExist(final String sql) throws Exception;

}
 