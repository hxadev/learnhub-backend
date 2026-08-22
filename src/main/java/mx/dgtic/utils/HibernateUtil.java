package mx.dgtic.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Utilidad para obtener un {@link EntityManagerFactory} y {@link EntityManager}.
 * Implementa el patrón Singleton y construye la fábrica a partir de una
 * unidad de persistencia (persistence unit) configurada en esta clase.
 */
public final class HibernateUtil {

	// Nombre por defecto de la unidad de persistencia (coincide con persistence.xml)
	private static final String DEFAULT_PERSISTENCE_UNIT = "learnhubPU";

	// Instancia Singleton volátil
	private static volatile HibernateUtil instance;

	// Fábrica de EntityManager
	private final EntityManagerFactory emf;

	/**
	 * Constructor privado que crea el EntityManagerFactory para la unidad indicada.
	 * @param persistenceUnitName nombre de la unidad de persistencia
	 */
	private HibernateUtil(String persistenceUnitName) {
		this.emf = Persistence.createEntityManagerFactory(persistenceUnitName);
	}

	/**
	 * Obtiene la instancia Singleton usando la unidad de persistencia por defecto.
	 * @return instancia Singleton de {@link HibernateUtil}
	 */
	public static HibernateUtil getInstance() {
		return getInstance(DEFAULT_PERSISTENCE_UNIT);
	}

	/**
	 * Obtiene la instancia Singleton, inicializándola con la unidad de persistencia
	 * especificada la primera vez que se llama.
	 * @param persistenceUnitName nombre de la unidad de persistencia
	 * @return instancia Singleton de {@link HibernateUtil}
	 */
	public static HibernateUtil getInstance(String persistenceUnitName) {
		if (instance == null) {
			synchronized (HibernateUtil.class) {
				if (instance == null) {
					instance = new HibernateUtil(persistenceUnitName);
				}
			}
		}
		return instance;
	}

	/**
	 * Devuelve el {@link EntityManagerFactory} creado.
	 * @return EntityManagerFactory
	 */
	public EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}

	/**
	 * Crea y devuelve un nuevo {@link EntityManager}.
	 * @return EntityManager
	 */
	public EntityManager createEntityManager() {
		return emf.createEntityManager();
	}

	/**
	 * Cierra el {@link EntityManagerFactory} si está abierto.
	 */
	public void close() {
		if (emf != null && emf.isOpen()) {
			emf.close();
		}
	}
}
