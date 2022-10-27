package fr.lernejo.umlgrapher;

public class UmlGraph {

    private final Class<?>[] iClass;

    public UmlGraph(Class<?>... classe) {
        this.iClass = classe;
    }

    public String as (GraphType graphType){
        String chaine = "classDiagram\n";
        for (Class class_n : iClass) {
            switch (graphType) {
                case Mermaid:
                    chaine = chaine + "class " + class_n.getSimpleName();
                    if (class_n.isInterface()) {
                        chaine = chaine + " {\n" + "    <<interface>>\n" + "}\n";
                    }
                    break;
            }
        }
        return chaine;
    }

}
