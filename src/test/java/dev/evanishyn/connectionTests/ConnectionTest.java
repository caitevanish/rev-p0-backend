package dev.evanishyn.connectionTests;

import dev.evanishyn.utilities.ConnectionUtil;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class ConnectionTest {

    @Test   //Passed
    void connection_available(){
        Connection connection = ConnectionUtil.createConnection();
        System.out.println(connection);
    }
}
