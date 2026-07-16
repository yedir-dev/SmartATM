package com.smartatm.service;


import java.util.List;


import org.springframework.stereotype.Service;


import com.smartatm.entity.Client;
import com.smartatm.repository.ClientRepository;



@Service
public class ClientService {


    private final ClientRepository repository;



    public ClientService(
            ClientRepository repository
    ){

        this.repository = repository;

    }




    // GET tous les clients
    public List<Client> findAll(){


        return repository.findAll();

    }





    // GET client par ID
    public Client findById(Long id){


        return repository.findById(id)
                .orElse(null);

    }






    // POST création client
    public Client save(Client client){


        return repository.save(client);

    }







    // PUT modification client
    public Client update(
            Long id,
            Client newClient
    ){



        Client existing = repository.findById(id)
                .orElse(null);



        if(existing == null){

            return null;

        }



        existing.setNom(
                newClient.getNom()
        );


        existing.setPrenom(
                newClient.getPrenom()
        );


        existing.setTelephone(
                newClient.getTelephone()
        );



        return repository.save(existing);


    }








    // DELETE client
    public boolean delete(Long id){


        if(!repository.existsById(id)){

            return false;

        }


        repository.deleteById(id);


        return true;


    }



}