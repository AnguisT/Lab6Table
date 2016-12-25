package Resume;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import DAO.ResumeImpl;
import DAO.Resume;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import javax.faces.bean.SessionScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@ManagedBean(name="dtResume")
@SessionScoped
public class ResumeBean {
    
    private List<Resume> resume = null;
    List<Resume> selectedResumes;
    private ResumeImpl ri;
    
    public ResumeBean() {
        
    } 

    @PostConstruct
    public void init() {
        try 
        {
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/lab6");
            Connection conn = ds.getConnection();
            ri = new ResumeImpl(conn);
            resume = ri.getAllResume();
        } 
        catch (NamingException | SQLException | IOException e)
        {}
    }
    
    public List<Resume> getResume() throws SQLException, IOException {
        return resume;
    }
    
    public List<Resume> getSelectedResume() {
        return selectedResumes;
    }
 
    public void setSelectedResume(List<Resume> selectedResumes) {
        this.selectedResumes = selectedResumes;
    }
    
    public void update(Resume resume) throws SQLException, IOException, ParseException
    {
        ri.updateResume(resume);
    }
}