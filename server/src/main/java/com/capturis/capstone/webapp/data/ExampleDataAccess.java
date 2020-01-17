package com.capturis.capstone.webapp.data;

import com.capturis.capstone.webapp.models.Example;
import com.capturis.capstone.webapp.sql.Connection;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExampleDataAccess extends Connection {


    public Example createExampleModel(Example example) throws SQLException, IOException, Exception {
        String sql = "INSERT INTO example (description) VALUES (?) RETURNING id";
        PreparedStatement ps = setupPreparedStatement(sql);
        ResultSet rs = null;

        int col = 0;

        try {
            ps.setString(++col, example.getDescription());

            rs = ps.executeQuery();
            rs.next();

            return mapExample(rs);

        } catch (Exception e) {
            if (e instanceof RuntimeException) {
                throw e;
            } else {
                throw new RuntimeException(e);
            }
        } finally {
            closeConnections(rs, ps);
        }
    }

    public Example getById(int id) throws SQLException, IOException, Exception {
        String sql = "SELECT * FROM example WHERE id = ?";
        PreparedStatement ps = setupPreparedStatement(sql);
        ResultSet rs = null;


        int col = 0;

        try {
            ps.setInt(++col, id);

            rs = ps.executeQuery();
            rs.next();

            return mapExample(rs);
        } catch (Exception e) {

            if (e instanceof RuntimeException) {
                throw e;
            } else {
                throw new RuntimeException(e);
            }
        } finally {
            closeConnections(rs, ps);
        }
    }

    public boolean updateExample(Example example)  throws SQLException, IOException, Exception {
        String sql = "UPDATE example SET description = ?";
        PreparedStatement ps = setupPreparedStatement(sql);
        int col = 0;

        try {
            ps.setString(++col, example.getDescription());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            if (e instanceof RuntimeException) {
                throw e;
            } else {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean deleteExample(int id) throws SQLException, IOException, Exception  {
        String sql = "DELETE FROM example WHERE id = ?";
        PreparedStatement ps = setupPreparedStatement(sql);
        int col = 0;

        try {
            ps.setInt(++col, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            if (e instanceof RuntimeException) {
                throw e;
            } else {
                throw new RuntimeException(e);
            }
        }
    }

    Example mapExample(ResultSet rs) throws SQLException {
        Example example = new Example();

        example.setId(rs.getInt("id"));
        example.setDescription(rs.getString("description"));

        return example;
    }
}
