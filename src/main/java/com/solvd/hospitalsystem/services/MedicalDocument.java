package services;

public abstract class MedicalDocument {

    protected String documentID;

    public MedicalDocument(String documentID) {
        this.documentID = documentID;
    }

    public String getDocumentID() {
        return documentID;
    }

    public void setDocumentID(String documentID) {
        this.documentID = documentID;
    }

    public abstract void archive();
}