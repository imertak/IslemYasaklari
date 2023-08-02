package com.pokemonrewiev.api.controller;

import com.pokemonrewiev.api.dto.IslemYasaklariDto;
import com.pokemonrewiev.api.entity.IslemYasaklari;
import com.pokemonrewiev.api.service.IslemYasaklariService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class IslemYasaklariController {

    IslemYasaklariService islemYasaklariService;


    @Autowired
    public IslemYasaklariController(IslemYasaklariService islemYasaklariService) {
        this.islemYasaklariService = islemYasaklariService;
    }

    @GetMapping()
    public String hello(){
        return "MKK İŞLEM YASAKLARI...";
    }



    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<List<IslemYasaklari>> createİslemYasaklari(@RequestBody List<IslemYasaklari> yasaklar){
        try{
            return new ResponseEntity<>(islemYasaklariService.createIslemYasaklari(yasaklar), HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<List<IslemYasaklariDto>>getIslemYasaklari(){
        try {
            System.out.println("Başarılı");
            return new ResponseEntity<>(islemYasaklariService.getIslemYasaklari(),HttpStatus.ACCEPTED);
        }catch (Exception e){
            System.out.println("Hatalı");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @PutMapping("/unvan-update/{id}")
    public String updateIslemYasaklari(@RequestBody String unvan, @PathVariable int id){
        try {
            islemYasaklariService.updateIslemYasaklari(unvan,id);
            return "Update Başarılı";
        }catch (Exception e){
            return "Update Başarısız";
        }
    }

    @DeleteMapping("delete/{id}")
    public String deleteIslemYasaklari(@RequestBody String onay, @PathVariable int id){
        try {
            //Postman'den "onay" text'i gelmeden silmez
            islemYasaklariService.deleteIslemYasaklari(onay, id);
            return "Delete Başarılı";
        }catch (Exception e){
            return "Delete Başarısız";
        }
    }




}
