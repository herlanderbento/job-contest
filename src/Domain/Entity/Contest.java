package Domain.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Contest{
    private UUID id;
    private String name;
    private String type;
    private int quantityVacancies;
    private List<Applicant> applicants;

    public Contest(String name, String type, int quantityVacancies) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.type = type;
        this.quantityVacancies = quantityVacancies;
        this.applicants = new ArrayList<>();
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

    public void deleteApplicants(int id) {
        applicants.removeIf(entity -> entity.getId() == id);
    }


}
