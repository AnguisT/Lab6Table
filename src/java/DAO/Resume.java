package DAO;

import java.util.Date;

public class Resume {
    
    private Integer idResume;
    private String FirstName;
    private Integer Experiance;
    private Date DateCreate;

    public Integer getIdResume() {
        return idResume;
    }

    public void setIdResume(Integer idResume) {
        this.idResume = idResume;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public Integer getExperiance() {
        return Experiance;
    }

    public void setExperiance(Integer Experiance) {
        this.Experiance = Experiance;
    }

    public Date getDateCreate() {
        return DateCreate;
    }

    public void setDateCreate(Date DateCreate) {
        this.DateCreate = DateCreate;
    }
    
}
