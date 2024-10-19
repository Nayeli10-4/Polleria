/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.integrador.Services;

import com.example.integrador.Entidades_Model.Clientes;
import com.example.integrador.Repositorio.ClientesDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioClientes {
    @Autowired
    private ClientesDAO clientesDAO;
    
     //Select
    public List<Clientes> getList() {
        return clientesDAO.findAll();
    }
    
    //INSERT Y UPDATE
    public Clientes save(Clientes clientes) {
        return clientesDAO.save(clientes);
    }
    
    //SELECT
    public Clientes get(Long id) {
        return clientesDAO.findById(id).orElse(null);
    }
    
    //DELETE
    public void delete(Long id) {
        clientesDAO.deleteById(id);
    }
    
}
