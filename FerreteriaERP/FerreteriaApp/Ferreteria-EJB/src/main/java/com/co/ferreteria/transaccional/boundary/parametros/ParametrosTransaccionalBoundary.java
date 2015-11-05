package com.co.ferreteria.transaccional.boundary.parametros;

import com.co.ferreteria.definitions.transaccional.parametros.ParametrosTransaccionalLocal;
import com.co.ferreteria.ferresoft.dto.maestro.MarcaDto;
import com.co.ferreteria.ferresoft.dto.maestro.UnidadDto;
import com.co.ferreteria.ferresoft.model.maestros.Marca;
import com.co.ferreteria.ferresoft.model.maestros.Unidad;
import java.sql.Connection;
import java.sql.SQLException;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import org.eclipse.persistence.sessions.Session;

/**
 *
 * @author johan
 */
@Stateless
public class ParametrosTransaccionalBoundary implements ParametrosTransaccionalLocal {

    @PersistenceContext
    EntityManager em;

    @Override
    public void guardarMarca(MarcaDto marca) {
        Marca marcaEntity = new Marca();
        marcaEntity.setDescripcion(marca.getDescripcion());
        em.persist(marcaEntity);
    }

    @Override
    public void guardarUnidad(UnidadDto unidad) {
        Unidad unidadEntity = new Unidad();
        unidadEntity.setDescripcion(unidad.getDescripcion());
        unidadEntity.setDiminutivo(unidad.getDiminutivo());
        em.persist(unidadEntity);
    }

    @Override
    public Connection obtenerConexion() {
        Connection connection = null;
        try {
            InitialContext initialContext = new InitialContext();
        DataSource dataSource = (DataSource) initialContext.lookup("java:/ferremaurosDS");
        connection = dataSource.getConnection();
        } catch (Exception e) {
            System.err.println("Error obteniendo la conexion");
        }
        
        return connection;
    }

}
