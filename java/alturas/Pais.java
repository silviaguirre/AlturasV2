package alturas;


import java.util.Objects;

public class Pais implements Comparable<Pais>{
    private String nombre;
    private String continente;
    private double altura;

    public Pais(String nombre, String continente, double altura){
        this.nombre = nombre;
        this.continente = continente;
        this.altura = altura;
    }

    public String getContinente() {
        return continente;
    }

    public double getAltura() {
        return altura;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return
                "[" + nombre + "," + continente  + "," + altura + ']';
    }

    ///Orden natural que ordena los países por altura y a igualdad de altura, los ordena alfabéticamente
    @Override
    public int compareTo(Pais p) {
        int resultado = Double.compare(this.altura,p.getAltura());
        if (resultado == 0)
            resultado = this.nombre.compareToIgnoreCase(p.getNombre());
        return resultado;
    }
}
