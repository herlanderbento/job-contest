package Domain.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Contest{
    private UUID id;
    private String name;
    private String type;
    private int quantityVacancies;
    private Exam exam;
    private List<Applicant> applicants;

    public Contest(UUID id, String name, String type, int quantityVacancies) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.quantityVacancies = quantityVacancies;
        this.applicants = new ArrayList<>();
        this.exam = null;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantityVacancies() {
        return quantityVacancies;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public void setQuantityVacancies(int quantityVacancies) {
        this.quantityVacancies = quantityVacancies;
    }

    public List<Applicant> getApplicants() {
        return applicants;
    }

    public void setApplicants(ArrayList<Applicant> applicants) {
        this.applicants = applicants;
    }


    public void createApplicants(Applicant applicant) {
        applicants.add(applicant);
    }

    public void deleteApplicants(String name) {
        applicants.removeIf(entity -> Objects.equals(entity.getName(), name));
    }

}
