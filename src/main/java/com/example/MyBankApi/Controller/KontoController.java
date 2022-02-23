package com.example.MyBankApi.Controller;

import com.example.MyBankApi.Entity.Konto;
import com.example.MyBankApi.MyBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("bankApi/v1/konto")
public class KontoController {
    private final MyBankService myBankService;

    @Autowired
    public KontoController(MyBankService myBankService){
        this.myBankService = myBankService;
    }

    @GetMapping
    public Iterable<Konto> getAll(){
        return this.myBankService.getAllKontos();
    }

    @GetMapping("/{id}")
    public Optional<Konto> getKontoById(@PathVariable(name = "id") Long id){
        return this.myBankService.getKontoById(id);
    }

    @PutMapping("/update/{id}")
    public void updateKontoById(@RequestParam Long id,@RequestBody Konto konto){
        this.myBankService.updateKontoById(id,konto);
    }

    @PostMapping
    public void addNewKonto(@RequestBody Konto konto){
        this.myBankService.addNewKonto(konto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteKontoById(@PathVariable(name = "id") Long id){
        this.myBankService.deleteKontoById(id);
    }
}
