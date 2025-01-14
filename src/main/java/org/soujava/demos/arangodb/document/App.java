/*
 * Copyright (c) 2022 Contributors to the Eclipse Foundation
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Apache License v2.0 which accompanies this distribution.
 *  The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 *  and the Apache License v2.0 is available at http://www.opensource.org/licenses/apache2.0.php.
 *
 * You may elect to redistribute this code under either of these licenses.
 */

package org.soujava.demos.arangodb.document;


import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import net.datafaker.Faker;
import org.eclipse.jnosql.mapping.document.DocumentTemplate;

import java.util.List;
import java.util.logging.Logger;


public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        var faker = new Faker();
        LOGGER.info("Starting the application");
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            var template = container.select(DocumentTemplate.class).get();
            LOGGER.info("Creating 10 documents");
            for (int index = 0; index < 5; index++) {
                template.insert(List.of(AWSCloudProvider.of(faker), AzureCloudProvider.of(faker)));
            }
            template.select(CloudProvider.class).stream().forEach(System.out::println);
        }
    }

    private App() {
    }
}
