package org.soujava.demos.arangodb.document;


import jakarta.nosql.*;

@Entity
@Inheritance
@DiscriminatorColumn("type")
public class CloudProvider {

    @Id
    protected String id;

    @Column
    protected String region;


}
