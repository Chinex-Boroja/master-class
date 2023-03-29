package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

//        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        DoctorAnnotation staff = context.getBean(DoctorAnnotation .class);
        staff.assist();
//        Nurse nurse = context.getBean(Nurse.class);
//        Nurse nurse = (Nurse) context.getBean("nurse");
//        nurse.assist();
//        System.out.println(staff.getQualification());
    }
}
