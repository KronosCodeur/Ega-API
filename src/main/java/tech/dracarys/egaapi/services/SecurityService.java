package tech.dracarys.egaapi.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tech.dracarys.egaapi.dto.AuthenticationRequest;
import tech.dracarys.egaapi.dto.AuthenticationResponse;
import tech.dracarys.egaapi.dto.RegisterRequest;
import tech.dracarys.egaapi.dto.RegisterResponse;
import tech.dracarys.egaapi.entities.Client;
import tech.dracarys.egaapi.repositories.ClientRepository;
@Slf4j
@RequiredArgsConstructor
@Service
public class SecurityService {

    private final JwtService jwtService;
    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        UserDetails user = clientRepository.findClientByEmail(request.getEmail()).orElseThrow(() -> new EntityNotFoundException("aucun utilisateur n'est trouvé!"));
        String jwtToken = "";
        if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            jwtToken = jwtService.generateToken(user);
        }
        UserDetails user1 = clientRepository.findClientByEmail(request.getEmail()).orElseThrow(() -> new EntityNotFoundException("aucun utilisateur n'est trouvé!"));
        if (!StringUtils.hasLength(user1.getUsername())) {
            log.warn("l'email de ce utilisateur est null");
        }
        Client client = clientRepository.findClientByEmail(request.getEmail()).get();

        return AuthenticationResponse.builder()
                .token(jwtToken).
                id(client.getId()).
                gender(client.getGender()).
                fullName(client.getFullName()).
                active(client.isActive()).
                email(client.getEmail()).
                birthday(client.getBirthday()).
                phone(client.getPhone())
                .build();
    }

    public RegisterResponse register(RegisterRequest request) {
        var user = Client.builder()
                .fullName(request.getFullName())
                .birthday(request.getBirthday())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .phone(request.getPhone())
                .gender(request.getGender())
                .active(true)
                .build();
        clientRepository.save(user);
        return RegisterResponse.builder().message("Account successfully created !!!").build();
    }
}