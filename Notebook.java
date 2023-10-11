import java.util.Objects;

public class Notebook {
    int memory;
    int HDD;
    String OS;
    String CPU;
    String color;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Notebook)){
            return false;
        }
        Notebook notebook = (Notebook) obj;
        return memory == notebook.memory && HDD == notebook.HDD && Objects.equals(OS, notebook.OS) &&
                Objects.equals(CPU, notebook.CPU) && Objects.equals(color, notebook.color);
    }

    @Override
    public int hashCode() {
        return 5 * memory + 6 * HDD + 7 * OS.hashCode() + 8 * CPU.hashCode() + color.hashCode();
    }

    @Override
    public String toString() {
        return "{" +
                "memory=" + memory +
                ", HDD=" + HDD +
                ", OS='" + OS + '\'' +
                ", CPU='" + CPU + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
