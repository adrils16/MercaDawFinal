module es.tiernoparla.daw.mercadaw {
    requires transitive javafx.controls;
    requires transitive javafx.fxml;
    requires org.mariadb.jdbc;
    requires javafx.graphics;
    requires org.apache.poi.ooxml;

    opens es.tiernoparla.daw.mercadaw to javafx.fxml;
    opens es.tiernoparla.daw.mercadaw.view to javafx.fxml;
    exports es.tiernoparla.daw.mercadaw.controller;
    exports es.tiernoparla.daw.mercadaw.view;
    exports es.tiernoparla.daw.mercadaw.model;
}
