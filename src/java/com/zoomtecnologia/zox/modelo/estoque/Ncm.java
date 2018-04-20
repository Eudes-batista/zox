/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoomtecnologia.zox.modelo.estoque;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "ncm")
@Data
@NamedQueries({
    @NamedQuery(name = "Ncm.listarTodos", query = "select u from Ncm u")
    ,@NamedQuery(name = "Ncm.buscarDescricao", query = "select u from Ncm u where u.descricao like :descricao")
})
public class Ncm implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "NCCODNCM", length = 8, nullable = false)
    @Length(max = 8, message = "Código do NCM com até {max}.")
    String codigo;

    @Column(name = "NCDESNCM", length = 150, nullable = false)
    @Length(max = 150, message = "Descrição do NCM com até {max}.")
    String descricao;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ncm")
    private List<Cest> cests = new ArrayList<>();
}