package org.soujava.demos.arangodb.keyvalue;

import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

import java.util.Objects;

@Entity
public class Airport {

    @Id
    private String code;

    @Column
    private String name;


    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Airport airport = (Airport) o;
        return Objects.equals(code, airport.code);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(code);
    }

    @Override
    public String toString() {
        return "Airport{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
