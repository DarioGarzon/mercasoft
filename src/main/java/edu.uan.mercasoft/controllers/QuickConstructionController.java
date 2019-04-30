package edu.uan.mercasoft.controllers;

import edu.uan.mercasoft.domain.*;
import edu.uan.mercasoft.repository.ICustomerRepository;
import edu.uan.mercasoft.repository.IUserRepository;
import edu.uan.mercasoft.repository.JPAImpl.JPAUserRepositoryImpl;
import edu.uan.mercasoft.useCases.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuickConstructionController {

    public void loadBasicUser(){
        IUserManagementInteractor manager= new UserManagementInteractorImpl();
        Permission addProduct=new Permission("adicionar producto","permiso que le añadir un nuevo producto");
        Permission sell=new Permission("vender","permiso que le deja vender");
        manager.savePermission(addProduct);
        manager.savePermission(sell);
        List<Permission> permissions=new ArrayList<>();
        permissions.add(addProduct);
        permissions.add(sell);
        Role admin= new Role("Administrador",permissions);
        manager.saveRole(admin);
        User adminUser= new User("Sys", "Admin","123456","admin1",
                "C46D76F62D2441BD0F314E016FF14BC37F204465D213391EF1F2D8A286A79061",admin);
        manager.saveUser(adminUser);
    }

    public void loadBasicProducts(){
        Product testMilk=new Product("01","Leche",1650,(short)19,
                new ProductType("Lacteos","Leche o sus derivados"),new Date(),"Caja",
                new Supplier("900","Lecheros de colombia","315"),1)  ;
        Product testGaseosa=new Product("02","Gaseosa",2500,(short)19,
                new ProductType("Gaseosas","Bebidas carbonatadas"),new Date(),"Litro",
                new Supplier("901","Postobon","315"),2)  ;
        loadBasicProduct(testMilk);
        loadBasicProduct(testGaseosa);
    }

    public void loadBasicProduct(Product productToLoad){
        IProductManagementInteractor manager= new ProductManagementInteractorImpl();
        manager.saveSupplier(productToLoad.getSupplier());
        manager.saveProductType(productToLoad.getProductType());
        manager.saveProduct(productToLoad);
    }

    public void loadBasicCustomers(){
        NaturalPerson persona= new NaturalPerson("marco", "gonzalez","122");
        RegularCustomer testClient= new RegularCustomer(new Date(),"31256",(short) 0,persona,"mi casa");
        loadBasicCustomer(testClient);
    }

    private void loadBasicCustomer(RegularCustomer customerToLoad){
        ILoyaltyInteractor manager= new LoyaltyInteractorImpl();
        manager.saveCustomer(customerToLoad);

    }
}
