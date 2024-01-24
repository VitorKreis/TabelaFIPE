package desafio.com.TabelaFIPE.prinicipal;

import desafio.com.TabelaFIPE.models.Dados;
import desafio.com.TabelaFIPE.models.ModelosList;
import desafio.com.TabelaFIPE.models.Veiculo;
import desafio.com.TabelaFIPE.service.ConverterDados;
import desafio.com.TabelaFIPE.service.ObterDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    String url;
    Scanner sc = new Scanner(System.in);

    ObterDados obterDados = new ObterDados();
    ConverterDados convertedor = new ConverterDados();
    public void TabelaFIPE(){

        System.out.println("""
                           Escolha uma das opçoes que gostaria de pesquisar:
                           1-Carros
                           2-Motos
                           3-Caminhoes""");

        var veiculo = sc.nextLine();

        if(veiculo.contains("1") | veiculo.toLowerCase().contains("carros")){
            url =  "https://parallelum.com.br/fipe/api/v1/carros/marcas";
        } else if (veiculo.contains("2") | veiculo.toLowerCase().contains("motos")) {
            url =  "https://parallelum.com.br/fipe/api/v1/motos/marcas";
        }else {
            url =  "https://parallelum.com.br/fipe/api/v1/caminhoes/marcas";
        }


        var json = obterDados.ConsumirAPI(url);

        List<Dados> dadosMarca = convertedor.IObterLista(json, Dados.class);

       dadosMarca.forEach(System.out::println);

        System.out.println("Escolha o codigo de alguma marca:");
        var codigo = sc.nextInt();


        url = url + "/" + codigo + "/modelos";

         json = obterDados.ConsumirAPI(url);


        var dadosModelo = convertedor.IObterDados(json, ModelosList.class);

        dadosModelo.modelos()
                .forEach(System.out::println);

        System.out.println("Escolha o codigo de algum modelo:");
        var codigoMarca = sc.nextInt();

        url = url + "/" +  codigoMarca + "/anos";

        json = obterDados.ConsumirAPI(url);

        List<Dados> anos = convertedor.IObterLista(json, Dados.class);


        List<Veiculo> veiculos = new ArrayList();

        for (int i = 1; i < anos.size(); i++){
             url = url + "/" + anos.get(i).codigo();

             json = obterDados.ConsumirAPI(url);

             Veiculo dadosVeiculo = convertedor.IObterDados(json, Veiculo.class);

             veiculos.add(dadosVeiculo);

        }

        veiculos.forEach(System.out::println);

    }

}
