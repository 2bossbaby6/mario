package org.example.finalp_v.ai;

class Connection {
    int fromNode, toNode;
    double weight;
    boolean enabled;
    int innovationNumber;

    public Connection(int from, int to, double weight, int innovation) {
        this.fromNode = from;
        this.toNode = to;
        this.weight = weight;
        this.innovationNumber = innovation;
        this.enabled = true;
    }
}

