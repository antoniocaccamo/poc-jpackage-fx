package me.antoniocaccamo.player.ui;

import de.saxsys.mvvmfx.ViewModel;
import de.saxsys.mvvmfx.utils.commands.Action;
import de.saxsys.mvvmfx.utils.commands.Command;
import de.saxsys.mvvmfx.utils.commands.DelegateCommand;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class HelloWorldViewModel implements ViewModel {

    private StringProperty textFieldProperty;
    private StringProperty locationURLProperty ;
    private BooleanProperty precondition;
    private Command commandGO;

    public HelloWorldViewModel() {
        textFieldProperty   = new SimpleStringProperty();
        locationURLProperty = new SimpleStringProperty();

        precondition =  new SimpleBooleanProperty();
        precondition.bind(locationURLProperty.isNotEmpty());

        commandGO = new DelegateCommand(() -> new Action() {
            @Override
            protected void action() throws Exception {
                textFieldProperty.set(locationURLProperty.get());
            }
        }, precondition);

    }

    /**
     *
     * @return
     */
    public StringProperty textFieldProperty() {
        return textFieldProperty;
    }

    /**
     *
     * @return
     */
    public StringProperty locationURLProperty(){
        return locationURLProperty;
    }

    public Command getCommandGO(){return commandGO;}


}