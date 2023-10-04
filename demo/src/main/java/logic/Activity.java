package logic;

import java.util.Date;

/**
 * CLASE DE ACTIVIDADES, PARA SUS ATRIBUTOS, GETTERS, SETTERS Y EL MÉTODO TO STRING
 */
public class Activity {
    /**
     * Atributo para guardar el ID de la actividad
     */
    private String actId;
    /**
     * Atributo para guardar el TIPO de actividad
     */
    private String tipoAct;
    /**
     * Atributo para guardar el NOMBRRE de la actividad
     */
    private String nombreAct;
    /**
     * Atributo para guardar la DESCRIPCION de cada actividad
     */
    private String descripcionAct;
    /**
     * Atributo para guardar el PONDERADO de cada actividad
     */
    private String ponderadoAct;
    /**
     * Atributo para guardar la FECHA de cada actividad
     */
    private String fechaAct;
    /**
     * Atributo para guardar la CALIFICACION de cada actividad
     */
    private String calificacionAct;
    /**
     * Objeto de tipo MATERIA
     */
    private String idMateria;

    public Activity(String actId, String tipoAct, String nombreAct, String descripcionAct, String ponderadoAct, String fechaAct, String calificacionAct, String idMateria) {
        this.actId = actId;
        this.tipoAct = tipoAct;
        this.nombreAct = nombreAct;
        this.descripcionAct = descripcionAct;
        this.ponderadoAct = ponderadoAct;
        this.fechaAct = fechaAct;
        this.calificacionAct = calificacionAct;
        this.idMateria = idMateria;
    }

    /**
     * Metodo para tomar el valor del ID de la actividad
     * @return
     */
    public String getActId() {
        return actId;
    }

    /**
     * Metodo para asignar el valor del ID de la actividad
     * @param actId
     */
    public void setActId(String actId) {
        this.actId = actId;
    }

    public String getTipoAct() {
        return tipoAct;
    }

    public void setTipoAct(String tipoAct) {
        this.tipoAct = tipoAct;
    }

    public String getDescripcionAct() {
        return descripcionAct;
    }

    public void setDescripcionAct(String descripcionAct) {
        this.descripcionAct = descripcionAct;
    }

    public String getPonderadoAct() {
        return ponderadoAct;
    }

    public void setPonderadoAct(String ponderadoAct) {
        this.ponderadoAct = ponderadoAct;
    }

    public String getFechaAct() {
        return fechaAct;
    }

    public void setFechaAct(String fechaAct) {
        this.fechaAct = fechaAct;
    }

    public String getCalificacionAct() {
        return calificacionAct;
    }

    public void setCalificacionAct(String calificacionAct) {
        this.calificacionAct = calificacionAct;
    }

    public String getNombreAct() {
        return nombreAct;
    }

    public void setNombreAct(String nombreAct) {
        this.nombreAct = nombreAct;
    }

    public String getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(String idMateria) {
        this.idMateria = idMateria;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "actId='" + actId + '\'' +
                ", tipoAct='" + tipoAct + '\'' +
                ", nombreAct='" + nombreAct + '\'' +
                ", descripcionAct='" + descripcionAct + '\'' +
                ", ponderadoAct=" + ponderadoAct +
                ", fechaAct=" + fechaAct +
                ", calificacionAct=" + calificacionAct +
                ", idMateria='" + idMateria + '\'' +
                '}';
    }
}
