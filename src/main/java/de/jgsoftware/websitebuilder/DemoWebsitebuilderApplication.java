package de.jgsoftware.websitebuilder;

import org.h2.tools.Server;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class DemoWebsitebuilderApplication
{


    @Autowired
    private JdbcTemplate jtm;

    public DemoWebsitebuilderApplication()
    {
        startH2Server();
    }

    public static void main(String[] args)
    {

        SpringApplication.run(DemoWebsitebuilderApplication.class, args);
    }


    // start h2 database server
    private static void startH2Server()
    {
        try
        {
            Server h2Server = Server.createTcpServer().start();
            if (h2Server.isRunning(true))
            {
                System.out.print("H2 server was started and is running." + "\n");
            } else
            {
                h2Server = Server.createTcpServer().start();
                h2Server = Server.createWebServer().start();
                throw new RuntimeException("Could not start H2 server." + "\n");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to start H2 server: " + e + "\n");
        }

    }

    // second jdbc session to save fibu data  NOT OVER JDBC TEMPLATE
    @Bean
    @Primary
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource datasource()
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:tcp://localhost:9092/~/shopdb");
        dataSource.setUsername( "admin" );
        dataSource.setPassword( "jj78mvpr52k1" );
        return dataSource;
    }


    @Bean
    public JdbcTemplate jdbcTemplate() {

        jtm = new JdbcTemplate();
        jtm.setDataSource(datasource());

        return jtm;
    }
}
