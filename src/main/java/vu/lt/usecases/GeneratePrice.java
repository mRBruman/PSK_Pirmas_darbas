package vu.lt.usecases;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class GeneratePrice implements Serializable {

    @Inject
    private PriceGenerator priceGenerator;

    private CompletableFuture<Integer> generatePriceTask = null;

    public String generateNewPrice() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        int buildingId = Integer.parseInt(requestParameters.get("buildingId"));

        generatePriceTask = CompletableFuture.supplyAsync(() -> priceGenerator.generatePrice());
        return "/buildingDetails.xhtml?faces-redirect=true&buildingId=" + buildingId;
    }

    public boolean isPriceGeneratorRunning() {
        return generatePriceTask != null && !generatePriceTask.isDone();
    }

    public String getPriceGeneratorStatus() throws ExecutionException, InterruptedException {
        if (generatePriceTask == null) {
            return null;
        } else if (isPriceGeneratorRunning()) {
            return "Price generation is in progress.";
        }
        return "Suggested price: " + generatePriceTask.get();
    }
}
