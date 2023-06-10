package br.com.ifpe.oxefood.api.login;

import br.com.ifpe.oxefood.modelo.login.Login;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    
    private String email;

    private int senha;

    public Login build() {  

        return Login.builder()
                .email(email)
                .senha(senha)
                .build();
    }

}
