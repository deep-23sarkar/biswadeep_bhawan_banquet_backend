package com.biswadeep.banquetHall.config;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
@EnableMongoAuditing
public class MongoConfig {

    @Bean
    public MongoClient mongoClient() {
        String uri = System.getenv("MONGO_URL");
        if (uri == null || uri.isBlank()) {
            throw new IllegalStateException("MONGO_URL environment variable is not set");
        }
        return MongoClients.create(uri);
    }

    @Bean
    public MongoDatabaseFactory mongoDatabaseFactory(MongoClient mongoClient) {
        String uri = System.getenv("MONGO_URL");
        ConnectionString connectionString = new ConnectionString(uri);
        String database = connectionString.getDatabase();
        if (database == null || database.isBlank()) {
            throw new IllegalStateException("No database name found in MONGO_URL — add it to the URI path, e.g. .../dbname");
        }
        return new SimpleMongoClientDatabaseFactory(mongoClient, database);
    }
}