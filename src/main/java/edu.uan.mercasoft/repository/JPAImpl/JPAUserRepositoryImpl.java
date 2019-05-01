package edu.uan.mercasoft.repository.JPAImpl;

import edu.uan.mercasoft.domain.NaturalPerson;
import edu.uan.mercasoft.domain.Permission;
import edu.uan.mercasoft.domain.Role;
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
        return foundUser.get(0).convertToUser();
    }

    @Override
    public void savePermission(Permission permissionToSave) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(new PermissionDTO(permissionToSave));
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void saveRole(Role roleToSave) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(new RoleDTO(roleToSave));
        em.getTransaction().commit();
        em.close();
    }


    public void saveUser(User userToSave){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        UserDTO userDTOToSave=new UserDTO(userToSave);
        em.merge(userDTOToSave);
        em.getTransaction().commit();
        em.close();
        //em.flush();
    }


}
