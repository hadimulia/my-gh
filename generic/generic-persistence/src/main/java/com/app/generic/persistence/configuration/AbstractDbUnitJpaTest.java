package com.app.generic.persistence.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Before;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;

public abstract class AbstractDbUnitJpaTest {

	protected abstract String getDataSet();

	@Autowired
	private DataSource dataSource;
		
	/**
	 * Will load test-dataset.xml before each test case
	 * @throws DatabaseUnitException 
	 * @throws HibernateException 
	 * @throws SQLException 
	 * @throws IOException 
	 */
	@Before
	public void initEntityManager() throws HibernateException, DatabaseUnitException, SQLException, IOException {		
        Connection con = DataSourceUtils.getConnection(dataSource);
        IDatabaseConnection dbUnitCon = new DatabaseConnection(con);
        FlatXmlDataSetBuilder flatXmlDataSetBuilder = new FlatXmlDataSetBuilder();
		flatXmlDataSetBuilder.setColumnSensing(true);
		InputStream dataSetStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(getDataSet());
		IDataSet dataset = flatXmlDataSetBuilder.build(dataSetStream);
		
        try {
            DatabaseOperation.REFRESH.execute(dbUnitCon, dataset);
        } finally {
            DataSourceUtils.releaseConnection(con, dataSource);
        }
	}
	
}
