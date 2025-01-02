package org.soujava.demos.arangodb.document;

import jakarta.nosql.Column;
import jakarta.nosql.Entity;

@Entity
public class AWS extends CloudProvider {


    @Column
    private String appName;

    @Column
    private String accountId;



}
