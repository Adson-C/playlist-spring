package br.com.adson.service;

import br.com.adson.dao.PlayListDAO;
import br.com.adson.domain.PlayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PlayListServiceImpl implements PlayListService{

    @Autowired // dependencia
    private PlayListDAO playListDAO;

    @Override
    public void salvar(PlayList playList) {
        playListDAO.salvar(playList);

    }

    @Override
    @Transactional(readOnly = true)
    public List<PlayList> recuperar() {
        return playListDAO.recuperar();
    }

    @Override
    @Transactional(readOnly = true)
    public PlayList recuperarPorId(long id) {
        return playListDAO.recuperarPorID(id);
    }

    @Override
    public void atualizar(PlayList playList) {
        playListDAO.atualizar(playList);
    }

    @Override
    public void excluir(long id) {
        playListDAO.excluir(id);
    }
}
