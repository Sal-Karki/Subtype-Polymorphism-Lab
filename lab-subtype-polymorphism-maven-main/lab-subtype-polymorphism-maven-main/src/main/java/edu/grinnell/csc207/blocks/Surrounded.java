package edu.grinnell.csc207.blocks;

/**
 * A text block surrounded by a single letter.
 *
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 */
public class Surrounded implements AsciiBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The stuff in the block.
   */
  AsciiBlock contents;

  /**
   * The character we put around the block.
   */
  String boxChar;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new block with the specified contents.
   *
   * @param blockContents
   *   The contents of the block.
   *
   * @param surroundChar
   *   The character that we use to surround the block.
   */
  public Surrounded(AsciiBlock blockContents, char surroundChar) {
    this.contents = blockContents;
    this.boxChar = Character.toString(surroundChar);
  } // Surrounded(AsciiBlock)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   *
   * @param i the number of the row
   *
   * @return row i.
   *
   * @exception Exception
   *   If the row is invalid.
   */
  @Override
  public String row(int i) throws Exception {
    if (i == 0 || i == this.height() - 1) {
      // First and last row: Full of surrounding characters
      return this.boxChar.repeat(this.width());
    } else if (i > 0 && i < this.height() - 1) {
      // Middle rows: Surround the content's row with the box character
      return this.boxChar + this.contents.row(i - 1) + this.boxChar;
    } else {
      throw new Exception("Invalid row index");
    }
  } // row(int)

  /**
   * Determine how many rows are in the block.
   *
   * @return the number of rows
   */
  @Override
  public int height() {
    // Add 2 to the height of the content (top and bottom surround rows)
    return this.contents.height() + 2;
  } // height()

  /**
   * Determine how many columns are in the block.
   *
   * @return the number of columns
   */
  @Override
  public int width() {
    // Add 2 to the width of the content (left and right surround columns)
    return this.contents.width() + 2;
  } // width()
} // class Surrounded
