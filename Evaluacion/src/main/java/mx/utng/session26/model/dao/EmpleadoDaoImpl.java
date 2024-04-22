package mx.utng.session26.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.session26.model.entity.Empleado;



@Repository
public class EmpleadoDaoImpl implements IEmpleadoDao {
        @Autowired
    private EntityManager em;


    @SuppressWarnings("unchecked")
    @Override
    public List<Empleado> list() {
        return em.createQuery("from Empleado").getResultList();
    }

    @Override
    public void save(Empleado empleado) {
        System.out.println("Empleado id="+empleado.getId());
        if(empleado.getId() != null && empleado.getId() >0){
            //Actualizo estudiante
            em.merge(empleado);
        }else{
            //Creamos nuevo estudiante en la base
            em.persist(empleado);
        }
    }

    @Override
    public Empleado getById(Long id) {
        return em.find(Empleado.class, id);
    }

    @Override
    public void delete(Long id) {
        Empleado empleado = getById(id);
        em.remove(empleado);
    }

    
}
    

