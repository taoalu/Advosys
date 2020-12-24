/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.recife.ifpe.edu.model.classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Processo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numero;
    private String dataAbertura;
    private String instanciaAtual;
    private int status;
    private String decisaoFinal;
    @javax.persistence.Lob
    private String descricao;
    @OneToMany
    private List<Cliente> clientes;
    @OneToMany
    private List<Advogado> advogados;
    @OneToMany
    private List<Lei> leis;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Historico> historico;

    public Processo() {
        this.advogados = new ArrayList<Advogado>();
        this.clientes = new ArrayList<Cliente>();
        this.leis = new ArrayList<Lei>();
        this.historico = new ArrayList<Historico>();
    }

    public Processo(int numero, String dataAbertura, String instanciaAtual, int status, String decisaoFinal, String descricao) {
        this.numero = numero;
        this.dataAbertura = dataAbertura;
        this.instanciaAtual = instanciaAtual;
        this.status = status;
        this.decisaoFinal = decisaoFinal;
        this.descricao = descricao;
        this.clientes = clientes;
        this.advogados = advogados;
        this.leis = leis;
        this.historico = historico;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(String dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getInstanciaAtual() {
        return instanciaAtual;
    }

    public void setInstanciaAtual(String instanciaAtual) {
        this.instanciaAtual = instanciaAtual;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDecisaoFinal() {
        return decisaoFinal;
    }

    public void setDecisaoFinal(String decisaoFinal) {
        this.decisaoFinal = decisaoFinal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Advogado> getAdvogados() {
        return advogados;
    }

    public void setAdvogados(List<Advogado> advogados) {
        this.advogados = advogados;
    }

    public List<Lei> getLeis() {
        return leis;
    }

    public void setLeis(List<Lei> leis) {
        this.leis = leis;
    }

    public List<Historico> getHistorico() {
        return historico;
    }

    public void setHistorico(List<Historico> historico) {
        this.historico = historico;
    }

    public void addCliente(Cliente c) {
        this.clientes.add(c);
    }

    public void addAdvogado(Advogado a) {
        this.advogados.add(a);
    }

    public void addLei(Lei l) {
        this.leis.add(l);
    }

    public void addHistorico(Historico h) {
        this.addHistorico(h);
    }

}
