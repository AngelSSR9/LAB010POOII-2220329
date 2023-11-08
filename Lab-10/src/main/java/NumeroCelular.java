public class NumeroCelular {
    private int numero;

    public NumeroCelular(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "NumeroCelular{" +
                "numero=" + numero +
                '}';
    }
}
