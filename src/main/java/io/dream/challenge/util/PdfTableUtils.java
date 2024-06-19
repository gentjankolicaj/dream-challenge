package io.dream.challenge.util;

import io.dream.challenge.view.chance.ChanceAreaView;
import io.dream.challenge.view.user.choice.ChoiceAreaView;
import java.awt.Color;
import java.io.IOException;
import javax.swing.JTextArea;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.vandeseer.easytable.TableDrawer;
import org.vandeseer.easytable.structure.Row;
import org.vandeseer.easytable.structure.Table;
import org.vandeseer.easytable.structure.cell.TextCell;

public class PdfTableUtils {

  public static MultiField0 drawInputTable(PDDocument pdDocument, int[] inputArray) {
    try {
      PDPage pdPage = new PDPage(PDRectangle.A4);
      pdDocument.addPage(pdPage);
      PDRectangle pageMediaBox = pdPage.getMediaBox();

      PDPageContentStream contentStream = new PDPageContentStream(pdDocument, pdPage);
      float columnWidth = getColumnWidth(3);

      Table table = Table.builder()
          .addColumnsOfWidth(columnWidth, columnWidth, columnWidth)
          .padding(5)
          .addRow(Row.builder()
              .add(TextCell.builder().text("Choices : ").build())
              .add(TextCell.builder().text("Choice sets : ").build())
              .add(TextCell.builder().text("Random sets : ").build())
              .borderWidth(1)
              .borderColor(Color.darkGray).build())

          .addRow(Row.builder()
              .add(TextCell.builder().text("" + inputArray[0]).build())
              .add(TextCell.builder().text("" + inputArray[1]).build())
              .add(TextCell.builder().text("" + inputArray[2]).build())
              .borderWidth(1)
              .borderColor(Color.darkGray).build())
          .build();

      float additionalDistanceFromTop = 50;
      float startX = 20f;
      float startY = pageMediaBox.getUpperRightY() - additionalDistanceFromTop; //Lower -50
      TableDrawer tableDrawer = TableDrawer.builder()
          .contentStream(contentStream)
          .startX(startX)
          .startY(startY)
          .table(table)
          .build();
      tableDrawer.draw();

      return new MultiField0(table, pdPage, contentStream);
    } catch (IOException io) {
      io.printStackTrace();
      return null;
    }
  }

  public static Table drawConsoleTable(PDDocument pdDocument, MultiField0 multiField0,
      JTextArea printArea) {
    Table inputTable = multiField0.table;
    PDPage pdPage = multiField0.pdPage;
    PDPageContentStream contentStream = multiField0.contentStream;
    if (inputTable != null) {
      try {
        String content = printArea.getText();
        float columnWidth = getColumnWidth(1);

        Table table = Table.builder()
            .addColumnsOfWidth(columnWidth)
            .padding(5)
            .addRow(Row.builder()
                .add(TextCell.builder().text("Console : ").build())
                .borderWidth(1)
                .borderColor(Color.darkGray).build())
            .addRow(Row.builder()
                .add(TextCell.builder().text(content).build())
                .borderWidth(1)
                .borderColor(Color.darkGray).build())
            .build();

        float startX = 20f;
        float startY = getStartY(inputTable);

        TableDrawer tableDrawer = TableDrawer.builder()
            .contentStream(contentStream)
            .startX(startX)
            .startY(startY)
            .table(table)
            .endY(50)
            .build();

        tableDrawer.draw();

        contentStream.close();

        return null;
      } catch (IOException io) {
        io.printStackTrace();
        return null;
      }
    } else {
      return null;
    }
  }

  public static void drawChoiceTables(PDDocument pdDocument, ChoiceAreaView[] chanceAreaViews) {

  }

  public static void drawChanceTables(PDDocument pdDocument, ChanceAreaView[] chanceAreaViews) {
  }


  private static float getStartY(Table table) {
    float additionalDistanceFromTop = 50;
    float distanceBetweenTable = 5f;
    float pageHeight = PDRectangle.A4.getUpperRightY();
    float tableHeight = table == null ? 0 : table.getHeight();
    return pageHeight - tableHeight - distanceBetweenTable - additionalDistanceFromTop;

  }

  private static float getColumnWidth(int columnNumber) {
    //PdRectangle.getWidth()-20 because we start X at position 20  (-3 border width)
    float rectangleWidth = PDRectangle.A4.getWidth() - 23f;
    return rectangleWidth / columnNumber;
  }


  static class MultiField0 {

    Table table;
    PDPage pdPage;
    PDPageContentStream contentStream;

    MultiField0(Table table, PDPage pdPage, PDPageContentStream contentStream) {
      this.table = table;
      this.pdPage = pdPage;
      this.contentStream = contentStream;
    }
  }
}
