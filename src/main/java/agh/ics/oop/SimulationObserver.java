package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Platform;

public class SimulationObserver implements IObserver{

    private final App app;

    public SimulationObserver(App app) {
        this.app = app;
    }

    @Override
    public void positionChanged() {
        Platform.runLater(app::updateGrid);

    }
}
