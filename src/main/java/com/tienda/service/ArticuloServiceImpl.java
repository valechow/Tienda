
package com.tienda.service;

import com.tienda.domain.Articulo;
import com.tienda.dao.ArticuloDao;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticuloServiceImpl implements ArticuloService{
    // se definen los 4 metodos de un CRUD 
    //Create Read, Update, Delete
    
    //Se utiliza una anotacion Autowired para que el objeto articuloDao
    //Si ya esta en memoria se usa ese... sino se crea (singleton)
    
    @Autowired
    private ArticuloDao articuloDao;
    
    // Retorna la lista de articulos
    @Override
    @Transactional(readOnly = true)
    public List<Articulo> getArticulos(boolean activos){
        var lista = (List<Articulo>)articuloDao.findAll();
        if (activos){ //solo los articulos activos 
            lista.removeIf(e -> !e.isActivo()); 
        }
        return lista;
    }
    // Dado un articulo.id se busca en la tabla y 
    //se retorna todo el objeto articulo
    @Override
    @Transactional(readOnly = true)
    public Articulo getArticulo(Articulo articulo){
        return articuloDao.findById(articulo.getIdArticulo()).orElse(null);
        
    }
    
    // Si el articulo.id tiene un valor se busca y se actualiza
    // Si el articulo.id NO tiene valor, se inserta el objeto en la tabla 
    
    
    @Override
    @Transactional
    public void save(Articulo articulo){
        articuloDao.save(articulo);
        
    }
    
    
    //Elimina el registro que tiene el id igual al articulo.id 
    @Override
    @Transactional
    public void delete(Articulo articulo){
        articuloDao.delete(articulo);
    }
}

