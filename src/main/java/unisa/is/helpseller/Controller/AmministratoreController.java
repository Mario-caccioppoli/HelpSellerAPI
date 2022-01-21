package unisa.is.helpseller.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unisa.is.helpseller.Service.AmministratoreService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unisa.is.helpseller.Entity.Amministratore;
import unisa.is.helpseller.Model.AmministratoreModel;

@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:4200")
public class AmministratoreController {
	
	@Autowired
	private final AmministratoreService amministratoreService;

	@Autowired
	public AmministratoreController(AmministratoreService amministratoreService) {
		this.amministratoreService = amministratoreService;
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<AmministratoreModel>> findAll() {
		try
		{
			List<Amministratore> amministratori = amministratoreService.findAll();
			List<AmministratoreModel> amministratoriModel = new ArrayList<AmministratoreModel>();
				amministratoriModel = amministratori.stream().map(p -> {
					return new AmministratoreModel(p.getId(), p.getEmail(), p.getUsername(), p.getPassword());
				}).collect(Collectors.toList());
				return new ResponseEntity<>(amministratoriModel, HttpStatus.OK);
		}catch(Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/findId/{id}")
	public ResponseEntity<AmministratoreModel> findId(@PathVariable("id") int id) {
		try
		{
			Amministratore amministratore = amministratoreService.findId(id);
			AmministratoreModel amministratoreModel = new AmministratoreModel(amministratore.getId(), amministratore.getEmail(), amministratore.getUsername(), amministratore.getPassword());
			return new ResponseEntity<>(amministratoreModel, HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/update")
	public ResponseEntity<AmministratoreModel> update(@RequestBody AmministratoreModel amministratore) {
		try
		{
                        Amministratore a = new Amministratore(amministratore.getEmail(), amministratore.getUsername(), amministratore.getPassword());
			amministratoreService.udpate(a);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
