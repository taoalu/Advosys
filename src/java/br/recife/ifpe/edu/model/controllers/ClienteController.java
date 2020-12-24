/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.recife.ifpe.edu.model.controllers;

import br.recife.ifpe.edu.model.classes.Cliente;
import br.recife.ifpe.edu.model.classes.Cliente;
import br.recife.ifpe.edu.model.dao.ManagerDao;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author taoal
 */
@ManagedBean
@SessionScoped
public class ClienteController {

    private Cliente mCliente;
    private Cliente objSelecionado;

    @PostConstruct
    public void init() {
        this.mCliente = new Cliente();
    }

    public String insert() {
        ManagerDao.getCurrentInstance().insert(mCliente);
        return "ListaCliente.xhtml";
    }

    public List<Cliente> readAll() {

        String query = "Select c from Cliente c";
        return ManagerDao.getCurrentInstance().read(query, Cliente.class);

    }

    public String update() {
        ManagerDao.getCurrentInstance().update(this.objSelecionado);
        return "ListaCliente.xhtml";
    }

    public String updateByCodigo() {

        objSelecionado = new Cliente(
                Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("advogadoSelecionadoCodigo")),
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("advogadoSelecionadoNome"),
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("advogadoSelecionadoCpf"),                
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("advogadoSelecionadoEndereco"),
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("advogadoSelecionadoTelefone"));

        return "EditaCliente.xhtml";
    }
    public String deleteByCodigo(int codigo) {

        ManagerDao.getCurrentInstance().deleteByCodigo(codigo,"cli");

        return "ListaCliente.xhtml";
    }

    public Cliente getCliente() {
        return mCliente;
    }

    public void setCliente(Cliente cliente) {
        this.mCliente = cliente;
    }

    public Cliente getObjSelecionado() {
        return objSelecionado;
    }

    public void setObjSelecionado(Cliente objSelecionado) {
        this.objSelecionado = objSelecionado;
    }

}
