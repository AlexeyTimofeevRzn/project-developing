package ru.timofeev.project_developing.service.impl;

import org.springframework.stereotype.Service;
import ru.timofeev.project_developing.service.IConnectionInfoService;

import javax.sql.DataSource;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class DatasourceConnectionInfoService implements IConnectionInfoService {

    private final DataSource dataSource;

    public DatasourceConnectionInfoService(DataSource hikariDataSource) {
        this.dataSource = hikariDataSource;
    }


    @Override
    public Map<String, String> getConnectionInfo() {
        try (Connection connection = dataSource.getConnection()) {
            Map<String, String> properties = new LinkedHashMap<>();
            DatabaseMetaData metaData = connection.getMetaData();
            for (Method method : DatabaseMetaData.class.getDeclaredMethods()) {
                var methodName = method.getName();
                if (methodName.startsWith("get") && method.getParameters().length == 0 && method.getReturnType().equals(String.class)) {
                    properties.put(method.getName().substring(3), (String) method.invoke(metaData, null));
                }
            }
            return properties;
        } catch (Exception e) {
            return Collections.emptyMap();
        }
    }

}
