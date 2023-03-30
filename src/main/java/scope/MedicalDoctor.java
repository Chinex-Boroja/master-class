package scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(scopeName = "prototype")
@Component
public class MedicalDoctor implements Staff{
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
}
