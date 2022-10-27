package fr.lernejo.umlgrapher;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UmlGraph {
    private Class<?>[] aClass;
    private final Set<UmlType> types = new TreeSet<>(Comparator
        .<UmlType, String>comparing(t->t.name())
        .thenComparing(t->t.packageName()));

    private final Set<MermaidConnexion> connector = new TreeSet<>(Comparator
        .<MermaidConnexion, String>comparing(t->t.getChildClass())
        .thenComparing(t->t.getParentClass()));

    public UmlGraph(Class<?>... myclass){
        this.aClass = myclass;
    }

    public String as (GraphType graphType){
        List<Class> tabClass = null;
        for (Class nClass : aClass) {
            switch (graphType) {
                case Mermaid:
                    tabClass = new InternalGraphRepresentation(nClass).whatIsYourRelate();
                    for (Class i : tabClass) {
                        types.add(new UmlType(i));
                    }
                    break;
            }
        }
        return new MermaidFormatter(types).words() + new UmlRelation(types).allLinks(connector, types);
    }
}
