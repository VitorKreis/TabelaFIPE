package desafio.com.TabelaFIPE.models;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Dados(
         @JsonAlias("nome") String nome,
         @JsonAlias("codigo") String codigo

) {
}
