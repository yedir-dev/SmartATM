package com.smartatm.controller;


import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.smartatm.entity.Client;
import com.smartatm.service.ClientService;



@RestController
@RequestMapping("/api/clients")
public class ClientController {



    private final ClientService service;




    public ClientController(
            ClientService service
    ){

        this.service = service;

    }







    // =========================
    // GET tous les clients
    // =========================

    @GetMapping
    public List<Client> getClients(){


        return service.findAll();

    }







    // =========================
    // GET client par ID
    // =========================

    @GetMapping("/{id}")
    public ResponseEntity<Client> getById(
            @PathVariable Long id
    ){


        Client client = service.findById(id);



        if(client == null){

            return ResponseEntity.notFound().build();

        }



        return ResponseEntity.ok(client);


    }








    // =========================
    // POST créer client
    // =========================

    @PostMapping
    public Client createClient(
            @RequestBody Client client
    ){


        return service.save(client);


    }









    // =========================
    // PUT modifier client
    // =========================

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(
            @PathVariable Long id,
            @RequestBody Client client
    ){



        Client updated =
                service.update(id, client);



        if(updated == null){

            return ResponseEntity.notFound().build();

        }



        return ResponseEntity.ok(updated);


    }









    // =========================
    // DELETE supprimer client
    // =========================

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient(
            @PathVariable Long id
    ){



        boolean deleted =
                service.delete(id);



        if(!deleted){

            return ResponseEntity
                    .notFound()
                    .build();

        }



        return ResponseEntity.ok(
                "Client supprimé avec succès"
        );


    }





}