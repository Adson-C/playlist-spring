package br.com.adson.dao;

import br.com.adson.domain.PlayList;

import java.util.List;

public interface PlayListDAO {

    void salvar(PlayList playList);
    List<PlayList> recuperar();
    PlayList recuperarPorID(long id);
    void atualizar(PlayList playList);
    void excluir(long id);
}
