package org.artavia.tarea.t1.artavia.model;

/** This class represents a minipc with memory and registers. */
public class MiniPcModel {
  private MemoryModel miniPcMemory;
  private RegisterModel ac;
  private RegisterModel ir;
  private RegisterModel pc;
  private RegisterModel ax;
  private RegisterModel bx;
  private RegisterModel cx;
  private RegisterModel dx;

  /** Main constructor. */
  public MiniPcModel() {
    miniPcMemory = new MemoryModel();
    ac = new RegisterModel();
    ir = new RegisterModel();
    pc = new RegisterModel();
    ax = new RegisterModel();
    bx = new RegisterModel();
    cx = new RegisterModel();
    dx = new RegisterModel();
  }

  /**
   * Constructor with asmModel object.
   *
   * @param asmfile
   */
  public MiniPcModel(AsmModel asmfile) {
    miniPcMemory = new MemoryModel();
    miniPcMemory.asignRandomAddresses(asmfile.getInstructions());
    ac = new RegisterModel();
    ir = new RegisterModel();
    pc = new RegisterModel();
    ax = new RegisterModel();
    bx = new RegisterModel();
    cx = new RegisterModel();
    dx = new RegisterModel();
  }

  // Getters and setters
  public MemoryModel getMiniPcMemory() {
    return miniPcMemory;
  }

  public void setMiniPcMemory(MemoryModel miniPcMemory) {
    this.miniPcMemory = miniPcMemory;
  }

  public RegisterModel getAc() {
    return ac;
  }

  public void setAc(RegisterModel ac) {
    this.ac = ac;
  }

  public RegisterModel getIr() {
    return ir;
  }

  public void setIr(RegisterModel ir) {
    this.ir = ir;
  }

  public RegisterModel getPc() {
    return pc;
  }

  public void setPc(RegisterModel pc) {
    this.pc = pc;
  }

  public RegisterModel getAx() {
    return ax;
  }

  public void setAx(RegisterModel ax) {
    this.ax = ax;
  }

  public RegisterModel getBx() {
    return bx;
  }

  public void setBx(RegisterModel bx) {
    this.bx = bx;
  }

  public RegisterModel getCx() {
    return cx;
  }

  public void setCx(RegisterModel cx) {
    this.cx = cx;
  }

  public RegisterModel getDx() {
    return dx;
  }

  public void setDx(RegisterModel dx) {
    this.dx = dx;
  }
}