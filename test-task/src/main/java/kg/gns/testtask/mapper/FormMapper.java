package kg.gns.testtask.mapper;

import kg.gns.testtask.models.Form;
import kg.gns.testtask.models.dto.FormDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FormMapper {

    FormMapper INSTANCE = Mappers.getMapper(FormMapper.class);

    Form toForm(FormDto formDto);
    FormDto toFormDto(Form form);
}
