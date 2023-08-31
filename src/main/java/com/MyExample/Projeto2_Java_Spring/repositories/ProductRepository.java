package com.MyExample.Projeto2_Java_Spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MyExample.Projeto2_Java_Spring.entities.Product;

//Interface responsável por instanciar objetos do tipo 'repository' (esses objetos terão funcionalidades direcionadas para os usuários 'User')

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	//OBS: O framework Spring já possui uma implementação padrão para essa interface.
}
