package martins.ton.springsecurity.dto;

public record RegisterRequestDTO(
        String name, String lastName, String password, String userPhone,
        String email, String userRg, String userCpf
) {
}
