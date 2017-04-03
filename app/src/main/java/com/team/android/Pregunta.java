package com.team.android;

/**
 * Created by Administrator on 4/2/2017.
 */
public enum Pregunta {

    P_1("Usamos el crédito cuando tenemos la necesidad o la meta de adquirir un bien cuyo valor esta fuera de nuestras Posibilidades", true),
    P_2("Sólo podemos usar el crédito para comprar productos simples y cotidianos", false),
    P_3("Sólo podemos usar el crédito para comprar productos con precio elevado", false),
    P_4("En la sociedad actual prácticamente no hay consumo importante sin crédito", true),
    P_5("En la sociedad actual prácticamente no hay necesidad de utilizar el crédito", false),
    P_6("El crédito nunca se puede usar a nuestro favor", false),
    P_7("El crédito es un instrumento financiero", true),
    P_8("El crédito bien utilizado se puede usar a nuestro favor", true),
    P_9("El crédito es un instrumento estadístico", false),
    P_10("Usamos el crédito para comprar despensa", true),
    P_11("Usamos el crédito para comprar una casa", true),
    P_12("Usamos el crédito para comprar calzado", true);

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