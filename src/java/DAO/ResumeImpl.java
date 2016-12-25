package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class ResumeImpl {
    
    ArrayList<Resume> resume;
    private static Connection con;
    private static PreparedStatement pstmt;
    private static ResultSet rs;
    
    public ResumeImpl(Connection con) {
        this.con = con;
    }
    
    public List<Resume> getAllResume() throws SQLException, IOException {
        resume = new ArrayList<>();
        String query = "select * from resume";
        pstmt = con.prepareStatement(query);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            Resume r = new Resume();
            r.setIdResume(rs.getInt(1));
            r.setFirstName(rs.getString(2));
            r.setExperiance(rs.getInt(3));
            r.setDateCreate(rs.getDate(4));
            resume.add(r);
        }
        rs.close();
        return resume;
    }
    
    public void updateResume(Resume resume) throws SQLException, IOException, ParseException {
        java.util.Date utilDate = resume.getDateCreate();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        pstmt = con.prepareStatement("UPDATE resume set FirstName = ?, Experiance = ?, DateCreate = ? WHERE idResume = ?;");
        pstmt.setString(1, resume.getFirstName());
        pstmt.setInt(2, resume.getExperiance());
        pstmt.setDate(3, sqlDate);
        pstmt.setInt(4, resume.getIdResume());
        pstmt.executeUpdate();
    }
}
