package org.artavia.tarea.t1.artavia.model;

/** This class represents all the program registers. */
public class RegisterModel {
  /** Integer to store the register data. */
  private int content;

  /** Main constructor. */
  public RegisterModel() {
    content = 0;
  }

  /**
   * Constructor with content parameter.
   *
   * @param content Register content.
   */
  public RegisterModel(int content) {
    this.content = content;
  }

  /**
   * Gets the register content.
   *
   * @return Register content.
   */
  public int getContent() {
    return content;
  }

  /**
   * Sets the register content.
   *
   * @param content Register content.
   */
  public void setContent(int content) {
    this.content = content;
  }

  /** Clears the content. */
  public void clearContent() {
    content = 0;
  }

  /** Prints the register content. */
  public void printContentTerminal() {
    System.out.println("Register content: " + content);
  }
}
