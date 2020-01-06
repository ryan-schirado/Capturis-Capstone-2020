package src.main.java.com.capturis.capstone.webapp.sql;


import java.io.IOException;
import java.security.Permissions;
import java.sql.Array;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Connection {
    private static  final String DB_CONN = "jdbc:postgresql://shinji.cs.ndsu.nodak.edu/username_55555"; // database url
    private static  final String DB_USER = "tester"; // database username
    private static  final String DB_PW = "test1234"; // database password

    public Statement setupStatement() throws SQLException, IOException {
        java.sql.Connection connection = setUpCommonConnection();

        return connection.createStatement();
    }

    public PreparedStatement setupPreparedStatement(String sql) throws SQLException, IOException {
        java.sql.Connection connection = setUpCommonConnection();

        return connection.prepareStatement(sql);
    }

    public Array generateArray(List<Permissions> list) throws SQLException, IOException {
        java.sql.Connection connection = setUpCommonConnection();

        return connection.createArrayOf("varchar", list.toArray());
    }

    public void closeConnections(ResultSet rs, Statement ps) throws SQLException {
        java.sql.Connection conn = null;

        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            conn = ps.getConnection();
            ps.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    private java.sql.Connection setUpCommonConnection() throws SQLException, IOException {
        return DriverManager.getConnection(DB_CONN, DB_USER, DB_PW);
    }
}

