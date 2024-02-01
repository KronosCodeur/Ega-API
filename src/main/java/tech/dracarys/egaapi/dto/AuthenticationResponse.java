package tech.dracarys.egaapi.dto;

import lombok.*;
import tech.dracarys.egaapi.enums.Gender;

import java.time.LocalDate;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private Gender gender;
    private LocalDate birthday;
    private boolean active;
    String token;
}