package desafio.com.TabelaFIPE.service;

import java.util.List;

public interface IObterDados {
    <T> T IObterDados(String json, Class<T> classe);

    <T> List IObterLista(String json, Class<T> classe);
}
