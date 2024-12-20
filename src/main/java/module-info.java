module es.tiernoparla.daw.mercadaw {
    requires transitive javafx.controls;
    requires transitive javafx.fxml;
    requires org.mariadb.jdbc;
    requires javafx.graphics;
    requires org.apache.poi.ooxml;
    requires org.apache.commons.csv;

    opens es.tiernoparla.daw.mercadaw to javafx.fxml;
    opens es.tiernoparla.daw.mercadaw.view to javafx.fxml;
    exports es.tiernoparla.daw.mercadaw.controller;
    exports es.tiernoparla.daw.mercadaw.view;
    exports es.tiernoparla.daw.mercadaw.model;
    exports es.tiernoparla.daw.mercadaw.model.entity.persona.empleado;
    exports es.tiernoparla.daw.mercadaw.model.entity.persona;
    exports es.tiernoparla.daw.mercadaw.model.entity.producto;
    exports es.tiernoparla.daw.mercadaw.model.entity.interfaces;
    exports es.tiernoparla.daw.mercadaw.model.entity.producto.enums;
    exports es.tiernoparla.daw.mercadaw.model.entity.persona.empleado.enums;
}
