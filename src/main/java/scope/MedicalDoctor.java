package scope;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Scope(scopeName = "prototype")
@Component
public class MedicalDoctor implements Staff, BeanNameAware {
    private String qualification;

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void assist() {
        System.out.println("Doctors assisting");
    }
    @Override
    public String toString() {
        return "MedicalDoctor{" +
                "qualification='" + qualification + '\'' +
                '}';
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Set Bean name method is called");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Post Construct Method is called");
    }
}
