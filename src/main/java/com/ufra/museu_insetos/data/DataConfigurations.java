package com.ufra.museu_insetos.data;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

public class DataConfigurations {

    @Configuration
    @Profile("dev")
    public class DataConfiguration {

        @Bean
        public DataSource dataSource(){
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

            dataSource.setUrl("jdbc:mysql://localhost:3306/museu_insetos");
            dataSource.setUsername("root");
            dataSource.setPassword("root");
            return dataSource;
        }
        @Bean
        public JpaVendorAdapter jpaVendorAdapter(){
            HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
            adapter.setDatabase(Database.MYSQL);
            adapter.setShowSql(true);
            adapter.setGenerateDdl(true);
            adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
            adapter.setPrepareConnection(true);
            return adapter;
        }
    }



}
