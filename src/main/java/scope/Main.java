package scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        MedicalDoctor doctor = context.getBean((MedicalDoctor.class));
        doctor.assist();
        doctor.setQualification("Mphil");
        System.out.println(doctor);

//        MedicalDoctor doctor1 = context.getBean(MedicalDoctor.class);
//        System.out.println(doctor1);

    }
}
