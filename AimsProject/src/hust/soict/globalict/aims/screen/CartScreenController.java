package hust.soict.globalict.aims.screen;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import hust.soict.globalict.aims.store.Store;

public class CartScreenController {
    private Cart cart;
    private Store store;

    public CartScreenController(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }

    @FXML private TableView<Media> tblMedia;
    @FXML private TableColumn<Media, String> colMediaTitle;
    @FXML private TableColumn<Media, String> colMediacategory;
    @FXML private TableColumn<Media, Float> colMediaCost;
    
    @FXML private Button btnPlay;
    @FXML private Button btnRemove;
    
    @FXML private TextField tfFilter;
    @FXML private RadioButton radioBtnFilterId;
    @FXML private RadioButton radioBtnFilterTitle;
    @FXML private Label costLabel; 


    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
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
            }
        );
        cart.getItemsOrdered().addListener((ListChangeListener<Media>) change -> {
        updateTotalCost();
    });

        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }
        });
    }

    private void updateTotalCost() {
        float total = cart.totalCost(); 
        costLabel.setText(String.format("%.2f $", total));
    }

    private void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
    }

    private void showFilteredMedia(String filter) {
        FilteredList<Media> filteredData = new FilteredList<>(cart.getItemsOrdered(), p -> true);
        filteredData.setPredicate(media -> {
            if (filter == null || filter.isEmpty()) return true;
            if (radioBtnFilterTitle.isSelected() && media.getTitle().toLowerCase().contains(filter.toLowerCase())) {
                return true;
            }
            if (radioBtnFilterId.isSelected() && String.valueOf(media.getId()).equals(filter)) {
                return true;
            }
            return false;
        });
        tblMedia.setItems(filteredData);
    }
}