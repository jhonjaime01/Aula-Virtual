package logic;

public class Subject {
    private String subjId;
    private String nameSubj;
    private String notaFinalSubj;


    public Subject(String subjId, String nameSubj, String notaFinalSubj) {
        this.subjId = subjId;
        this.nameSubj = nameSubj;
        this.notaFinalSubj = notaFinalSubj;
    }

    public String getSubjId() {
        return subjId;
    }

    public void setSubjId(String subjId) {
        this.subjId = subjId;
    }

    public String getNameSubj() {
        return nameSubj;
    }

    public void setNameSubj(String nameSubj) {
        this.nameSubj = nameSubj;
    }

    public String getNotaFinalSubj() {
        return notaFinalSubj;
    }

    public void setNotaFinalSubj(String notaFinalSubj) {
        this.notaFinalSubj = notaFinalSubj;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjId='" + subjId + '\'' +
                ", nameSubj='" + nameSubj + '\'' +
                ", notaFinalSubj=" + notaFinalSubj +
                '}';
    }
}
