package com.easytest.dao.impl;

import com.easytest.dao.ProjectDao;
import com.easytest.model.Project;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.apache.commons.lang.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProjectDaoImpl implements ProjectDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Project project) {

        Project merged = em.merge(project);
        em.flush();
        BeanUtils.copyProperties(merged, project);
    }

    @Override
    public Project getProjectById(Long id) {

        Query query = em.createQuery("SELECT p FROM Project p WHERE p.id = :id");
        query.setParameter("id", id);
        query.setMaxResults(1);
        return (Project) query.getSingleResult();
    }

    @Override
    public Project getProjectByName(String name) {

        Query query=em.createQuery("SELECT p FROM Project p WHERE p.name=:name");
        query.setParameter("name",name);
        query.setMaxResults(1);
        return query.getResultList().size() > 0 ? (Project) query.getSingleResult() : null;

    }

    @Override
    public List<Project> getProject(Long id,String name){
        String hql="SELECT p FROM Project p WHERE 1=1 ";
        if(id!=null&&name!=null){
            hql+="and p.id=:id ";
        }
        else if(name!=null){
            hql+="and p.name like:name";
        }
        Query query=em.createQuery(hql);
        if(id!=null){
            query.setParameter("id",id);
        }

        if (StringUtils.isNotBlank(name)) {
            query.setParameter("name", "%" + name + "%");
        }
        return query.getResultList().size()>0?query.getResultList():null;
    }

    @Override
    public void delete(Project project) {
        project=em.merge(project);
        em.remove(project);
    }
}
