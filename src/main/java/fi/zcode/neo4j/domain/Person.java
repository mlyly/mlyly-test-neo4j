package fi.zcode.neo4j.domain;

import lombok.*;
import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import java.util.Set;

@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@NodeEntity
public class Person {

    @GraphId
    Long id;

    String name;

    @RelatedTo(type = "CHILD", direction = Direction.OUTGOING)
    @Fetch
    @Singular("child")
    Set<Person> children;

    @RelatedTo(type = "SPOUSE", direction = Direction.BOTH)
    @Fetch
    @Singular
    Set<Person> spouses;

    public String toString() {
        StringBuilder sb = new StringBuilder("Person: [name=");
        sb.append(name);
        sb.append(", chidren=[");
        if (children != null) {
            for (Person p : children) {
                sb.append(p.name);
                sb.append(", ");
            }
        }
        sb.append("]]");
        return sb.toString();
    }

}
