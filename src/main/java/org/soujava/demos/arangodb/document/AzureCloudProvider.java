package org.soujava.demos.arangodb.document;

import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import net.datafaker.Faker;

import java.util.UUID;

@Entity
public class AzureCloudProvider extends CloudProvider {


    @Column
    private String accountId;



    public static AzureCloudProvider of(Faker faker) {
        var aws = faker.aws();
        var cloudProvider = new AzureCloudProvider();
        cloudProvider.region = aws.region();
        cloudProvider.region = aws.region();
        cloudProvider.id = UUID.randomUUID().toString();
        cloudProvider.accountId = aws.accountId();
        return cloudProvider;

    }


}
