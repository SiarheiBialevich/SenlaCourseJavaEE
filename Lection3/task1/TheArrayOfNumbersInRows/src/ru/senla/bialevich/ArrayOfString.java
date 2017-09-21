package ru.senla.bialevich;

public class ArrayOfString {
    private String num1;
    private String num2;
    private String num3;

    public ArrayOfString(String num1, String num2, String num3) {
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
    }

    public String[] getArrayString() {

        return new String[]{num1, num2, num3};
    }

    public String getAmountNumbers(String[] arr) {

        Integer[] numbers = new Integer[arr.length];
        Integer sum = 0;

        for (int i = 0; i < arr.length; i++) {
            numbers[i] = Integer.parseInt(arr[i]);

            sum += numbers[i];
        }
        System.out.print(toString());
        return String.valueOf(sum);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Introduced an array of strings: ").append("[ ");
        sb.append(num1).append(", ");
        sb.append(num2).append(", ");
        sb.append(num3).append(" ]").append("\n");
        sb.append("The sum of the numbers in the array: ");

        return sb.toString();
    }
}
