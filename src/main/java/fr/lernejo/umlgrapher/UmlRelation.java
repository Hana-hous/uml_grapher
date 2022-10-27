package fr.lernejo.umlgrapher;

import java.util.Set;

public class UmlRelation {
    private final Set<UmlType> umlTree;

    public UmlRelation(Set<UmlType> theTree) {
        this.umlTree = theTree;
    }

    public Set<MermaidConnexion> theLink(Set<MermaidConnexion> connector){
        String link ="";
        for(UmlType i : umlTree){
            Class[] j = i.tClasse().getInterfaces();
            for(Class k : j){
                if(i.tClasse().getSuperclass()==null){
                    link = k.getSimpleName()+" <|-- " + i.tClasse().getSimpleName() + " : extends";
                }
                else{
                    link = k.getSimpleName()+" <|.. " + i.tClasse().getSimpleName() + " : implements";
                }
                link +="\n";
                connector.add(new MermaidConnexion(k,i.tClasse(),link));
            }
        }
        return connector;
    }

    public String allLinks(Set<MermaidConnexion> connector, Set<UmlType> types){
        String linksString="";
        connector = new UmlRelation(types).theLink(connector);
        for (MermaidConnexion i : connector) {
            linksString += i.getLink();
        }
        return linksString;
    }
}
