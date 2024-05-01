package es.tiernoparla.daw.mercadaw.model.dao;

public class MercaDawDAOFactory {
    public MercaDawDAOImp crear(TipoDB tipo) {

        MercaDawDAOImp dao = null;

        switch (tipo) {
            case MARIADB:
                //dao = new MercaDawMariaDBDAOImp();
                break;
        
            default:
                //dao = new MercaDawMockDAOImp();
                break;
        }

        return dao;
    }
}
