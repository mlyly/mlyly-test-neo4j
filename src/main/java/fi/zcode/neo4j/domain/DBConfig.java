package fi.zcode.neo4j.domain;

import fi.zcode.neo4j.logger.Loggable;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;

@Configuration
@EnableNeo4jRepositories("fi.zcode.neo4j.domain")
public class DBConfig extends Neo4jConfiguration {

    public DBConfig() {
        setBasePackage("fi.zcode.neo4j.domain");
    }

    @Bean
    public GraphDatabaseService graphDatabaseService() {
        return new GraphDatabaseFactory().newEmbeddedDatabase("mlyly-neo4j-test.db");
    }
}
