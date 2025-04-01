package ru.timofeev.project_developing.dao.impl;

import org.springframework.stereotype.Service;
import ru.timofeev.project_developing.dao.ITaskDao;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class PostgresTaskDao implements ITaskDao {

    private final DataSource dataSource;

    public PostgresTaskDao(DataSource hikariDataSource) {
        this.dataSource = hikariDataSource;
    }

    @Override
    public void increaseTaskPayload() {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("CALL increase_tasks_payload()");
        } catch (SQLException e) {
            throw new RuntimeException("Error increasing payload", e);
        }
    }
}
