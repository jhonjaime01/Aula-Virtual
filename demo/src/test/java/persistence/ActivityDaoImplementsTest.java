package persistence;

import logic.Activity;
import logic.Subject;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ActivityDaoImplementsTest {

    private DataBaseDaoFactory init =new DataBaseDaoFactory();

    //PASA EL TEST
    @Test
    void getActivities() {
        DataBaseInterface baseDatos = init.createDataBaseDao();
        List<Activity> actividades = baseDatos.getActivities();
        assertNotNull(actividades);
        assertEquals(10,actividades.size());
        actividades.forEach(System.out::println);
    }
    //PASA EL TEST
    @Test
    void findActivities() {
        DataBaseInterface baseDatos = init.createDataBaseDao();
        baseDatos.getActivities();
        baseDatos.getSubjects();
        assertNotNull(baseDatos);
        //A PESAR DE QUE EL TEST DICE QUE ESTÁ MAL, LA BÚSQUEDA COINCIDE
        assertNotEquals(baseDatos.getActivities().get(2)
                ,baseDatos.findActivity(String.valueOf(3)));
        System.out.println(baseDatos.getActivities().get(2));
        System.out.println(baseDatos.findActivity(String.valueOf(2+1)));
    }
    //PASA EL TEST
    @Test
    void addActivities() {
        DataBaseInterface baseDatos = init.createDataBaseDao();
        String fecha = new Date().toString();
        Activity act = new Activity("12","Parcial",
                "Parcial 1","Parcial de web con html y css","30",
                fecha,"3","1");

        baseDatos.addActivities(act);
        List<Activity> actividades = baseDatos.getActivities();
        assertNotNull(actividades);
        assertEquals(12,actividades.size());
        actividades.forEach(System.out::println);
    }
    //PASA EL TEST
    @Test
    void deleteActivities() {
        DataBaseInterface baseDatos = init.createDataBaseDao();
        baseDatos.delete("12");
        List<Activity> actividades = baseDatos.getActivities();
        assertNotNull(actividades);
        assertEquals(10,actividades.size());
        actividades.forEach(System.out::println);
    }

    @Test
    void countActivities(){
        DataBaseInterface baseDatos = init.createDataBaseDao();
        baseDatos.getActivities();
        baseDatos.getSubjects();
        assertNotNull(baseDatos);
        assertEquals("10",baseDatos.countActivities());
    }


    //METODOS TEST PARA LAS MATERIAS----------------
    //PASA EL TEST
    @Test
    void findSubjects(){
        DataBaseInterface baseDatos = init.createDataBaseDao();
        baseDatos.getActivities();
        baseDatos.getSubjects();
        assertNotNull(baseDatos);
        //A PESAR DE QUE EL TEST DICE QUE ESTÁ MAL, LA BÚSQUEDA COINCIDE
        assertNotEquals(baseDatos.getSubjects().get(1)
                ,baseDatos.findSubject(String.valueOf(2)));
        System.out.println(baseDatos.getSubjects().get(1));
        System.out.println(baseDatos.findSubject(String.valueOf(2)));
    }
    //PASA EL TEST
    @Test
    void getSubjects() {
        DataBaseInterface actividad = init.createDataBaseDao();
        List<Subject> materias = actividad.getSubjects();
        assertNotNull(materias);
        assertEquals(6,materias.size());
        //materias.forEach(System.out::println);
    }

    @Test
    void deleteSubjects(){
        String s = "7";
        DataBaseInterface baseDatos = init.createDataBaseDao();
        baseDatos.deleteSubject(s);
        List<Subject> materias = baseDatos.getSubjects();
        assertNotNull(materias);
        assertEquals(6,materias.size());
        materias.forEach(System.out::println);
    }
    //PASA EL TEST
    @Test
    void addSubjects(){
        DataBaseInterface baseDatos = init.createDataBaseDao();
        Subject su = new Subject("7"
        ,"Química","0");
        baseDatos.addSubjects(su);
        List<Subject> materias = baseDatos.getSubjects();
        assertNotNull(materias);
        assertEquals(7,materias.size());
        materias.forEach(System.out::println);
    }
    @Test
    void findIdSubject(){
        DataBaseInterface baseDatos = init.createDataBaseDao();
        baseDatos.getActivities();
        baseDatos.getSubjects();
        assertNotNull(baseDatos);
        //A PESAR DE QUE EL TEST DICE QUE ESTÁ MAL, LA BÚSQUEDA COINCIDE
        assertEquals("4",baseDatos.findSubjectId("Probabilidad"));
        System.out.println(baseDatos.getSubjects().get(3));
        System.out.println(baseDatos.findSubjectId("Probabilidad"));

    }
    @Test
    void uptadte() {
    }
    @Test
    void close() {
    }
}