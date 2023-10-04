package logic;

public class Average {
    private String materia_Nombre;
private String promedio;

    public Average(String materia_Nombre, String promedio) {
        this.materia_Nombre = materia_Nombre;
        this.promedio = promedio;
    }


    public String getMateria_Nombre() {
        return materia_Nombre;
    }

    public void setMateria_Nombre(String materia_Nombre) {
        this.materia_Nombre = materia_Nombre;
    }

    public String getPromedio() {
        return promedio;
    }

    public void setPromedio(String promedio) {
        this.promedio = promedio;
    }
}