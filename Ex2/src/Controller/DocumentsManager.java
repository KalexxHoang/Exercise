package Controller;

import Model.Book;
import Model.Document;


import java.util.*;
import java.util.stream.Collectors;

public class DocumentsManager {
    /**********************************
     *            Attribute           *
     **********************************/
    private Set<Document> docList;

    /*********************************
     *            Constructor        *
     *********************************/
    public DocumentsManager() {
        this.docList = new LinkedHashSet<>();
    }

    /*********************************
     *            Add Document       *
     *********************************/
    public void addDoc(Document document) {
        for (Document doc : this.docList) {
            if (doc.equals(document)) {
                System.out.println("This ID already exists!");
                System.out.println("Do you want to replace?");
                System.out.println("\t1: YES");
                System.out.println("\t2: NO");
                int option = new Scanner(System.in).nextInt();

                switch (option) {
                    case 1:
                        this.docList.remove(doc);
                        this.docList.add(document);
                    case 2:
                        return;
                }
            }
        }
        this.docList.add(document);
    }

    /*********************************
     *       Delete Document         *
     *********************************/
    public void removeDoc(String docID) {
        // Don't need to Override hashCode
        //this.docList.stream().filter(item -> item.equals(new Document(docID))).forEach(item -> this.docList.remove(item));

        // Need to Override hashCode
        this.docList.remove(new Document(docID));
    }

    /*********************************
     *          Show Infor           *
     *********************************/
    public void showDocument() {
        this.docList.forEach(Document::showInfor);
    }

    /*********************************
     *          searchType           *
     *********************************/
    public ArrayList<Document> searchType(String docType) {
        return (ArrayList<Document>) docList.stream().filter(item -> item.getType().contains(docType)).collect(Collectors.toList());
    }

    public void showType(String type) {
        ArrayList<Document> docSet = searchType(type);
        System.out.println("Document by " + type);
        docSet.forEach(Document::showInfor);
    }
}
