package com.example.poc.lowhighIntegratePlatform.service;

import com.example.poc.lowhighIntegratePlatform.infra.SocketClient;
import com.example.poc.lowhighIntegratePlatform.util.DateUtils;
import com.example.poc.lowhighIntegratePlatform.util.StringBuilderUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;

@Service
public class IntegrateService {


    public String i () throws IOException {
        SocketClient client = new SocketClient();
        client.start("xx.xx.com.br", 8001);
        final String aoiRequestBody = buildRequest();
        String response = client.send(aoiRequestBody);
        return response;
    }

    private String buildRequest() {
        StringBuilderUtil sb = new StringBuilderUtil();

        sb.add("CIN36 AOIS15", 56); //Sub Rotina + 44 espacos livres
        sb.add(1, 1); //Op��o de Processametno da SUB ROTINA
        sb.add(1, 1); //Tipo do Indicador
        sb.add("", 5); //Codigo Indicador
        sb.add(DateUtils.formatYMD(new Date(0)), 8); // Data Vigencia (AAAAMMDD)
        sb.add("", 15); //Percentual Evolucao Indice
        sb.add(0, 15);//Percentual Evolucao Indice
        sb.add(0, 15);//Percentual Evolucao Indice
        return sb.getString();
    }
}
