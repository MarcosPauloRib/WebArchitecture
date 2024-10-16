package org.example.service;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;


public class Service {
    public String preverTempo(){
        String dadosMeteorologicos = "";
        String apiUrl = "http://apiadvisor.climatempo.com.br/api/v1/weather/locale/6879/current?token=10c8ab12c27158bccb114c430fc26a5f";
        //String apiUrl = "http://apiadvisor.climatempo.com.br/api-manager/user-token/:10c8ab12c27158bccb114c430fc26a5f/locales";
        //String apiUrl = "http://apiadvisor.climatempo.com.br/api/v1/anl/synoptic/locale/BR?token=10c8ab12c27158bccb114c430fc26a5f";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);

        if(responseEntity.getStatusCode().is2xxSuccessful()){
            dadosMeteorologicos = responseEntity.getBody();
        }else{
            dadosMeteorologicos = "Falha ao obter dados meteorológicos. Código de status: " + responseEntity.getStatusCode();
        }
        return dadosMeteorologicos;
    }
}
