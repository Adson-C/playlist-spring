package br.com.adson.dao;

import br.com.adson.domain.PlayList;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PlayListDaoImpl implements PlayListDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void salvar(PlayList playList) {
        em.persist(playList);
    }

    @Override
    public List<PlayList> recuperar() {
        return em.createQuery("select p from Playlist p", PlayList.class).getResultList();
    }

    @Override
    public PlayList recuperarPorID(long id) {
        return em.find(PlayList.class, id);
    }

    @Override
    public void atualizar(PlayList playList) {
        em.merge(playList);
    }

    @Override
    public void excluir(long id) {
        em.remove(em.getReference(PlayList.class, id));
    }
}
