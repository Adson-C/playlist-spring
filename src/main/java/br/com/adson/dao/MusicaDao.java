package br.com.adson.dao;

import br.com.adson.domain.Musica;

import java.util.List;

public interface MusicaDao {
    void salvar(Musica musica);
    List<Musica> recuperarMusicaPorPlayList(long playlistId);
    Musica recuperarPorPlayListIdEMusicaId(long playlistId, long musicaId);
    void atualizar(Musica musica);
    void excluir(long musicaId);

}
