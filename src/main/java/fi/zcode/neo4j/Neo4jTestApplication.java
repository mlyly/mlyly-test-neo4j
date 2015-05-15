package fi.zcode.neo4j;

import fi.zcode.neo4j.domain.Person;
import fi.zcode.neo4j.domain.PersonRepository;
import fi.zcode.neo4j.logger.Loggable;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Transaction;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.core.GraphDatabase;
import org.springframework.data.neo4j.rest.SpringRestGraphDatabase;

import javax.inject.Inject;

@SpringBootApplication
public class Neo4jTestApplication implements CommandLineRunner {

    @Loggable
    private static Logger log;

    @Inject
    PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(Neo4jTestApplication.class, args);
    }

    @Inject
    GraphDatabase graphDatabase;

    @Override
    public void run(String... strings) throws Exception {
        log.info("run()...");

/*
        Person greg = new Person("Greg");
        Person roy = new Person("Roy");
        Person craig = new Person("Craig");

        Transaction tx = graphDatabase.beginTx();
        try {
            personRepository.save(craig);
            tx.success();
        } catch (Exception ex) {
            tx.failure();
        } finally {
            tx.close();
        }
*/

        log.info("run()... done.");
    }

}
