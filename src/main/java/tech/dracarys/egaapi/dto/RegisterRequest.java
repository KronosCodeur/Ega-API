package tech.dracarys.egaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.dracarys.egaapi.enums.Gender;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest {
    private String fullName;
    private String email;
    private String phone;
    private Gender gender;
    private LocalDate birthday;
    private String password;
    private boolean active;

}