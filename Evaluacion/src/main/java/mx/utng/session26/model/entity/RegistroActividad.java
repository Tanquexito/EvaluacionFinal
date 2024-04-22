/**
 * 
 * @author Carlos Samael
 * 
 */
package mx.utng.session26.model.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import jakarta.validation.constraints.NotEmpty;
 
@Entity
public class RegistroActividad {
     @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date recordAt;

    @NotEmpty
    @Column 
    private String actividad;

    


   
    

   

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }



    public Date getRecordAt() {
        return recordAt;
    }









    public void setRecordAt(Date recordAt) {
        this.recordAt = recordAt;
    }









    public String getActividad() {
        return actividad;
    }









    public void setActividad(String actividad) {
        this.actividad = actividad;
    }









    @PreUpdate
    @PrePersist
    public void prePersist(){
        recordAt = new Date();
    }
}
