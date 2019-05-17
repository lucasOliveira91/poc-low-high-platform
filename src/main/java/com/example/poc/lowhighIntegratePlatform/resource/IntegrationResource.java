package com.example.poc.lowhighIntegratePlatform.resource;

import com.example.poc.lowhighIntegratePlatform.service.IntegrateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/integrate")
public class IntegrationResource {

    @Autowired
    private IntegrateService integrateService;

    public ResponseEntity i () throws IOException {
        return ResponseEntity.ok(integrateService.i());
    }
}
