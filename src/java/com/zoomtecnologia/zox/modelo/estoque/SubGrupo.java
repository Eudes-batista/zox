/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoomtecnologia.zox.modelo.estoque;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author zox
 */
@Entity
@Table(name = "zoxcadsubgrup")
@Data
@NamedQueries({
    @NamedQuery(name = "SubGrupo.listarTodos", query = "select u from SubGrupo u")
    ,@NamedQuery(name = "SubGrupo.buscarDescricao", query = "select u from SubGrupo u where u.descricao like :descricao")
})
public class SubGrupo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "SGCODSUB", length = 20, nullable = false)
    @Length(max = 20, message = "Código do SubGrupo com até {max}.")
    private String codigo;

    /**
     * CÓDIGO DO GRUPO
     */
    @Id
    @ManyToOne
    @JoinColumn(name = "SGCODGRU", nullable = false)
    @ForeignKey(name = "zoxcadsubgrupFKzoxcadgrup")
    private Grupo grupo;

    /**
     * DESCRIÇÃO DO SUBGRUPO
     */
    @Column(name = "SGDESGRU", length = 50, nullable = false)
    @Length(max = 50, message = "Descrição do SubGrupo com até {max}.")

    private String descricao;

    /**
     * CÓDIGO DO NCM PADRÃO DO SUBGRUPO
     */
    @Column(name = "SGCODNCM", length = 8, nullable = false)
    @Length(max = 8, message = "Descrição do NCM com até {max}.")
    private String ncm;

    /**
     * CÓDIGO DO CEST PADRÃO DO SUBGRUPO
     */
    @Column(name = "SGCDCEST", length = 7, nullable = true)
    @Length(max = 7, message = "Descrição do CEST com até {max}.")
    private String cest;

    /**
     * IAT (ARREDONDAMENTO OU TRUNCAMENTO) PADRÃO DO SUBGRUPO
     */
    @Column(name = "SGIATPRO", length = 1, nullable = true, columnDefinition = "enum(A,T) defaut 'A'")
    String iat;

    /**
     * IPPT (MERCADORIA DE TERCEIROS OU PROPRIA) PADRÃO DO SUBGRUPO
     */
    @Column(name = "SGIPPTPR", length = 1, nullable = true, columnDefinition = "enum(T,P) default 'T'")
    String ippt;
}