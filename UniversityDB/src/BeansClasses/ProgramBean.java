/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeansClasses;

/**
 *
 * @author Umaid Mugheri
 */
public class ProgramBean {

    public int getFacId() {
        return facId;
    }

    public void setFacId(int facId) {
        this.facId = facId;
    }

    public int getProgramId() {
        return ProgramId;
    }

    public void setProgramId(int ProgramId) {
        this.ProgramId = ProgramId;
    }

    public String getProgramName() {
        return ProgramName;
    }

    public void setProgramName(String ProgramName) {
        this.ProgramName = ProgramName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getDuration() {
        return Duration;
    }

    public void setDuration(int Duration) {
        this.Duration = Duration;
    }

    private int facId;
    private int ProgramId;
    private String ProgramName;
    private String remarks;
     private int Duration;
   
    
    @Override
    public String toString() {
        return ProgramName;
    }
    
}
