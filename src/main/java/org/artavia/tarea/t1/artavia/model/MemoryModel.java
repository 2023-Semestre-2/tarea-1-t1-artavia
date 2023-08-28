package org.artavia.tarea.t1.artavia.model;

import java.util.Map;
import java.util.HashMap;
import java.util.Random;

/** This class represents the memory of this minicomputer, assembly instructions will be stored. */
public class MemoryModel {

  /**
   * This will be the memory of the program, the HashMap helps to use the keys as numeric positions
   * and the value for the content of the assembler instructions.
   */
  private Map<Integer, String> programMemory;

  /** Constructor that initializes the memory with 100 addresses with " " value. */
  public MemoryModel() {
    programMemory = new HashMap<>();
    initializeProgramMemory();
  }

  /** Function that takes an empty memory and assigns 100 addresses with value " " to it. */
  private void initializeProgramMemory() {
    for (int i = 0; i < 100; i++) {
      programMemory.put(i, " ");
    }
  }

  /**
   * Gets the memory.
   *
   * @return Program memory.
   */
  public Map<Integer, String> getProgramMemory() {
    return programMemory;
  }

  /**
   * Sets the memory.
   *
   * @param programMemory.
   */
  public void setProgramMemory(Map<Integer, String> programMemory) {
    this.programMemory = programMemory;
  }

  /**
   * Asigns randoms locations to instructions.
   *
   * @param instruction.
   * @param programMemory.
   * @param instructionsLength.
   */
  public void asignRandomAddress(
      String instruction, Map<Integer, String> programMemory, int instructionsLength) {

    // Boolean to check if memory is empty
    boolean isMemoryEmpty = true;
    for (String value : programMemory.values()) {
      if (!value.equals(" ")) {
        isMemoryEmpty = false;
        break;
      }
    }

    String lastPositionInstruction = " ";

    // If memory is empty asigns a random address, otherwise asigns next intruction in order
    if (!isMemoryEmpty) {
      for (Integer address : programMemory.keySet()) {
        if (programMemory.get(address).equals(" ") && !lastPositionInstruction.equals(" ")) {
          programMemory.put(address, instruction);
          break;
        }
        lastPositionInstruction = programMemory.get(address);
      }
    } else {
      getInitialAddress(instruction, programMemory, instructionsLength);
    }
  }

  /**
   * Asigns instruction to initial random location .
   *
   * @param instruction.
   * @param programMemory.
   * @param instructionsLength.
   */
  private void getInitialAddress(
      String instruction, Map<Integer, String> programMemory, int instructionsLength) {

    Random random = new Random();
    int minAddress = 10;
    int maxAdreess = 100 - instructionsLength;

    if (maxAdreess < minAddress) {
      System.out.println("No hay suficiente espacio para las instrucciones.");
      return;
    }

    int randomAddress = random.nextInt(maxAdreess - minAddress + 1) + minAddress;
    System.out.println(randomAddress);
    programMemory.put(randomAddress, instruction);
  }

  /**
   * Clears the memory with " " values.
   *
   * @param programMemory.
   */
  public void clearProgramMemory(Map<Integer, String> programMemory) {

    for (Integer address : programMemory.keySet()) {
      programMemory.put(address, " ");
    }
  }

  /** Prints all the memory keys and values in terminal. */
  private void printMemoryTerminal() {
    for (Integer address : programMemory.keySet()) {
      System.out.println("Address: " + address + " | Instruction: " + programMemory.get(address));
    }
  }
}
