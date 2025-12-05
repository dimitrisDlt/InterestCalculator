package org.example;

import javafx.animation.ScaleTransition;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.FillRule;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Month;
import java.time.chrono.Chronology;
import java.util.Locale;

public class FieldBox extends HBox {

    // Στην αρχή θέτουμε τα μέλη της κλάσης
    private InterestCalculator interestCalculator = new InterestCalculator();
    private CustomColors colors = new CustomColors();
    private TextField posoInput = new TextField();
    private DatePicker imerominiaYperimeriasInput = new DatePicker();

    public FieldBox(VBox parent) {

        // UI
        this.getStyleClass().clear();
        this.getStyleClass().add("fieldbox");
        this.setEffect(new DropShadow(5, colors.getSecondaryColor()));
        this.setSpacing(10);
        this.setPrefWidth(9000);
        this.setAlignment(Pos.CENTER);
        this.setMinHeight(50);
        Label posoLabel = new Label("Ποσό κονδυλίου:");
        posoLabel.setFont(Font.font("System", FontWeight.BOLD, 16));
        posoLabel.setAlignment(Pos.CENTER);
        Label imerominiaYperimeriasLabel = new Label("Ημερομηνία έναρξης:");
        imerominiaYperimeriasLabel.setFont(Font.font("System", FontWeight.BOLD, 16));

        posoInput.setFont(Font.font("System", FontWeight.BOLD, 16));

        Button addButton = new Button();
        SVGPath addImage = new SVGPath();
        addImage.setContent("M15 12L12 12M12 12L9 12M12 12L12 9M12 12L12 15 M7 3.33782C8.47087 2.48697 10.1786 2 12 2C17.5228 2 22 6.47715 22 12C22 17.5228 17.5228 22 12 22C6.47715 22 2 17.5228 2 12C2 10.1786 2.48697 8.47087 3.33782 7");
        addImage.setStroke(colors.getFourthColor());
        addImage.setStrokeWidth(3);
        addImage.setFillRule(FillRule.EVEN_ODD);
        addImage.setFill(Color.TRANSPARENT);
        addButton.setGraphic(addImage);
        addButton.setStyle("-fx-background-color: transparent; -fx-border-style: none; -fx-bacground-radius: 0px;");
        addButton.setMaxSize(30, 30);
        addButton.setTooltip(new Tooltip("Δημιουργία νέου"));
        addButton.setOnMouseEntered(e -> {

            ScaleTransition hoverEnter = new ScaleTransition(Duration.millis(300));
            hoverEnter.setNode(addButton);
            hoverEnter.setFromX(1);
            hoverEnter.setFromY(1);
            hoverEnter.setByX(0.05);
            hoverEnter.setByY(0.05);
            hoverEnter.play();
        });

        addButton.setOnMouseExited(e -> {

            ScaleTransition hoverExit = new ScaleTransition(Duration.millis(300));
            hoverExit.setNode(addButton);
            hoverExit.setFromX(1.05);
            hoverExit.setFromY(1.05);
            hoverExit.setByX(-0.05);
            hoverExit.setByY(-0.05);
            hoverExit.play();
        });

        addButton.setOnAction(e -> {

            parent.getChildren().add(new FieldBox(parent));
        });


        Button duplicateButton = new Button();
        SVGPath duplicateImage = new SVGPath();
        duplicateImage.setContent("M18 3H4C3.44772 3 3 3.44772 3 4V18C3 18.5523 2.55228 19 2 19C1.44772 19 1 18.5523 1 18V4C1 2.34315 2.34315 1 4 1H18C18.5523 1 19 1.44772 19 2C19 2.55228 18.5523 3 18 3Z M13 11C13 10.4477 13.4477 10 14 10C14.5523 10 15 10.4477 15 11V13H17C17.5523 13 18 13.4477 18 14C18 14.5523 17.5523 15 17 15H15V17C15 17.5523 14.5523 18 14 18C13.4477 18 13 17.5523 13 17V15H11C10.4477 15 10 14.5523 10 14C10 13.4477 10.4477 13 11 13H13V11Z M20 5C21.6569 5 23 6.34315 23 8V20C23 21.6569 21.6569 23 20 23H8C6.34315 23 5 21.6569 5 20V8C5 6.34315 6.34315 5 8 5H20ZM20 7C20.5523 7 21 7.44772 21 8V20C21 20.5523 20.5523 21 20 21H8C7.44772 21 7 20.5523 7 20V8C7 7.44772 7.44772 7 8 7H20Z");
        duplicateImage.setStroke(colors.getFourthColor());
        duplicateImage.setFillRule(FillRule.EVEN_ODD);
        duplicateImage.setFill(colors.getFourthColor());
        duplicateButton.setGraphic(duplicateImage);
        duplicateButton.setStyle("-fx-background-color: transparent; -fx-border-style: none; -fx-bacground-radius: 0px;");
        duplicateButton.setMaxSize(30, 30);
        duplicateButton.setTooltip(new Tooltip("Αντιγραφή στοιχείων"));
        duplicateButton.setOnMouseEntered(e -> {

            ScaleTransition hoverEnter = new ScaleTransition(Duration.millis(300));
            hoverEnter.setNode(duplicateButton);
            hoverEnter.setFromX(1);
            hoverEnter.setFromY(1);
            hoverEnter.setByX(0.05);
            hoverEnter.setByY(0.05);
            hoverEnter.play();
        });

        duplicateButton.setOnMouseExited(e -> {

            ScaleTransition hoverExit = new ScaleTransition(Duration.millis(300));
            hoverExit.setNode(duplicateButton);
            hoverExit.setFromX(1.05);
            hoverExit.setFromY(1.05);
            hoverExit.setByX(-0.05);
            hoverExit.setByY(-0.05);
            hoverExit.play();
        });

        duplicateButton.setOnAction(e -> {

            FieldBox newBox = new FieldBox(parent);
            newBox.getPosoInput().setText(posoInput.getText());
            newBox.getImerominiaYperimeriasInput().setValue(imerominiaYperimeriasInput.getValue());
            parent.getChildren().add(newBox);
        });

        Button removeButton = new Button();
        SVGPath removeImage = new SVGPath();
        removeImage.setContent("M538.708,1151.28 C538.314,1150.89 537.676,1150.89 537.281,1151.28 L534.981,1153.58 L532.742,1151.34 C532.352,1150.95 531.718,1150.95 531.327,1151.34 C530.936,1151.73 530.936,1152.37 531.327,1152.76 L533.566,1154.99 L531.298,1157.26 C530.904,1157.65 530.904,1158.29 531.298,1158.69 C531.692,1159.08 532.331,1159.08 532.725,1158.69 L534.993,1156.42 L537.232,1158.66 C537.623,1159.05 538.257,1159.05 538.647,1158.66 C539.039,1158.27 539.039,1157.63 538.647,1157.24 L536.408,1155.01 L538.708,1152.71 C539.103,1152.31 539.103,1151.68 538.708,1151.28 L538.708,1151.28 Z M545.998,1162 C545.998,1163.1 545.102,1164 543.996,1164 L526.467,1164 L518.316,1154.98 L526.438,1146 L543.996,1146 C545.102,1146 545.998,1146.9 545.998,1148 L545.998,1162 L545.998,1162 Z M543.996,1144 L526.051,1144 C525.771,1143.98 525.485,1144.07 525.271,1144.28 L516.285,1154.22 C516.074,1154.43 515.983,1154.71 515.998,1154.98 C515.983,1155.26 516.074,1155.54 516.285,1155.75 L525.271,1165.69 C525.467,1165.88 525.723,1165.98 525.979,1165.98 L525.979,1166 L543.996,1166 C546.207,1166 548,1164.21 548,1162 L548,1148 C548,1145.79 546.207,1144 543.996,1144 L543.996,1144 Z");
        removeImage.setStroke(colors.getFourthColor());
        removeImage.setFillRule(FillRule.EVEN_ODD);
        removeImage.setFill(colors.getFourthColor());
        removeButton.setGraphic(removeImage);
        removeButton.setStyle("-fx-background-color: transparent; -fx-border-style: none; -fx-background-radius: 0px;");
        removeButton.setMaxSize(30, 30);
        removeButton.setTooltip(new Tooltip("Αφαίρεση"));
        removeButton.setOnMouseEntered(e -> {

            ScaleTransition hoverEnter = new ScaleTransition(Duration.millis(300));
            hoverEnter.setNode(removeButton);
            hoverEnter.setFromX(1);
            hoverEnter.setFromY(1);
            hoverEnter.setByX(0.05);
            hoverEnter.setByY(0.05);
            hoverEnter.play();
        });

        removeButton.setOnMouseExited(e -> {

            ScaleTransition hoverExit = new ScaleTransition(Duration.millis(300));
            hoverExit.setNode(removeButton);
            hoverExit.setFromX(1.05);
            hoverExit.setFromY(1.05);
            hoverExit.setByX(-0.05);
            hoverExit.setByY(-0.05);
            hoverExit.play();
        });

        removeButton.setOnAction(e -> {

            parent.getChildren().remove(this);
        });

        this.getChildren().add(posoLabel);
        this.getChildren().add(posoInput);
        this.getChildren().add(imerominiaYperimeriasLabel);
        this.getChildren().add(imerominiaYperimeriasInput);
        this.getChildren().add(addButton);
        this.getChildren().add(duplicateButton);
        this.getChildren().add(removeButton);

    }

