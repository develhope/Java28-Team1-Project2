package co.develhope.gameez_progetto.controller;

import co.develhope.gameez_progetto.entity.Prodotto;
import co.develhope.gameez_progetto.service.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/prodotto")
public class ProdottoController {
    @Autowired
    private ProdottoService prodottoService;

    @PostMapping("/create-prodotto")
    public ResponseEntity<Prodotto> createProdotto(@RequestBody Prodotto prodotto) {
        Prodotto prodotto1 = prodottoService.createProdotto(prodotto);
        return ResponseEntity.ok(prodotto1);
    }

    @GetMapping("/get-all-prodotti-attivi")
    public ResponseEntity<List<Prodotto>> getAllProdotti() {
        List<Prodotto> prodotti = prodottoService.getAllProdotti();
        return ResponseEntity.ok(prodotti);
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Optional<Prodotto>> cercaPerId(@PathVariable Long id){
        Optional<Prodotto> prodottoOptional = prodottoService.cercaPerId(id);
        if (prodottoOptional.isPresent()){
            return ResponseEntity.ok(prodottoOptional);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Prodotto> updateProdotto(@PathVariable Long id, @RequestBody Prodotto prodotto){
        Optional<Prodotto> updateProdotto = prodottoService.updateProdotto(id,prodotto);
        if(updateProdotto.isPresent()){
            return ResponseEntity.ok(updateProdotto.get());
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/delete-logical/{id}")
    public ResponseEntity<Prodotto> deleteLogicalProdotto(@PathVariable Long id) {
        Optional<Prodotto> deletedProdotto = prodottoService.deleteLogicalProdotto(id);
        if (deletedProdotto.isPresent()) {
            return ResponseEntity.ok(deletedProdotto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/activate/{id}")
    public ResponseEntity<Prodotto> activateStatusProdotto(@PathVariable Long id) {
        Optional<Prodotto> activatedProdotto = prodottoService.activateStatusProdotto(id);
        if (activatedProdotto.isPresent()) {
            return ResponseEntity.ok(activatedProdotto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }







}
