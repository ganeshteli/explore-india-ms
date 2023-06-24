package com.gt.exploreindia;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gt.exploreindia.domain.Difficulty;
import com.gt.exploreindia.domain.Region;
import com.gt.exploreindia.service.TourPackageService;
import com.gt.exploreindia.service.TourService;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.PropertyAccessor.FIELD;

@SpringBootApplication
public class ExploreIndiaApp implements CommandLineRunner{

	@Value("ExploreIndia.json")
    private String importFile;

	@Autowired
	private TourService tourService;

	@Autowired
	private TourPackageService tourPackageService;

	public static void main(String[] args) {
		SpringApplication.run(ExploreIndiaApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		createTourAllPackages();
		createTours(importFile);
	}

	private void createTourAllPackages(){
        tourPackageService.createTourPackage("NB", "North Backpack");
        tourPackageService.createTourPackage("WC", "Western Calm");
        tourPackageService.createTourPackage("HS", "Hot springs");
        tourPackageService.createTourPackage("CM", "Cycle Mumbai");
        tourPackageService.createTourPackage("MG", "From Mumbai to Goa");
        tourPackageService.createTourPackage("KF", "Kids Fun");
        tourPackageService.createTourPackage("NW", "Nature Watch");
        tourPackageService.createTourPackage("SM", "Snowboard Manali");
        tourPackageService.createTourPackage("TP", "Taste of Pune");
    }

	private void createTours(String fileToImport) throws IOException {
        TourFromFile.read(fileToImport).forEach(importedTour ->
            tourService.createTour(importedTour.getTitle(),
                    importedTour.getDescription(),
                    importedTour.getBlurb(),
                    importedTour.getPrice(),
                    importedTour.getLength(),
                    importedTour.getBullets(),
                    importedTour.getKeywords(),
                    importedTour.getPackageType(),
                    importedTour.getDifficulty(),
                    importedTour.getRegion()));
    }

	private static class TourFromFile {
        private String packageType, title, description, blurb, price, length,
                bullets, keywords, difficulty, region;

		static List<TourFromFile> read(String fileToImport) throws IOException {
            return new ObjectMapper().setVisibility(FIELD, ANY).
                    readValue(new FileInputStream(fileToImport), new TypeReference<List<TourFromFile>>() {});
        }
		
        protected TourFromFile(){}

        String getPackageType() { return packageType; }

        String getTitle() { return title; }

        String getDescription() { return description; }

        String getBlurb() { return blurb; }

        Integer getPrice() { return Integer.parseInt(price); }

        String getLength() { return length; }

        String getBullets() { return bullets; }

        String getKeywords() { return keywords; }

        Difficulty getDifficulty() { return Difficulty.valueOf(difficulty); }

        Region getRegion() { return Region.findByLabel(region); }
    }	

}