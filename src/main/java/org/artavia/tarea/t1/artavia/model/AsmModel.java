package org.artavia.tarea.t1.artavia.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/** This class represents the asm file that is loaded. */
public class AsmModel {
  /** This is where the asm file lines are stored . */
  private List<String> instructions;

  /** Main constructor . */
  public AsmModel() {
    instructions = new ArrayList<>();
  }

  /** Constructor with file path . */
  public AsmModel(String filepath) {
    instructions = new ArrayList<>();
    loadAsmFile(filepath);
  }

  /**
   * Gets the instructions.
   *
   * @return Instructions list.
   */
  public List<String> getInstructions() {
    return instructions;
  }

  /**
   * Sets the instructions.
   *
   * @param instruction .
   */
  public void setInstructions(List<String> instruction) {
    this.instructions = instruction;
  }

  /** Prints the list on terminal. */
  public void printInstructionsTerminal() {
    for (String instruction : instructions) {
      System.out.println(instruction);
    }
  }

  /**
   * Loads an asm file given a file path.
   *
   * @param filePath
   */
  public void loadAsmFile(String filePath) {

    if (!filePath.toLowerCase().endsWith(".asm")) {
      System.out.println("Error: this is not a .asm file.");
      return;
    }

    try {
      List<String> lines = Files.readAllLines(Paths.get(filePath));
      int numberOfLines = lines.size();

      for (int i = 0; i < numberOfLines; i++) {
        String line = lines.get(i);
        if (validateInstruction(line)) {
          instructions.add(line);
        } else {
          System.out.println("Line " + (i + 1) + " invalid: " + line);
        }
      }
    } catch (IOException e) {
      System.out.println("Error with asm file load: " + e.getMessage());
    }
  }

  /**
   * Validates if an instruction follows the asm rules given.
   *
   * @param instruction
   */
  private boolean validateInstruction(String instruction) {

    boolean operatorBoolean = false;
    boolean registerBoolean = false;
    String[] validOperators = {"load", "store", "mov", "sub", "add"};
    String[] validRegisters = {"ax", "bx", "cx", "dx"};

    // If instruction is empty or has more than for 3 words.
    String[] instructionSplited = instruction.split(" ");
    if (instruction.length() == 0 || instructionSplited.length >= 4) {
      return false;
    }

    // Verifies valid operator name.
    String instructionOperator = instructionSplited[0].toLowerCase();
    for (String validOp : validOperators) {
      if (instructionOperator.startsWith(validOp)) {
        operatorBoolean = true;
      }
    }

    // Verifies valid register name.
    String instructionRegister = instructionSplited[1].toLowerCase();
    for (String validReg : validRegisters) {
      if (instructionRegister.startsWith(validReg)) {
        registerBoolean = true;
      }
    }

    // Verifies that the MOV operator and its number is correct.
    if (instructionSplited.length == 3 && instructionOperator.equals("MOV")
        || instructionOperator.equals("mov")) {

      String instructionInt = instructionSplited[2];
      try {
        Integer.parseInt(instructionInt);
        return true;
      } catch (NumberFormatException e) {
        return false;
      }
    }

    if (operatorBoolean && registerBoolean && instructionSplited.length == 2) {
      return true;

    } else {
      return false;
    }
  }
}
