package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Root(name = "Informe")
public class Informe {
    @Element(name = "Resultado_simulacion")
    public String resultadoDeLaSimulacion;
    @Element(name = "Salas_superadas")
    public String salasSuperadas;
    @Element(name = "Salas_no_superadas")
    public String salasNoSuperadas;

    @Element(name = "Tiempo_inicial")
    public String tiempoInicial;
    @Element(name = "Tiempo_final")
    public String tiempoFinal;

    /** Esto sería lo necesario si el lombok
     *     public Informe(){}      // Añado este constructor vacio, para que funcione el simpleXML a importar, con lombok y @NoArgsConstructor se hace igual de bien
     *     public Informe(String resultadoDeLaSimulacion, String salasSuperadas, String salasNoSuperadas, String tiempoInicial, String tiempoFinal) {
     *         this.resultadoDeLaSimulacion = resultadoDeLaSimulacion;
     *         this.salasSuperadas = salasSuperadas;
     *         this.salasNoSuperadas = salasNoSuperadas;
     *         this.tiempoInicial = tiempoInicial;
     *         this.tiempoFinal = tiempoFinal;
     *     }
     *
     *     @Override
     *     public String toString() {
     *         return "Informe{" +
     *                 "resultadoDeLaSimulacion='" + resultadoDeLaSimulacion + '\'' +
     *                 ", salasSuperadas='" + salasSuperadas + '\'' +
     *                 ", salasNoSuperadas='" + salasNoSuperadas + '\'' +
     *                 ", tiempoInicial='" + tiempoInicial + '\'' +
     *                 ", tiempoFinal='" + tiempoFinal + '\'' +
     *                 '}';
     *     }
     */
}
