package org.SchoolApp.Web.Dtos.Mapper;

import javax.annotation.processing.Generated;
import org.SchoolApp.Datas.Entity.UserEntity;
import org.SchoolApp.Web.Dtos.Request.UserRequestDto;
import org.SchoolApp.Web.Dtos.Response.UserResponseDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-26T01:13:29+0000",
    comments = "version: 1.6.2, compiler: javac, environment: Java 23 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity toEntity(UserRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        return userEntity;
    }

    @Override
    public UserResponseDto toDto(UserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UserResponseDto userResponseDto = new UserResponseDto();

        return userResponseDto;
    }
}
