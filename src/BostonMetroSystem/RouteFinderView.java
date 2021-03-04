package BostonMetroSystem;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RouteFinderView extends JFrame{

    private JLabel startLabel = new JLabel("Starting Destination");
    private JLabel endLabel = new JLabel("Ending Destination");
    private JLabel routeLabel = new JLabel("Route");
    private JTextField startDest = new JTextField(10);
    private JTextField endDest = new JTextField(10);
    private JTextField route = new JTextField(10);
    private JTextField startSearch = new JTextField("Search", 10);
    private JTextField endSearch = new JTextField("Search",10);
    private JButton calcRouteButton = new JButton("Find Route");


    public RouteFinderView(){
        JPanel findRoutePanel = new JPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 200);

        findRoutePanel.add(startLabel);
        findRoutePanel.add(endLabel);
        findRoutePanel.add(routeLabel);
        findRoutePanel.add(startDest);
        findRoutePanel.add(endDest);
        findRoutePanel.add(route);
        findRoutePanel.add(startSearch);
        findRoutePanel.add(endSearch);
        findRoutePanel.add(calcRouteButton);

        this.add(findRoutePanel);
    }
    public String getStartDest(){
        return startDest.getText();
    }
    public String getEndDest(){
        return endDest.getText();
    }

    public String getRoute(){
        return route.getText();
    }

    public String getStartSearch(){
        return startSearch.getText();
    }

    public String getEndSearch(){
        return endSearch.getText();
    }

    public void setStartDest(String start){
        startDest.setText(start);
    }
    public void setEndDest(String end){
        endDest.setText(end);
    }

    public void setRoute(String r){
        route.setText(r);
    }

    public void setStartSearch(String start){
        startSearch.setText(start);
    }

    public void setEndSearch(String end){
        endSearch.setText(end);
    }

    void addCalcRouteListener(ActionListener listenerForCalcButton){
        calcRouteButton.addActionListener(listenerForCalcButton);
    }

    void displayErrorMessage(String errorMessage){
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}
