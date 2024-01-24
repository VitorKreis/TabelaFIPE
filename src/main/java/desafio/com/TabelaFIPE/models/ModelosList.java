package desafio.com.TabelaFIPE.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record ModelosList(
        List<Dados> modelos
) {
}
