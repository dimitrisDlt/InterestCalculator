package org.example;

import javafx.animation.ScaleTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.FillRule;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javafx.util.Duration;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

public class MainView extends GridPane {

    private CustomColors colors = new CustomColors();
    private CustomBackgrounds backgrounds = new CustomBackgrounds();
    private CustomInput dikastikiApofasiInput = new CustomInput();
    private DatePicker imerominiaEpidosisInput = new DatePicker();
    private DatePicker imerominiaDimosieusisInput = new DatePicker();
    private DatePicker imerominiaYpologismouInput = new DatePicker();
    private Label infoLabel = new Label("");


    public MainView() {

        this.setGridLinesVisible(false);
        this.setStyle("-fx-background-color: transparent;");

        this.getColumnConstraints().add(new ColumnConstraints(1, 9000, 9000, Priority.ALWAYS, HPos.CENTER, true));
        this.getRowConstraints().add(new RowConstraints(70, 70, 70, Priority.ALWAYS, VPos.CENTER, true));
        this.getRowConstraints().add(new RowConstraints(70, 70, 70, Priority.ALWAYS, VPos.CENTER, true));
        this.getRowConstraints().add(new RowConstraints(50, 50, 50, Priority.ALWAYS, VPos.CENTER, true));
        this.getRowConstraints().add(new RowConstraints(50, 50, 50, Priority.ALWAYS, VPos.CENTER, true));
        this.getRowConstraints().add(new RowConstraints(50, 50, 50, Priority.ALWAYS, VPos.CENTER, true));
        this.getRowConstraints().add(new RowConstraints(50, 50, 50, Priority.ALWAYS, VPos.CENTER, true));


        this.getRowConstraints().add(new RowConstraints(1, 9000, 9000, Priority.ALWAYS, VPos.CENTER, true));
        this.getRowConstraints().add(new RowConstraints(70, 70, 70, Priority.ALWAYS, VPos.CENTER, true));


        Label titleLabel = new Label("ΥΠΟΛΟΓΙΣΜΟΣ ΤΟΚΟΦΟΡΙΑΣ");
        titleLabel.setBackground(backgrounds.getPrimaryBackground());
        titleLabel.setFont(Font.font("System", FontWeight.BOLD, 22));
        titleLabel.setTextFill(colors.getFourthColor());
        titleLabel.setAlignment(Pos.CENTER);
        titleLabel.setTextAlignment(TextAlignment.CENTER);
        titleLabel.setEffect(new DropShadow(10, Color.BLACK));
        titleLabel.setPrefSize(9000, 9000);

        this.add(titleLabel, 0, 0);

        CustomLabel prommptLabel = new CustomLabel("Εισάγετε τουλάχιστον ημερομηνία υπολογισμού για να συνεχίσετε. Σε περίπτωση που επιθυμείτε μόνο υπολογισμό τόκων υπερημερίας αφήστε τα άλλα πεδία κενά.");
        prommptLabel.setWrapText(true);
        prommptLabel.setPadding(new Insets(0, 20, 0, 20));
        this.add(prommptLabel, 0, 1);

        HBox dikastikiApofasiContainer = new HBox(10);
        CustomLabel dikastikiApofasiLabel = new CustomLabel("Αριθμός δικαστικής απόφασης:");
        dikastikiApofasiLabel.setMinWidth(250);
        dikastikiApofasiContainer.getChildren().add(dikastikiApofasiLabel);
        dikastikiApofasiContainer.getChildren().add(dikastikiApofasiInput);
        dikastikiApofasiContainer.setPadding(new Insets(0, 20, 0, 20));
        this.add(dikastikiApofasiContainer, 0, 2);

        HBox imerominiaEpidosisContainer = new HBox(10);
        CustomLabel imerominiaEpidosisLabel = new CustomLabel("Ημερομηνία Επίδοσης:");
        imerominiaEpidosisLabel.setMinWidth(250);
        imerominiaEpidosisContainer.getChildren().add(imerominiaEpidosisLabel);
        imerominiaEpidosisContainer.getChildren().add(imerominiaEpidosisInput);
        imerominiaEpidosisContainer.setPadding(new Insets(0, 20, 0, 20));
        this.add(imerominiaEpidosisContainer, 0, 3);

        HBox imerominiaDimosieusisContainer = new HBox(10);
        CustomLabel imerominiaDimosieusisLabel = new CustomLabel("Ημερομηνία Δημοσίευσης:");
        imerominiaDimosieusisLabel.setMinWidth(250);
        imerominiaDimosieusisContainer.getChildren().add(imerominiaDimosieusisLabel);
        imerominiaDimosieusisContainer.getChildren().add(imerominiaDimosieusisInput);
        imerominiaDimosieusisContainer.setPadding(new Insets(0, 20, 0, 20));
        this.add(imerominiaDimosieusisContainer, 0, 4);

        HBox imerominiaYpologismouContainer = new HBox(10);
        CustomLabel imerominiaYpologismouLabel = new CustomLabel("Ημερομηνία Υπολογισμού:");
        imerominiaYpologismouLabel.setMinWidth(250);
        imerominiaYpologismouContainer.getChildren().add(imerominiaYpologismouLabel);
        imerominiaYpologismouContainer.getChildren().add(imerominiaYpologismouInput);
        imerominiaYpologismouContainer.setPadding(new Insets(0, 20, 0, 20));
        this.add(imerominiaYpologismouContainer, 0, 5);

        ScrollPane mainScrollPane = new ScrollPane();
        VBox mainVBox = new VBox();

        mainScrollPane.setContent(mainVBox);
        mainScrollPane.setFitToWidth(true);

        mainScrollPane.setStyle("-fx-background: transparent; -fx-background-color: transparent;");

        mainVBox.setStyle("-fx-background: transparent; -fx-background-color: transparent;");
        mainVBox.setPrefWidth(9000);
        mainVBox.setSpacing(10);
        mainVBox.setPadding(new Insets(0, 20, 0, 20));
        mainVBox.getChildren().add(new FieldBox(mainVBox));
        mainVBox.getChildren().add(new FieldBox(mainVBox));
        mainVBox.getChildren().add(new FieldBox(mainVBox));
        mainVBox.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                mainScrollPane.setVvalue((Double) t1);
            }
        });

        HBox buttonContainer = new HBox();
        Button addFieldButton = new Button();
        SVGPath addFieldImage = new SVGPath();
        addFieldImage.setContent("M15 12L12 12M12 12L9 12M12 12L12 9M12 12L12 15 M7 3.33782C8.47087 2.48697 10.1786 2 12 2C17.5228 2 22 6.47715 22 12C22 17.5228 17.5228 22 12 22C6.47715 22 2 17.5228 2 12C2 10.1786 2.48697 8.47087 3.33782 7");
        addFieldImage.setFillRule(FillRule.EVEN_ODD);
        addFieldImage.setFill(Color.TRANSPARENT);
        addFieldImage.setStroke(colors.getPrimaryColor());
        addFieldImage.setStrokeWidth(3);
        addFieldImage.setScaleX(1.4);
        addFieldImage.setScaleY(1.4);
        addFieldButton.setMaxSize(40, 40);
        addFieldButton.setMinSize(40, 40);
        addFieldButton.setGraphic(addFieldImage);
        addFieldButton.setStyle("-fx-background-color: transparent; -fx-border-style: none; -fx-background-radius: 0px;");
        addFieldButton.setOnMouseEntered(e -> {

            ScaleTransition hoverEnter = new ScaleTransition(Duration.millis(300));
            hoverEnter.setNode(addFieldButton);
            hoverEnter.setFromX(1);
            hoverEnter.setFromY(1);
            hoverEnter.setByX(0.05);
            hoverEnter.setByY(0.05);
            hoverEnter.play();
        });

        addFieldButton.setOnMouseExited(e -> {

            ScaleTransition hoverExit = new ScaleTransition(Duration.millis(300));
            hoverExit.setNode(addFieldButton);
            hoverExit.setFromX(1.05);
            hoverExit.setFromY(1.05);
            hoverExit.setByX(-0.05);
            hoverExit.setByY(-0.05);
            hoverExit.play();
        });

        addFieldButton.setOnAction(e -> {

            mainVBox.getChildren().add(new FieldBox(mainVBox));
        });

        infoLabel.setPrefSize(9000, 9000);
        infoLabel.setFont(Font.font("System", FontWeight.BOLD, 16));

        ButtonStack calculateButton = new ButtonStack("ΥΠΟΛΟΓΙΣΜΟΣ");
        calculateButton.setSize(200, 40);
        calculateButton.getButton().setOnAction(e -> {

            infoLabel.setText("");

            XWPFDocument document = new XWPFDocument();

            XWPFStyles styles = document.createStyles();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", new Locale("el"));


            CTFonts fonts = CTFonts.Factory.newInstance();
            fonts.setAscii("Georgia");
            fonts.setHAnsi("Georgia");
            fonts.setEastAsia("Georgia");
            fonts.setCs("Georgia");

            styles.setDefaultFonts(fonts);

            CTSectPr sectPr = document.getDocument().getBody().isSetSectPr()
                    ? document.getDocument().getBody().getSectPr()
                    : document.getDocument().getBody().addNewSectPr();

            // Add or get the page margins element (<w:pgMar>)
            CTPageMar pageMar = sectPr.isSetPgMar() ? sectPr.getPgMar() : sectPr.addNewPgMar();

            // Set margins (in twentieths of a point — 1 inch = 1440 twips)
            int oneInch = 1440 / 2;
            pageMar.setTop(BigInteger.valueOf(1440));
            pageMar.setBottom(BigInteger.valueOf(1440));
            pageMar.setLeft(BigInteger.valueOf(oneInch));
            pageMar.setRight(BigInteger.valueOf(oneInch));

            // Optional: gutter and header/footer distances
            pageMar.setHeader(BigInteger.valueOf(1440));
            pageMar.setFooter(BigInteger.valueOf(1440));

            XWPFParagraph title = document.createParagraph();
            title.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun runTitle = title.createRun();
            runTitle.setText("ΥΠΟΛΟΓΙΣΜΟΣ ΤΟΚΟΦΟΡΙΑΣ ΑΠΑΙΤΗΣΕΩΝ ΒΑΣΕΙ ΤΗΣ ΥΠ' ΑΡΙΘΜΟΝ " + dikastikiApofasiInput.getText() + " ΔΙΚΑΣΤΙΚΗΣ ΑΠΟΦΑΣΕΩΣ");
            runTitle.setBold(true);
            runTitle.setFontSize(16);
            runTitle.addBreak();
            runTitle.addBreak();

            XWPFParagraph arithmosApofasisParagraph = document.createParagraph();
            arithmosApofasisParagraph.setAlignment(ParagraphAlignment.LEFT);
            XWPFRun runArithmosApofasisParagraph = arithmosApofasisParagraph.createRun();
            if (dikastikiApofasiInput.getText() != null) {
                runArithmosApofasisParagraph.setText("Αριθμός απόφασης: " + dikastikiApofasiInput.getText() + ".");
            }

            runArithmosApofasisParagraph.setBold(false);
            runArithmosApofasisParagraph.setFontSize(12);
            runArithmosApofasisParagraph.addBreak();

            XWPFParagraph imerominiaEpidosisParagraph = document.createParagraph();
            imerominiaEpidosisParagraph.setAlignment(ParagraphAlignment.LEFT);
            XWPFRun runImerominiaEpidosisParagraph = imerominiaEpidosisParagraph.createRun();

            if (imerominiaEpidosisInput.getValue() != null) {

                runImerominiaEpidosisParagraph.setText("Ημερομηνία επίδοσης αγωγής: " + formatter.format(imerominiaEpidosisInput.getValue()) + ".");
            }
            runImerominiaEpidosisParagraph.setBold(false);
            runImerominiaEpidosisParagraph.setFontSize(12);
            runImerominiaEpidosisParagraph.addBreak();

            XWPFParagraph imerominiaDimosieusisParagraph = document.createParagraph();
            imerominiaDimosieusisParagraph.setAlignment(ParagraphAlignment.LEFT);
            XWPFRun runImerominiaDimosieusisParagraph = imerominiaDimosieusisParagraph.createRun();

            if (imerominiaDimosieusisInput.getValue() != null) {

                runImerominiaDimosieusisParagraph.setText("Ημερομηνία δημοσίευσης: " + formatter.format(imerominiaDimosieusisInput.getValue()) + ".");
            }
            runImerominiaDimosieusisParagraph.setBold(false);
            runImerominiaDimosieusisParagraph.setFontSize(12);
            runImerominiaDimosieusisParagraph.addBreak();

            XWPFParagraph imerominiaYpologismouParagraph = document.createParagraph();
            imerominiaYpologismouParagraph.setAlignment(ParagraphAlignment.LEFT);
            XWPFRun runImerominiaYpologismouParagraph = imerominiaYpologismouParagraph.createRun();
            runImerominiaYpologismouParagraph.setText("Ημερομηνία υπολογισμού: " + formatter.format(imerominiaYpologismouInput.getValue()) + ".");
            runImerominiaYpologismouParagraph.setBold(false);
            runImerominiaYpologismouParagraph.setFontSize(12);
            runImerominiaYpologismouParagraph.addBreak();
            runImerominiaYpologismouParagraph.addBreak();


            XWPFTable table = document.createTable();
            table.setTableAlignment(TableRowAlign.CENTER);

            //create first row
            XWPFTableRow tableRowOne = table.getRow(0);
            tableRowOne.getCell(0).setText("Α/Α");
            tableRowOne.addNewTableCell().setText("ΗΜ/ΝΙΑ ΕΝΑΡΞΗΣ ΥΠΕΡΗΜΕΡΙΑΣ");
            tableRowOne.addNewTableCell().setText("ΚΕΦΑΛΑΙΟ");
            tableRowOne.addNewTableCell().setText("ΤΟΚΟΙ ΥΠΕΡΗΜΕΡΙΑΣ ΕΩΣ ΤΗΝ ΕΠΙΔΟΣΗ");
            tableRowOne.addNewTableCell().setText("ΤΟΚΟΙ ΕΠΙΔΙΚΙΑΣ ΕΩΣ ΤΗ ΔΗΜΟΣΙΕΥΣΗ");
            tableRowOne.addNewTableCell().setText("ΤΟΚΟΙ ΕΠΙΔΙΚΙΑΣ ΑΠΟ ΤΗ ΔΗΜΟΣΙΕΥΣΗ");
            tableRowOne.addNewTableCell().setText("ΣΥΝΟΛΟ ΤΟΚΩΝ");
            tableRowOne.addNewTableCell().setText("ΣΥΝΟΛΟ");

            for (XWPFTableCell cel : tableRowOne.getTableCells()) {

                cel.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);
                cel.getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);
                for (XWPFRun run : cel.getParagraphs().get(0).getRuns()) {

                    run.setBold(true);
                    run.setFontSize(12);
                }
            }

            double synolikoKefalaio = 0;
            double synolikoiTokoi = 0;
            double synoliko = 0;

            int i = 1;

            for (Node node : mainVBox.getChildren()) {

                FieldBox box = (FieldBox) node;

                HelperFunctions funcs = new HelperFunctions();

                double kefalaio = funcs.parseGreekDouble(box.getPosoInput().getText());
                double tokoiYperimerias = 0;
                double tokoiEpidikiasSyn2 = 0;
                double tokoiEpidikiasSyn3 = 0;

                if (box.getImerominiaYperimeriasInput().getValue() != null) {

                    if (imerominiaEpidosisInput.getValue() != null) {

                        tokoiYperimerias += box.getResult(imerominiaEpidosisInput.getValue());

                        if (imerominiaDimosieusisInput.getValue() != null) {

                            tokoiEpidikiasSyn2 += box.getTokoiEpidikiasSyn2(imerominiaEpidosisInput.getValue().plusDays(1), imerominiaDimosieusisInput.getValue());
                            tokoiEpidikiasSyn3 += box.getTokoiEpidikiasSyn3(imerominiaDimosieusisInput.getValue().plusDays(1), imerominiaYpologismouInput.getValue());
                        } else {

                            tokoiEpidikiasSyn2 += box.getTokoiEpidikiasSyn2(imerominiaEpidosisInput.getValue(), imerominiaYpologismouInput.getValue());
                        }


                        if (box.getImerominiaYperimeriasInput().getValue().isAfter(imerominiaEpidosisInput.getValue())) {

                            tokoiYperimerias = 0;
                        }

                        if (box.getImerominiaYperimeriasInput().getValue().isAfter(imerominiaDimosieusisInput.getValue())) {

                            tokoiEpidikiasSyn2 = 0;
                        }

                    } else {

                        tokoiYperimerias += box.getResult(imerominiaYpologismouInput.getValue());
                    }

                } else {

                    infoLabel.setTextFill(Color.RED);
                    infoLabel.setWrapText(true);
                    infoLabel.setFont(Font.font("System", FontWeight.BOLD, 16));
                    infoLabel.setText("Πρέπει να ορίσετε ημερομηνία έναρξης τοκοφορίας!");
                    return;
                }

                double tokoi = tokoiYperimerias + tokoiEpidikiasSyn2 + tokoiEpidikiasSyn3;
                double synolo = kefalaio + tokoi;

                synolikoKefalaio += kefalaio;
                synolikoiTokoi += tokoi;
                synoliko += synolo;

                XWPFTableRow newTableRow = table.createRow();
                newTableRow.getCell(0).setText(String.valueOf(i));
                newTableRow.getCell(1).setText(formatter.format(box.getImerominiaYperimeriasInput().getValue()));
                newTableRow.getCell(2).setText(new BigDecimal(kefalaio).setScale(2, RoundingMode.HALF_UP).doubleValue() + "€");
                newTableRow.getCell(3).setText(new BigDecimal(tokoiYperimerias).setScale(2, RoundingMode.HALF_UP).doubleValue() + "€");
                newTableRow.getCell(4).setText(new BigDecimal(tokoiEpidikiasSyn2).setScale(2, RoundingMode.HALF_UP).doubleValue() + "€");
                newTableRow.getCell(5).setText(new BigDecimal(tokoiEpidikiasSyn3).setScale(2, RoundingMode.HALF_UP).doubleValue() + "€");
                newTableRow.getCell(6).setText(new BigDecimal(tokoi).setScale(2, RoundingMode.HALF_UP).doubleValue() + "€");
                newTableRow.getCell(7).setText(new BigDecimal(synolo).setScale(2, RoundingMode.HALF_UP).doubleValue() + "€");

                for (XWPFTableCell cel : newTableRow.getTableCells()) {

                    cel.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);
                    cel.getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);
                    for (XWPFRun run : cel.getParagraphs().get(0).getRuns()) {

                        run.setBold(false);
                        run.setFontSize(12);
                    }
                }

                CTTrPr trPr = newTableRow.getCtRow().isSetTrPr() ? newTableRow.getCtRow().getTrPr() : newTableRow.getCtRow().addNewTrPr();

                CTHeight ht = trPr.addNewTrHeight();
                ht.setVal(BigInteger.valueOf(900));
                ht.setHRule(STHeightRule.EXACT);

                i++;
            }

            XWPFTableRow newTableRow = table.createRow();
            newTableRow.getCell(0).setText("ΣΥΝΟΛΟ");
            newTableRow.getCell(1).setText("");
            newTableRow.getCell(2).setText(new BigDecimal(synolikoKefalaio).setScale(2, RoundingMode.HALF_UP).doubleValue() + "€");
            newTableRow.getCell(3).setText("");
            newTableRow.getCell(4).setText("");
            newTableRow.getCell(5).setText("");
            newTableRow.getCell(6).setText(new BigDecimal(synolikoiTokoi).setScale(2, RoundingMode.HALF_UP).doubleValue() + "€");
            newTableRow.getCell(7).setText(new BigDecimal(synoliko).setScale(2, RoundingMode.HALF_UP).doubleValue() + "€");

            for (XWPFTableCell cel : newTableRow.getTableCells()) {

                cel.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);
                cel.getParagraphs().get(0).setAlignment(ParagraphAlignment.CENTER);
                for (XWPFRun run : cel.getParagraphs().get(0).getRuns()) {

                    run.setBold(true);
                    run.setFontSize(12);
                }
            }

            CTTrPr trPr = newTableRow.getCtRow().isSetTrPr() ? newTableRow.getCtRow().getTrPr() : newTableRow.getCtRow().addNewTrPr();
            CTHeight ht = trPr.addNewTrHeight();
            ht.setVal(BigInteger.valueOf(900));
            ht.setHRule(STHeightRule.EXACT);

            XWPFParagraph katakleidaSynolikoKefalaio = document.createParagraph();
            katakleidaSynolikoKefalaio.setAlignment(ParagraphAlignment.LEFT);
            XWPFRun runKatakleidaSynolikoKefalaio = katakleidaSynolikoKefalaio.createRun();
            runKatakleidaSynolikoKefalaio.addBreak();
            runKatakleidaSynolikoKefalaio.addBreak();

            runKatakleidaSynolikoKefalaio.setText("ΣΥΝΟΛΟ ΚΕΦΑΛΑΙΟΥ: " + new BigDecimal(synolikoKefalaio).setScale(2, RoundingMode.HALF_UP).doubleValue() + "€.");
            runKatakleidaSynolikoKefalaio.setBold(true);
            runKatakleidaSynolikoKefalaio.setFontSize(12);
            runKatakleidaSynolikoKefalaio.addBreak();

            XWPFParagraph katakleidaSynolikoiTokoi = document.createParagraph();
            katakleidaSynolikoiTokoi.setAlignment(ParagraphAlignment.LEFT);
            XWPFRun runKatakleidaSynolikoiTokoi = katakleidaSynolikoiTokoi.createRun();
            runKatakleidaSynolikoiTokoi.setText("ΣΥΝΟΛΟ ΤΟΚΩΝ: " + new BigDecimal(synolikoiTokoi).setScale(2, RoundingMode.HALF_UP).doubleValue() + "€.");
            runKatakleidaSynolikoiTokoi.setBold(true);
            runKatakleidaSynolikoiTokoi.setFontSize(12);
            runKatakleidaSynolikoiTokoi.addBreak();

            XWPFParagraph katakleidaSynoliko = document.createParagraph();
            katakleidaSynoliko.setAlignment(ParagraphAlignment.LEFT);
            XWPFRun runKatakleidaSynoliko = katakleidaSynoliko.createRun();
            runKatakleidaSynoliko.setText("ΣΥΝΟΛΟ ΑΠΑΙΤΗΣΕΩΝ (ΚΕΦΑΛΑΙΟ + ΤΟΚΟΙ): " + new BigDecimal(synoliko).setScale(2, RoundingMode.HALF_UP).doubleValue() + "€.");
            runKatakleidaSynoliko.setBold(true);
            runKatakleidaSynoliko.setFontSize(12);
            runKatakleidaSynoliko.addBreak();

            // Save document
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Αποθήκευση αρχείου");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Word Document (*.docx)", "*.docx"));
            fileChooser.setInitialFileName("ΥΠΟΛΟΓΙΣΜΟΣ ΤΟΚΟΦΟΡΙΑΣ - ΑΠΟΦΑΣΗ " + dikastikiApofasiInput.getText().replace('/', '-'));

            File file = fileChooser.showSaveDialog(this.getScene().getWindow());

            if (file != null) {
                try {

                    try (FileOutputStream out = new FileOutputStream(file)) {
                        document.write(out);
                    }

                    System.out.println("Document saved to: " + file.getAbsolutePath());
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            } else {
                System.out.println("Save cancelled by user.");
            }
        });


        buttonContainer.getChildren().add(addFieldButton);
        buttonContainer.getChildren().add(infoLabel);
        buttonContainer.getChildren().add(calculateButton);
        buttonContainer.setPrefSize(9000, 9000);
        buttonContainer.setPadding(new Insets(0, 20, 0, 20));
        buttonContainer.setAlignment(Pos.CENTER_RIGHT);

        this.add(mainScrollPane, 0, 6);
        this.add(buttonContainer, 0, 7);
    }
}
