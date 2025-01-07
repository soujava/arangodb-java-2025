package org.soujava.demos.arangodb.graph;


import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import org.eclipse.jnosql.databases.tinkerpop.mapping.GraphTemplate;

import java.util.List;

import static org.apache.tinkerpop.gremlin.process.traversal.P.between;
import static org.apache.tinkerpop.gremlin.process.traversal.P.gte;
import static org.soujava.demos.arangodb.graph.Person.builder;

public final class App {


    private App() {
    }

    public static void main(String[] args) {

        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            GraphTemplate graph = container.select(GraphTemplate.class).get();

            Person banner = graph.insert(builder().withAge(30).withName("Banner")
                    .withOccupation("Developer").withSalary(3_000D).build());

            Person natalia = graph.insert(builder().withAge(32).withName("Natalia")
                    .withOccupation("Developer").withSalary(5_000D).build());

            Person rose = graph.insert(builder().withAge(40).withName("Rose")
                    .withOccupation("Design").withSalary(1_000D).build());

            Person tony = graph.insert(builder().withAge(22).withName("tony")
                    .withOccupation("Developer").withSalary(4_500D).build());


            graph.edge(tony, "knows", rose).add("feel", "love");
            graph.edge(tony, "knows", natalia);

            graph.edge(natalia, "knows", rose);
            graph.edge(banner, "knows", rose);

            List<Person> developers = graph.traversalVertex()
                    .has("salary", gte(3_000D))
                    .has("age", between(20, 25))
                    .has("occupation", "Developer")
                    .<Person>result().toList();

            List<Person> peopleWhoDeveloperKnows = graph.traversalVertex()
                    .has("salary", gte(3_000D))
                    .has("age", between(20, 25))
                    .has("occupation", "Developer")
                    .out("knows")
                    .<Person>result().toList();

            List<Person> both = graph.traversalVertex()
                    .has("salary", gte(3_000D))
                    .has("age", between(20, 25))
                    .has("occupation", "Developer")
                    .outE("knows")
                    .bothV()
                    .<Person>result()
                    .distinct()
                    .toList();

            List<Person> couple = graph.traversalVertex()
                    .has("salary", gte(3_000D))
                    .has("age", between(20, 25))
                    .has("occupation", "Developer")
                    .outE("knows")
                    .has("feel", "love")
                    .bothV()
                    .<Person>result()
                    .distinct()
                    .toList();

            System.out.println("Developers has salary greater than 3000 and age between 20 and 25: " + developers);
            System.out.println("Person who the Developers target know: " + peopleWhoDeveloperKnows);
            System.out.println("The person and the developers target: " + both);
            System.out.println("Developers to Valentine days: " + couple);

        }
    }

}