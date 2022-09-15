package com.umg.edu.UMGFIFA2022B.controller;

import com.umg.edu.UMGFIFA2022B.entity.Liga;
import com.umg.edu.UMGFIFA2022B.service.LigaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ligaUser")
@CrossOrigin(origins = "*")
public class LigaController {

    @Autowired
    LigaService ligaService;

    @GetMapping("/ligas")
    public ResponseEntity<List<Liga>> list(){
        List<Liga> list = ligaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
}
