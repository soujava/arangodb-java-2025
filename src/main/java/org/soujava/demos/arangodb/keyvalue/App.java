package org.soujava.demos.arangodb.keyvalue;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import net.datafaker.Faker;
import net.datafaker.providers.entertainment.DragonBall;

public class App {

    public static void main(String[] args) {
        Faker faker = new Faker();
        faker.aviation()
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            Villain lock = new Villain();
            lock.setId("lock");
            lock.setName("Lock");

            VillainService service = container.select(VillainService.class).get();
            service.put(lock);
            System.out.println(service.get("lock"));

        }
    }
}
