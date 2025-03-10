package org.example.finalp_v.ai;

class Mutation {
    public static void mutate(Genome2 genome) {
        if (Math.random() < 0.8) mutateWeights(genome);
        if (Math.random() < 0.1) addNode(genome);
        if (Math.random() < 0.1) addConnection(genome);
    }

    private static void mutateWeights(Genome2 genome) {
        for (Connection c : genome.connections) {
            if (Math.random() < 0.9) c.weight += Math.random() * 0.2 - 0.1;
            else c.weight = Math.random() * 2 - 1;
        }
    }

    private static void addNode(Genome2 genome) {
        if (genome.connections.isEmpty()) return;
        Connection c = genome.connections.get((int) (Math.random() * genome.connections.size()));
        c.enabled = false;
        int newId = genome.nodes.size();
        Neuron2 newNode = new Neuron2(newId, false, false);
        genome.nodes.add(newNode);
        genome.connections.add(new Connection(c.fromNode, newId, 1.0, c.innovationNumber + 1));
        genome.connections.add(new Connection(newId, c.toNode, c.weight, c.innovationNumber + 2));
    }

    private static void addConnection(Genome2 genome) {
        int a = (int) (Math.random() * genome.nodes.size());
        int b = (int) (Math.random() * genome.nodes.size());
        genome.connections.add(new Connection(a, b, Math.random() * 2 - 1, genome.connections.size() + 1));
    }
}
