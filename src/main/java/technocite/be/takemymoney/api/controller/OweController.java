package technocite.be.takemymoney.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import technocite.be.takemymoney.api.dto.OweDto;
import technocite.be.takemymoney.model.OweMoney;
import technocite.be.takemymoney.repository.OweDao;
import technocite.be.takemymoney.service.OweService;

import java.util.List;

@RestController
@RequestMapping("/Dettes")
public class OweController {

    @Autowired
    private OweService oweService;

    @PostMapping

    public OweDto addDette(@RequestBody OweDto oweDto){
        return oweService.addDette(oweDto);
    }
    @DeleteMapping(value = "{id}")
    public ResponseEntity<OweDto> removeDette(@PathVariable String id ){
        if (oweService.removeDette(id)){
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<OweDto> findById(String id){
        OweDto oweDto = oweService.findById(id);

        if (oweDto != null){
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.noContent().build();
        }
    }
    @GetMapping(path = "/searchEmprunteur")
    public List<OweDto> searchByEmprunter(@RequestParam String emailEmprunteur){
       return oweService.searchByEmprunteur(emailEmprunteur);
    }

    @GetMapping(path = "/searchDonneur")
    public List<OweDto> searchByGiver(@RequestParam String emailDonneur){
        return oweService.searchByDonneur(emailDonneur);
    }
}
