package org.soujava.demos.arangodb.document;

import jakarta.nosql.Column;
import jakarta.nosql.DiscriminatorValue;
import jakarta.nosql.Entity;
import net.datafaker.Faker;

import java.util.UUID;

@Entity
@DiscriminatorValue("AZURE")
public class AzureCloudProvider extends CloudProvider {


    @Column
    private String tenantId;

// --Commented out by Inspection START (14/01/2025, 18:40):
//    public String getTenantId() {
//        return tenantId;
//    }
// --Commented out by Inspection STOP (14/01/2025, 18:40)

    @Override
    public String toString() {
        return "AzureCloudProvider{" +
                "tenantId='" + tenantId + '\'' +
                ", id='" + id + '\'' +
                ", region='" + region + '\'' +
                '}';
    }

    public static AzureCloudProvider of(Faker faker) {
        var azure = faker.azure();
        var cloudProvider = new AzureCloudProvider();
        cloudProvider.region = azure.region();
        cloudProvider.region = azure.region();
        cloudProvider.id = UUID.randomUUID().toString();
        cloudProvider.tenantId = azure.tenantId();
        return cloudProvider;
    }
}
