import alturas.*;
import java.io.IOException;
import java.util.*;

public class MainMundo{
    public static void main(String[] args) throws IOException {
        Mundo mundo = new Mundo();
        mundo.leePaises("data/alturas.txt");

        List<Pais> listaPaises = mundo.selecciona(new MayoresQue(1.00));

        //con lambdas
        Comparator<Pais> compAltura = (p1,p2) -> Double.compare(p1.getAltura(),p2.getAltura());

        Set<Pais> setAltura = new TreeSet<>(compAltura);
        setAltura.addAll(listaPaises); //ahora en setAltura ya estan todos ordenados

        System.out.println("Conjunto de listaPaises ordenados por altura de menor a mayor.");
        for(Pais pais:setAltura){
            System.out.println(pais);
        } //no me piden que lo printee
        //setAltura.size = 77 ---> hemos perdido 24 elementos xque 24 paises tienen la misma altura media
        // y los conjuntos no admiten duplicados (estamos comparando x altura!)


        System.out.println("\nConjunto de listaPaises ordenados alfabéticamente.");
        Comparator<Pais> compAlf = (p1,p2)-> p1.getNombre().compareTo(p2.getNombre());

        Set<Pais> setAlfabeto = new TreeSet<>(compAlf);
        setAlfabeto.addAll(listaPaises);

        for (Pais pais:setAlfabeto){
            System.out.println(pais);
        }

        System.out.println("\nConjunto de listaPaises ordenados por continente y a igualdad de continente, alfabéticamente.");
        Comparator<Pais> compCont = (p1,p2)-> p1.getContinente().compareTo(p2.getContinente());
        Comparator<Pais> compContAlf = compCont.thenComparing(compAlf);

        Set<Pais> setContinenteAlfabeto = new TreeSet<>(compContAlf);
        setContinenteAlfabeto.addAll(listaPaises);

        for (Pais pais:setContinenteAlfabeto){
            System.out.println(pais);
        }

        System.out.println("\nConjunto de listaPaises ordenados por continente y a igualdad de continente, alfabéticamente en orden inverso.");
        Comparator<Pais> compContAlfDESC = compCont.thenComparing(compAlf.reversed());

        Set<Pais> setContinenteAlfabetoDESC = new TreeSet<>(compContAlfDESC);
        setContinenteAlfabetoDESC.addAll(listaPaises);

        for (Pais pais:setContinenteAlfabetoDESC){
            System.out.println(pais);
        }

        System.out.println("\nConjunto de listaPaises ordenados por orden natural definido en Pais.");

        Set<Pais> setOrdNat = new TreeSet<>();
        setOrdNat.addAll(listaPaises);
        for(Pais pais:setOrdNat){
            System.out.println(pais);
        }

        System.out.println("\nConjunto de listaPaises ordenados por continente y en caso de igualdad, por el orden natural.");

        Comparator<Pais> compContNat = compCont.thenComparing(Comparator.naturalOrder());
        Set<Pais> setContNat = new TreeSet<>(compContNat);
        setContNat.addAll(listaPaises);
        for(Pais pais:setContNat){
            System.out.println(pais);
        }

    }
}
