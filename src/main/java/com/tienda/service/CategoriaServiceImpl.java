
package com.tienda.service;

import com.tienda.domain.Categoria;
import com.tienda.dao.CategoriaDao;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService{
    // se definen los 4 metodos de un CRUD 
    //Create Read, Update, Delete
    
    //Se utiliza una anotacion Autowired para que el objeto categoriaDao
    //Si ya esta en memoria se usa ese... sino se crea (singleton)
    
    @Autowired
    private CategoriaDao categoriaDao;
    
    // Retorna la lista de categorias
    @Override
    @Transactional(readOnly = true)
    public List<Categoria> getCategorias(boolean activos){
        var lista = (List<Categoria>)categoriaDao.findAll();
        if (activos){ //solo los categorias activos 
            lista.removeIf(e -> !e.isActivo()); 
        }
        return lista;
    }
    // Dado un categoria.id se busca en la tabla y 
    //se retorna todo el objeto categoria
    @Override
    @Transactional(readOnly = true)
    public Categoria getCategoria(Categoria categoria){
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
        
    }
    
    // Si el categoria.id tiene un valor se busca y se actualiza
    // Si el categoria.id NO tiene valor, se inserta el objeto en la tabla 
    
    
    @Override
    @Transactional
    public void save(Categoria categoria){
        categoriaDao.save(categoria);
        
    }
    
    
    //Elimina el registro que tiene el id igual al categoria.id 
    @Override
    @Transactional
    public void delete(Categoria categoria){
        categoriaDao.delete(categoria);
    }
}

