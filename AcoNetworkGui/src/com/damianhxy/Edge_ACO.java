package com.damianhxy;

import java.util.*;

/**
 * Created by damian on 16/5/16.
 */
class Edge_ACO extends Edge {

    Queue<Ant> ants;

    /**
     * Initializes an edge
     *
     * @param _source Startpoint
     * @param _destination Endpoint
     * @param _cost Time taken to traverse
     */
    Edge_ACO(int _source, int _destination, int _cost) {
        super(_source, _destination, _cost);
    }

    /**
     * Transmit an ant
     *
     * @param ant Ant
     * @param currentTime Timestamp
     */
    void addAnt(Ant ant, int currentTime) {
        ant.timestamp = currentTime + cost;
        ant.totalTime += cost;
        ants.add(ant);
    }
}