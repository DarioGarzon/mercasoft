package edu.uan.mercasoft.repository;

import edu.uan.mercasoft.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class JPAUserRepositoryImpl implements IUserRepository {
    public List<User> getUsersByUserName(String userName) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager em = emf.createEntityManager();
        TypedQuery<UserDTO> consultaAlumnos= em.createNamedQuery("User.findByUserName", UserDTO.class);
        consultaAlumnos.setParameter("userName", userName);
        List<User> lista= new ArrayList<User>();
        consultaAlumnos.getResultList().stream().forEach(x->lista.add(new User(x)));
        return lista;
    }

    public void saveUser(String hashedPass){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        RoleDTO admin=new RoleDTO();
        admin.setName("Administrador");
        List<PermissionDTO> grants=new ArrayList<>();
        //grants.add(new PermissionDTO("vender","permiso que le deja vender"));
        grants.add(new PermissionDTO("adicionar producto","permiso que le añadir un nuevo producto"));
        admin.setPermissionList(grants);
        UserDTO userToSave=new UserDTO("test1", hashedPass,admin);
        userToSave.setDocumentNumber("1031122298");
        userToSave.setRole(admin);
        userToSave.setName("Marco");
        userToSave.setLastName("Gonzalez");
        em.persist(userToSave);
        em.getTransaction().commit();
        em.close();
        //em.flush();
    }
}
