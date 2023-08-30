package repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@Configuration
public class Connection_DB {

        @Bean
        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost/hotelstellar",
                    "postgres","lovapinto"
            );
        }
    }

