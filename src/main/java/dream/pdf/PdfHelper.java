package dream.pdf;


import dream.view.chance.ChanceAreaView;
import dream.view.user.choice.ChoiceAreaView;
import org.apache.pdfbox.pdmodel.PDDocument;

import javax.swing.*;
import java.io.IOException;

import static dream.pdf.PdfTableHelper.drawConsoleTable;
import static dream.pdf.PdfTableHelper.drawInputTable;

public class PdfHelper {

    public static void exportToPdf(String destinationDirectory, int[] inputArray, JTextArea printArea, ChoiceAreaView[] choiceAreaViews, ChanceAreaView[] chanceAreaViews) {
        if (destinationDirectory != null && !destinationDirectory.isEmpty()) {
            PDDocument pdDocument = new PDDocument();
            try {

                addInputPages(pdDocument, inputArray, printArea);
                addChoicePages(pdDocument, choiceAreaViews);
                addChancePage(pdDocument, chanceAreaViews);

                String path = destinationDirectory + System.getProperty("file.separator") + "Export_results.pdf";
                pdDocument.save(path);

                pdDocument.close();
            } catch (IOException e) {
                e.printStackTrace();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private static void addChoicePages(PDDocument pdDocument, ChoiceAreaView[] choiceAreaViews) {
        PdfTableHelper.drawChoiceTables(pdDocument, choiceAreaViews);
    }

    private static void addChancePage(PDDocument pdDocument, ChanceAreaView[] chanceAreaViews) {
        PdfTableHelper.drawChanceTables(pdDocument, chanceAreaViews);
    }


    //todo : to fix console table extension
    private static void addInputPages(PDDocument pdDocument, int[] inputArray, JTextArea printArea) {

        PdfTableHelper.MultiField0 multiField0 = drawInputTable(pdDocument, inputArray);
        drawConsoleTable(pdDocument, multiField0, printArea);
    }


}
