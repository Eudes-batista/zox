package com.zoomtecnologia.zox.bean;

import com.zoomtecnologia.zox.modelo.cadastros.Estado;
import com.zoomtecnologia.zox.modelo.cadastros.Pais;
import com.zoomtecnologia.zox.servico.EstadoService;
import com.zoomtecnologia.zox.servico.PaisService;
import java.util.List;
import javax.faces.bean.ManagedBean;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("estadoBean")
@ManagedBean
@Scope("view")
public class EstadoBean extends GenericBean<Estado, EstadoService> {

    @Autowired
    EstadoService estadoService;
    @Autowired
    PaisService paisService;
    @Getter
    @Setter
    private List<Pais> paises;

    @Override
    public void inicializar() {
        super.inicializar();
        this.paises = this.paisService.listarTodos();
    }

    @Override
    public EstadoService getGenericService() {
        return estadoService;
    }

    @Override
    public Estado createEntidade() {
        return new Estado();
    }

}
