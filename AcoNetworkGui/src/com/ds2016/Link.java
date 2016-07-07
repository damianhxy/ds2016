package com.ds2016;

import com.sun.corba.se.impl.orbutil.concurrent.Mutex;

import static com.ds2016.Main.*;
import static com.ds2016.NewGui.sGraphAlgo;

/**
 * Created by zwliew on 4/7/16.
 * <p>
 * Common methods which act on both the graph and the GUI
 */
class Link {

    static void tick() {
        sAlgo.tick();
        sGraphAlgo.compute();
    }

    static void addNode(int speed) {
        Mutex mutex = new Mutex();
        try {
            mutex.acquire();
            try {
                sGui.addNode(speed);
                sAlgo.addNode(speed);
            } finally {
                mutex.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void toggleNode(int ID) {
        Mutex mutex = new Mutex();
        try {
            mutex.acquire();
            try {
                sGui.toggleNode(ID);
                sAlgo.toggleNode(ID);
            } finally {
                mutex.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void addEdge(int node1, int node2, int cost) {
        Mutex mutex = new Mutex();
        try {
            mutex.acquire();
            try {
                sGui.addEdge(node1, node2, cost);
                sAlgo.addEdge(node1, node2, cost);
            } finally {
                mutex.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void toggleEdge(int ID) {
        Mutex mutex = new Mutex();
        try {
            mutex.acquire();
            try {
                sGui.toggleEdge(ID);
                sAlgo.toggleEdge(ID);
            } finally {
                mutex.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void start() {
        sGui.startThread();
        Main.startThread();
    }

    static void stop() {
        sGui.stopThread();
        Main.stopThread();
    }

    static void update() {
        sGui.update();
        Main.initAlgo();
        sAlgo.build(sGui.mNodeList, sGui.mEdgeList, sParams.getSource(), sParams.getDestination());

    }

    /**
     * OSPF chokes; others ok
     */
    static void buildDemoGraph1() {
        addNode(8); // Node 0
        addNode(4); // Node 1
        addNode(8); // Node 2
        addNode(4); // Node 3

        addEdge(0, 1, 4);
        addEdge(1, 2, 4);
        addEdge(0, 3, 4);
        addEdge(3, 2, 4);
    }

    /**
     * AntNet not ok; others ok
     */
    static void buildDemoGraph2() {
        addNode(8); // Node 0
        addNode(8); // Node 1
        addNode(8); // Node 2
        addNode(8); // Node 3

        addEdge(0, 1, 4);
        addEdge(1, 2, 4);
        addEdge(0, 3, 4);
        addEdge(3, 2, 4);
    }
}
