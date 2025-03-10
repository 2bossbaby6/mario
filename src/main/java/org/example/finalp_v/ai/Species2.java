package org.example.finalp_v.ai;

import java.util.*;

public class Species2 {
    List<Genome2> members = new ArrayList<>();
    Genome2 representative;

    public void addMember(Genome2 g) {
        members.add(g);
    }

    public void clear() {
        members.clear();
    }
}
