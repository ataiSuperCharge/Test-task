package kg.gns.testtask.models.dto;

import lombok.Data;

@Data
public class FormDto {

    private Long id;
    private String login;
    private String password;
    private String email;
    private String name;


}
