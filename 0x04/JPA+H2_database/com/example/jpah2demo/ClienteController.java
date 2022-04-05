package com.example.jpah2demo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ClienteController {

  @Autowired
  private ClienteRepository clienteRepository;

  @PostMapping("/addClient")
  public ResponseEntity<Cliente> addClient(@RequestBody Cliente cliente) {
	  Cliente clienteAdd = clienteRepository.save(cliente);
	 return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
  }

  @GetMapping("/findAllClients")
  public ResponseEntity<List<Cliente>> findAllClients() {
	  List<Cliente> find = clienteRepository.findAll();
	return  ResponseEntity.ok(find);
    
  }

  @GetMapping("/findClientById/{id}")
  public ResponseEntity<Cliente> findClientById(@PathVariable("id") Long idClient) {
	  return clienteRepository.findById(idClient)
			  .map(t -> ResponseEntity.ok(t)).orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping("/removeClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCliente(@PathVariable("id") Long idClient){
	  clienteRepository.deleteById(idClient);
    }

  @PutMapping("/updateClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente){
	  clienteRepository.findById(id);
	  cliente.setId(id);
	  clienteRepository.save(cliente);
	  ResponseEntity.status(HttpStatus.OK).body(clienteRepository.save(cliente));
	  
    }
  
  
}