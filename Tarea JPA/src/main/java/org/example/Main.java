package org.example;

import Entidades.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            // Persistir una nueva entidad Person
            entityManager.getTransaction().begin();

            Factura factura1 = Factura.builder().
                    numero(12).
                    fecha("10/08/2020").
                    build();

            Domicilio domicilio = Domicilio.builder().
                    nombreCalle("San Martin").
                    numero(1222).
                    build();

            Cliente cliente = Cliente.builder().
                    nombre("Pablo").
                    apellido("Muñoz").
                    dni(1524577).
                    build();

            Categoria perecederos = Categoria.builder().
                    denominacion("Perecederos").
                    build();

            Categoria lacteos = Categoria.builder().
                    denominacion("Lacteos").
                    build();

            Categoria limpieza = Categoria.builder().
                    denominacion("Limpieza").
                    build();

            Articulo articulo1 = Articulo.builder().
                    cantidad(200).
                    denominacion("Yogurt sabor frutilla").
                    precio(20).
                    build();

            Articulo articulo2 = Articulo.builder().
                    cantidad(300).
                    denominacion("Detergente Maggistral").
                    precio(80).
                    build();

            DetalleFactura det1 = DetalleFactura.builder().
                    cantidad(2).
                    subtotal(40).
                    build();

            DetalleFactura det2 = DetalleFactura.builder().
                    cantidad(1).
                    subtotal(80).
                    build();


            cliente.setDomicilio(domicilio);
            factura1.setCliente(cliente);
            articulo1.getCategorias().add(perecederos);
            articulo1.getCategorias().add(lacteos);

            articulo2.getCategorias().add(limpieza);

            det1.setArticulo(articulo1);

            factura1.getDetalles().add(det1);

            det2.setArticulo(articulo2);
            factura1.getDetalles().add(det2);

            factura1.setTotal(120);

            entityManager.persist(factura1);
            entityManager.flush();
            entityManager.getTransaction().commit();

        }catch (Exception e){

            entityManager.getTransaction().rollback();
            //System.out.println(e.getMessage());
            //System.out.println("No se pudo grabar la clase Persona");
            }

        // Cerrar el EntityManager y el EntityManagerFactory
        entityManager.close();
        entityManagerFactory.close();
    }
}
