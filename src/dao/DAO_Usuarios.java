/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.ProdutosEma;
import bean.UsuariosEma;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author u06934922107
 */
public class DAO_Usuarios extends DAO_Abstract {

    public UsuariosEma LoginUsuario(String nomeUsuario, String senha) {
        UsuariosEma usuario = null;
        session.beginTransaction();
        Criteria criteria = session.createCriteria(UsuariosEma.class);
        criteria.add(Restrictions.eq("nomeUsuarioEma", nomeUsuario));
        criteria.add(Restrictions.eq("senhaEma", senha));
        usuario = (UsuariosEma) criteria.uniqueResult();
        session.getTransaction().commit();
        return usuario;
    }

    @Override
    public void insert(Object object) {
        session.beginTransaction(); // É obrigatorio ter a transação com o hibernate e terminar com commit().
        session.save(object);
        session.getTransaction().commit();
    }

    @Override
    public void update(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.update(object);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Object object) {
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
    }

    @Override
    public Object list(int id) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(UsuariosEma.class);
        criteria.add(Restrictions.eq("idUsuarioEma", id));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista.get(0);
    }

    @Override
    public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(UsuariosEma.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public List listNome(String nome) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(UsuariosEma.class);
        criteria.add(Restrictions.ilike("nomeUsuarioEma", nome, MatchMode.ANYWHERE));
        List lista = criteria.list();
        session.getTransaction().commit();

        return lista;
    }

    public List listEmail(String email) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(UsuariosEma.class);
        criteria.add(Restrictions.ilike("emailEma", email, MatchMode.ANYWHERE));
        List lista = criteria.list();
        session.getTransaction().commit();

        return lista;
    }

    public List listNomeEmail(String email, String nome) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(UsuariosEma.class);
        criteria.add(Restrictions.ilike("nomeUsuarioEma", "%" + nome + "%"));
        criteria.add(Restrictions.ilike("emailEma", "%" + email + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();

        return lista;
    }

}
