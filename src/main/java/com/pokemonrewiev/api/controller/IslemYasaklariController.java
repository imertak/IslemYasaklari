package com.pokemonrewiev.api.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.pokemonrewiev.api.dto.IslemYasaklariDto;
import com.pokemonrewiev.api.entity.IslemYasaklari;
import com.pokemonrewiev.api.service.impl.IslemYasaklariServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequestMapping("/api")
public class IslemYasaklariController {

    IslemYasaklariServiceImpl islemYasaklariService;

    @Autowired
    public IslemYasaklariController(IslemYasaklariServiceImpl islemYasaklariService) {
        this.islemYasaklariService = islemYasaklariService;
    }

    @GetMapping()
    public String hello(){
        return "MKK İŞLEM YASAKLARI...";
    }


    //@FeignClient ile alır
    //IslemYasaklari'daki Json verileri gösterir
    @GetMapping("/tum-yasaklar")
    public ResponseEntity<List<IslemYasaklariDto>> getWebIslemYasaklari(){
        return new ResponseEntity<List<IslemYasaklariDto>>(islemYasaklariService.getWebIslemYasaklari(),HttpStatus.OK);
    }

    @GetMapping("/getStringByWeb")
    public ResponseEntity getByWeb() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://ws.spk.gov.tr/IdariYaptirimlar/api/IslemYasaklari"; // Harici sitenin API URL'si
        String jsonResponse = restTemplate.getForObject(url, String.class);
        return ResponseEntity.ok(jsonResponse);
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


    //DB'den alır
    @GetMapping("/get")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<List<IslemYasaklariDto>> getIslemYasaklariByRepository(
            @RequestParam (value = "pageNo",defaultValue = "1", required = false) int pageNo,
            @RequestParam (value = "pageSize", defaultValue = "1",required = false) int pageSize){
        try {
            System.out.println("Başarılı");
            return new ResponseEntity<>(islemYasaklariService.getIslemYasaklariByRepository(pageNo,pageSize),HttpStatus.ACCEPTED);
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

    @DeleteMapping("/delete/{id}")
    public String deleteIslemYasaklari(@RequestBody String onay, @PathVariable int id){
        //Postman'den "onay" text'i gelmeden silmez
        islemYasaklariService.deleteIslemYasaklari(onay, id);
        return "Delete Başarılı";
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<IslemYasaklariDto> detailIslemYasaklari(@PathVariable int id){
        return ResponseEntity.ok(islemYasaklariService.getDetail(id));
    }

    @PostMapping("/add")
    public ResponseEntity<IslemYasaklariDto> createDto(@RequestBody IslemYasaklariDto islemYasaklariDto){
        System.out.println("kayıt girişi");
        return new ResponseEntity<>(islemYasaklariService.createDto(islemYasaklariDto),HttpStatus.CREATED);
    }

}
