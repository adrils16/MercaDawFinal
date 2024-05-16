package es.tiernoparla.daw.mercadaw.model.dao;

import es.tiernoparla.daw.mercadaw.model.dao.enums.TipoDB;

public class MercaDawDAOFactory {

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
