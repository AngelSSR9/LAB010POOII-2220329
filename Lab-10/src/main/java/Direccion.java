import java.util.Objects;

public class Direccion {
    private String zipCode;
    private String calle;
    private String distrito;
    private String provincia;

    public Direccion(String zipCode, String calle, String distrito, String provincia) {
        this.zipCode = zipCode;
        this.calle = calle;
        this.distrito = distrito;
        this.provincia = provincia;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direccion direccion = (Direccion) o;
        return Objects.equals(zipCode, direccion.zipCode) && Objects.equals(calle, direccion.calle) && Objects.equals(distrito, direccion.distrito) && Objects.equals(provincia, direccion.provincia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zipCode, calle, distrito, provincia);
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "zipCode='" + zipCode + '\'' +
                ", calle='" + calle + '\'' +
                ", distrito='" + distrito + '\'' +
                ", provincia='" + provincia + '\'' +
                '}';
    }
}
