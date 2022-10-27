package fr.lernejo.umlgrapher;

import java.util.ArrayList;
import java.util.List;

public class InternalGraphRepresentation {
    private final Class lClass;

    public InternalGraphRepresentation(Class eClass) {
        this.lClass = eClass;
    }

    public List<Class> recursiveLink(List<Class> recursiveList, Class... tableClasses){
        for(Class aClass : tableClasses){
            if(!recursiveList.contains(aClass)){
                recursiveList.add(aClass);
                recursiveList = recursiveLink(recursiveList, aClass.getInterfaces());
            }
        }
        return recursiveList;
    }

    public List<Class> whatIsYourRelate(){
        List<Class> list = new ArrayList<>();
        list = recursiveLink(list, this.lClass);
        return list;
    }
}
