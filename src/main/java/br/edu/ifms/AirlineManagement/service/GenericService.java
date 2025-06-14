package br.edu.ifms.AirlineManagement.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class GenericService<T, ID> {
  protected abstract JpaRepository<T, ID>getRepository();

  public T create(T entity){
    return getRepository().save(entity);
  }

  public List<T> readAll(){
    return getRepository().findAll();
  }

  public T update(ID id, T entity){
    if(getRepository().existsById(id)){
      return getRepository().save(entity);
    }
    throw new RuntimeException("ID "+id+" não encontrado");
  }

  public void delete(ID id){
    if(getRepository().existsById(id)){
      getRepository().deleteById(id);
    }else{
      throw new RuntimeException("ID "+id+" não encontrado");
    }
  }
}
