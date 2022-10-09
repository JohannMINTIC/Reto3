/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.Grupo10.Servicio;

import com.demo.Grupo10.Modelo.Category;
import com.demo.Grupo10.Repositorio.CategoryRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Eduwin Tibata
 */
@Service
public class CategoryServicio {
    @Autowired
    private CategoryRepositorio categoryRepositorio;
    
    public List<Category> getAll(){
        return categoryRepositorio.getAll();
    }
    
    public Optional<Category> getCategory(int id){
        return categoryRepositorio.getCategory(id);
    }
    
    public Category save(Category p){
        if(p.getId()==null){
            return categoryRepositorio.save(p);
        }else{
            Optional<Category> caux=categoryRepositorio.getCategory(p.getId());
            if(caux.isEmpty()){
                return categoryRepositorio.save(p);
            }else{
                return p;
            }
        }
    }
}
