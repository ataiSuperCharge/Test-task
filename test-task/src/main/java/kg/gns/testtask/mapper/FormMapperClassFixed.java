package kg.gns.testtask.mapper;

import kg.gns.testtask.models.Form;
import kg.gns.testtask.models.dto.FormDto;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class FormMapperClassFixed {

    public FormDto toFormDto(Form form){
        if ( form == null ) {
            return null;
        }
        FormDto formDto  = new FormDto();
        formDto.setEmail(form.getEmail());
        formDto.setPassword(form.getPassword());
        formDto.setId(form.getId());
        formDto.setLogin(form.getLogin());
        formDto.setName(form.getName());
        return formDto;
    }

    public Form toForm (FormDto formDto){
        if ( formDto == null ) {
            return null;
        }
        Form form = new Form();
        form.setEmail(formDto.getEmail());
        form.setPassword(formDto.getPassword());
        form.setId(formDto.getId());
        form.setLogin(formDto.getLogin());
        form.setName(formDto.getName());
        return form;
    }

}
