package org.soujava.demos.arangodb.keyvalue;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import net.datafaker.Faker;

public class App {

    public static void main(String[] args) {
        Faker faker = new Faker();

        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {

        }
    }
}
