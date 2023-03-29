package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        Doctor staff = context.getBean(Doctor.class);
//        Nurse nurse = context.getBean(Nurse.class);
        Nurse nurse = (Nurse) context.getBean("nurse");
        staff.assist();
//        nurse.assist();
        System.out.println(staff.getQualification());
    }
}
