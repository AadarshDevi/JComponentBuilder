# JComponentBuilder

An application for UI/UX Designers and Java Devs to ease the creation of
JavaFX and Swing components visually allowing them to focus on creating their
programs without needing to get stuck on UI/UX designing in CSS or Java.

## Dev Feature List

### Supported JavaFX Components

#### Pane
Accordion
AnchorPane
BorderPane
GridPane
HBox
VBox
ScrollPane
SpitPane
StackPane
TabPane
TilePane

#### Control
Button
Label
ListView
TextArea
TextField

#### Menu
Menu
MenuItem
ContextMenu

#### Extra
Tooltip
Stage
Scene

#### Charts
ScatterChart

### Supported Swing Components

Button
Label

## App Structure

### Home Page

```
BorderPane:
    [Top] Menu:
        Menu (File):
            MenuItem (Exit)
    [Center] SplitPane:
        [Left] VBox (Recent)
        [Right] ScrollPane:
            Accordion:
                [1] TilePane (JavaFX)
                    VBox
                [2] TilePane (Swing)
```

### Editor Page

```
BorderPane:
    [Top] Menu:
        Menu (Editor):
            MenuItem (Visual)
            MenuItem (Coder)
        Menu (File):
            Menu (Export)
                MenuItem (Export as Java Object)
                MenuItem (Export as Internal CSS)
                MenuItem (Export as External CSS)
            MenuItem (Home)
    [Center] SplitPane:
        [Left] 
        [Right] ScrollPane (Viewer)
```


## RoadMap