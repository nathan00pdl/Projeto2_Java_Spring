package com.MyExample.Projeto2_Java_Spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MyExample.Projeto2_Java_Spring.entities.Category;

//Interface responsável por instanciar objetos do tipo 'repository'

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

	//OBS: O framework Spring já possui uma implementação padrão para essa interface.
}
