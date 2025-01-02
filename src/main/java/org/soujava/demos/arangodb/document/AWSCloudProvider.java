package org.soujava.demos.arangodb.document;

import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import net.datafaker.Faker;

@Entity
public class AWSCloudProvider extends CloudProvider {


    @Column
    private String appName;

    @Column
    private String accountId;



    public static AWSCloudProvider of(Faker faker) {
        var aws = faker.aws();


    }


}
