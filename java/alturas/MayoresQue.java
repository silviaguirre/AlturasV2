package alturas;
public class MayoresQue implements Seleccion{
    private double alturaMin;

    //constructor
    public MayoresQue(double alturaMin){
        this.alturaMin = alturaMin;
    }


    ///Devuelve true si la media de altura de `pais` es mayor a `alturaMin`.
    @Override
    public boolean test(Pais pais){
        return (pais.getAltura() >= alturaMin);
    }





}
