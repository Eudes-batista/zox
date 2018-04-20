package com.zoomtecnologia.zox.modelo.estoque;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "est_cadproduto")
@Data
@NamedQueries({
    @NamedQuery(name = "Produto.buscarDescricao", query = "select p from Produto p where p.descricao like :descricao")
})
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "PRREFPRO", length = 20, nullable = false)
    String codigo;

    @ManyToOne
    @JoinColumn(name = "PRNCMCOD", nullable = false)
    @ForeignKey(name = "est_cadprodutoFKzoxcadncm")
    Ncm ncm;

    @Column(name = "PRCODCES", length = 7, nullable = true)
    Integer cest;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "PRCODSUB", referencedColumnName = "SGCODSUB", nullable = false)
        ,@JoinColumn(name = "PRCODGRU", referencedColumnName = "SGCODGRU", nullable = false)
    })
    @ForeignKey(name = "est_cadprodutoFKzoxcadsubgrup")
    SubGrupo subGrupo;

    @Column(name = "PRDESPRO", length = 120, nullable = false)
    String descricao;

    @Column(name = "PRAPLICA", nullable = true, columnDefinition = "text")
    String aplicacao;

    @Column(name = "PRTIPOPS", nullable = true, columnDefinition = "enum(P,S) default 'P'")
    String tipo;

    @Column(name = "PRULTALT", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date ultimaAtualizacao;

    @Column(name = "PRCODFAB", length = 20, nullable = true)
    String fabricante;

    @Column(name = "PRCDPROD", length = 20, nullable = true)
    String produtor;

    @Column(name = "PRDIAVEN", length = 5, nullable = true)
    String diaVencimento;

    @Column(name = "PRIATPRO", nullable = false, columnDefinition = "enum(A,T) default 'A'")
    String iat;

    @Column(name = "PRGERABA", nullable = false, columnDefinition = "enum(S,N) default 'N'")
    String balanca;

    @Column(name = "PRINFONU", nullable = false, columnDefinition = "enum(S,N) default 'N'")
    String informacaoNutricional;

    @Column(name = "PRIMPVAL", nullable = false, columnDefinition = "enum(S,N) default 'N'")
    String imprimiDataValidade;

    @Column(name = "PRCLENQU", length = 5, nullable = true)
    String classeEnquadramentoIpi;

    @Column(name = "PRCDSELO", length = 60, nullable = true)
    String codigoSelo;

    @Column(name = "PRCODEAN", length = 20, nullable = true)
    String eanTributacao;

    @Column(name = "PREMBALA", length = 20, nullable = false)
    String codigoEmbalagem;

    @ManyToOne
    @JoinColumn(name = "PRUNIDAD", nullable = false)
    @ForeignKey(name = "unidadeFKproduto")
    Unidade unidade;

    @Column(name = "PRFATMUL", precision = 5, scale = 3, nullable = false)
    Double fatorMultiplicacao;

}