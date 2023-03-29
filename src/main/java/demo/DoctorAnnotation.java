package demo;

import org.springframework.stereotype.Component;

//@Component
public class DoctorAnnotation implements Staff {

    public void assist() {
        System.out.println("Doctor Annotation is assisting");
    }
}
