import java.util.List;

public class EstudianteUniversitario {
    private String nombre;
    private String apellidos;
    private int edad;
    private String carrera;
    private Direccion direccion;
    private List<NumeroCelular> numeroCelulares;

    public EstudianteUniversitario(String nombre, String apellidos, int edad, String carrera, Direccion direccion, List<NumeroCelular> numeroCelulares) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.carrera = carrera;
        this.direccion = direccion;
        this.numeroCelulares = numeroCelulares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public List<NumeroCelular> getNumeroCelulares() {
        return numeroCelulares;
    }

    public void setNumeroCelulares(List<NumeroCelular> numeroCelulares) {
        this.numeroCelulares = numeroCelulares;
    }

    @Override
    public String toString() {
        return "EstudianteUniversitario{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                ", carrera='" + carrera + '\'' +
                ", direccion=" + direccion +
                ", numeroCelulares=" + numeroCelulares +
                '}'+"\n";
    }
}
