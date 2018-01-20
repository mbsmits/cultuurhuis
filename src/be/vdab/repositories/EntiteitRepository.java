package be.vdab.repositories;

import java.util.logging.Level;

import javax.sql.DataSource;

public abstract class EntiteitRepository {

	public static final String JNDI_NAME = "jdbc/cultuurhuis";
	protected static final String LOG_MESSAGE = "Probleem met database cultuurhuis";
	protected static final Level LOG_LEVEL = Level.SEVERE;

	protected DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
