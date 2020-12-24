/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.recife.ifpe.edu.model.controllers;

import br.recife.ifpe.edu.model.classes.Lei;
import br.recife.ifpe.edu.model.classes.Lei;
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
public class LeiController {

    private Lei mLei;
    private Lei objSelecionado;

    @PostConstruct
    public void init() {
        this.mLei = new Lei();
    }

    public String insert() {
        ManagerDao.getCurrentInstance().insert(mLei);
        return "ListaLei.xhtml";
    }

    public List<Lei> readAll() {

        String query = "Select c from Lei c";
        return ManagerDao.getCurrentInstance().read(query, Lei.class);

    }

    public String update() {
        ManagerDao.getCurrentInstance().update(this.objSelecionado);
        return "ListaLei.xhtml";
    }

    public String updateByCodigo() {
        
        //int codigo, String descricao, String tipo, int capitulo, String artigo
        
        objSelecionado = new Lei(Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("advogadoSelecionadoCodigo")),
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("advogadoSelecionadoDescricao"),
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("advogadoSelecionadoTipo"),
                Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("advogadoSelecionadoCapitulo")),
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("advogadoSelecionadoArtigo"));
        
        return "EditaLei.xhtml";
    }

    public String deleteByCodigo(int codigo) {

        ManagerDao.getCurrentInstance().deleteByCodigo(codigo, "lei");

        return "ListaLei.xhtml";
    }

    public Lei getLei() {
        return mLei;
    }

    public void setLei(Lei lei) {
        this.mLei = lei;
    }

    public Lei getObjSelecionado() {
        return objSelecionado;
    }

    public void setObjSelecionado(Lei objSelecionado) {
        this.objSelecionado = objSelecionado;
    }
}
