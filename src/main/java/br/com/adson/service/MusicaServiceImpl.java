package br.com.adson.service;

import br.com.adson.dao.MusicaDao;
import br.com.adson.domain.Musica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MusicaServiceImpl implements MusicaService {

    @Autowired
    private MusicaDao musicaDao;

    @Autowired
    private PlayListService playListService;

    @Override
    public void salvar(Musica musica, long playlistId) {
        musica.setPlayList(playListService.recuperarPorId(playlistId));
        musicaDao.salvar(musica);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Musica> recuperarPorPlaylist(long playlistId) {
        return musicaDao.recuperarMusicaPorPlayList(playlistId);
    }

    @Override
    @Transactional(readOnly = true)
    public Musica recuperarPorPlaylistIdEMuicaId(long playlistId, long musicaId) {
        return musicaDao.recuperarPorPlayListIdEMusicaId(playlistId, musicaId);
    }

    @Override
    public void atualizar(Musica musica, long playlistId) {
        musica.setPlayList(playListService.recuperarPorId(playlistId));
        musicaDao.atualizar(musica);
    }

    @Override
    public void excluir(long playlistId, long musicaId) {
        musicaDao.excluir(recuperarPorPlaylistIdEMuicaId(playlistId,musicaId).getId());
    }
}
