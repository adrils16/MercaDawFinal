package es.tiernoparla.daw.mercadaw.model.dao;

import es.tiernoparla.daw.mercadaw.model.dao.enums.TipoDB;
/**
 * Factory de la interfaz MercaDAW que permite crear objetos de tipo MARIADB o Mock.
 */
public class MercaDawDAOFactory {

    /**
     * Crea un objeto de clase MercaDAwDAO
     * @param tipo Tipo MARIADB o, por defecto, Mock.
     * @return Un objeto de tipo MercaDawDAO.
     */
    public static MercaDawDAO crear(TipoDB tipo) {

        MercaDawDAO dao = null;

        switch (tipo) {
            case MARIADB:
                dao = new MercaDawMariaDBDAOImp();
                break;
        
            default:
                dao = new MercaDawMockDAOImp();
                break;
        }

        return dao;
    }
}
