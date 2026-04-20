package org.example;

public class TicTacToe {

    public static int[] convertSlotToIndices(int slot) {
        if (slot < 1 || slot > 9) {
            throw new IllegalArgumentException("Slot must be between 1 and 9");
        }
        int adjustedSlot = slot - 1;
        int row = adjustedSlot / 3;
        int col = adjustedSlot % 3;

        return new int[]{row, col};
    }
    public static void main(String[] args) {
        int slot = 5;
        int[] indices = convertSlotToIndices(slot);
        System.out.println("Slot " + slot + " maps to:");
        System.out.println("Row = " + indices[0] + ", Column = " + indices[1]);
    }
}
