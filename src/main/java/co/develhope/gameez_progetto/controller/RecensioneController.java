package co.develhope.gameez_progetto.controller;

import co.develhope.gameez_progetto.entity.Recensione;
import co.develhope.gameez_progetto.service.RecensioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recensione")
public class RecensioneController {
    @Autowired
    private RecensioneService recensioneService;


    @PostMapping("/create-recensione")
    public ResponseEntity<Recensione> createRecensione(@RequestBody Recensione recensione) {
        Recensione recensione1 = recensioneService.creaRecensione(recensione);
        return ResponseEntity.ok(recensione1);
    }

    @GetMapping("/get-all-recensioni-attive")
    public ResponseEntity<List<Recensione>> getAllRecensioni() {
        List<Recensione> recensioneList = recensioneService.getAllRecensioni();
        return ResponseEntity.ok(recensioneList);
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Optional<Recensione>> findById(@PathVariable Long id) {
        Optional<Recensione> recensioneOptional = recensioneService.findById(id);
        if (recensioneOptional.isPresent()) {
            return ResponseEntity.ok(recensioneOptional);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Optional<Recensione>> updateRecensione(@PathVariable Long id, @RequestBody Recensione recensione) {
        Optional<Recensione> recensioneOptional = recensioneService.updateRecensione(id, recensione);
        if (recensioneOptional.isPresent()) {
            return ResponseEntity.ok(recensioneOptional);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/delete-logical/{id}")
    public ResponseEntity<Optional<Recensione>> deleteLogical(@PathVariable Long id){
        Optional<Recensione> recensioneOptional1 = recensioneService.deleteLogicalRecensione(id);
        if (recensioneOptional1.isPresent()){
            return ResponseEntity.ok(recensioneOptional1);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/active-status/{id}")
    public ResponseEntity<Optional<Recensione>> activeRecensione(@PathVariable Long id){
        Optional<Recensione> recensioneOptional = recensioneService.activeStatusRecensione(id);
        if (recensioneOptional.isPresent()){
            return ResponseEntity.ok(recensioneOptional);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
