package alturas;

public class EnContinente implements Seleccion{
    private String texto;

    public EnContinente(String texto){
        this.texto = texto;
    }

    ///Devulve true si el continente del `pais` contiene el texto en el nombre del continente
    @Override
    public boolean test(Pais pais){
        return (pais.getContinente().contains(texto));
    }
}

