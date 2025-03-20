package uk.michaelelison.person.config;

import org.springframework.context.annotation.Configuration;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
//        org.modelmapper.config.Configuration configuration = modelMapper.getConfiguration();
//        configuration.setPropertyCondition(Conditions.isNotNull());
        return modelMapper;
    }
}

