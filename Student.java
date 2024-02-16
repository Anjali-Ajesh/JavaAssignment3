package Assignment3;


class Student {
    private int prn;
    private String name;
    private String dob;
    private double marks;

    public Student(int prn, String name, String dob, double marks) {
        this.prn = prn;
        this.name = name;
        this.dob = dob;
        this.marks = marks;
    }

    public int getPrn() {
        return prn;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public double getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "PRN: " + prn + ", Name: " + name + ", DoB: " + dob + ", Marks: " + marks;
    }
}
