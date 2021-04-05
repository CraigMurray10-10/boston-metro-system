package BostonMetroSystem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;



import java.util.ArrayList;

/**
 *  Used to create and display the graphical user interface
 */
public class RouteFinderView{

    private javafx.scene.control.Button button;
    private BorderPane pane;
    private ListView<String> startListView;
    private ListView<String> endListView;
    private ListView<String> routeListView;
    private ListView<String> tempRoutesListView;
    private javafx.scene.control.Label start;
    private javafx.scene.control.Label end;
    private Label route;
    private TextField searchStart;
    private TextField searchEnd;
    public ObservableList<String> starts;
    public ObservableList<String> ends;
    private ObservableList<String> routes = FXCollections.observableArrayList();



    private ArrayList<Station> stations;

    /**
     * RouteFinderView constructor
     * @param stations
     */
    public RouteFinderView(ArrayList<Station> stations) {
        this.stations = stations;

        this.initialiseWindow();
    }



    /**
     * Used to create the graphical user interface
     */
    public void initialiseWindow() {
        pane = new BorderPane();
        button = new javafx.scene.control.Button("Find Route");
        start = new javafx.scene.control.Label("Start Destination");
        end = new javafx.scene.control.Label("End Destination");
        route = new javafx.scene.control.Label("Route:");
        searchStart = new javafx.scene.control.TextField();
        searchStart.setPromptText("Search");
        searchEnd = new TextField();
        searchEnd.setPromptText("Search");
        startListView = new ListView<>();
        endListView = new ListView<>();
        routeListView = new ListView<>();
        starts = FXCollections.observableArrayList();
        ends = FXCollections.observableArrayList();
        routes = getRoutes();

        for (Station s : this.stations) {
            starts.add(s.stationAsString());
            ends.add(s.stationAsString());
        }

        startListView.setItems(starts);
        startListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        endListView.setItems(ends);
        endListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        routes.add("Hello");
        routeListView.setItems(routes);
        routeListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        VBox leftPane = new VBox(start, startListView, searchStart);
        VBox middlePane = new VBox(end, endListView, searchEnd);
        VBox rightPane = new VBox(route, routeListView, button);

        HBox layout = new HBox(20);
        layout.setPadding(new Insets(20, 20, 20,20));
        layout.getChildren().addAll(leftPane, middlePane, rightPane);
        pane.setCenter(layout);
    }


    /**
     * @return pane
     */
    public Parent asParent(){ return pane; }


    /**
     * @return startListView
     */
    public ListView<String> getStartSelectInput(){ return startListView; }

    /**
     * @return endListView
     */
    public ListView<String> getEndSelectInput(){return endListView;}

    /**
     * @return searchStart
     */
    public TextField getSearchStart(){
        return searchStart;
    }

    /**
     * @return searchEnd
     */
    public TextField getSearchEnd(){ return searchEnd; }


    /**
     * @return button
     */
    public Button getButton() {
        return button;
    }

    /**
     * Method wraps the starts ObservableList and filters the contents of the list using the predicate provided by the
     * user. The changes made in the ObservableList are propagated to the FilteredList and then the startListView is then
     * set to display this.
     * @param startInput
     * @param starts
     */
    public void searchStartUserInput(TextField startInput, ObservableList<String> starts){


        FilteredList<String> filterStart = new FilteredList<>(starts, item -> true);

        startInput.textProperty().addListener((observable, oldValue, newValue) -> {


            if(newValue == null || newValue.length() == 0){
                filterStart.setPredicate(item -> true);
                this.startListView.setItems(filterStart);

            } else {
                filterStart.setPredicate(item -> item.contains(newValue));
                this.startListView.setItems(filterStart);

            }
        });
    }

    /**
     *  Method wraps the ends ObservableList and filters the contents of the list using the predicate provided by the
     *  user. The changes made in the ObservableList are propagated to the FilteredList and then the endListView is then
     *  set to display this.
     * @param endInput
     * @param ends
     */
    public void searchEndUserInput(TextField endInput, ObservableList<String> ends){

        FilteredList<String> filterEnd = new FilteredList<>(ends, item -> true);

        endInput.textProperty().addListener((observable, oldValue, newValue) -> {


            if(newValue == null || newValue.length() == 0){
                filterEnd.setPredicate(item -> true);
                this.endListView.setItems(filterEnd);

            } else {
                filterEnd.setPredicate(item -> item.contains(newValue));
                this.endListView.setItems(filterEnd);

            }
        });
    }

    /**
     * @return routes
     */
    public ObservableList<String> getRoutes(){
        return routes;
    }


    /**
     * Sets the routeListView items to passed in ListView's items
     * @param getRoutesListView
     */
    public void updateRoutes(ListView<String> getRoutesListView){
        routeListView.setItems(getRoutesListView.getItems());

    }

}

