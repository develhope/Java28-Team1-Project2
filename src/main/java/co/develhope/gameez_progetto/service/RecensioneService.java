package co.develhope.gameez_progetto.service;

import co.develhope.gameez_progetto.entity.Recensione;
import co.develhope.gameez_progetto.repository.RecensioneRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecensioneService {
    @Autowired
    private RecensioneRepository recensioneRepository;


    public Recensione creaRecensione(Recensione recensione){
        return recensioneRepository.save(recensione);
    }

    public List<Recensione> getAllRecensioni(){
        return recensioneRepository.findAllByStatusRecensioneTrue();
    }

    public Optional<Recensione> findById(Long id){
        Optional<Recensione> recensioneOptional = recensioneRepository.findById(id);
        if(recensioneOptional.isPresent()){
            return recensioneOptional;
        }else{
            return Optional.empty();
        }
    }

    public Optional<Recensione> updateRecensione(Long id, Recensione recensione){
        Optional<Recensione> optionalRecensione = recensioneRepository.findById(id);
        if(optionalRecensione.isPresent()){
            optionalRecensione.get().setCommento(recensione.getCommento());
            optionalRecensione.get().setData(recensione.getData());
            Recensione recensione1 = recensioneRepository.save(optionalRecensione.get());
            return Optional.of(recensione1);
        }else{
            return  Optional.empty();
        }
    }

    public Optional<Recensione> deleteLogicalRecensione(Long id){
        Optional<Recensione> recensioneOptional = recensioneRepository.findById(id);
        if (recensioneOptional.isPresent()){
            Recensione recensione = recensioneOptional.get();
            recensione.setStatusRecensione(false);
            recensioneRepository.save(recensione);
            return  Optional.of(recensione);
        }else{
            return Optional.empty();
        }
    }

    public Optional<Recensione> activeStatusRecensione(Long id){
        Optional<Recensione> recensioneOptional = recensioneRepository.findById(id);
        if (recensioneOptional.isPresent()){
            Recensione recensione = recensioneOptional.get();
            recensione.setStatusRecensione(true);
            recensioneRepository.save(recensione);
            return  Optional.of(recensione);
        }else{
            return Optional.empty();
        }
    }

}
