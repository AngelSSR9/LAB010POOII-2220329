import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Principal {
    public static void main(String[] args) {
        List<EstudianteUniversitario> listaEstudiantes = new ArrayList<>();
        String banco = "123456789";

        for (int i = 1; i <= 15; i++) {
            // Crear objetos Direccion
            Direccion direccion = new Direccion("Zip" + i, "Calle" + i, "Distrito" + i, "Provincia" + i);

            // Generar una secuencia de números telefónicos aleatorios
            Stream<Integer> numerosTelefonicos = Stream.generate(() -> 900000000 + new Random().nextInt(100000000))
                    .filter(numero -> String.valueOf(numero).length() == 9)
                    .limit(new Random().nextInt(5) + 1);

            List<NumeroCelular> numerosList = new ArrayList<>();
            numerosTelefonicos.forEach(numero -> numerosList.add(new NumeroCelular(numero)));

            // Crear instancia de EstudianteUniversitario
            EstudianteUniversitario estudiante = new EstudianteUniversitario(
                    "Nombre" + i,
                    "Apellido" + i,
                    20 + i, // Edad de ejemplo
                    "Carrera" + i,
                    direccion,
                    numerosList
            );

            // Agregar el estudiante a la lista
            listaEstudiantes.add(estudiante);
        }


        //a. Dado un nombre, obtener el estudiante con nombre de coincidencia exacta.
        String nombreBuscar = "Nombre1";
        listaEstudiantes.stream()
                .filter(e -> e.getNombre().equals(nombreBuscar))
                .findFirst()
                .ifPresent(e -> System.out.println("Estudiante por nombre encontrado: " + e.getNombre() + " " + e.getApellidos()));


        //b. Dado una dirección, obtener el estudiante con dirección de coincidencia exacta.
        Direccion direccionBuscar = new Direccion("Zip1","Calle1","Distrito1","Provincia1");
        listaEstudiantes.stream()
                .filter(e -> e.getDireccion().equals(direccionBuscar))
                .findFirst().ifPresent(e -> System.out.println("Direccion encontrada en el alumno: " + e.getNombre()));

        //c. Dado un número celular, obtener todos los estudiantes con celulares de coincidencia exacta.
        int numeroBuscar1 = 999999999;
        listaEstudiantes.get(0).getNumeroCelulares().add(new NumeroCelular(999999999)); //forzar a que el estudiante 1 tenga el numero

        listaEstudiantes.stream().filter(estudiante ->
                        estudiante.getNumeroCelulares()
                                .stream().anyMatch(n -> n.getNumero() == numeroBuscar1))
                .forEach(e -> System.out.println("Numero de celular encontrado en el estudiante: " + e.getNombre()));

        //d. Dado dos números celulares, obtener todos los estudiantes que tengan el número de móvil XX-XXXXA y XX-XXXXB.
        int numeroBuscar2 = 999999998;
        //Forzar a que el estudiante con nombre "Nombre2" tenga ambos 2 numeros de coincidencia
        listaEstudiantes.get(1).getNumeroCelulares().add(new NumeroCelular(999999999));
        listaEstudiantes.get(1).getNumeroCelulares().add(new NumeroCelular(999999998));

        listaEstudiantes.stream()
                .filter(estudiante ->
                        estudiante.getNumeroCelulares().stream()
                                .filter(n -> n.getNumero() == numeroBuscar1 || n.getNumero() == numeroBuscar2)
                                .count() == 2) // Verificar si tiene exactamente dos números buscados
                .forEach(estudiante -> System.out.println("Numeros(1 y 2) encontrados en el alumno: " + estudiante.getNombre()));


    }
}
