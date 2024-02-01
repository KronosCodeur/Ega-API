package tech.dracarys.egaapi.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.dracarys.egaapi.dto.AuthenticationRequest;
import tech.dracarys.egaapi.dto.AuthenticationResponse;
import tech.dracarys.egaapi.dto.RegisterRequest;
import tech.dracarys.egaapi.dto.RegisterResponse;
import tech.dracarys.egaapi.services.SecurityService;

import static tech.dracarys.egaapi.Constant.Utils.APP_ROOT;


@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping(APP_ROOT + "auth")
public class SecurityController {
    private final SecurityService securityService;

    @PostMapping(value = "/login")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(securityService.authenticate(request));
    }

    @PostMapping(value = "/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(securityService.register(request));
    }

}