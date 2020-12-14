/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.recife.ifpe.edu.model.controllers;

import br.recife.ifpe.edu.model.classes.Advogado;
import br.recife.ifpe.edu.model.dao.ManagerDao;
import java.io.Console;
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
public class AdvogadoController {

    private Advogado advogado;
    private Advogado objSelecionado;

    @PostConstruct
    public void init() {
        this.advogado = new Advogado();
    }

    public String insert() {
        ManagerDao.getCurrentInstance().insert(this.advogado);
        return "ListaAdvogado.xhtml";
    }

    public List<Advogado> readAll() {

        String query = "Select a from Advogado a";
        return ManagerDao.getCurrentInstance().read(query, Advogado.class);

    }   

    public String update() {
        ManagerDao.getCurrentInstance().update(this.objSelecionado);
        return "ListaAdvogado.xhtml";
    }

    public String updateByCodigo() {

        objSelecionado = new Advogado(Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("advogadoSelecionadoCodigo")),
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("advogadoSelecionadoNome"),
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("advogadoSelecionadoCpf"),
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("advogadoSelecionadoOab"),
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("advogadoSelecionadoEndereco"),
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("advogadoSelecionadoTelefone"));

        return "EditaAdvogado.xhtml";
    }
    
    public String deleteByCodigo(int codigo) {       
        
        ManagerDao.getCurrentInstance().deleteByCodigo(codigo);
        
        return "ListaAdvogado.xhtml";
    }

    public Advogado getAdvogado() {
        return advogado;
    }

    public void setAdvogado(Advogado advogado) {
        this.advogado = advogado;
    }

    public Advogado getObjSelecionado() {
        return objSelecionado;
    }

    public void setObjSelecionado(Advogado objSelecionado) {
        this.objSelecionado = objSelecionado;
    }

}
