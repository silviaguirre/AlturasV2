package alturas;

import java.io.IOException;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.util.*;

///Ejercicio alturasV2
/// @author Silvia Aguirre
/// @version 1.0

public class Mundo {
    private List<Pais> paises;


    public Mundo(){
     this.paises = new ArrayList<>();
    }
    public List<Pais> getPaises(){
        return paises;
    }

    ///Lee los paises del fichero que se pasa como argumento
    ///Los lee linea a linea, y despues llama al metodo lineaToPais para leer cada linea
    public void leePaises(String file) throws IOException {
        Path path = Path.of(file);
        try(Scanner sc = new Scanner(path)){
            while(sc.hasNext()){
                String linea = sc.nextLine();
                lineaToPais(linea);
            }
        }
    }

    private void lineaToPais(String linea){
        try(Scanner sc = new Scanner(linea)){
            sc.useDelimiter(",");
            sc.useLocale(Locale.US);  //separador decimal punto en vez de coma
            while (sc.hasNext()){
                String nombre = sc.next();
                String continente = sc.next();
                double altura = sc.nextDouble();
                Pais pais = new Pais(nombre,continente,altura);
                paises.add(pais);
            }
        }catch(InputMismatchException e){
            System.err.println("Error de formato en la línea: " + linea);
        }catch(NoSuchElementException e){
            System.err.println("Faltan datos en la línea "+ linea);
        }
    }

    ///Selecciona paises segun el criterio `sel`que se le pasa como parámetro
    public List<Pais> selecciona(Seleccion sel){
        List<Pais> seleccionados = new ArrayList<>();
        for(Pais pais:paises){
            if(sel.test(pais)){
                seleccionados.add(pais);
            }
        }
        return seleccionados;
    }

}

