package edu.uan.mercasoft.repository.JPAImpl;

import edu.uan.mercasoft.domain.NaturalPerson;
import edu.uan.mercasoft.domain.User;
import edu.uan.mercasoft.exceptions.NotFoundUser;
import edu.uan.mercasoft.repository.IUserRepository;
import edu.uan.mercasoft.repository.JPAImpl.NaturalPersonDTO;
import edu.uan.mercasoft.repository.JPAImpl.PermissionDTO;
import edu.uan.mercasoft.repository.JPAImpl.RoleDTO;
import edu.uan.mercasoft.repository.JPAImpl.UserDTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class JPAUserRepositoryImpl implements IUserRepository {
    public User getUserByUserName(String userName) throws NotFoundUser {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager em = emf.createEntityManager();
        TypedQuery<UserDTO> customQuery= em.createNamedQuery("UserDTO.findByUserName", UserDTO.class);
        customQuery.setParameter("userName", userName);
        List<UserDTO> foundUser=customQuery.getResultList();
        if(foundUser.size()<1){
            throw new NotFoundUser();
        }
        return foundUser.get(0).ConvertToUser();
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
