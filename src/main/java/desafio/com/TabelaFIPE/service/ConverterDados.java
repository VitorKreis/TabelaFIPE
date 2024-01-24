package desafio.com.TabelaFIPE.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.Collections;
import java.util.List;

public class ConverterDados implements IObterDados {

    private ObjectMapper mapper = new ObjectMapper();


    @Override
    public <T> T IObterDados(String json, Class<T> classe) {
        try{
            return mapper.readValue(json, classe);
        }catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> List IObterLista(String json, Class<T> classe) {
        CollectionType lista = mapper.getTypeFactory()
                .constructCollectionType(List.class, classe);

        try{
            return mapper.readValue(json, lista);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
