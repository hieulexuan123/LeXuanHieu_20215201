package hust.soict.ict.aims.screen;

import hust.soict.ict.aims.cart.Cart;
import hust.soict.ict.aims.media.Media;
import hust.soict.ict.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
	private Cart cart;
	
	@FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;
    
	@FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableView<Media> tblMedia;
    
    @FXML
    private Label lbTotalCost;
    
    @FXML
    private Button btnOrder;
    
    @FXML
    private void initialize() {
    	colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
    	colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
    	colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
    	tblMedia.setItems(this.cart.getItemsOrdered());
    	
    	btnPlay.setVisible(false);
    	btnRemove.setVisible(false);
    	
    	tblMedia.getSelectionModel().selectedItemProperty().addListener(
    			new ChangeListener<Media>() {

					@Override
					public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
						if (newValue != null) {
							updateButtonBar(newValue);
						}			
					}
					
					private void updateButtonBar(Media media) {
				    	btnRemove.setVisible(true);
				    	if (media instanceof Playable) {
				    		btnPlay.setVisible(true);
				    	}
				    	else {
				    		btnPlay.setVisible(false);
				    	}
				    }
				});
    	
    	lbTotalCost.setText(cart.totalCost() + " $");
        cart.getItemsOrdered().addListener((ListChangeListener<Media>) c -> {
            lbTotalCost.setText(cart.totalCost() + " $");
        });
    }
    
    @FXML
    void btnRemovePressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	try {
			cart.removeMedia(media);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void btnOrderPressed(ActionEvent event) {
        if (cart.getItemsOrdered().size() > 0) {
            cart.placeOrder();
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Order Created!", ButtonType.OK);
            alert.setTitle("Order");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "No items in the cart!", ButtonType.OK);
            alert.setTitle("Order");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
    }
    
    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();

        Alert alert = new Alert(Alert.AlertType.NONE, "Play " + media.getTitle(), ButtonType.OK);
        alert.setTitle("Playing");
        alert.setHeaderText(null);
        alert.showAndWait();
    }
    
    public CartScreenController(Cart cart) {
    	super();
    	this.cart = cart;	
	}
}
