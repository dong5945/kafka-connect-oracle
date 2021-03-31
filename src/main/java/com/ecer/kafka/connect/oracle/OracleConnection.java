package com.ecer.kafka.connect.oracle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *  
 * @author Erdem Cer (erdemcer@gmail.com)
 */

public class OracleConnection{

    private static Logger log = LoggerFactory.getLogger(OracleSourceConnector.class);
    
    public Connection connect(OracleSourceConnectorConfig config) throws SQLException{
        String jdbcUrl = "jdbc:oracle:thin:@"+config.getDbHostName()+":"+config.getDbPort()+":"+config.getDbName();
//        log.info("jdbc url:{}",jdbcUrl);
        //jdbc:oracle:thin:@192.168.5.70:1521:pep
        return DriverManager.getConnection(
                jdbcUrl,
            config.getDbUser(),
            config.getDbUserPassword());
    }
}
