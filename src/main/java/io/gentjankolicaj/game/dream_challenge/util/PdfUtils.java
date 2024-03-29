package io.gentjankolicaj.game.dream_challenge.util;


import io.gentjankolicaj.game.dream_challenge.view.chance.ChanceAreaView;
import io.gentjankolicaj.game.dream_challenge.view.user.choice.ChoiceAreaView;
import org.apache.pdfbox.pdmodel.PDDocument;

import javax.swing.*;

import static io.gentjankolicaj.game.dream_challenge.util.PdfTableUtils.drawConsoleTable;
import static io.gentjankolicaj.game.dream_challenge.util.PdfTableUtils.drawInputTable;

public class PdfUtils {

    private PdfUtils() {
    }

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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private static void addChoicePages(PDDocument pdDocument, ChoiceAreaView[] choiceAreaViews) {
        PdfTableUtils.drawChoiceTables(pdDocument, choiceAreaViews);
    }

    private static void addChancePage(PDDocument pdDocument, ChanceAreaView[] chanceAreaViews) {
        PdfTableUtils.drawChanceTables(pdDocument, chanceAreaViews);
    }


    //todo : to fix console table extension
    private static void addInputPages(PDDocument pdDocument, int[] inputArray, JTextArea printArea) {
        PdfTableUtils.MultiField0 multiField0 = drawInputTable(pdDocument, inputArray);
        drawConsoleTable(pdDocument, multiField0, printArea);
    }


}
