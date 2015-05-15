package fi.zcode.neo4j;

import fi.zcode.neo4j.domain.Person;
import fi.zcode.neo4j.domain.PersonRepository;
import fi.zcode.neo4j.logger.Loggable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Neo4jTestApplication.class)
public class Neo4jTestApplicationTests {

    @Loggable
    private Logger log;

    @Inject
    PersonRepository personRepository;

    @Test
    @Transactional
    public void contextLoads() {
        log.info("contectLoads()...");

        Person hertta = Person.builder().name("Hertta").build();
        Person heikki = Person.builder().name("Heikki").build();

        Person emilia = Person.builder()
                .name("Emilia")
                .child(hertta)
                .child(heikki)
                .build();

        Person marko = Person.builder()
                .name("Marko")
                .child(hertta)
                .child(heikki)
                .spouse(emilia)
                .build();

        personRepository.save(marko);

        for (Person person : personRepository.findAll()) {
            log.info("P: {}", person);
        }

        for (Person person : personRepository.findByChildrenName("Hertta")) {
            log.info("Herttas parents: P: {}", person);
        }


        log.info("contectLoads()... done.");
    }

}
