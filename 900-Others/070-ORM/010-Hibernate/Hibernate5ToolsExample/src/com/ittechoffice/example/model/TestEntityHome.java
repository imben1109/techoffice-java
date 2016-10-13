package com.ittechoffice.example.model;
// Generated 2016/10/3 ¤U¤È 04:20:43 by Hibernate Tools 5.2.0.Beta1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class TestEntity.
 * @see com.ittechoffice.example.model.TestEntity
 * @author Hibernate Tools
 */
public class TestEntityHome {

	private static final Log log = LogFactory.getLog(TestEntityHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(TestEntity transientInstance) {
		log.debug("persisting TestEntity instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TestEntity instance) {
		log.debug("attaching dirty TestEntity instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TestEntity instance) {
		log.debug("attaching clean TestEntity instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TestEntity persistentInstance) {
		log.debug("deleting TestEntity instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TestEntity merge(TestEntity detachedInstance) {
		log.debug("merging TestEntity instance");
		try {
			TestEntity result = (TestEntity) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TestEntity findById(int id) {
		log.debug("getting TestEntity instance with id: " + id);
		try {
			TestEntity instance = (TestEntity) sessionFactory.getCurrentSession()
					.get("com.ittechoffice.example.model.TestEntity", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TestEntity instance) {
		log.debug("finding TestEntity instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("com.ittechoffice.example.model.TestEntity").add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
