public enum Color {
    GREEN (5),
    WHITE (255),
    BLACK (0);

    private int color;
    Color(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }

}
