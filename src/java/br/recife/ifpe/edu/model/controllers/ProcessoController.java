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
import javax.faces.context.FacesContext;

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

    public List<Processo> readAbertos() {

        String query = "Select p from Processo p where p.status=0";
        return ManagerDao.getCurrentInstance().read(query, Processo.class);

    }

    public String update() {
        ManagerDao.getCurrentInstance().update(this.objSelecionado);
        return "ListaProcesso.xhtml";
    }

    public String updateByCodigo() {

        objSelecionado = new Processo(Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("processoSelecionadoNumero")),
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("processoSelecionadoDataAbertura"),
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("processoSelecionadoInstanciaAtual"),
                Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("processoSelecionadoStatus")),
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("processoSelecionadoDecisaoFinal"),
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("processoSelecionadoDescricao"));

        return "EditaProcesso.xhtml";
    }

    public void showDetails() {
        
        objSelecionado = new Processo(Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("processoSelecionadoNumero")),
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("processoSelecionadoDataAbertura"),
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("processoSelecionadoInstanciaAtual"),
                Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("processoSelecionadoStatus")),
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("processoSelecionadoDecisaoFinal"),
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("processoSelecionadoDescricao"));
        
    }

    public String finalizaProcesso(int numero) {

        ManagerDao.getCurrentInstance().finalizaProcesso(numero);

        return "index.xhtml";
    }

    public String deleteByCodigo(int codigo) {

        ManagerDao.getCurrentInstance().deleteByCodigo(codigo, "pro");

        return "ListaProcesso.xhtml";
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
