package org.soujava.demos.arangodb.keyvalue;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import net.datafaker.Faker;
import org.eclipse.jnosql.mapping.keyvalue.KeyValueTemplate;

public class App {

    public static void main(String[] args) {
        Faker faker = new Faker();

        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            KeyValueTemplate template = container.select(KeyValueTemplate.class).get();
            Airport airport = template.put(Airport.of(faker));
            System.out.println(template.get(airport.getCode(), Airport.class));

        }
    }
}
