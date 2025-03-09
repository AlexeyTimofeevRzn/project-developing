package ru.timofeev.project_developing.config;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Value("${datasource.url}")
    private String url;

    @Value("${datasource.user}")
    private String user;

    @Value("${datasource.password}")
    private String password;

    @Bean
    public DataSource postgresDataSource() {
        return DataSourceBuilder.create()
                .type(PGSimpleDataSource.class)
                .url(url)
                .username(user)
                .password(password)
                .build();
    }
}
