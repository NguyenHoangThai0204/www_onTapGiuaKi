package vn.edu.iuh.fit.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "experience")
public class Experience {
    public Experience(long id, Candidate candidate, String companyName, String workDescription, LocalDate fromDate, LocalDate toDate, Roles roles) {
        this.id = id;
        this.candidate = candidate;
        this.companyName = companyName;
        this.workDescription = workDescription;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.roles = roles;
    }

    @Id
    @Column(name = "exp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "can_id")
    private Candidate candidate;
    @Column(name = "company", length = 120)
    private String companyName;

    public Experience() {
    }

    public Experience(Candidate candidate, String companyName, String workDescription, LocalDate fromDate, LocalDate toDate, Roles roles) {
        this.candidate = candidate;
        this.companyName = companyName;
        this.workDescription = workDescription;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", workDescription='" + workDescription + '\'' +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", roles=" + roles +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getWorkDescription() {
        return workDescription;
    }

    public void setWorkDescription(String workDescription) {
        this.workDescription = workDescription;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    @Column(name = "work_des", length = 400)
    private String workDescription;
    @Column(name = "from_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fromDate;
    @Column(name = "to_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate toDate;
    @Column(name = "role", length = 4)
    private Roles roles;

}
