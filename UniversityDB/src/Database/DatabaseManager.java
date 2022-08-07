/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import BeansClasses.DepartmentBean;
import BeansClasses.FacultyBean;
import BeansClasses.ProgramBean;
import com.healthmarketscience.jackcess.Cursor.Id;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author Umaid Mugheri
 */
public class DatabaseManager {
    
    
    public static Connection con = null;
    private static String name;
    private static String Id;
    private static String programname;
    
    static{
        try{
            init();
        }catch(Exception e){
        e.printStackTrace();
        }
    }

    private static void init() {
          try{
              Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");//Loading Driver
              String filename="D:\\Database\\UniversityDB.accdb";
              String path="jdbc:ucanaccess://";
              con= DriverManager.getConnection(path+filename);//Establishing Connection
              System.out.println("Connected Successfully");
 
          }catch(Exception e){
              System.out.println("Error in connection");
 
          }        
    }
//    public static void main(String[] args) {
//        init();
//    }
    
//Faculty methods
    
    //getFaculty
    public static Vector getFaculty() throws SQLException {
       
        String query="select * from faculty";
        
        Statement st=null;
        ResultSet rs=null;
        Vector v=new Vector();
         try{
             st=con.createStatement();
             rs=st.executeQuery(query);
        while(rs.next()){
            FacultyBean bean=new FacultyBean();
                bean.setId(rs.getInt("facId"));
                bean.setName(rs.getString("facName"));
                bean.setRemarks(rs.getString("remarks"));
                v.addElement(bean);
            
        }
        return v;
       }finally{
           if(rs!=null)rs.close();
           if(st!=null)st.close();
           
       }
        
        
    
    }
    
    //addFaculty
    public static int addFaculty(String name,String remarks) {
        String query="INSERT INTO faculty(facName,remarks) VALUES ('"+name+"','"+remarks+"')";
        int rows=0;
        Statement st=null;
        try{
                st=con.createStatement();
            rows = st.executeUpdate(query);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return rows;
    
    }

    //deleteFaculty
    public static int deleteFaculty(int id) {
        String query="delete * from faculty where facId="+id;
        int rows=0;
        Statement st=null;
        try{
                st=con.createStatement();
            rows = st.executeUpdate(query);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return rows;
    }

    //updateFaculty
    public static int updateFaculty(int id, String name, String remarks) {
        String query="UPDATE faculty SET facName = '"+name+"', remarks = '"+remarks+"'  WHERE facId="+id;
        int rows=0;
        Statement st=null;
        try{
                st=con.createStatement();
            rows = st.executeUpdate(query);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return rows;
     }
//end faculty methods
    
 //start department methods   
    
    //getDepartment
    public static Vector getDepartment(int facId) throws SQLException {

        String query="select * from department where facId="+facId;
        
        Statement st=null;
        ResultSet rs=null;
        Vector v=new Vector();
         try{
             st=con.createStatement();
             rs=st.executeQuery(query);
        while(rs.next()){
            DepartmentBean bean=new DepartmentBean();
               // bean.setFacId(rs.getInt("facId"));
                bean.setDepartmentId(rs.getInt("deptId"));
                bean.setDepartmentName(rs.getString("deptName"));
                bean.setRemarks(rs.getString("remarks"));
                v.addElement(bean);
            
        }
        return v;
       }finally{
           if(rs!=null)rs.close();
           if(st!=null)st.close();
           
       }
    
               
    
    }
     //addFaculty
    public static int addDepartment(int facId,String departmentname,String remarks) {
        String query="INSERT INTO department(facId,deptName,remarks) VALUES ("+facId+",'"+departmentname+"','"+remarks+"')" ;
        System.out.println(query);
        int rows=0;
        Statement st=null;
        try{
                st=con.createStatement();
            rows = st.executeUpdate(query);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return rows;
    
    }

    public static int deleteDepartment(int deptId) {
      String query="delete * from department where deptId="+deptId;
        int rows=0;
        Statement st=null;
        try{
                st=con.createStatement();
            rows = st.executeUpdate(query);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return rows;
    }

    public static int updateDepartment(int departmentId, String deptName, String remarks) {
       String query="UPDATE department SET deptName = '"+deptName+"', remarks = '"+remarks+"'  WHERE deptId="+departmentId;
        int rows=0;
        Statement st=null;
        try{
                st=con.createStatement();
            rows = st.executeUpdate(query);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return rows;
    }
//DEPARTMENT END Method//
  

    //Program Start menthod

    public static Vector getProgram(int departmentId) throws SQLException {
      
         String query="select * from programm where deptId="+departmentId;
        
        Statement st=null;
        ResultSet rs=null;
        Vector v=new Vector();
         try{
             st=con.createStatement();
             rs=st.executeQuery(query);
        while(rs.next()){
            ProgramBean bean=new ProgramBean();
               // bean.setFacId(rs.getInt("facId"));
                bean.setProgramId(rs.getInt("progId"));
                bean.setProgramName(rs.getString("ProgName"));
                bean.setRemarks(rs.getString("remarks"));
                bean.setDuration(rs.getInt("duarationInSem"));
                v.addElement(bean);
            
        }
        return v;
       }finally{
           if(rs!=null)rs.close();
           if(st!=null)st.close();
           
       }
    }

    public static int addProgram(int departmentId,String ProgName,int duarationInSem,String remarks)throws Exception{
       String query="INSERT INTO programm(deptId,ProgName,duarationInSem,remarks) VALUES ("+departmentId+",'"+ProgName+"',"+duarationInSem+",'"+remarks+"')" ;
        System.out.println(query);
        int rows=0;
        Statement st=null;
        try{
                st=con.createStatement();
            rows = st.executeUpdate(query);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return rows;
    
    }

    public static int deleteProgram(int progId) {
        String query="delete * from programm where progId="+progId;
        int rows=0;
        Statement st=null;
        try{
                st=con.createStatement();
            rows = st.executeUpdate(query);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return rows;
    }

    public static int updateProgram(int progId, String ProgName, int duarationInSem, String remarks) {
        
        String query="UPDATE programm SET ProgName = '"+ProgName+"',duarationInSem = "+duarationInSem+", remarks = '"+remarks+"'  WHERE progId="+progId;
        int rows=0;
        Statement st=null;
        try{
                st=con.createStatement();
            rows = st.executeUpdate(query);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return rows;
    }

  
}
