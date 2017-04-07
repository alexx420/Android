package com.team.android;

/**
 * Created by Administrator on 4/2/2017.
 */
public enum Pregunta {

    P_1("¿Un crédito es un instrumento financiero?", true),
    P_2("El crédito no cuesta", false),
    P_3("Sólo podemos usar el crédito para comprar una casa", false),
    P_4("Cada vez más personas se  benefician del uso del crédito para cubrir sus necesidades", true),
    P_5("Sólo podemos usar el crédito para comprar productos con precios elevados", false),
    P_6("¿Podemos usar un crédito para viajar?", true),
    P_7("El crédito nunca se puede usar a nuestro favor", false),
    P_8("Podemos usar el crédito para comprar la casa de nuestros sueños", true),
    P_9("El crédito bien utilizado se puede usar a nuestro favor", true),
    P_10("Podemos usar el crédito para comprar calzado", true),
    P_11("Podemos usar el crédito para comprar ropa", true),
    P_12("¿Cuándo pido un crédito lo más importante es que la tasa sea la más baja?", true),
    P_13("¿Cuándo pido un crédito no importa la tasa que me cobren?", false);

    private final String pregunta;
    private final boolean respuesta;

    Pregunta(String pregunta, boolean respuesta) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public boolean isRespuesta() {
        return respuesta;
    }


}