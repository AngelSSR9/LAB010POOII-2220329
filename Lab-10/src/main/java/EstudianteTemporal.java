import java.util.List;

public class EstudianteTemporal {
    private String nombre;
    private int edad;
    private Direccion direccion;
    private List<NumeroCelular> numeroCelulares;

    public EstudianteTemporal(String nombre, int edad, Direccion direccion, List<NumeroCelular> numeroCelulares) {
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
        this.numeroCelulares = numeroCelulares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
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
}
