
package com.clienteapi.crud.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.clienteapi.crud.model.Cliente;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long > {

}