    public double getResult(LocalDate endDate) {

        HelperFunctions funcs = new HelperFunctions();

        double result = 0;
        double poso = funcs.parseGreekDouble(posoInput.getText());

        // ΤΟΚΟΙ ΥΠΕΡΗΜΕΡΙΑΣ
        if (imerominiaYperimeriasInput.getValue().isBefore(LocalDate.of(2019, Month.DECEMBER, 31))) {

            LocalDate currentEndDate = LocalDate.of(2019, Month.DECEMBER, 31);

            if (endDate.isBefore(LocalDate.of(2019, Month.DECEMBER, 31))) {

                currentEndDate = endDate;
            }
            //System.out.println(interestCalculator.calculateInterestPeriod(poso, 7.25, imerominiaYperimeriasInput.getValue(), LocalDate.of(2022, Month.JULY, 27)));
            result += interestCalculator.calculateInterestPeriod(poso, 7.25, imerominiaYperimeriasInput.getValue(), currentEndDate);
        }

        if (imerominiaYperimeriasInput.getValue().isBefore(LocalDate.of(2020, Month.DECEMBER, 31)) && endDate.isAfter(LocalDate.of(2019, Month.DECEMBER, 31))) {

            LocalDate startDate = imerominiaYperimeriasInput.getValue();
            LocalDate currentEndDate = LocalDate.of(2020, Month.DECEMBER, 31);

            if (startDate.isBefore(LocalDate.of(2020, Month.JANUARY, 1))) {

                startDate = LocalDate.of(2020, Month.JANUARY, 1);
            }

            if (endDate.isBefore(LocalDate.of(2020, Month.DECEMBER, 31))) {

                currentEndDate = endDate;
            }
            //System.out.println(interestCalculator.calculateInterestPeriod(poso, 7.75, startDate, LocalDate.of(2022, Month.SEPTEMBER, 13)));
            result += interestCalculator.calculateInterestPeriodLeapYear(poso, 7.25, startDate, currentEndDate);
        }

        if (imerominiaYperimeriasInput.getValue().isBefore(LocalDate.of(2022, Month.JULY, 26)) && endDate.isAfter(LocalDate.of(2020, Month.DECEMBER, 31))) {

            LocalDate startDate = imerominiaYperimeriasInput.getValue();
            LocalDate currentEndDate = LocalDate.of(2022, Month.JULY, 26);

            if (startDate.isBefore(LocalDate.of(2021, Month.JANUARY, 1))) {

                startDate = LocalDate.of(2021, Month.JANUARY, 1);
            }

            if (endDate.isBefore(LocalDate.of(2022, Month.JULY, 26))) {

                currentEndDate = endDate;
            }
            //System.out.println(interestCalculator.calculateInterestPeriod(poso, 7.25, imerominiaYperimeriasInput.getValue(), LocalDate.of(2022, Month.JULY, 27)));
            result += interestCalculator.calculateInterestPeriod(poso, 7.25, startDate, currentEndDate);
        }

        if (imerominiaYperimeriasInput.getValue().isBefore(LocalDate.of(2022, Month.SEPTEMBER, 13)) && endDate.isAfter(LocalDate.of(2022, Month.JULY, 26))) {

            LocalDate startDate = imerominiaYperimeriasInput.getValue();
            LocalDate currentEndDate = LocalDate.of(2022, Month.SEPTEMBER, 13);

            if (startDate.isBefore(LocalDate.of(2022, Month.JULY, 27))) {

                startDate = LocalDate.of(2022, Month.JULY, 27);
            }

            if (endDate.isBefore(LocalDate.of(2022, Month.SEPTEMBER, 13))) {

                currentEndDate = endDate;
            }
            //System.out.println(interestCalculator.calculateInterestPeriod(poso, 7.75, startDate, LocalDate.of(2022, Month.SEPTEMBER, 13)));
            result += interestCalculator.calculateInterestPeriod(poso, 7.75, startDate, currentEndDate);
        }

        if (imerominiaYperimeriasInput.getValue().isBefore(LocalDate.of(2022, Month.NOVEMBER, 1)) && endDate.isAfter(LocalDate.of(2022, Month.SEPTEMBER, 13))) {

            LocalDate startDate = imerominiaYperimeriasInput.getValue();
            LocalDate currentEndDate = LocalDate.of(2022, Month.NOVEMBER, 1);

            if (startDate.isBefore(LocalDate.of(2022, Month.SEPTEMBER, 14))) {

                startDate = LocalDate.of(2022, Month.SEPTEMBER, 14);
            }

            if (endDate.isBefore(LocalDate.of(2022, Month.NOVEMBER, 1))) {

                currentEndDate = endDate;
            }
            //System.out.println(interestCalculator.calculateInterestPeriod(poso, 8.50, startDate, LocalDate.of(2022, Month.NOVEMBER, 1)));
            result += interestCalculator.calculateInterestPeriod(poso, 8.50, startDate, currentEndDate);
        }

        if (imerominiaYperimeriasInput.getValue().isBefore(LocalDate.of(2022, Month.DECEMBER, 20)) && endDate.isAfter(LocalDate.of(2022, Month.NOVEMBER, 1))) {

            LocalDate startDate = imerominiaYperimeriasInput.getValue();
            LocalDate currentEndDate = LocalDate.of(2022, Month.DECEMBER, 20);

            if (startDate.isBefore(LocalDate.of(2022, Month.NOVEMBER, 2))) {

                startDate = LocalDate.of(2022, Month.NOVEMBER, 2);
            }

            if (endDate.isBefore(LocalDate.of(2022, Month.DECEMBER, 20))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateInterestPeriod(poso, 9.25, startDate, currentEndDate);
        }

        if (imerominiaYperimeriasInput.getValue().isBefore(LocalDate.of(2023, Month.FEBRUARY, 7)) && endDate.isAfter(LocalDate.of(2022, Month.DECEMBER, 20))) {

            LocalDate startDate = imerominiaYperimeriasInput.getValue();
            LocalDate currentEndDate = LocalDate.of(2023, Month.FEBRUARY, 7);

            if (startDate.isBefore(LocalDate.of(2022, Month.DECEMBER, 21))) {

                startDate = LocalDate.of(2022, Month.DECEMBER, 21);
            }

            if (endDate.isBefore(LocalDate.of(2023, Month.FEBRUARY, 7))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateInterestPeriod(poso, 9.75, startDate, currentEndDate);
        }

        if (imerominiaYperimeriasInput.getValue().isBefore(LocalDate.of(2023, Month.MARCH, 21)) && endDate.isAfter(LocalDate.of(2023, Month.FEBRUARY, 7))) {

            LocalDate startDate = imerominiaYperimeriasInput.getValue();
            LocalDate currentEndDate = LocalDate.of(2023, Month.MARCH, 21);

            if (startDate.isBefore(LocalDate.of(2023, Month.FEBRUARY, 8))) {

                startDate = LocalDate.of(2023, Month.FEBRUARY, 8);
            }

            if (endDate.isBefore(LocalDate.of(2023, Month.MARCH, 21))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateInterestPeriod(poso, 10.25, startDate, currentEndDate);
        }

        if (imerominiaYperimeriasInput.getValue().isBefore(LocalDate.of(2023, Month.MAY, 9)) && endDate.isAfter(LocalDate.of(2023, Month.MARCH, 21))) {

            LocalDate startDate = imerominiaYperimeriasInput.getValue();
            LocalDate currentEndDate = LocalDate.of(2023, Month.MAY, 9);

            if (startDate.isBefore(LocalDate.of(2023, Month.MARCH, 22))) {

                startDate = LocalDate.of(2023, Month.MARCH, 22);
            }

            if (endDate.isBefore(LocalDate.of(2023, Month.MAY, 9))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateInterestPeriod(poso, 10.75, startDate, currentEndDate);
        }

        if (imerominiaYperimeriasInput.getValue().isBefore(LocalDate.of(2023, Month.JUNE, 20)) && endDate.isAfter(LocalDate.of(2023, Month.MAY, 9))) {

            LocalDate startDate = imerominiaYperimeriasInput.getValue();
            LocalDate currentEndDate = LocalDate.of(2023, Month.JUNE, 20);

            if (startDate.isBefore(LocalDate.of(2023, Month.MAY, 10))) {

                startDate = LocalDate.of(2023, Month.MAY, 10);
            }

            if (endDate.isBefore(LocalDate.of(2023, Month.JUNE, 20))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateInterestPeriod(poso, 11.00, startDate, currentEndDate);
        }

        if (imerominiaYperimeriasInput.getValue().isBefore(LocalDate.of(2023, Month.AUGUST, 1)) && endDate.isAfter(LocalDate.of(2023, Month.JUNE, 20))) {

            LocalDate startDate = imerominiaYperimeriasInput.getValue();
            LocalDate currentEndDate = LocalDate.of(2023, Month.AUGUST, 1);

            if (startDate.isBefore(LocalDate.of(2023, Month.JUNE, 21))) {

                startDate = LocalDate.of(2023, Month.JUNE, 21);
            }

            if (endDate.isBefore(LocalDate.of(2023, Month.AUGUST, 1))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateInterestPeriod(poso, 11.25, startDate, currentEndDate);
        }

        if (imerominiaYperimeriasInput.getValue().isBefore(LocalDate.of(2023, Month.SEPTEMBER, 19)) && endDate.isAfter(LocalDate.of(2023, Month.AUGUST, 1))) {

            LocalDate startDate = imerominiaYperimeriasInput.getValue();
            LocalDate currentEndDate = LocalDate.of(2023, Month.SEPTEMBER, 19);

            if (startDate.isBefore(LocalDate.of(2023, Month.AUGUST, 2))) {

                startDate = LocalDate.of(2023, Month.AUGUST, 2);
            }

            if (endDate.isBefore(LocalDate.of(2023, Month.SEPTEMBER, 19))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateInterestPeriod(poso, 11.50, startDate, currentEndDate);
        }

        if (imerominiaYperimeriasInput.getValue().isBefore(LocalDate.of(2023, Month.DECEMBER, 31)) && endDate.isAfter(LocalDate.of(2023, Month.SEPTEMBER, 19))) {

            LocalDate startDate = imerominiaYperimeriasInput.getValue();
            LocalDate currentEndDate = LocalDate.of(2023, Month.DECEMBER, 31);

            if (startDate.isBefore(LocalDate.of(2023, Month.SEPTEMBER, 20))) {

                startDate = LocalDate.of(2023, Month.SEPTEMBER, 20);
            }

            if (endDate.isBefore(LocalDate.of(2023, Month.DECEMBER, 31))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateInterestPeriod(poso, 11.75, startDate, currentEndDate);
        }

        if (imerominiaYperimeriasInput.getValue().isBefore(LocalDate.of(2024, Month.JUNE, 11)) && endDate.isAfter(LocalDate.of(2023, Month.DECEMBER, 31))) {

            LocalDate startDate = imerominiaYperimeriasInput.getValue();
            LocalDate currentEndDate = LocalDate.of(2024, Month.JUNE, 11);

            if (startDate.isBefore(LocalDate.of(2024, Month.JANUARY, 1))) {

                startDate = LocalDate.of(2024, Month.JANUARY, 1);
            }

            if (endDate.isBefore(LocalDate.of(2024, Month.JUNE, 11))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateInterestPeriodLeapYear(poso, 11.75, startDate, currentEndDate);
        }

        if (imerominiaYperimeriasInput.getValue().isBefore(LocalDate.of(2024, Month.SEPTEMBER, 17)) && endDate.isAfter(LocalDate.of(2024, Month.JUNE, 11))) {

            LocalDate startDate = imerominiaYperimeriasInput.getValue();
            LocalDate currentEndDate = LocalDate.of(2024, Month.SEPTEMBER, 17);

            if (startDate.isBefore(LocalDate.of(2024, Month.JUNE, 12))) {

                startDate = LocalDate.of(2024, Month.JUNE, 12);
            }

            if (endDate.isBefore(LocalDate.of(2024, Month.SEPTEMBER, 17))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateInterestPeriodLeapYear(poso, 11.50, startDate, currentEndDate);
        }

        if (imerominiaYperimeriasInput.getValue().isBefore(LocalDate.of(2024, Month.OCTOBER, 22)) && endDate.isAfter(LocalDate.of(2024, Month.SEPTEMBER, 17))) {

            LocalDate startDate = imerominiaYperimeriasInput.getValue();
            LocalDate currentEndDate = LocalDate.of(2024, Month.OCTOBER, 22);

            if (startDate.isBefore(LocalDate.of(2024, Month.SEPTEMBER, 18))) {

                startDate = LocalDate.of(2024, Month.SEPTEMBER, 18);
            }

            if (endDate.isBefore(LocalDate.of(2024, Month.OCTOBER, 22))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateInterestPeriodLeapYear(poso, 10.90, startDate, currentEndDate);
        }

        if (imerominiaYperimeriasInput.getValue().isBefore(LocalDate.of(2024, Month.DECEMBER, 17)) && endDate.isAfter(LocalDate.of(2024, Month.OCTOBER, 22))) {

            LocalDate startDate = imerominiaYperimeriasInput.getValue();
            LocalDate currentEndDate = LocalDate.of(2024, Month.DECEMBER, 17);

            if (startDate.isBefore(LocalDate.of(2024, Month.OCTOBER, 23))) {

                startDate = LocalDate.of(2024, Month.OCTOBER, 23);
            }

            if (endDate.isBefore(LocalDate.of(2024, Month.DECEMBER, 17))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateInterestPeriodLeapYear(poso, 10.65, startDate, currentEndDate);
        }

        if (imerominiaYperimeriasInput.getValue().isBefore(LocalDate.of(2024, Month.DECEMBER, 31)) && endDate.isAfter(LocalDate.of(2024, Month.DECEMBER, 17))) {

            LocalDate startDate = imerominiaYperimeriasInput.getValue();
            LocalDate currentEndDate = LocalDate.of(2024, Month.DECEMBER, 31);

            if (startDate.isBefore(LocalDate.of(2024, Month.DECEMBER, 18))) {

                startDate = LocalDate.of(2024, Month.DECEMBER, 18);
            }

            if (endDate.isBefore(LocalDate.of(2024, Month.DECEMBER, 31))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateInterestPeriodLeapYear(poso, 10.40, startDate, currentEndDate);
        }

        if (imerominiaYperimeriasInput.getValue().isBefore(LocalDate.of(2025, Month.FEBRUARY, 4)) && endDate.isAfter(LocalDate.of(2024, Month.DECEMBER, 31))) {

            LocalDate startDate = imerominiaYperimeriasInput.getValue();
            LocalDate currentEndDate = LocalDate.of(2025, Month.FEBRUARY, 4);

            if (startDate.isBefore(LocalDate.of(2025, Month.JANUARY, 1))) {

                startDate = LocalDate.of(2025, Month.JANUARY, 1);
            }

            if (endDate.isBefore(LocalDate.of(2025, Month.FEBRUARY, 4))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateInterestPeriod(poso, 10.40, startDate, currentEndDate);
        }

        if (imerominiaYperimeriasInput.getValue().isBefore(LocalDate.of(2025, Month.MARCH, 11)) && endDate.isAfter(LocalDate.of(2025, Month.FEBRUARY, 4))) {

            LocalDate startDate = imerominiaYperimeriasInput.getValue();
            LocalDate currentEndDate = LocalDate.of(2025, Month.MARCH, 11);

            if (startDate.isBefore(LocalDate.of(2025, Month.FEBRUARY, 5))) {

                startDate = LocalDate.of(2025, Month.FEBRUARY, 5);
            }

            if (endDate.isBefore(LocalDate.of(2025, Month.MARCH, 11))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateInterestPeriod(poso, 10.15, startDate, currentEndDate);
        }

        if (imerominiaYperimeriasInput.getValue().isBefore(LocalDate.of(2025, Month.APRIL, 22)) && endDate.isAfter(LocalDate.of(2025, Month.MARCH, 11))) {

            LocalDate startDate = imerominiaYperimeriasInput.getValue();
            LocalDate currentEndDate = LocalDate.of(2025, Month.APRIL, 22);

            if (startDate.isBefore(LocalDate.of(2025, Month.MARCH, 12))) {

                startDate = LocalDate.of(2025, Month.MARCH, 12);
            }

            if (endDate.isBefore(LocalDate.of(2025, Month.APRIL, 22))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateInterestPeriod(poso, 9.90, startDate, currentEndDate);
        }

        if (imerominiaYperimeriasInput.getValue().isBefore(LocalDate.of(2025, Month.JUNE, 10)) && endDate.isAfter(LocalDate.of(2025, Month.APRIL, 22))) {

            LocalDate startDate = imerominiaYperimeriasInput.getValue();
            LocalDate currentEndDate = LocalDate.of(2025, Month.JUNE, 10);

            if (startDate.isBefore(LocalDate.of(2025, Month.APRIL, 23))) {

                startDate = LocalDate.of(2025, Month.APRIL, 23);
            }

            if (endDate.isBefore(LocalDate.of(2025, Month.JUNE, 10))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateInterestPeriod(poso, 9.65, startDate, currentEndDate);
        }

        if (endDate.isAfter(LocalDate.of(2025, Month.JUNE, 10))) {
            LocalDate startDate = imerominiaYperimeriasInput.getValue();

            if (startDate.isBefore(LocalDate.of(2025, Month.JUNE, 11))) {

                startDate = LocalDate.of(2025, Month.JUNE, 11);
            }
            result += interestCalculator.calculateInterestPeriod(poso, 9.40, startDate, endDate);
        }

        return new BigDecimal(result).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public double getTokoiEpidikiasSyn2(LocalDate imerominiaEpidosis, LocalDate endDate) {

        HelperFunctions funcs = new HelperFunctions();

        double result = 0;
        double poso = funcs.parseGreekDouble(posoInput.getText());

        // ΤΟΚΟΙ ΕΠΙΔΙΚΙΑΣ ΣΥΝ 2
        if (imerominiaEpidosis.isBefore(LocalDate.of(2019, Month.DECEMBER, 31))) {

            LocalDate currentEndDate = LocalDate.of(2019, Month.DECEMBER, 31);

            if (endDate.isBefore(LocalDate.of(2019, Month.DECEMBER, 31))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateEpidikiaSynDyoPeriod(poso, 7.25, imerominiaYperimeriasInput.getValue(), currentEndDate);
        }

        if (imerominiaEpidosis.isBefore(LocalDate.of(2020, Month.NOVEMBER, 6)) &&
                endDate.isAfter(LocalDate.of(2019, Month.DECEMBER, 31))) {

            LocalDate startDate = imerominiaEpidosis;
            LocalDate currentEndDate = LocalDate.of(2020, Month.NOVEMBER, 6);

            if (startDate.isBefore(LocalDate.of(2020, Month.JANUARY, 1))) {

                startDate = LocalDate.of(2020, Month.JANUARY, 1);
            }

            if (endDate.isBefore(LocalDate.of(2020, Month.NOVEMBER, 6))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateEpidikiaSynDyoPeriodLeapYear(poso, 7.25, startDate, currentEndDate);
        }

        // ΔΙΑΣΤΗΜΑ ΑΝΑΣΤΟΛΗΣ ΛΟΓΩ ΚΟΡΩΝΟΪΟΥ
        if (imerominiaEpidosis.isBefore(LocalDate.of(2020, Month.DECEMBER, 31)) &&
                endDate.isAfter(LocalDate.of(2020, Month.NOVEMBER, 6))) {

            LocalDate startDate = imerominiaEpidosis;
            LocalDate currentEndDate = LocalDate.of(2020, Month.DECEMBER, 31);

            if (startDate.isBefore(LocalDate.of(2020, Month.NOVEMBER, 6))) {

                startDate = LocalDate.of(2020, Month.NOVEMBER, 6);
            }

            if (endDate.isBefore(LocalDate.of(2020, Month.DECEMBER, 31))) {

                currentEndDate = endDate;
            }
            // ΒΑΖΟΥΜΕ ΔΥΟ ΜΟΝΑΔΕΣ ΛΙΓΟΤΕΡΟ ΩΣ ΟΡΙΣΜΑ ΤΗΣ ΣΥΝΑΡΤΗΣΗΣ ΩΣΤΕ ΤΟ +2 ΝΑ ΓΙΝΕ 0!
            result += interestCalculator.calculateEpidikiaSynDyoPeriodLeapYear(poso, 7.25 - 2.00, startDate, currentEndDate);
        }

        if (imerominiaEpidosis.isBefore(LocalDate.of(2021, Month.APRIL, 5)) && endDate.isAfter(LocalDate.of(2020, Month.DECEMBER, 31))) {

            LocalDate startDate = imerominiaEpidosis;
            LocalDate currentEndDate = LocalDate.of(2021, Month.APRIL, 5);

            if (startDate.isBefore(LocalDate.of(2021, Month.JANUARY, 1))) {

                startDate = LocalDate.of(2021, Month.JANUARY, 1);
            }

            if (endDate.isBefore(LocalDate.of(2021, Month.APRIL, 5))) {

                currentEndDate = endDate;
            }
            // ΠΑΛΙ ΒΑΖΟΥΜΕ 2 ΛΙΓΟΤΕΡΟ ΓΙΑ ΤΟ ΔΕΥΤΕΡΟ ΜΙΣΟ ΤΟΥ ΔΙΑΣΤΗΜΑΤΟΣ ΤΗΣ ΑΝΑΣΤΟΛΗΣ
            result += interestCalculator.calculateEpidikiaSynDyoPeriod(poso, 7.25 - 2.00, startDate, currentEndDate);
        }

        if (imerominiaEpidosis.isBefore(LocalDate.of(2022, Month.JULY, 26)) && endDate.isAfter(LocalDate.of(2021, Month.APRIL, 5))) {

            LocalDate startDate = imerominiaEpidosis;
            LocalDate currentEndDate = LocalDate.of(2022, Month.JULY, 26);

            if (startDate.isBefore(LocalDate.of(2021, Month.APRIL, 5))) {

                startDate = LocalDate.of(2021, Month.APRIL, 5);
            }

            if (endDate.isBefore(LocalDate.of(2022, Month.JULY, 26))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateEpidikiaSynDyoPeriod(poso, 7.25, startDate, currentEndDate);
        }

        if (imerominiaEpidosis.isBefore(LocalDate.of(2022, Month.SEPTEMBER, 13)) && endDate.isAfter(LocalDate.of(2022, Month.JULY, 26))) {

            LocalDate startDate = imerominiaEpidosis;
            LocalDate currentEndDate = LocalDate.of(2022, Month.SEPTEMBER, 13);

            if (startDate.isBefore(LocalDate.of(2022, Month.JULY, 27))) {

                startDate = LocalDate.of(2022, Month.JULY, 27);
            }

            if (endDate.isBefore(LocalDate.of(2022, Month.SEPTEMBER, 13))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateEpidikiaSynDyoPeriod(poso, 7.75, startDate, currentEndDate);
        }

        if (imerominiaEpidosis.isBefore(LocalDate.of(2022, Month.NOVEMBER, 1)) && endDate.isAfter(LocalDate.of(2022, Month.SEPTEMBER, 13))) {

            LocalDate startDate = imerominiaEpidosis;
            LocalDate currentEndDate = LocalDate.of(2022, Month.NOVEMBER, 1);

            if (startDate.isBefore(LocalDate.of(2022, Month.SEPTEMBER, 14))) {

                startDate = LocalDate.of(2022, Month.SEPTEMBER, 14);
            }

            if (endDate.isBefore(LocalDate.of(2022, Month.NOVEMBER, 1))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateEpidikiaSynDyoPeriod(poso, 8.50, startDate, currentEndDate);
        }

        if (imerominiaEpidosis.isBefore(LocalDate.of(2022, Month.DECEMBER, 20)) && endDate.isAfter(LocalDate.of(2022, Month.NOVEMBER, 1))) {

            LocalDate startDate = imerominiaEpidosis;
            LocalDate currentEndDate = LocalDate.of(2022, Month.DECEMBER, 20);

            if (startDate.isBefore(LocalDate.of(2022, Month.NOVEMBER, 2))) {

                startDate = LocalDate.of(2022, Month.NOVEMBER, 2);
            }

            if (endDate.isBefore(LocalDate.of(2022, Month.DECEMBER, 20))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateEpidikiaSynDyoPeriod(poso, 9.25, startDate, currentEndDate);
        }

        if (imerominiaEpidosis.isBefore(LocalDate.of(2023, Month.FEBRUARY, 7)) && endDate.isAfter(LocalDate.of(2022, Month.DECEMBER, 20))) {

            LocalDate startDate = imerominiaEpidosis;
            LocalDate currentEndDate = LocalDate.of(2023, Month.FEBRUARY, 7);

            if (startDate.isBefore(LocalDate.of(2022, Month.DECEMBER, 21))) {

                startDate = LocalDate.of(2022, Month.DECEMBER, 21);
            }

            if (endDate.isBefore(LocalDate.of(2023, Month.FEBRUARY, 7))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateEpidikiaSynDyoPeriod(poso, 9.75, startDate, currentEndDate);
        }

        if (imerominiaEpidosis.isBefore(LocalDate.of(2023, Month.MARCH, 21)) && endDate.isAfter(LocalDate.of(2023, Month.FEBRUARY, 7))) {

            LocalDate startDate = imerominiaEpidosis;
            LocalDate currentEndDate = LocalDate.of(2023, Month.MARCH, 21);

            if (startDate.isBefore(LocalDate.of(2023, Month.FEBRUARY, 8))) {

                startDate = LocalDate.of(2023, Month.FEBRUARY, 8);
            }

            if (endDate.isBefore(LocalDate.of(2023, Month.MARCH, 21))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateEpidikiaSynDyoPeriod(poso, 10.25, startDate, currentEndDate);
        }

        if (imerominiaEpidosis.isBefore(LocalDate.of(2023, Month.MAY, 9)) && endDate.isAfter(LocalDate.of(2023, Month.MARCH, 21))) {

            LocalDate startDate = imerominiaEpidosis;
            LocalDate currentEndDate = LocalDate.of(2023, Month.MAY, 9);

            if (startDate.isBefore(LocalDate.of(2023, Month.MARCH, 22))) {

                startDate = LocalDate.of(2023, Month.MARCH, 22);
            }

            if (endDate.isBefore(LocalDate.of(2023, Month.MAY, 9))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateEpidikiaSynDyoPeriod(poso, 10.75, startDate, currentEndDate);
        }

        if (imerominiaEpidosis.isBefore(LocalDate.of(2023, Month.JUNE, 20)) && endDate.isAfter(LocalDate.of(2023, Month.MAY, 9))) {

            LocalDate startDate = imerominiaEpidosis;
            LocalDate currentEndDate = LocalDate.of(2023, Month.JUNE, 20);

            if (startDate.isBefore(LocalDate.of(2023, Month.MAY, 10))) {

                startDate = LocalDate.of(2023, Month.MAY, 10);
            }

            if (endDate.isBefore(LocalDate.of(2023, Month.JUNE, 20))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateEpidikiaSynDyoPeriod(poso, 11.00, startDate, currentEndDate);
        }

        if (imerominiaEpidosis.isBefore(LocalDate.of(2023, Month.AUGUST, 1)) && endDate.isAfter(LocalDate.of(2023, Month.JUNE, 20))) {

            LocalDate startDate = imerominiaEpidosis;
            LocalDate currentEndDate = LocalDate.of(2023, Month.AUGUST, 1);

            if (startDate.isBefore(LocalDate.of(2023, Month.JUNE, 21))) {

                startDate = LocalDate.of(2023, Month.JUNE, 21);
            }

            if (endDate.isBefore(LocalDate.of(2023, Month.AUGUST, 1))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateEpidikiaSynDyoPeriod(poso, 11.25, startDate, currentEndDate);
        }

        if (imerominiaEpidosis.isBefore(LocalDate.of(2023, Month.SEPTEMBER, 19)) && endDate.isAfter(LocalDate.of(2023, Month.AUGUST, 1))) {

            LocalDate startDate = imerominiaEpidosis;
            LocalDate currentEndDate = LocalDate.of(2023, Month.SEPTEMBER, 19);

            if (startDate.isBefore(LocalDate.of(2023, Month.AUGUST, 2))) {

                startDate = LocalDate.of(2023, Month.AUGUST, 2);
            }

            if (endDate.isBefore(LocalDate.of(2023, Month.SEPTEMBER, 19))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateEpidikiaSynDyoPeriod(poso, 11.50, startDate, currentEndDate);
        }

        if (imerominiaEpidosis.isBefore(LocalDate.of(2023, Month.DECEMBER, 31)) && endDate.isAfter(LocalDate.of(2023, Month.SEPTEMBER, 19))) {

            LocalDate startDate = imerominiaEpidosis;
            LocalDate currentEndDate = LocalDate.of(2023, Month.DECEMBER, 31);

            if (startDate.isBefore(LocalDate.of(2023, Month.SEPTEMBER, 20))) {

                startDate = LocalDate.of(2023, Month.SEPTEMBER, 20);
            }

            if (endDate.isBefore(LocalDate.of(2023, Month.DECEMBER, 31))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateEpidikiaSynDyoPeriod(poso, 11.75, startDate, currentEndDate);
        }

        if (imerominiaEpidosis.isBefore(LocalDate.of(2024, Month.JUNE, 11)) && endDate.isAfter(LocalDate.of(2023, Month.DECEMBER, 31))) {

            LocalDate startDate = imerominiaEpidosis;
            LocalDate currentEndDate = LocalDate.of(2024, Month.JUNE, 11);

            if (startDate.isBefore(LocalDate.of(2024, Month.JANUARY, 1))) {

                startDate = LocalDate.of(2024, Month.JANUARY, 1);
            }

            if (endDate.isBefore(LocalDate.of(2024, Month.JUNE, 11))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateEpidikiaSynDyoPeriodLeapYear(poso, 11.75, startDate, currentEndDate);
        }

        if (imerominiaEpidosis.isBefore(LocalDate.of(2024, Month.SEPTEMBER, 17)) && endDate.isAfter(LocalDate.of(2024, Month.JUNE, 11))) {

            LocalDate startDate = imerominiaEpidosis;
            LocalDate currentEndDate = LocalDate.of(2024, Month.SEPTEMBER, 17);

            if (startDate.isBefore(LocalDate.of(2024, Month.JUNE, 12))) {

                startDate = LocalDate.of(2024, Month.JUNE, 12);
            }

            if (endDate.isBefore(LocalDate.of(2024, Month.SEPTEMBER, 17))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateEpidikiaSynDyoPeriodLeapYear(poso, 11.50, startDate, currentEndDate);
        }

        if (imerominiaEpidosis.isBefore(LocalDate.of(2024, Month.OCTOBER, 22)) && endDate.isAfter(LocalDate.of(2024, Month.SEPTEMBER, 17))) {

            LocalDate startDate = imerominiaEpidosis;
            LocalDate currentEndDate = LocalDate.of(2024, Month.OCTOBER, 22);

            if (startDate.isBefore(LocalDate.of(2024, Month.SEPTEMBER, 18))) {

                startDate = LocalDate.of(2024, Month.SEPTEMBER, 18);
            }

            if (endDate.isBefore(LocalDate.of(2024, Month.OCTOBER, 22))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateEpidikiaSynDyoPeriodLeapYear(poso, 10.90, startDate, currentEndDate);
        }

        if (imerominiaEpidosis.isBefore(LocalDate.of(2024, Month.DECEMBER, 17)) && endDate.isAfter(LocalDate.of(2024, Month.OCTOBER, 22))) {

            LocalDate startDate = imerominiaEpidosis;
            LocalDate currentEndDate = LocalDate.of(2024, Month.DECEMBER, 17);

            if (startDate.isBefore(LocalDate.of(2024, Month.OCTOBER, 23))) {

                startDate = LocalDate.of(2024, Month.OCTOBER, 23);
            }

            if (endDate.isBefore(LocalDate.of(2024, Month.DECEMBER, 17))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateEpidikiaSynDyoPeriodLeapYear(poso, 10.65, startDate, currentEndDate);
        }

        if (imerominiaEpidosis.isBefore(LocalDate.of(2024, Month.DECEMBER, 31)) && endDate.isAfter(LocalDate.of(2024, Month.DECEMBER, 17))) {

            LocalDate startDate = imerominiaEpidosis;
            LocalDate currentEndDate = LocalDate.of(2024, Month.DECEMBER, 31);

            if (startDate.isBefore(LocalDate.of(2024, Month.DECEMBER, 18))) {

                startDate = LocalDate.of(2024, Month.DECEMBER, 18);
            }

            if (endDate.isBefore(LocalDate.of(2024, Month.DECEMBER, 31))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateEpidikiaSynDyoPeriodLeapYear(poso, 10.40, startDate, currentEndDate);
        }

        if (imerominiaEpidosis.isBefore(LocalDate.of(2025, Month.FEBRUARY, 4)) && endDate.isAfter(LocalDate.of(2024, Month.DECEMBER, 31))) {

            LocalDate startDate = imerominiaEpidosis;
            LocalDate currentEndDate = LocalDate.of(2025, Month.FEBRUARY, 4);

            if (startDate.isBefore(LocalDate.of(2025, Month.JANUARY, 1))) {

                startDate = LocalDate.of(2025, Month.JANUARY, 1);
            }

            if (endDate.isBefore(LocalDate.of(2025, Month.FEBRUARY, 4))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateEpidikiaSynDyoPeriod(poso, 10.40, startDate, currentEndDate);
        }

        if (imerominiaEpidosis.isBefore(LocalDate.of(2025, Month.MARCH, 11)) && endDate.isAfter(LocalDate.of(2025, Month.FEBRUARY, 4))) {

            LocalDate startDate = imerominiaEpidosis;
            LocalDate currentEndDate = LocalDate.of(2025, Month.MARCH, 11);

            if (startDate.isBefore(LocalDate.of(2025, Month.FEBRUARY, 5))) {

                startDate = LocalDate.of(2025, Month.FEBRUARY, 5);
            }

            if (endDate.isBefore(LocalDate.of(2025, Month.MARCH, 11))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateEpidikiaSynDyoPeriod(poso, 10.15, startDate, currentEndDate);
        }

        if (imerominiaEpidosis.isBefore(LocalDate.of(2025, Month.APRIL, 22)) && endDate.isAfter(LocalDate.of(2025, Month.MARCH, 11))) {

            LocalDate startDate = imerominiaEpidosis;
            LocalDate currentEndDate = LocalDate.of(2025, Month.APRIL, 22);

            if (startDate.isBefore(LocalDate.of(2025, Month.MARCH, 12))) {

                startDate = LocalDate.of(2025, Month.MARCH, 12);
            }

            if (endDate.isBefore(LocalDate.of(2025, Month.APRIL, 22))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateEpidikiaSynDyoPeriod(poso, 9.90, startDate, currentEndDate);
        }

        if (imerominiaEpidosis.isBefore(LocalDate.of(2025, Month.JUNE, 10)) && endDate.isAfter(LocalDate.of(2025, Month.APRIL, 22))) {

            LocalDate startDate = imerominiaEpidosis;
            LocalDate currentEndDate = LocalDate.of(2025, Month.JUNE, 10);

            if (startDate.isBefore(LocalDate.of(2025, Month.APRIL, 23))) {

                startDate = LocalDate.of(2025, Month.APRIL, 23);
            }

            if (endDate.isBefore(LocalDate.of(2025, Month.JUNE, 10))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateEpidikiaSynDyoPeriod(poso, 9.65, startDate, currentEndDate);
        }

        if (endDate.isAfter(LocalDate.of(2025, Month.JUNE, 10))) {
            LocalDate startDate = imerominiaEpidosis;

            if (startDate.isBefore(LocalDate.of(2025, Month.JUNE, 11))) {

                startDate = LocalDate.of(2025, Month.JUNE, 11);
            }
            result += interestCalculator.calculateEpidikiaSynDyoPeriod(poso, 9.40, startDate, endDate);
        }

        return new BigDecimal(result).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public double getTokoiEpidikiasSyn3(LocalDate imerominiaDimosieusis, LocalDate endDate) {

        HelperFunctions funcs = new HelperFunctions();

        double result = 0;
        double poso = funcs.parseGreekDouble(posoInput.getText());

        // ΤΟΚΟΙ ΕΠΙΔΙΚΙΑΣ ΣΥΝ 3
        if (imerominiaDimosieusis.isBefore(LocalDate.of(2019, Month.DECEMBER, 31))) {

            LocalDate currentEndDate = LocalDate.of(2019, Month.DECEMBER, 31);

            if (endDate.isBefore(LocalDate.of(2019, Month.DECEMBER, 31))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateEpidikiaSynTriaPeriod(poso, 7.25, imerominiaDimosieusis, currentEndDate);
        }

        if (imerominiaDimosieusis.isBefore(LocalDate.of(2020, Month.NOVEMBER, 6)) && endDate.isAfter(LocalDate.of(2019, Month.DECEMBER, 31))) {

            LocalDate startDate = imerominiaDimosieusis;
            LocalDate currentEndDate = LocalDate.of(2020, Month.NOVEMBER, 6);

            if (startDate.isBefore(LocalDate.of(2020, Month.JANUARY, 1))) {

                startDate = LocalDate.of(2020, Month.JANUARY, 1);
            }

            if (endDate.isBefore(LocalDate.of(2020, Month.NOVEMBER, 6))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateEpidikiaSynTriaPeriodLeapYear(poso, 7.25, startDate, currentEndDate);
        }

        // ΔΙΑΣΤΗΜΑ ΑΝΑΣΤΟΛΗΣ ΛΟΓΩ COVID
        if (imerominiaDimosieusis.isBefore(LocalDate.of(2020, Month.DECEMBER, 31)) && endDate.isAfter(LocalDate.of(2020, Month.NOVEMBER, 6))) {

            LocalDate startDate = imerominiaDimosieusis;
            LocalDate currentEndDate = LocalDate.of(2020, Month.DECEMBER, 31);

            if (startDate.isBefore(LocalDate.of(2020, Month.NOVEMBER, 6))) {

                startDate = LocalDate.of(2020, Month.NOVEMBER, 6);
            }

            if (endDate.isBefore(LocalDate.of(2020, Month.DECEMBER, 31))) {

                currentEndDate = endDate;
            }
            // ΑΦΑΙΡΟΥΜΕ ΤΡΕΙΣ ΜΟΝΑΔΕΣ ΩΣΤΕ ΤΟ +3 ΝΑ ΓΙΝΕΙ 0
            result += interestCalculator.calculateEpidikiaSynTriaPeriodLeapYear(poso, 7.25 - 3.00, startDate, currentEndDate);
        }

        if (imerominiaDimosieusis.isBefore(LocalDate.of(2021, Month.APRIL, 5)) && endDate.isAfter(LocalDate.of(2020, Month.DECEMBER, 31))) {

            LocalDate startDate = imerominiaDimosieusis;
            LocalDate currentEndDate = LocalDate.of(2021, Month.APRIL, 5);

            if (startDate.isBefore(LocalDate.of(2021, Month.JANUARY, 1))) {

                startDate = LocalDate.of(2021, Month.JANUARY, 1);
            }

            if (endDate.isBefore(LocalDate.of(2021, Month.APRIL, 5))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateEpidikiaSynTriaPeriodLeapYear(poso, 7.25 - 3.00, startDate, currentEndDate);
        }

        if (imerominiaDimosieusis.isBefore(LocalDate.of(2022, Month.JULY, 26)) && endDate.isAfter(LocalDate.of(2021, Month.APRIL, 5))) {

            LocalDate startDate = imerominiaDimosieusis;
            LocalDate currentEndDate = LocalDate.of(2022, Month.JULY, 26);

            if (startDate.isBefore(LocalDate.of(2021, Month.APRIL, 5))) {

                startDate = LocalDate.of(2021, Month.APRIL, 5);
            }

            if (endDate.isBefore(LocalDate.of(2022, Month.JULY, 26))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateEpidikiaSynTriaPeriod(poso, 7.25, startDate, currentEndDate);
        }

        if (imerominiaDimosieusis.isBefore(LocalDate.of(2022, Month.SEPTEMBER, 13)) && endDate.isAfter(LocalDate.of(2022, Month.JULY, 26))) {

            LocalDate startDate = imerominiaDimosieusis;
            LocalDate currentEndDate = LocalDate.of(2022, Month.SEPTEMBER, 13);

            if (startDate.isBefore(LocalDate.of(2022, Month.JULY, 27))) {

                startDate = LocalDate.of(2022, Month.JULY, 27);
            }

            if (endDate.isBefore(LocalDate.of(2022, Month.SEPTEMBER, 13))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateEpidikiaSynTriaPeriod(poso, 7.75, startDate, currentEndDate);
        }

        if (imerominiaDimosieusis.isBefore(LocalDate.of(2022, Month.NOVEMBER, 1)) && endDate.isAfter(LocalDate.of(2022, Month.SEPTEMBER, 13))) {

            LocalDate startDate = imerominiaDimosieusis;
            LocalDate currentEndDate = LocalDate.of(2022, Month.NOVEMBER, 1);

            if (startDate.isBefore(LocalDate.of(2022, Month.SEPTEMBER, 14))) {

                startDate = LocalDate.of(2022, Month.SEPTEMBER, 14);
            }

            if (endDate.isBefore(LocalDate.of(2022, Month.NOVEMBER, 1))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateEpidikiaSynTriaPeriod(poso, 8.50, startDate, currentEndDate);
        }

        if (imerominiaDimosieusis.isBefore(LocalDate.of(2022, Month.DECEMBER, 20)) && endDate.isAfter(LocalDate.of(2022, Month.NOVEMBER, 1))) {

            LocalDate startDate = imerominiaDimosieusis;
            LocalDate currentEndDate = LocalDate.of(2022, Month.DECEMBER, 20);

            if (startDate.isBefore(LocalDate.of(2022, Month.NOVEMBER, 2))) {

                startDate = LocalDate.of(2022, Month.NOVEMBER, 2);
            }

            if (endDate.isBefore(LocalDate.of(2022, Month.DECEMBER, 20))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateEpidikiaSynTriaPeriod(poso, 9.25, startDate, currentEndDate);
        }

        if (imerominiaDimosieusis.isBefore(LocalDate.of(2023, Month.FEBRUARY, 7)) && endDate.isAfter(LocalDate.of(2022, Month.DECEMBER, 20))) {

            LocalDate startDate = imerominiaDimosieusis;
            LocalDate currentEndDate = LocalDate.of(2023, Month.FEBRUARY, 7);

            if (startDate.isBefore(LocalDate.of(2022, Month.DECEMBER, 21))) {

                startDate = LocalDate.of(2022, Month.DECEMBER, 21);
            }

            if (endDate.isBefore(LocalDate.of(2023, Month.FEBRUARY, 7))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateEpidikiaSynTriaPeriod(poso, 9.75, startDate, currentEndDate);
        }

        if (imerominiaDimosieusis.isBefore(LocalDate.of(2023, Month.MARCH, 21)) && endDate.isAfter(LocalDate.of(2023, Month.FEBRUARY, 7))) {

            LocalDate startDate = imerominiaDimosieusis;
            LocalDate currentEndDate = LocalDate.of(2023, Month.MARCH, 21);

            if (startDate.isBefore(LocalDate.of(2023, Month.FEBRUARY, 8))) {

                startDate = LocalDate.of(2023, Month.FEBRUARY, 8);
            }

            if (endDate.isBefore(LocalDate.of(2023, Month.MARCH, 21))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateEpidikiaSynTriaPeriod(poso, 10.25, startDate, currentEndDate);
        }

        if (imerominiaDimosieusis.isBefore(LocalDate.of(2023, Month.MAY, 9)) && endDate.isAfter(LocalDate.of(2023, Month.MARCH, 21))) {

            LocalDate startDate = imerominiaDimosieusis;
            LocalDate currentEndDate = LocalDate.of(2023, Month.MAY, 9);

            if (startDate.isBefore(LocalDate.of(2023, Month.MARCH, 22))) {

                startDate = LocalDate.of(2023, Month.MARCH, 22);
            }

            if (endDate.isBefore(LocalDate.of(2023, Month.MAY, 9))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateEpidikiaSynTriaPeriod(poso, 10.75, startDate, currentEndDate);
        }

        if (imerominiaDimosieusis.isBefore(LocalDate.of(2023, Month.JUNE, 20)) && endDate.isAfter(LocalDate.of(2023, Month.MAY, 9))) {

            LocalDate startDate = imerominiaDimosieusis;
            LocalDate currentEndDate = LocalDate.of(2023, Month.JUNE, 20);

            if (startDate.isBefore(LocalDate.of(2023, Month.MAY, 10))) {

                startDate = LocalDate.of(2023, Month.MAY, 10);
            }

            if (endDate.isBefore(LocalDate.of(2023, Month.JUNE, 20))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateEpidikiaSynTriaPeriod(poso, 11.00, startDate, currentEndDate);
        }

        if (imerominiaDimosieusis.isBefore(LocalDate.of(2023, Month.AUGUST, 1)) && endDate.isAfter(LocalDate.of(2023, Month.JUNE, 20))) {

            LocalDate startDate = imerominiaDimosieusis;
            LocalDate currentEndDate = LocalDate.of(2023, Month.AUGUST, 1);

            if (startDate.isBefore(LocalDate.of(2023, Month.JUNE, 21))) {

                startDate = LocalDate.of(2023, Month.JUNE, 21);
            }

            if (endDate.isBefore(LocalDate.of(2023, Month.AUGUST, 1))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateEpidikiaSynTriaPeriod(poso, 11.25, startDate, currentEndDate);
        }

        if (imerominiaDimosieusis.isBefore(LocalDate.of(2023, Month.SEPTEMBER, 19)) && endDate.isAfter(LocalDate.of(2023, Month.AUGUST, 1))) {

            LocalDate startDate = imerominiaDimosieusis;
            LocalDate currentEndDate = LocalDate.of(2023, Month.SEPTEMBER, 19);

            if (startDate.isBefore(LocalDate.of(2023, Month.AUGUST, 2))) {

                startDate = LocalDate.of(2023, Month.AUGUST, 2);
            }

            if (endDate.isBefore(LocalDate.of(2023, Month.SEPTEMBER, 19))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateEpidikiaSynTriaPeriod(poso, 11.50, startDate, currentEndDate);
        }

        if (imerominiaDimosieusis.isBefore(LocalDate.of(2023, Month.DECEMBER, 31)) && endDate.isAfter(LocalDate.of(2023, Month.SEPTEMBER, 19))) {

            LocalDate startDate = imerominiaDimosieusis;
            LocalDate currentEndDate = LocalDate.of(2023, Month.DECEMBER, 31);

            if (startDate.isBefore(LocalDate.of(2023, Month.SEPTEMBER, 20))) {

                startDate = LocalDate.of(2023, Month.SEPTEMBER, 20);
            }

            if (endDate.isBefore(LocalDate.of(2023, Month.DECEMBER, 31))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateEpidikiaSynTriaPeriod(poso, 11.75, startDate, currentEndDate);
        }

        if (imerominiaDimosieusis.isBefore(LocalDate.of(2024, Month.JUNE, 11)) && endDate.isAfter(LocalDate.of(2023, Month.DECEMBER, 31))) {

            LocalDate startDate = imerominiaDimosieusis;
            LocalDate currentEndDate = LocalDate.of(2024, Month.JUNE, 11);

            if (startDate.isBefore(LocalDate.of(2024, Month.JANUARY, 1))) {

                startDate = LocalDate.of(2024, Month.JANUARY, 1);
            }

            if (endDate.isBefore(LocalDate.of(2024, Month.JUNE, 11))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateEpidikiaSynTriaPeriodLeapYear(poso, 11.75, startDate, currentEndDate);
        }

        if (imerominiaDimosieusis.isBefore(LocalDate.of(2024, Month.SEPTEMBER, 17)) && endDate.isAfter(LocalDate.of(2024, Month.JUNE, 11))) {

            LocalDate startDate = imerominiaDimosieusis;
            LocalDate currentEndDate = LocalDate.of(2024, Month.SEPTEMBER, 17);

            if (startDate.isBefore(LocalDate.of(2024, Month.JUNE, 12))) {

                startDate = LocalDate.of(2024, Month.JUNE, 12);
            }

            if (endDate.isBefore(LocalDate.of(2024, Month.SEPTEMBER, 17))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateEpidikiaSynTriaPeriodLeapYear(poso, 11.50, startDate, currentEndDate);
        }

        if (imerominiaDimosieusis.isBefore(LocalDate.of(2024, Month.OCTOBER, 22)) && endDate.isAfter(LocalDate.of(2024, Month.SEPTEMBER, 17))) {

            LocalDate startDate = imerominiaDimosieusis;
            LocalDate currentEndDate = LocalDate.of(2024, Month.OCTOBER, 22);

            if (startDate.isBefore(LocalDate.of(2024, Month.SEPTEMBER, 18))) {

                startDate = LocalDate.of(2024, Month.SEPTEMBER, 18);
            }

            if (endDate.isBefore(LocalDate.of(2024, Month.OCTOBER, 22))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateEpidikiaSynTriaPeriodLeapYear(poso, 10.90, startDate, currentEndDate);
        }

        if (imerominiaDimosieusis.isBefore(LocalDate.of(2024, Month.DECEMBER, 17)) && endDate.isAfter(LocalDate.of(2024, Month.OCTOBER, 22))) {

            LocalDate startDate = imerominiaDimosieusis;
            LocalDate currentEndDate = LocalDate.of(2024, Month.DECEMBER, 17);

            if (startDate.isBefore(LocalDate.of(2024, Month.OCTOBER, 23))) {

                startDate = LocalDate.of(2024, Month.OCTOBER, 23);
            }

            if (endDate.isBefore(LocalDate.of(2024, Month.DECEMBER, 17))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateEpidikiaSynTriaPeriodLeapYear(poso, 10.65, startDate, currentEndDate);
        }

        if (imerominiaDimosieusis.isBefore(LocalDate.of(2024, Month.DECEMBER, 31)) && endDate.isAfter(LocalDate.of(2024, Month.DECEMBER, 17))) {

            LocalDate startDate = imerominiaDimosieusis;
            LocalDate currentEndDate = LocalDate.of(2024, Month.DECEMBER, 31);

            if (startDate.isBefore(LocalDate.of(2024, Month.DECEMBER, 18))) {

                startDate = LocalDate.of(2024, Month.DECEMBER, 18);
            }

            if (endDate.isBefore(LocalDate.of(2024, Month.DECEMBER, 31))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateEpidikiaSynTriaPeriodLeapYear(poso, 10.40, startDate, currentEndDate);
        }

        if (imerominiaDimosieusis.isBefore(LocalDate.of(2025, Month.FEBRUARY, 4)) && endDate.isAfter(LocalDate.of(2024, Month.DECEMBER, 31))) {

            LocalDate startDate = imerominiaDimosieusis;
            LocalDate currentEndDate = LocalDate.of(2025, Month.FEBRUARY, 4);

            if (startDate.isBefore(LocalDate.of(2025, Month.JANUARY, 1))) {

                startDate = LocalDate.of(2025, Month.JANUARY, 1);
            }

            if (endDate.isBefore(LocalDate.of(2025, Month.FEBRUARY, 4))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateEpidikiaSynTriaPeriod(poso, 10.40, startDate, currentEndDate);
        }

        if (imerominiaDimosieusis.isBefore(LocalDate.of(2025, Month.MARCH, 11)) && endDate.isAfter(LocalDate.of(2025, Month.FEBRUARY, 4))) {

            LocalDate startDate = imerominiaDimosieusis;
            LocalDate currentEndDate = LocalDate.of(2025, Month.MARCH, 11);

            if (startDate.isBefore(LocalDate.of(2025, Month.FEBRUARY, 5))) {

                startDate = LocalDate.of(2025, Month.FEBRUARY, 5);
            }

            if (endDate.isBefore(LocalDate.of(2025, Month.MARCH, 11))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateEpidikiaSynTriaPeriod(poso, 10.15, startDate, currentEndDate);
        }

        if (imerominiaDimosieusis.isBefore(LocalDate.of(2025, Month.APRIL, 22)) && endDate.isAfter(LocalDate.of(2025, Month.MARCH, 11))) {

            LocalDate startDate = imerominiaDimosieusis;
            LocalDate currentEndDate = LocalDate.of(2025, Month.APRIL, 22);

            if (startDate.isBefore(LocalDate.of(2025, Month.MARCH, 12))) {

                startDate = LocalDate.of(2025, Month.MARCH, 12);
            }

            if (endDate.isBefore(LocalDate.of(2025, Month.APRIL, 22))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateEpidikiaSynTriaPeriod(poso, 9.90, startDate, currentEndDate);
        }

        if (imerominiaDimosieusis.isBefore(LocalDate.of(2025, Month.JUNE, 10)) && endDate.isAfter(LocalDate.of(2025, Month.APRIL, 22))) {

            LocalDate startDate = imerominiaDimosieusis;
            LocalDate currentEndDate = LocalDate.of(2025, Month.JUNE, 10);

            if (startDate.isBefore(LocalDate.of(2025, Month.APRIL, 23))) {

                startDate = LocalDate.of(2025, Month.APRIL, 23);
            }

            if (endDate.isBefore(LocalDate.of(2025, Month.JUNE, 10))) {

                currentEndDate = endDate;
            }
            result += interestCalculator.calculateEpidikiaSynTriaPeriod(poso, 9.65, startDate, currentEndDate);
        }

        if (endDate.isAfter(LocalDate.of(2025, Month.JUNE, 10))) {
            LocalDate startDate = imerominiaDimosieusis;

            if (startDate.isBefore(LocalDate.of(2025, Month.JUNE, 11))) {

                startDate = LocalDate.of(2025, Month.JUNE, 11);
            }
            result += interestCalculator.calculateEpidikiaSynTriaPeriod(poso, 9.40, startDate, endDate);
        }

        return new BigDecimal(result).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public TextField getPosoInput() {
        return posoInput;
    }

    public DatePicker getImerominiaYperimeriasInput() {
        return imerominiaYperimeriasInput;
    }
}
