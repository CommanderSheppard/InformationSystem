package frontend;


import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

import javax.servlet.annotation.WebServlet;

@Title("Addressbook")
@Theme("valo")
public class View extends UI {


    Label title = new Label("This is title");
    Button persDepButton = new Button("Personnel department");
    Button accDepButton = new Button("Accounts department");
    Button salaryButton = new Button("Salary");
    Button storageButton = new Button("Storage");



    @Override
    protected void init(VaadinRequest request) {
        buildLayout();
    }


    private void buildLayout() {

        persDepButton.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                title.setValue("Personnel department");
            }
        });

        accDepButton.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                title.setValue("Accounts department");
            }
        });

        salaryButton.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                title.setValue("Salary");
            }
        });

        storageButton.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                title.setValue("Storage");
            }
        });






        HorizontalLayout barLayout = new HorizontalLayout(persDepButton, accDepButton, salaryButton, storageButton);
        barLayout.setWidth("100%");
        barLayout.setExpandRatio(persDepButton, 1);
        barLayout.setExpandRatio(accDepButton, 1);
        barLayout.setExpandRatio(salaryButton, 1);
        barLayout.setExpandRatio(storageButton, 1);


        HorizontalLayout titleLayout = new HorizontalLayout(title);
        titleLayout.setSizeFull();
        titleLayout.setComponentAlignment(title, Alignment.MIDDLE_CENTER);
        title.setSizeUndefined();
        titleLayout.setExpandRatio(title, 1);

        GridLayout resultLayout = new GridLayout(5, 4);
        for (int i = 0; i < 5; i++) { //column
            for (int j = 0; j < 4; j++) { //row
                if (j == 0) {
                    resultLayout.addComponent(new TextArea("sometext" + i + j), i, j);
                } else {
                    resultLayout.addComponent(new TextArea(), i, j);

                }

            }
        }


        VerticalLayout verticalMainLayout = new VerticalLayout(barLayout, titleLayout, resultLayout);
        verticalMainLayout.setSizeFull();
        verticalMainLayout.setExpandRatio(barLayout, 1);
        verticalMainLayout.setExpandRatio(titleLayout, 1);
        verticalMainLayout.setExpandRatio(resultLayout, 5);

        HorizontalLayout mainLayout = new HorizontalLayout(verticalMainLayout);
        mainLayout.setSizeFull();
        mainLayout.setExpandRatio(verticalMainLayout, 1);

        setContent(mainLayout);
    }


    @WebServlet(urlPatterns = "/*")
    @VaadinServletConfiguration(ui = View.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }


}