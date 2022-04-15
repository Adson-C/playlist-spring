package br.com.adson.service;

import br.com.adson.domain.PlayList;

import java.util.List;

public interface PlayListService {

    void salvar(PlayList playList);
    List<PlayList> recuperar();
    PlayList recuperarPorId(long id);
    void atualizar(PlayList playList);
    void excluir(long id);
}
