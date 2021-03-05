package dream.pdf;


import dream.view.chance.ChanceAreaView;
import dream.view.user.choice.ChoiceAreaView;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class PdfHelper {


    public static void exportToPdf(String destinationDirectory, int[] inputArray, JTextArea printArea, ChoiceAreaView[] choiceAreaViews, ChanceAreaView[] chanceAreaViews) {
        PDDocument pdDocument = new PDDocument();
        try {

            PDPage[] inputPages = getInputPages(inputArray, printArea);
            if (inputPages != null && inputPages.length != 0)
                for (PDPage inputPage : inputPages)
                    pdDocument.addPage(inputPage);


            PDPage[] choicePages = getChoicePages(choiceAreaViews);
            if (choicePages != null && choicePages.length != 0)
                for (PDPage choicePage : choicePages)
                    pdDocument.addPage(choicePage);


            PDPage[] chancePages = getChancePage(chanceAreaViews);
            if (chancePages != null && chancePages.length != 0)
                for (PDPage chancePage : chancePages)
                    pdDocument.addPage(chancePage);


            File exportFile = new File(destinationDirectory + System.getProperty("file.separator") + "Export_results.pdf");
            pdDocument.save(exportFile);

            pdDocument.close();
        } catch (IOException e) {
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static PDPage[] getChoicePages(ChoiceAreaView[] choiceAreaViews) {
        return null;
    }

    private static PDPage[] getChancePage(ChanceAreaView[] chanceAreaViews) {
        return null;
    }


    private static PDPage[] getInputPages(int[] inputArray, JTextArea printArea) {
        return null;
    }


}
