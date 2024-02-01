package tech.dracarys.egaapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.dracarys.egaapi.entities.Client;
import tech.dracarys.egaapi.services.ClientService;

import static tech.dracarys.egaapi.Constant.Utils.APP_ROOT;


@RestController
@RequestMapping(APP_ROOT+"clients")
public class ClientController {

    @Autowired
    private ClientService clientService;
    @GetMapping("/getClientByEmail")
    public Client getClientByEmail(@RequestParam String email){
        return clientService.getClientByEmail(email);
    }
}
