package scope;

import demo.DoctorAnnotation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "scope")
public class BeanConfig {

    @Bean
    public MedicalDoctor doctorAnnotation() {
        return new MedicalDoctor();
    }
}
