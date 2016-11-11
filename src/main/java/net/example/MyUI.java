package net.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class MyUI extends UI {
	
	private static final Logger LOG = LoggerFactory.getLogger(MyUI.class);

	@Override
	protected void init(VaadinRequest request){
		LOG.info("Web application initialising");
		
		VerticalLayout rootLayout = new VerticalLayout();
	    HorizontalLayout textFieldLayout = new HorizontalLayout();
	 
	    TextField forenameTxt = new TextField("Forename");
	    TextField surnameTxt  = new TextField("Surname");
	     
	    Button submitBtn = new Button("Submit");
	    submitBtn.addClickListener(e -> {
	    	LOG.trace("Submit was clicked");
	        Notification.show("Welcome there" + forenameTxt.getValue() + " " + surnameTxt.getValue());
	    });
	 
	    textFieldLayout.setSpacing(true);
	    rootLayout.setMargin(true);
	    rootLayout.setSpacing(true);
	 
	    textFieldLayout.addComponents(forenameTxt, surnameTxt);
	    rootLayout.addComponents(textFieldLayout, submitBtn);
	 
	    setContent(rootLayout);
	    
	    LOG.info("Initialisation complete");
	}
	
}
