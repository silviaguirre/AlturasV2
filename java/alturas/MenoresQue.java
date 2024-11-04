package alturas;

public class MenoresQue implements Seleccion{
    private double alturaMax;

    public MenoresQue(double alturaMax){
        this.alturaMax = alturaMax;
    }

    ///Devulve true si la media de altura de `pais` es menor que `alturaMax`.
    @Override
    public boolean test(Pais pais){
        return (pais.getAltura() < alturaMax);
    }
}
