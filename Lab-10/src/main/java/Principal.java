import java.util.*;
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


        ////////////////////////////////////////////////////////////////////////////////////
        //Deberás instanciar 15 objetos de tipo EstudianteTemporal y añadirlo en una lista.
        EstudianteTemporal e1 = new EstudianteTemporal("Robert Doe", 18, new Direccion("123 Main St", "Springfield", "Anytown", "AnyState"), List.of(new NumeroCelular(90000000), new NumeroCelular(92313223)));
        EstudianteTemporal e2 = new EstudianteTemporal("Alice Johnson", 20, new Direccion("456 Oak Ave", "Riverside", "Otherville", "SomeState"), List.of(new NumeroCelular(90000001), new NumeroCelular(92313224)));
        EstudianteTemporal e3 = new EstudianteTemporal("David Smith", 22, new Direccion("789 Elm St", "Pineville", "Newtown", "AnotherState"), List.of(new NumeroCelular(90000002), new NumeroCelular(92313225)));
        EstudianteTemporal e4 = new EstudianteTemporal("Ralph Brown", 24, new Direccion("101 Cedar St", "Lakeview", "Villageton", "SomeOtherState"), List.of(new NumeroCelular(90000003), new NumeroCelular(92313226)));
        EstudianteTemporal e5 = new EstudianteTemporal("Sophia Wilson", 26, new Direccion("321 Pine St", "Hillcrest", "Countryside", "RandomState"), List.of(new NumeroCelular(90000004), new NumeroCelular(92313227)));
        EstudianteTemporal e6 = new EstudianteTemporal("Daniel Taylor", 21, new Direccion("555 Maple Ave", "Brookside", "Suburbia", "TestState"), List.of(new NumeroCelular(90000005), new NumeroCelular(92313228)));
        EstudianteTemporal e7 = new EstudianteTemporal("Ron Martinez", 23, new Direccion("777 Birch St", "Hometown", "Cityville", "UnknownState"), List.of(new NumeroCelular(90000006), new NumeroCelular(92313229)));
        EstudianteTemporal e8 = new EstudianteTemporal("Ryan White", 19, new Direccion("888 Oak Ave", "Greenville", "Metroville", "MysteryState"), List.of(new NumeroCelular(90000007), new NumeroCelular(92313230)));
        EstudianteTemporal e9 = new EstudianteTemporal("Ava Garcia", 25, new Direccion("444 Pine St", "Orchardville", "Villageburg", "SecretState"), List.of(new NumeroCelular(90000008), new NumeroCelular(92313231)));
        EstudianteTemporal e10 = new EstudianteTemporal("Mia Rodriguez", 18, new Direccion("999 Elm St", "Seaside", "Harborville", "HiddenState"), List.of(new NumeroCelular(90000009), new NumeroCelular(92313232)));
        EstudianteTemporal e11 = new EstudianteTemporal("Noah Lopez", 20, new Direccion("666 Cedar St", "Mountainside", "Summit City", "ConfidentialState"), List.of(new NumeroCelular(90000010), new NumeroCelular(92313233)));
        EstudianteTemporal e12 = new EstudianteTemporal("Isabella Perez", 22, new Direccion("222 Birch St", "Parkside", "Fairytown", "SecureState"), List.of(new NumeroCelular(90000011), new NumeroCelular(92313234)));
        EstudianteTemporal e13 = new EstudianteTemporal("Ethan Nguyen", 24, new Direccion("777 Maple Ave", "Lakeside", "Rivertown", "ProtectedState"), List.of(new NumeroCelular(90000012), new NumeroCelular(92313235)));
        EstudianteTemporal e14 = new EstudianteTemporal("Charlotte Kim", 26, new Direccion("111 Oak Ave", "Bayview", "Hometown", "ClassifiedState"), List.of(new NumeroCelular(90000013), new NumeroCelular(92313236)));
        EstudianteTemporal e15 = new EstudianteTemporal("Richard Singh", 21, new Direccion("555 Elm St", "Sunset", "Coastville", "TopSecretState"), List.of(new NumeroCelular(90000014), new NumeroCelular(92313237)));

        List<EstudianteTemporal> estudiantes =
                Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15);

        List<EstudianteUniversitario> estudiantesUniversitarios = estudiantes.stream()
                .map(estudianteTemporal -> new EstudianteUniversitario(
                        estudianteTemporal.getNombre(),
                        "",
                        estudianteTemporal.getEdad(),
                        "",
                        estudianteTemporal.getDireccion(),
                        estudianteTemporal.getNumeroCelulares()
                ))
                .toList();

        // b. Convertir Lista<EstudianteUniversitario> a Lista<String> del nombre del estudiante
        List<String> nombresEstudiantes = estudiantesUniversitarios.stream()
                .map(EstudianteUniversitario::getNombre)
                .toList();

        // c. Convertir lista <EstudianteUniversitario> a String
        String listaEstudiantesString = estudiantesUniversitarios.toString();

        // d. Convertir la lista de nombres a mayúsculas
        List<String> nombresEnMayusculas = nombresEstudiantes.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        // e. Ordenar la lista de nombres
        nombresEnMayusculas.sort(String::compareTo);

        // f. Filtrar la lista de nombres que empiecen con la letra “R” y ordenarla
        nombresEnMayusculas.stream()
                .filter(nombre -> nombre.startsWith("R"))
                .sorted()
                .forEach(System.out::println);



    }
}
