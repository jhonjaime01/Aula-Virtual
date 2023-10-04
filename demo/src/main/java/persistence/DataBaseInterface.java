package persistence;

import logic.Subject;

import java.util.List;

public interface DataBaseInterface<T> extends AutoCloseable{

    //METODOS PARA EL CRUD DE LAS ACTIVIDADES
    List<T> getActivities(); //LISTO
    T findActivity(String id); //LISTO
    int addActivities(T t); //LISTO
    void delete(String id); //LISTO

    String countActivities();
    void uptadte(T t);


    //METODOS PARA EL CRUD DE LAS MATERIAS
    List<Subject>getSubjects();
    Subject findSubject(String id);

    String findSubjectId(String name);
    int addSubjects(Subject s);

    void deleteSubject(String id);


}
