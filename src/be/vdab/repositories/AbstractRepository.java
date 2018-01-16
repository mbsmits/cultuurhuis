package be.vdab.repositories;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

abstract class AbstractRepository {
	
	public static final String JNDI_NAME = "jdbc/cultuurhuis";
	
	protected DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	protected void log(SQLException ex, Logger logger) {
		logger.log(Level.SEVERE, "Probleem met database cultuurhuis", ex);
	}
	
}
