/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.recife.ifpe.edu.model.controllers;

import br.recife.ifpe.edu.model.classes.Advogado;
import br.recife.ifpe.edu.model.classes.Processo;
import br.recife.ifpe.edu.model.dao.ManagerDao;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author taoal
 */
@ManagedBean
@SessionScoped
public class ProcessoController {

    private Processo mProcesso;
    private Processo objSelecionado;

    @PostConstruct
    public void init() {
        this.mProcesso = new Processo();
    }

    public String insert() {
        ManagerDao.getCurrentInstance().insert(mProcesso);
        return "ListaProcesso.xhtml";
    }

    public List<Processo> readAll() {

        String query = "Select p from Processo p";
        return ManagerDao.getCurrentInstance().read(query, Processo.class);

    }

    public String update() {
        ManagerDao.getCurrentInstance().update(this.objSelecionado);
        return "ListaProcesso.xhtml";
    }

//    public String updateByCodigo() {
//
//        objSelecionado = new Advogado(Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("advogadoSelecionadoCodigo")),
//                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("advogadoSelecionadoNome"),
//                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("advogadoSelecionadoCpf"),
//                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("advogadoSelecionadoOab"),
//                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("advogadoSelecionadoEndereco"),
//                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("advogadoSelecionadoTelefone"));
//
//        return "EditaAdvogado.xhtml";
//    }
    
    public String deleteByCodigo(int codigo) {

        ManagerDao.getCurrentInstance().deleteByCodigo(codigo);

        return "ListaAdvogado.xhtml";
    }

    public Processo getProcesso() {
        return mProcesso;
    }

    public void setProcesso(Processo processo) {
        this.mProcesso = processo;
    }

    public Processo getObjSelecionado() {
        return objSelecionado;
    }

    public void setObjSelecionado(Processo objSelecionado) {
        this.objSelecionado = objSelecionado;
    }

}
