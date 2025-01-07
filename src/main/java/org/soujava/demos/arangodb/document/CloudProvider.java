package org.soujava.demos.arangodb.document;


import jakarta.nosql.*;

import java.util.Objects;

@Entity
@Inheritance
@DiscriminatorColumn("type")
public class CloudProvider {

    @Id
    protected String id;

    @Column
    protected String region;


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CloudProvider that = (CloudProvider) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
