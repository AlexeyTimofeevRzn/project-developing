package ru.timofeev.project_developing.dao.impl;

import org.springframework.stereotype.Service;
import ru.timofeev.project_developing.dao.IProjectDao;
import ru.timofeev.project_developing.model.Employee;
import ru.timofeev.project_developing.util.mapper.EmployeeMapper;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

@Service
public class PostgresProjectDao implements IProjectDao {

    private final DataSource dataSource;

    public PostgresProjectDao(DataSource hikariDataSource) {
        this.dataSource = hikariDataSource;
    }

    @Override
    public double calculateProjectPayload(String projectCode) {
        try (Connection conn = dataSource.getConnection()) {
            // Вызов функции
            try (CallableStatement stmt = conn.prepareCall("{? = call calculate_project_payload(?)}")) {
                // Регистрация выходного параметра
                stmt.registerOutParameter(1, Types.NUMERIC);

                // Установка входного параметра
                stmt.setString(2, projectCode);

                // Выполнение запроса
                stmt.execute();

                // Получение результата
                return stmt.getBigDecimal(1).doubleValue();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
