package ru.aristov.binaryscrambler;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MainController {
    @FXML
    private Button btnClear;

    @FXML
    private Button btnScramble;

    @FXML
    private ComboBox<String> inputFormula;

    @FXML
    private Label incorrectMassage;

    @FXML
    private TextField inputSequence;

    @FXML
    private Label inputStr;

    @FXML
    private Label scramblerStr;

    @FXML
    private Label descramblerStr;

    @FXML
    private Label countUnits;

    @FXML
    private Label countZero;

    @FXML
    void initialize() {
        ObservableList<String> scrambleFormulaCollection = FXCollections.observableArrayList("1. B(i) = А(i) ⊕ B(i-3) ⊕ B(i-5)", "2. B(i) = А(i) ⊕ B(i-2) ⊕ B(i-3)");

        inputFormula.setStyle("-fx-font-size: 15; -fx-font-weight: bold");
        inputFormula.setItems(scrambleFormulaCollection);
        inputFormula.setValue("1. B(i) = А(i) ⊕ B(i-3) ⊕ B(i-5)");

        btnScramble.setOnAction(actionEvent -> {
            String inputSequenceStr = inputSequence.getText();
            if (inputSequence.getText() == null || inputSequence.getText().trim().isEmpty()) {
                incorrectMassage.setText("Введите последовательность!");
            } else {
                String[] inputSequenceStrArr = inputSequenceStr.split("");
                String[] inputFormilaNum = inputFormula.getValue().split("\\.");

                boolean correction = true;
                for (int i = 0; i < inputSequenceStrArr.length; i++) {
                    if ((Integer.parseInt(inputSequenceStrArr[i]) != 0) && (Integer.parseInt(inputSequenceStrArr[i]) != 1)) {
                        correction = false;
                    }
                }

                if (correction) {
                    if (Integer.parseInt(inputFormilaNum[0]) == 1) {
                        incorrectMassage.setText("");
                        inputStr.setText(inputSequenceStr);
                        scramblerStr.setText(MainApplication.arrayToString(Scrambler.scrambler_1(inputSequenceStr)));
                        descramblerStr.setText(MainApplication.arrayToString(Scrambler.descrambler_1(Scrambler.scrambler_1(inputSequenceStr))));

                        int[] statisticSequence = Scrambler.UnitZeroStatistic(Scrambler.scrambler_1(inputSequenceStr));
                        countUnits.setText("Максимальное количество подряд идущих единиц:  " + String.valueOf(statisticSequence[1]));
                        countZero.setText("Максимальное количество подряд идущих нулей: " + String.valueOf(statisticSequence[0]));
                    } else if (Integer.parseInt(inputFormilaNum[0]) == 2) {
                        incorrectMassage.setText("");
                        inputStr.setText(inputSequenceStr);
                        scramblerStr.setText(MainApplication.arrayToString(Scrambler.scrambler_2(inputSequenceStr)));
                        descramblerStr.setText(MainApplication.arrayToString(Scrambler.descrambler_2(Scrambler.scrambler_2(inputSequenceStr))));

                        int[] statisticSequence = Scrambler.UnitZeroStatistic(Scrambler.scrambler_2(inputSequenceStr));
                        countUnits.setText("Максимальное количество подряд идущих единиц:  " + String.valueOf(statisticSequence[1]));
                        countZero.setText("Максимальное количество подряд идущих нулей: " + String.valueOf(statisticSequence[0]));
                    }
                } else {
                    incorrectMassage.setText("Введите корректную последовательность!");
                    inputSequence.clear();
                    inputFormula.setValue("1. B(i) = А(i) ⊕ B(i-3) ⊕ B(i-5)");
                }
            }
        });

        btnClear.setOnAction(actionEvent -> {
            inputSequence.clear();
            inputFormula.setValue("1. B(i) = А(i) ⊕ B(i-3) ⊕ B(i-5)");

            incorrectMassage.setText("");

            inputStr.setText(" ");
            scramblerStr.setText(" ");
            descramblerStr.setText(" ");
            countUnits.setText("Максимальное количество подряд идущих единиц:  ");
            countZero.setText("Максимальное количество подряд идущих нулей: ");
        });
    }
}