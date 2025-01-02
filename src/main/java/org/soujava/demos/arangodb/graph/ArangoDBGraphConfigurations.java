package org.soujava.demos.arangodb.graph;

import java.util.function.Supplier;

public enum ArangoDBGraphConfigurations implements Supplier<String> {

    /**
     * The edge collection. It uses as a prefix. E.g.:jnosql.arangodb.graph.edge.1=edge
     */
    EDGE("jnosql.arangodb.graph.edge"),
    /**
     * Edge collection, the source vertex collection and the target vertex collection split by pipe.
     * It hou,It uses as a prefix.
     * E.g.: jnosql.arangodb.graph.relationship.1=Person|knows|Person
     */
    EDGE_RELATIONSHIP("jnosql.arangodb.graph.relationship"),
    /**
     * The vertex collection. It uses as a prefix. E.g.: jnosql.arangodb.graph.vertex.1=vertex
     */
    VERTEX("jnosql.arangodb.graph.vertex"),
    /**
     * Name of the graph to use.
     */
    GRAPH("jnosql.arangodb.graph.graph"),
    /**
     * The database host.
     */
    HOST("jnosql.arangodb.graph.host"),
    /**
     * The user's credential.
     */
    USER("jnosql.arangodb.graph.user"),
    /**
     * The password's credential.
     */
    PASSWORD("jnosql.arangodb.graph.password");

    private final String value;

    ArangoDBGraphConfigurations(String value) {
        this.value = value;
    }

    @Override
    public String get() {
        return value;
    }
}
