module me.antoniocaccamo.player {
    
    requires java.base;
    requires java.scripting;
    
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires javafx.web;

    requires org.apache.logging.log4j;
    requires de.saxsys.mvvmfx;

    opens me.antoniocaccamo.player.ui to de.saxsys.mvvmfx,javafx.fxml;

    exports me.antoniocaccamo.player;
    exports me.antoniocaccamo.player.ui;
}